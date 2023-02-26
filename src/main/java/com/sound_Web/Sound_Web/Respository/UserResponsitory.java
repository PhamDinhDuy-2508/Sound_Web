package com.sound_Web.Sound_Web.Respository;

import com.sound_Web.Sound_Web.Model.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserResponsitory extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.Account = :username")
    User findUserByAccount(String username);

    @Query("SELECT u FROM User u WHERE u.UserID = :id")
    User findByUserID(String id);

    @Query("SELECT u FROM User u WHERE u.Email = :Email")
    User findUserByEmail(String  Email)  ;



}

