package com.dev.dao;

import com.dev.models.Item;
import com.dev.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class RoleJdbcDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public RoleJdbcDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private final RowMapper<Role> cartRowMapper = (rs, rowNum) -> {
        Role role = new Role();
        role.setRoleId(rs.getLong("RoleId"));
        role.setRoleName(rs.getString("RoleName"));
        return role;
    };

    private HashMap<String, Object> getRoleMap(Role role) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("RoleId", role.getRoleId());
        map.put("RoleName", role.getRoleName());
        return map;
    }

    public Role getRoleById(long id){
        String sql = "SELECT * FROM Roles WHERE RoleId = :RoleId";
        return namedParameterJdbcTemplate.queryForObject(sql, new HashMap<String, Object>(){{put("RoleId", id);}}, cartRowMapper);
    }

    public Role getRoleByName(String name){
        String sql = "SELECT * FROM Roles WHERE RoleName = :RoleName";
        return namedParameterJdbcTemplate.queryForObject(sql, new HashMap<String, Object>(){{put("RoleName", name);}}, cartRowMapper);
    }

    public void createRole(Role role) {
        if(role.getRoleId()==0) role.setRoleId(0);// sets it to a random val.
        String sql = "INSERT INTO Roles (RoleId, RoleName) VALUES (:RoleId,:RoleName)";
        HashMap<String, Object> params = getRoleMap(role);
        namedParameterJdbcTemplate.update(sql, params);
    }

}
