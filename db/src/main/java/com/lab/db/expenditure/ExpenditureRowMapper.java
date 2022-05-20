package com.lab.db.expenditure;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenditureRowMapper implements RowMapper<Expenditure>{
    @Override
    public Expenditure mapRow(ResultSet rs, int rowNum) throws SQLException {
        Expenditure exp = new Expenditure();

        exp.setId(rs.getInt("id"));
        exp.setExpense(rs.getBigDecimal("expense"));

        return exp;
    }
}
