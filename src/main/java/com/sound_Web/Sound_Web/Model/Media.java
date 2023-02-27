package com.sound_Web.Sound_Web.Model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import static javax.persistence.GenerationType.IDENTITY;

@EnableAutoConfiguration
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int Id;

    @Column(nullable = false)
    private String Media_name;

    @Column(nullable = false)
    private String url;

    @ManyToMany(cascade = CascadeType.ALL  ,  fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "Media_User" ,  joinColumns = @JoinColumn(name = "address_id")
    ,inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Collection<User> users;
}
