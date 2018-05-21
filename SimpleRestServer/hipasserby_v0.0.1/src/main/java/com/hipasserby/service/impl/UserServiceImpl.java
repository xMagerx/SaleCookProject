package com.hipasserby.service.impl;

import com.hipasserby.controller.forUser.AuthenticationController;
import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.Message;
import com.hipasserby.entity.enums.Flag;
import com.hipasserby.entity.enums.Role;
import com.hipasserby.entity.enums.Sex;
import com.hipasserby.entity.User;
import com.hipasserby.repository.DialogRepository;
import com.hipasserby.repository.UserRepository;
import com.hipasserby.request.*;
import com.hipasserby.response.UserResponse;
import com.hipasserby.service.UserService;
import com.hipasserby.specification.SearchingUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {


    private AuthenticationController authenticationController;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DialogRepository dialogRepository;

    private JavaMailSender javaMailSender;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public boolean signUp(RegisterUserRequest registerUserRequest) throws MailException, MessagingException {
        //Перевірка на порожність поля
        if (registerUserRequest.getFirstName().isEmpty() | registerUserRequest.getLastName().isEmpty() |
                registerUserRequest.getEmail().isEmpty() | registerUserRequest.getPassword().isEmpty() |
                registerUserRequest.getRepeatPassword().isEmpty() | registerUserRequest.getSex() != null) {
            //Перевірка на наявність в базі email, щоб не було дублювання користувачів
            if (userRepository.findByEmail(registerUserRequest.getEmail()) == null) {
                //Перевірка імені
                if (registerUserRequest.getFirstName().length() >= 2 & registerUserRequest.getFirstName().length() <= 20
                        & includesOnlyLetters(registerUserRequest.getFirstName(), registerUserRequest)) {
                    //Перевірка прізвища
                    if (registerUserRequest.getLastName().length() >= 2 & registerUserRequest.getLastName().length() <= 25
                            & includesOnlyLetters(registerUserRequest.getLastName(), registerUserRequest)) {
                        //Перевірка email
                        if (emailForm(registerUserRequest)) {
                            //Перевірка пароля
                            if (registerUserRequest.getPassword().length() >= 8 & registerUserRequest.getPassword().length() <= 25) {
                                //Перевірка ідентичності паролей
                                if (registerUserRequest.getPassword().equals(registerUserRequest.getRepeatPassword())) {
                                    //Перевірка чи не порожнє поле "стать" та чи воно є одне з двох реальних
                                    if (registerUserRequest.getSex() != null | registerUserRequest.getSex() == Sex.SEX_MAN || registerUserRequest.getSex() == Sex.SEX_WOMAN) {
                                        System.out.println(registerUserRequest.getFirstName() + "\n" + registerUserRequest.getLastName()
                                                + "\n" + registerUserRequest.getEmail() + "\n" + registerUserRequest.getPassword() + "\n"
                                                + registerUserRequest.getRepeatPassword() + "\n" + registerUserRequest.getRole()
                                                + "\n" + registerUserRequest.getSex());
                                        //Якщо метод збереження повертає true - значить користувач успішно зареєстрований!
                                        if (userRepository.save(new User(registerUserRequest.getFirstName(), registerUserRequest.getLastName(),
                                                registerUserRequest.getEmail(), registerUserRequest.getPassword(), registerUserRequest.getRole(),
                                                registerUserRequest.getSex(), registerUserRequest.getFlag(), registerUserRequest.getRandomTokenOfActivation())) != null) {
                                            //Відправляємо на пошту рандомний токен, який згенерувався в registerUserRequest
                                            //Відправляє email
                                            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

                                            simpleMailMessage.setTo(registerUserRequest.getEmail());
                                            simpleMailMessage.setFrom("hipasserbym@gmail.com");
                                            simpleMailMessage.setSubject("Активація аккаунта в мессенджері HiPasserby!");
                                            simpleMailMessage.setText(emailMessageForActivationAccount(registerUserRequest));

                                            MimeMessage message = javaMailSender.createMimeMessage();
                                            MimeMessageHelper helper = new MimeMessageHelper(message, true);

                                            helper.setFrom(simpleMailMessage.getFrom());

                                            helper.setTo(simpleMailMessage.getTo());

                                            helper.setSubject("HiPasserby - aктивація аккаунта в мессенджері!");
                                            helper.setText(simpleMailMessage.getText(), true);


                                            javaMailSender.send(message);
                                            return true;
                                        } else {
                                            return false;
                                        }

                                    } else {
                                        throw new IllegalArgumentException("Невірно вказана стать!");
                                    }
                                } else {
                                    //Перевірка ідентичності паролей
                                    throw new IllegalArgumentException("Паролі не співпадають!");
                                }

                            } else {
                                //Перевірка пароля
                                throw new IllegalArgumentException("Пароль може складатись з 8-25 символів!");
                            }

                        } else {
                            //Перевірка email
                            throw new IllegalArgumentException("Невірний формат email!");
                        }

                    } else {
                        //Перевірка прізвища
                        throw new IllegalArgumentException("Невірний формат прізвища!");
                    }

                } else {
                    //Перевірка імені
                    throw new IllegalArgumentException("Невірний формат імені!");
                }
            } else {
                //Перевірка на наявність в базі email, щоб не було дублювання користувачів
                throw new IllegalArgumentException("Вказана електронна адреса вже зареєстрована!");
            }
        } else

        {
            //Перевірка на порожність поля
            throw new IllegalArgumentException("Порожні поля!");
        }

    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<Dialog> getUsersDialogs(FindOneByIdRequest findOneByIdRequest) {
        User user = findOne(findOneByIdRequest.getId());
//        List<Dialog> dialogs = user.getDialogs();

        for(Dialog dialog:user.getDialogs()){
            dialog.setDate(dialog.getMessages().get(dialog.getMessages().size()-1).getDateOfCreating());
            dialog.setLastMessage(dialog.getMessages().get(dialog.getMessages().size()-1).getText());
            dialog.setReadLastMessage(dialog.getMessages().get(dialog.getMessages().size()-1).getIsRead());
            dialog.setIdAuthorOfLastMessage(dialog.getMessages().get(dialog.getMessages().size()-1).getAuthor().getId());
            dialogRepository.save(dialog);
        }
        List<Dialog> dialogs = user.getDialogs();
        Collections.sort(dialogs, new Comparator<Dialog>() {
            public int compare(Dialog dialog1,Dialog dialog2) {
                return dialog2.getDate().compareTo(dialog1.getDate());
            }
        });

        return dialogs;

    }

    @Override
    public List<Message> getUsersMessage(FindOneByIdRequest findOneByIdRequest) {
        User user = findOne(findOneByIdRequest.getId());
        List<Message>messages = user.getMessages();
        return messages;
    }

    @Override
    public boolean login(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null) {
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return true;
            } else {
                throw new IllegalArgumentException("Невірна адреса або пароль!");
            }
        } else {
            throw new IllegalArgumentException("Невірна адреса або пароль!");
        }
    }

    @Override
    public Page<UserResponse> findAll(MyPageRequest page) {
        PageRequest pageRequest = new PageRequest(page.getNumberPage(), page.getSizePage());
        Page<User> pageUsers = userRepository.findAll(pageRequest);
        Page<UserResponse> pageUserResponse = pageUsers.map(this::convert);
        return pageUserResponse;
    }

    private UserResponse convert(User user) {
        return new UserResponse(user);
    }

    @Override
    public boolean delete(Integer id) {
        if (userRepository.findOne(id).getRole() == Role.ROLE_ADMIN) {
            return false;
        } else {
            userRepository.delete(id);
            return true;
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    @Override
    public List<User> findAll(SearchingRequest searchingRequest) {
        SearchingUser searchingUser = new SearchingUser(searchingRequest);
        return userRepository.findAll(searchingUser);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean editUserFlag(ActivationUserRequest activationUserRequest) {
        User user = new User();
        user = userRepository.findByEmail(activationUserRequest.getEmail());
        if (user != null) {
            if(!user.getFlag().equals(Flag.USER_ACTIVATED)) {
                if (activationUserRequest.getRandomTokenOfActivation().equals(user.getRandomTokenOfActivation())) {
                    user.setFlag(Flag.USER_ACTIVATED);
                    userRepository.save(user);
                    return true;
                } else {
                    throw new IllegalArgumentException("Невірний код!");
                }
            }else{
                throw new IllegalArgumentException("Обліковий запис з таким email вже активовано!");
            }
        }else {
            throw new IllegalArgumentException("Обліковий запис з таким email незареєстровано!");
        }
    }

    @Override
    public boolean includesOnlyLetters(String set, RegisterUserRequest registerUserRequest) {

        registerUserRequest.setFirstName(registerUserRequest.getFirstName().substring(0, 1).toUpperCase() + registerUserRequest.getFirstName().substring(1).toLowerCase());
        registerUserRequest.setLastName(registerUserRequest.getLastName().substring(0, 1).toUpperCase() + registerUserRequest.getLastName().substring(1).toLowerCase());

        char testChar;
        String testString;
        for (int i = 0; i < set.length(); i++) {

            testChar = set.charAt(i);
            testString = Character.toString(testChar);
            if (!testString.matches("^[іІїЇa-zA-Zа-яА-Яа-яА-Я]+$")) {

                return false;
            }
        }
        return true;
    }

    @Override
    public boolean emailForm(RegisterUserRequest registerUserRequest) {
        registerUserRequest.setEmail(registerUserRequest.getEmail().substring(0).toLowerCase());
        char testChar;
        String testString;
        if (registerUserRequest.getEmail().contains("@")
                & registerUserRequest.getEmail().contains(".")) {

            for (int i = 0; i < registerUserRequest.getEmail().length(); i++) {

                testChar = registerUserRequest.getEmail().charAt(i);
                testString = Character.toString(testChar);

                if (!testString.matches("^[-.@_0-9a-zA-Z]+$")) {

                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public String emailMessageForActivationAccount(RegisterUserRequest registerUserRequest) {
        String htmlMail = "<div id=\"mailsub\" class=\"notification\" align=\"center\">\n" +
                "\n" +
                "        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"min-width: 320px;\">\n" +
                "            <tr>\n" +
                "                <td align=\"center\" bgcolor=\"#eff3f8\">\n" +
                "\n" +
                "                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"table_width_100\" width=\"100%\" style=\"max-width: 680px; min-width: 300px;\">\n" +
                "                        <tr>\n" +
                "                            <td>\n" +
                "                                <!-- padding -->\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                        <!--header -->\n" +
                "                        <tr>\n" +
                "                            <td align=\"center\" bgcolor=\"#ffffff\">\n" +
                "                                <!-- padding -->\n" +
                "                                <table width=\"90%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                    <tr>\n" +
                "                                        <td align=\"center\" style=\"background-color: #747474\">\n" +
                "                                            <a href=\"#\" target=\"_blank\" style=\"color: #596167; font-family: Arial, Helvetica, sans-serif; float:left; width:100%; padding:20px;text-align:center; font-size: 13px;\">\n" +
                "                                                <font face=\"Arial, Helvetica, sans-seri; font-size: 13px;\" size=\"3\" color=\"#596167\">\n" +
                "                                                    <img src=\"https://cdn1.savepice.ru/uploads/2017/12/27/8bd9814b0071bd9a78c108d074eef618-full.png\" width=\"250\" alt=\"HiPasserby\" border=\"0\" /></font>\n" +
                "                                            </a>\n" +
                "                                        </td>\n" +
                "                                        <td align=\"right\">\n" +
                "                                            <!--[endif]-->\n" +
                "                                            <!-- \n" +
                "\n" +
                "\t\t\t</td>\n" +
                "\t\t\t</tr>\n" +
                "\t\t</table>\n" +
                "\t\t<!-- padding -->\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    <!--header END-->\n" +
                "\n" +
                "                                    <!--content 1 -->\n" +
                "                                    <tr>\n" +
                "                                        <td align=\"center\" bgcolor=\"#fbfcfd\">\n" +
                "                                            <font face=\"Arial, Helvetica, sans-serif\" size=\"4\" color=\"#57697e\" style=\"font-size: 15px;\">\n" +
                "                                                <table width=\"90%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"text-align: center\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td style=\"padding-top: 20px\">\n" +
                "                                                            Привіт<span style=\"font-size: 16px;color: midnightblue;font-weight: bold;\"> " + registerUserRequest.getFirstName() + " " + registerUserRequest.getLastName() + " </span> ,<br/> Вітаємо в мессенджері HiPasserby<br/> Ви щойно зареєструвались на сайті <a href=\"http://www.hipasserby.com\">http://www.hipasserby.com</a><br> Для входу в обліковий запис використайте:<br/> Email: <span style=\"font-size: 16px;color: midnightblue;font-weight: bold;\">" + registerUserRequest.getEmail() + "</span>\n" +
                "                                                            <br/> Пароль: <span style=\"font-size: 16px;color: midnightblue;font-weight: bold;\">" + registerUserRequest.getPassword() + "</span>\n" +
                "                                                            <br/> Код підтвердження: \n" +
                "                                                            <br/>\n" +
                "                                                        </td>\n" +
                "                                                    </tr>\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"center\">\n" +
                "                                                            <div style=\"line-height: 24px;font-size: 20px;\">\n" +
                "                                                               <br>\n" +
                "                                                                " + registerUserRequest.getRandomTokenOfActivation() + "\n" +
                "                                                            </div>\n" +
                "                                                            <!-- padding -->\n" +
                "                                                            <br>\n" +
                "                                                            <br>\n" +
                "                                                            <p style=\"text-align: center;color: darkslategray;font-size: 12px\"> <b style=\"text-align: center;font-size: 12px;\">Використайте цей код для підтвердження свого облікового запису, щоб користуватись нашим сервісом!<br>Неактивований обліковий запис вважається не дійсним!</b><p style=\"color: brown;font-size: 12px\">\n" +
                "                                                                Якщо ви не здійснювали реєстрацію - проігноруйте це повідомлення!</p>\n" +
                "                                                            <div style=\"height: 60px; line-height: 60px; font-size: 10px;\">\n" +
                "                                                               \n" +
                "                                                            </div>\n" +
                "                                                        </td>\n" +
                "                                                    </tr>\n" +
                "\n" +
                "                                                </table>\n" +
                "                                            </font>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    <!--content 1 END-->\n" +
                "\n" +
                "\n" +
                "                                    <!--footer -->\n" +
                "                                    <tr style=\"margin-top: 200px\">\n" +
                "                                        <td class=\"iage_footer\" align=\"center\" bgcolor=\"#ffffff\">\n" +
                "\n" +
                "\n" +
                "                                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                <tr>\n" +
                "                                                    <td align=\"center\" style=\"padding:20px;flaot:left;width:100%; text-align:center;\">\n" +
                "                                                        <font face=\"Arial, Helvetica, sans-serif\" size=\"3\" color=\"#96a5b5\" style=\"font-size: 13px;\">\n" +
                "                                                            <span style=\"font-family: Arial, Helvetica, sans-serif; font-size: 13px; color: #96a5b5;\">\n" +
                "\t\t\t\t\t2018 © HiPasserby.com <br>All Rights Reserved.\n" +
                "\t\t\t\t</span></font>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </table>\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                    <!--footer END-->\n" +
                "                                    <tr>\n" +
                "                                        <td>\n" +
                "\n" +
                "                                        </td>\n" +
                "                                    </tr>\n" +
                "                                </table>\n" +
                "                                <!--[if gte mso 10]>\n" +
                "</td></tr>\n" +
                "</table>\n" +
                "<![endif]-->\n" +
                "\n" +
                "                            </td>\n" +
                "                        </tr>\n" +
                "                    </table>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "    </div>";
        return htmlMail;
    }

    @Override
    public User findOne(FindOneByIdRequest findOneByIdRequest) {

        return userRepository.findOne(findOneByIdRequest.getId());
    }

    @Override
    public User findGet(FindOneByIdRequest findOneByIdRequest) {
        return userRepository.findOne(findOneByIdRequest.getId());
    }
}
