package com.dev.dao;

import com.dev.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.HashMap;

@Component
public class UserJdbcDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private RoleJdbcDao roleJdbcDao;


    @Autowired
    public UserJdbcDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate, RoleJdbcDao roleJdbcDao) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.roleJdbcDao = roleJdbcDao;
    }

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setUserId(rs.getLong("UserId"));
        user.setFirstName(rs.getString("FirstName"));
        user.setLastName(rs.getString("LastName"));
        user.setPhoneNumber(rs.getLong("PhoneNumber"));
        user.setEmail(rs.getString("Email"));
        user.setUserPassword(rs.getString("UserPassword"));
        user.setRole(roleJdbcDao.getRoleById(rs.getLong("RoleId")));
        return user;
    };

    private HashMap<String, Object> getUserMap(User user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("UserId", user.getUserId());
        map.put("FirstName", user.getFirstName());
        map.put("LastName", user.getLastName());
        map.put("PhoneNumber", user.getPhoneNumber());
        map.put("Email", user.getEmail());
        map.put("UserPassword", user.getUserPassword());
        map.put("RoleId", user.getRole().getRoleId());
        return map;
    }

    public void createUser(User user) {
        if (user.getUserId()==0) user.setUserId(0);// sets it to a random val.
        String sql = "INSERT INTO Users (UserId, FirstName, LastName, PhoneNumber, Email, UserPassword, RoleId) VALUES (:UserId,:FirstName, :LastName, :PhoneNumber, :Email, :UserPassword, :RoleId)";
        HashMap<String, Object> params = getUserMap(user);
        namedParameterJdbcTemplate.update(sql, params);
    }

    public User getUserById(long id){
        String sql = "SELECT * FROM Users WHERE UserId = :UserId";
        HashMap<String, Object> params = new HashMap<>();
        params.put("UserId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, params, userRowMapper);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM Users";
        return namedParameterJdbcTemplate.query(sql, userRowMapper);
    }

    public User getUserByEmail(String email){
        String sql = "SELECT * FROM Users WHERE Email = :Email";
        HashMap<String, Object> params = new HashMap<>();
        params.put("Email", email);
        return namedParameterJdbcTemplate.queryForObject(sql, params, userRowMapper);
    }

    public User getUserByUsername(String email){
        String sql = "SELECT * FROM Users WHERE Email = :Email";
        HashMap<String, Object> params = new HashMap<>();
        params.put("Email", email);
        return namedParameterJdbcTemplate.queryForObject(sql, params, userRowMapper);
    }
}
