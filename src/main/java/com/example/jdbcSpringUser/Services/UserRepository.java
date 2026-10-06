package com.example.jdbcSpringUser.Services;

import com.example.jdbcSpringUser.model.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {


    DataSource dataSource;

    public List<User> findAll(){
        String sql="select id,username from user";
        try( Connection connection = dataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs= stmt.executeQuery();){
           List <User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(mapRow(rs));
            }

            return users;
       }catch(SQLException ex){
            throw new RuntimeException("Failed to load users",ex);
        }
    }

    private User mapRow(ResultSet rs)
            throws SQLException {
        return new User(
                rs.getString("id"),
                rs.getString("username"),
                rs.getString("password")
        );
    }


    public void save(User user) {
        String sql = "INSERT INTO user (id,username,password) VALUES (?,?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to save todo", ex);
        }
    }


}
