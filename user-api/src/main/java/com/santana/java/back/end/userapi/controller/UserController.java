package com.santana.java.back.end.userapi.controller;

import com.santana.java.back.end.userapi.dto.UserDTO;
import com.santana.java.back.end.userapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@SuppressWarnings({"unused"})
public class UserController {

    public static List<UserDTO> users;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getMessage() {
        return  "Spring boot is working";
    }

    @SuppressWarnings({"unused"})
    @GetMapping(value = "/users")
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping(value = "/users/id/{id}")
    public UserDTO getUsersById(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping(value = "/users/cpf/{cpf}")
    public UserDTO getUsersByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @GetMapping(value = "/users/searchByName")
    public List<UserDTO> queryByName(@RequestParam(name = "name") String name) {
        return userService.queryByName(name);
    }

    @PostMapping("/newUser")
    public Long insertNewUser(@RequestBody UserDTO user) {
        user.setRegisterDate(new Date());

        return userService.save(user).getId();
    }

    @DeleteMapping("/removeUser/{id}")
    public boolean removeUser(@PathVariable long id) {
        return userService.delete(id);
    }

    @PostConstruct
    public static void initiateList() {
        users = new ArrayList<>();

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("Eduardo");
        userDTO.setCpf("123");
        userDTO.setAddress("Rua A");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelephone("1234-3454");
        userDTO.setRegisterDate(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setId(2L);
        userDTO2.setName("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setAddress("Rua b");
        userDTO.setEmail("luiz@email.com");
        userDTO.setTelephone("1234-3454");
        userDTO.setRegisterDate(new Date());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setId(3L);
        userDTO3.setName("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setAddress("Rua c");
        userDTO.setEmail("bruna@email.com");
        userDTO.setTelephone("1234-3454");
        userDTO.setRegisterDate(new Date());

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);
    }
}
