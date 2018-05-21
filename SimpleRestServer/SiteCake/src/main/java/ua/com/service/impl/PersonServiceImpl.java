package ua.com.service.impl;

import java.io.IOException;
import java.util.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.com.dto.Base64MultipartFile;
import ua.com.entity.Person;
import ua.com.repository.PersonRepository;
import ua.com.request.LoginRequest;
import ua.com.request.MyPageRequest;
import ua.com.request.SearchingRequest;
import ua.com.response.PersonResponse;
import ua.com.service.PersonService;
import ua.com.specification.SearchingPerson;
import sun.misc.BASE64Decoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ua.com.entity.Person;
import ua.com.repository.PersonRepository;
import ua.com.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService,UserDetailsService{
	private final static String PATH = "C://Users//Study//Desktop//imagesForProject"; 
	
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person register(Person person) throws IOException {
		byte[]fileContent;
		BASE64Decoder decoder = new BASE64Decoder();
		fileContent = decoder.decodeBuffer(person.getPhoto().split(",")[1]);
		String expansion = person.getPhoto().split(",")[0].split("/")[1].split(";")[0];
		person.setPhoto(null);
		person = personRepository.saveAndFlush(person);
		Base64MultipartFile multipartFile =new Base64MultipartFile(fileContent,person.getId()+"."+expansion);
		saveFile(multipartFile);
		person.setPhoto("/images/"+person.getId()+"."+expansion);
		return personRepository.save(person);
	}
	
	private void saveFile(MultipartFile file) throws FileNotFoundException, IOException{
		File pathToFolder = new File(PATH);
		createFolder(pathToFolder);
		File newFile = new File(pathToFolder+"/"+file.getOriginalFilename());
		writeFile(newFile,file);
		
	}

	private void createFolder(File path){
		if(!path.exists()){
			path.mkdirs();
		}
	}
	
	private void writeFile(File file ,MultipartFile multipartFile) throws FileNotFoundException, IOException{
		try(OutputStream fos = new FileOutputStream(file);BufferedOutputStream bos = new BufferedOutputStream(fos)){
			bos.write(multipartFile.getBytes(),0,multipartFile.getBytes().length);
			bos.flush();
		}catch (IOException e) {
			
		}
	}
	
	@Override
	public boolean login(LoginRequest loginRequest) {
		if(loginRequest!=null){
			Person person  = personRepository.findByEmail(loginRequest.getEmail());
			if(person!=null){
				if(person.getPass().equals(loginRequest.getPass())){
					return true;
				}else{
					throw new IllegalArgumentException("Login or password is incorrect");
				}
			}else{
				throw new IllegalArgumentException("Login or password is incorrect");
			}
		}else{
			throw new IllegalArgumentException("LoginRequest not be null");
		}
	}

	@Override
	public Page<PersonResponse> findAll(MyPageRequest page) {
		PageRequest pageRequest = new PageRequest(page.getNumberPage(),page.getSizePage());
		Page<Person> pagePerson =  personRepository.findAll(pageRequest);
		Page<PersonResponse> pagePersonResponse = pagePerson.map(this::convert);
		return pagePersonResponse;
	}
	
	private PersonResponse convert(Person person){
		return new PersonResponse(person);
	}

	@Override
	public boolean delete(Integer id) {
		 personRepository.delete(id);
		 return true;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return (UserDetails) personRepository.findByEmail(username);
	}

	@Override
	public List<Person> findAll(SearchingRequest searchingRequest) {
		SearchingPerson searchingPerson = new SearchingPerson(searchingRequest);
		return personRepository.findAll(searchingPerson);
	}
	
	
	
}
