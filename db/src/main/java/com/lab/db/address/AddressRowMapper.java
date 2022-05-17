package com.lab.db.address;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address addr = new Address();

        addr.setId(rs.getInt("id"));
        addr.setSettlement(rs.getString("settlement"));
        addr.setStreet(rs.getString("street"));
        addr.setHouse(rs.getInt("house"));

        return addr;
    }
}
