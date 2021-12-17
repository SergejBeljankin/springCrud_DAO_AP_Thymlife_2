package com.example.springcrud.services;

import com.example.springcrud.dao.PersonDAO;
import com.example.springcrud.entities.Person;
import com.example.springcrud.entities.Role;
import com.example.springcrud.repostories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceIpml implements UserDetailsService {
    private PersonRepository personRepository;
//    private PersonServiseImpl personServise;

    @Autowired
    public void setUserRepository(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

//    @Autowired
//    public void setPersonServiseImpl(PersonServiseImpl personServise){
//        this.personServise = personServise;
//    }
    @Transactional
    public Person findByUsername(String username){
        return personRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = findByUsername(username);
        if(person == null){
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return person;
    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
//    }
}
