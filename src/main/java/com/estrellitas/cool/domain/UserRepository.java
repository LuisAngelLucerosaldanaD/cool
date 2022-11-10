package com.estrellitas.cool.domain;

import com.estrellitas.cool.domain.abstractions.IUserRepository;
import com.estrellitas.cool.domain.models.UserMapper;
import com.estrellitas.cool.domain.models.UserModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepository implements IUserRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserModel CreateUser(String id, String names, String lastname, String email, int age, String password, String gender) {
        UserModel user = new UserModel();
        String sqlQueryCreateUser = "INSERT INTO auth.users (id, names, lastname, email, age, password, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sqlQueryCreateUser, id, names, lastname, email, age, password, gender);

        if (rows <= 0) {
            log.error("No se pudo crear el usuario");
            return user;
        }

        user.id = id;
        user.names = names;
        user.lastname = lastname;
        user.email = email;
        user.age = age;
        user.password = "";
        user.gender = gender;

        return user;
    }

    @Override
    public UserModel GetUserById(String id) {
        UUID uuid = UUID.fromString(id);
        String sqlQueryCreateUser = "SELECT id, names, lastname, email, age, password, gender FROM auth.users WHERE id = ? LIMIT 1;";
        UserModel user = jdbcTemplate.queryForObject(sqlQueryCreateUser, new UserMapper(), uuid);
        if (user == null) {
            return new UserModel();
        }
        return user;
    }

    @Override
    public UserModel GetUserByEmail(String email) {
        String sqlQueryCreateUser = "SELECT id, names, lastname, email, age, password, gender FROM auth.users WHERE email = ? LIMIT 1;";
        UserModel user = jdbcTemplate.queryForObject(sqlQueryCreateUser, new UserMapper(), email);
        if (user == null) {
            return new UserModel();
        }
        return user;
    }

    @Override
    public boolean DeleteUser(String id, String password) {
        String sqlQueryCreateUser = "delete from auth.users where email = ? and password = ?;";
        int rows = jdbcTemplate.update(sqlQueryCreateUser, id, password);
        if (rows <= 0) {
            log.error("No se pudo borrar el usuario");
            return false;
        }
        return true;
    }

}
