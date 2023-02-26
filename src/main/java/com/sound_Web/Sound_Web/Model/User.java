package com.sound_Web.Sound_Web.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_user")
    private int UserID = 0;

    @Column
    private String Account;

    @Column
    private String Email;

    @Column
    private String Phone;

    @Column
    private String Password;
    @Column
    private String LastName;

    @Column
    private String FirstName;

    @Column
    private Date DateOfBirth;

    @Column
    private String Address;
}
