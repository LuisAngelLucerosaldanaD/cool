package com.estrellitas.cool.services.user;

import com.estrellitas.cool.domain.UserRepository;
import com.estrellitas.cool.generate.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public User getUserByEmail(String email) {
        User newUser = new User();
        var userRes = userRepository.GetUserByEmail(email);
        newUser.setNames(userRes.names);
        newUser.setLastname(userRes.lastname);
        newUser.setAge(userRes.age);
        newUser.setEmail(userRes.email);
        newUser.setGender(userRes.gender);
        newUser.setId(userRes.id);
        newUser.setPassword(userRes.password);
        return newUser;
    }

    public User getUserById(String id) {
        User newUser = new User();
        var userRes = userRepository.GetUserById(id);
        newUser.setNames(userRes.names);
        newUser.setLastname(userRes.lastname);
        newUser.setAge(userRes.age);
        newUser.setEmail(userRes.email);
        newUser.setGender(userRes.gender);
        newUser.setId(userRes.id);
        newUser.setPassword(userRes.password);
        return newUser;
    }

    public User createUser(String id, String names, String lastname, String email, int age, String password, String gender) {
        User newUser = new User();
        var userRes = userRepository.CreateUser(id, names, lastname, email, age, password, gender);
        newUser.setNames(userRes.names);
        newUser.setLastname(userRes.lastname);
        newUser.setAge(userRes.age);
        newUser.setEmail(userRes.email);
        newUser.setGender(userRes.gender);
        newUser.setId(userRes.id);
        return newUser;
    }

    public String deleteUser(String id, String password) {
        if (userRepository.DeleteUser(id, password)) {
            return "Usuario borrado correctamente";
        }

        return "No se pudo eliminar el usuario";
    }
}
