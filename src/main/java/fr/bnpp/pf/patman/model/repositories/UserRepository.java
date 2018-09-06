package fr.bnpp.pf.patman.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import fr.bnpp.pf.patman.model.entities.User;
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("FROM User u WHERE u.email LIKE :email")
    User findByEmail(@Param(value = "email") String email);
}