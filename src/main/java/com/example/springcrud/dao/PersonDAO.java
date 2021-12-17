package com.example.springcrud.dao;

import com.example.springcrud.entities.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getAll();
    Person select(long id);
    void save(Person person);
    void delete(long id);
    void update(long id, Person person);
//    public void setRoles(Set<Role> roleSet);
    List<Person> findPersonByRole(String roleName);
    Person findByUserName(String username);
}
