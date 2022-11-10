package com.estrellitas.cool.domain.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserModel user = new UserModel();
        user.setId(rs.getString("id"));
        user.setNames(rs.getString("names"));
        user.setPassword(rs.getString("password"));
        user.setLastname(rs.getString("lastname"));
        user.setAge(rs.getInt("age"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));

        return user;
    }
}
