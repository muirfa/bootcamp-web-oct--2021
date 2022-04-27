/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.service;

import co.g2academy.bootcamp.dao.PersonDao;
import co.g2academy.bootcamp.entity.Person;

/**
 *
 * @author Asus
 */
public class Authenticator {
    private PersonDao personDao = new PersonDao();
    
    public String authenticate(String userName, String password){
        Person person =  personDao.getPersonByName(userName);
        if(person != null && person.getPassword().equals(password)){
            return "success";
        }
        return "fail";
    }
}
