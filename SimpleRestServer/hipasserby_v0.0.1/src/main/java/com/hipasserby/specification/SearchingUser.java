package com.hipasserby.specification;

import com.hipasserby.entity.User;
import com.hipasserby.request.SearchingRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.data.jpa.domain.Specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchingUser implements Specification<User> {

    private SearchingRequest searchingRequest;

    public SearchingUser(SearchingRequest searchingRequest) {
        this.searchingRequest = searchingRequest;
    }

    @Override
    public Predicate toPredicate(Root<User> rootUser, CriteriaQuery<?> crq, CriteriaBuilder crb) throws NullPointerException {
        CriteriaBuilder cb = crb;
        CriteriaQuery<?> cq = crq;
        Root<User> root = rootUser;


        Predicate firstNamePredicate = cb.like(root.get("firstName"), searchingRequest.getFirstName() + "%");//where email like %text%

        Predicate lastNamePredicate = cb.like(root.get("lastName"), searchingRequest.getLastName() + "%");//where email like %text%

        Predicate countryPredicate = cb.like(root.get("country"), searchingRequest.getCountry());//where email like

        Predicate yearPredicate = cb.equal(root.get("yearOfBirth"), searchingRequest.getYearOfBirth());

        Predicate monthPredicate = cb.equal(root.get("monthOfBirth"), searchingRequest.getMonthOfBirth());

        Predicate dayPredicate = cb.equal(root.get("dayOfBirth"), searchingRequest.getDayOfBirth());

        if (searchingRequest.getFirstName().length() > 0) {

            if (includeSymbolWhitespace(searchingRequest.getFirstName())) {

                List<String> words = splitWord(searchingRequest.getFirstName());

                searchingRequest.setFirstName(words.get(0));
                searchingRequest.setLastName(words.get(1));

                firstNamePredicate = cb.like(root.get("firstName"), searchingRequest.getFirstName() + "%");
                lastNamePredicate = cb.like(root.get("lastName"), searchingRequest.getLastName() + "%");


                if (searchingRequest.getCountry() != null) {

                    if (searchingRequest.getYearOfBirth() > 0) {

                        if (searchingRequest.getMonthOfBirth() > 0) {

                            if (searchingRequest.getDayOfBirth() > 0) {

                                return cb.and(firstNamePredicate, lastNamePredicate, countryPredicate, yearPredicate, monthPredicate, dayPredicate);

                            } else {
                                return cb.and(firstNamePredicate, lastNamePredicate, countryPredicate, yearPredicate, monthPredicate);
                            }
                        } else if (searchingRequest.getDayOfBirth() > 0) {
                            return cb.and(firstNamePredicate, lastNamePredicate, countryPredicate, yearPredicate, dayPredicate);
                        } else {
                            return cb.and(firstNamePredicate, lastNamePredicate, countryPredicate, yearPredicate);

                        }

                    } else if (searchingRequest.getMonthOfBirth() > 0) {
                        if (searchingRequest.getDayOfBirth() > 0) {

                            return cb.and(firstNamePredicate, lastNamePredicate, countryPredicate, monthPredicate, dayPredicate);

                        } else {
                            return cb.and(firstNamePredicate, lastNamePredicate, countryPredicate, monthPredicate);
                        }

                    } else if (searchingRequest.getDayOfBirth() > 0) {

                        return cb.and(firstNamePredicate, lastNamePredicate, countryPredicate, dayPredicate);

                    } else {
                        return cb.and(firstNamePredicate, lastNamePredicate, countryPredicate);
                    }

                } else if (searchingRequest.getYearOfBirth() > 0) {

                    if (searchingRequest.getMonthOfBirth() > 0) {

                        if (searchingRequest.getDayOfBirth() > 0) {
                            return cb.and(firstNamePredicate, lastNamePredicate, yearPredicate, monthPredicate, dayPredicate);
                        } else {
                            return cb.and(firstNamePredicate, lastNamePredicate, yearPredicate, monthPredicate);
                        }

                    } else if (searchingRequest.getDayOfBirth() > 0) {

                        return cb.and(firstNamePredicate, lastNamePredicate, yearPredicate, dayPredicate);

                    } else {
                        return cb.and(firstNamePredicate, lastNamePredicate, yearPredicate);
                    }

                } else if (searchingRequest.getMonthOfBirth() > 0) {

                    if (searchingRequest.getDayOfBirth() > 0) {
                        return cb.and(firstNamePredicate, lastNamePredicate, monthPredicate, dayPredicate);
                    } else {
                        return cb.and(firstNamePredicate, lastNamePredicate, monthPredicate);
                    }

                } else if (searchingRequest.getDayOfBirth() > 0) {
                    return cb.and(firstNamePredicate, lastNamePredicate, dayPredicate);
                } else {
                    return cb.and(firstNamePredicate, lastNamePredicate);
                }

            }else{
                return cb.or(firstNamePredicate, lastNamePredicate);
            }
        }else{
            if (searchingRequest.getCountry() != null) {

                if (searchingRequest.getYearOfBirth() > 0) {

                    if (searchingRequest.getMonthOfBirth() > 0) {

                        if(searchingRequest.getDayOfBirth()>0){

                            return cb.and(countryPredicate, yearPredicate, monthPredicate,dayPredicate);

                        }else {
                            return cb.and(countryPredicate, yearPredicate, monthPredicate);
                        }
                    } else if (searchingRequest.getDayOfBirth() > 0) {
                        return cb.and(countryPredicate,yearPredicate,dayPredicate);
                    }else{
                        return cb.and(countryPredicate, yearPredicate);

                    }

                } else if (searchingRequest.getMonthOfBirth() > 0) {
                    if (searchingRequest.getDayOfBirth() > 0) {

                        return cb.and(countryPredicate,monthPredicate,dayPredicate);

                    } else {
                        return cb.and(countryPredicate,monthPredicate);
                    }

                } else if (searchingRequest.getDayOfBirth() > 0) {

                    return cb.and(countryPredicate,dayPredicate);

                } else {
                    return cb.and(countryPredicate);
                }

            } else if (searchingRequest.getYearOfBirth() > 0) {

                if (searchingRequest.getMonthOfBirth() > 0) {

                    if (searchingRequest.getDayOfBirth() > 0) {
                        return cb.and(yearPredicate, monthPredicate, dayPredicate);
                    } else {
                        return cb.and(yearPredicate, monthPredicate);
                    }

                } else if (searchingRequest.getDayOfBirth() > 0) {

                    return cb.and(yearPredicate, dayPredicate);

                } else {
                    return cb.and(yearPredicate);
                }

            } else if (searchingRequest.getMonthOfBirth() > 0) {

                if (searchingRequest.getDayOfBirth() > 0) {
                    return cb.and(monthPredicate, dayPredicate);
                } else {
                    return cb.and(monthPredicate);
                }

            } else if (searchingRequest.getDayOfBirth() > 0) {
                return cb.and(dayPredicate);
            }
        }

        return cb.or(firstNamePredicate, lastNamePredicate);
    }


    //Чи містить стрічка пробіл
    public boolean includeSymbolWhitespace(String word) {

        char testChar;
        String testString;
        for (int i = 0; i < word.length(); i++) {

            testChar = word.charAt(i);
            testString = Character.toString(testChar);
            if (testString.matches(" ")) {
                return true;
            }
        }
        return false;

    }

    //розрізати стрічку до пробілів
    public List<String> splitWord(String firstName) {

        List<String> words = new ArrayList<String>();

        for (String particle : firstName.split(" ")) {
            words.add(particle);
        }
        return words;
    }




}
