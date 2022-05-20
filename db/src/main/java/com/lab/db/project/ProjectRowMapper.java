package com.lab.db.project;

import com.lab.db.nomenclature.Nomenclature;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRowMapper implements RowMapper<Project>{
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project proj = new Project();

        proj.setId(rs.getInt("id"));
        proj.setRooms(rs.getInt("rooms"));

        return proj;
    }
}
