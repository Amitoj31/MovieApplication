package com.niit.userservice.repository;

import com.niit.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public abstract User findByEmailAndPassword(String email,String password);
    public abstract User findByEmail(String email);

}
