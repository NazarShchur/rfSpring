package com.nazar.dto;

import com.nazar.entity.LifeStyle;
import com.nazar.entity.Role;
import com.nazar.entity.Sex;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {
    private String username;
    private String password;
    private Set<Role> roles;
    boolean active;
    private double weight;
    private double height;
    private double age;
    private Sex sex;
    private LifeStyle lifeStyle;
}