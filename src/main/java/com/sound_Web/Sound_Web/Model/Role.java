package com.sound_Web.Sound_Web.Model;

import com.sound_Web.Sound_Web.Model.Enum.Role_Enum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Role_Enum role_name;


}
