package com.santana.java.back.end.userapi.model;

import com.santana.java.back.end.userapi.dto.UserDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "cpf", nullable = false, length = 18)
    private String cpf;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(name = "register_date", nullable = false, length = 20)
    private Date registerDate;

    public static User convert(UserDTO userDTO) {
        User user = null;

        if (userDTO != null) {
            user = new User();
            user.setId(userDTO.getId());
            user.setName(userDTO.getName());
            user.setCpf(userDTO.getCpf());
            user.setAddress(userDTO.getAddress());
            user.setTelephone(userDTO.getTelephone());
            user.setEmail(userDTO.getEmail());
            user.setRegisterDate(userDTO.getRegisterDate());
        }

        return user;
    }
}
