package com.sound_Web.Sound_Web.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.*;

@Component
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private int UserID = 0;

    @Column
    private String Account;

    @Column
    private String Email;

    @Column
    private String Phone;

    @Column
    @JsonIgnore
    private String Password;
    @Column
    private String LastName;

    @Column
    private String FirstName;

    @Column
    private Date DateOfBirth;

    @Column
    private String Address;

    @Column
    private String Role;

    @ManyToMany(mappedBy = "users")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Media> mediaArrayList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


}
