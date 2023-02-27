package com.sound_Web.Sound_Web.Repository;

import com.sound_Web.Sound_Web.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponsitory extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.Account = :username")
    User findUserByAccount(String username);

    @Query("SELECT u FROM User u WHERE u.UserID = :id")
    User findByUserID(String id);

    @Query("SELECT u FROM User u WHERE u.Email = :Email")
    User findUserByEmail(String  Email)  ;

    @Modifying
    @Query("update User  u set u.Password =:pass where u.UserID =:id")
    void updatePassword(@Param("pass") String pass ,  @Param("id") int id) ;



}

