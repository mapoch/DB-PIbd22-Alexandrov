package com.lab.db.contractor;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractorRowMapper implements RowMapper<Contractor>{
    @Override
    public Contractor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contractor cont = new Contractor();
        cont.setId(rs.getInt("id"));
        cont.setName(rs.getString("name"));
        cont.setPhone(rs.getString("phone"));
        return cont;
    }
}
