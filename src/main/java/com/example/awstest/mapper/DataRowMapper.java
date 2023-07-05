package com.example.awstest.mapper;

import com.example.awstest.model.MMTData;
import com.mysql.cj.protocol.Resultset;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRowMapper implements RowMapper<MMTData> {

    public MMTData mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        MMTData data = new MMTData();
        data.setMemberno(rs.getInt("member_no"));
        data.setTitle(rs.getString("title"));
        data.setMarketingcontact(rs.getString("marketingcontact"));
        data.setDmnumber(rs.getInt("dmnumber"));
        data.setDocumentid(rs.getInt("documentid"));
        data.setRef(rs.getString("ref"));
        return data;
    }

}
