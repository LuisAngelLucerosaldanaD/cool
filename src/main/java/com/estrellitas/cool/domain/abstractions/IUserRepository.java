package com.estrellitas.cool.domain.abstractions;

import com.estrellitas.cool.domain.models.UserModel;

public interface IUserRepository {
    UserModel CreateUser(String id, String names, String lastname, String email, int age, String password, String gender);

    UserModel GetUserById(String id);

    UserModel GetUserByEmail(String email);

    boolean DeleteUser(String id, String password);
}
