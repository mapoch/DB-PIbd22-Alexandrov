package com.lab.db.nomenclature;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NomenclatureRowMapper implements RowMapper<Nomenclature>{
    @Override
    public Nomenclature mapRow(ResultSet rs, int rowNum) throws SQLException {
        Nomenclature nomen = new Nomenclature();

        nomen.setId(rs.getInt("id"));
        nomen.setName(rs.getString("name"));

        return nomen;
    }
}
