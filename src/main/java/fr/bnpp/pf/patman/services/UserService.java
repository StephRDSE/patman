package fr.bnpp.pf.patman.services;

import fr.bnpp.pf.patman.model.entities.User;

public interface UserService {

void save(User user);

void delete(User user);

User findByEmail(String email);

Iterable<User> findAll();

}