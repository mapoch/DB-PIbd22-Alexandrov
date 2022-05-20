package com.lab.db.expenditure_item;

import com.lab.db.address.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Expenditure_itemRowMapper implements RowMapper<Expenditure_item>{
    @Override
    public Expenditure_item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Expenditure_item exp_item = new Expenditure_item();

        exp_item.setId(rs.getInt("id"));
        exp_item.setName(rs.getString("name"));

        return exp_item;
    }
}
