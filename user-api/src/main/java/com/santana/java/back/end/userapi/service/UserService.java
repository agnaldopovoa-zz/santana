package com.santana.java.back.end.userapi.service;

import com.santana.java.back.end.userapi.dto.UserDTO;
import com.santana.java.back.end.userapi.model.User;
import com.santana.java.back.end.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();

        return users
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return UserDTO.convert(user.orElse(null));
    }

    public UserDTO findByCpf(String cpf) {
        return UserDTO.convert(userRepository.findByCpf(cpf));
    }

    public List<UserDTO> queryByName(String name) {
        return userRepository.queryByNameLike(name)
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO save (UserDTO userDTO) {
        return UserDTO.convert(userRepository.save(User.convert(userDTO)));
    }

    public boolean delete (long id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isPresent()) {
            userRepository.delete(opt.orElseThrow(NoSuchElementException::new));
            return true;
        }

        return false;
    }
}
