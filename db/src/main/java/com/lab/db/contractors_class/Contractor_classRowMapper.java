package com.lab.db.contractors_class;

import com.lab.db.expenditure.Expenditure;
import com.lab.db.project.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Contractor_classRowMapper implements RowMapper<Contractors_class>{
    @Override
    public Contractors_class mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contractors_class cont_class = new Contractors_class();

        cont_class.setId(rs.getInt("id"));
        cont_class.setName(rs.getString("name"));

        return cont_class;
    }
}
