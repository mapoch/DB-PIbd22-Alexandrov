package com.lab.db.order;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order>{
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order ord = new Order();

        ord.setId(rs.getInt("id"));
        ord.setWorks_start(rs.getDate("works_start"));
        ord.setWorks_end(rs.getDate("works_end"));

        return ord;
    }
}
