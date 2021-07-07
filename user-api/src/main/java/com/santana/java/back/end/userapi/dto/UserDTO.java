package com.santana.java.back.end.userapi.dto;

import com.santana.java.back.end.userapi.model.*;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String telephone;
    private Date registerDate;

    public static UserDTO convert(User user){
        UserDTO userDTO = null;

        if (user != null) {
            userDTO = new UserDTO();

            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setCpf(user.getCpf());
            userDTO.setAddress(user.getAddress());
            userDTO.setTelephone(user.getTelephone());
            userDTO.setEmail(user.getEmail());
            userDTO.setRegisterDate(user.getRegisterDate());
        }

        return userDTO;
    }
}
