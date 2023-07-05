package com.example.awstest.repository;

import com.example.awstest.mapper.DataRowMapper;
import com.example.awstest.model.MMTData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MMTServiceDAO {

    @Autowired
    JdbcTemplate jdbctemplate;

    @Transactional(readOnly = true)
    public List<MMTData> findAll()
    {
        //String sql = "SELECT * FROM mmtdemooutput";
        return jdbctemplate.query("SELECT * FROM mmtdemooutput", new DataRowMapper());
    }
    public List<MMTData> findDataByMemberNo(int memberno)
    {
        Object[] inputs = new Object[] {memberno};
        //String sql = "SELECT * FROM mmtdemooutput where member_no=?";
        return jdbctemplate.query("SELECT * FROM mmtdemooutput where member_no=?", inputs, new DataRowMapper());

        //return jdbctemplate.queryForObject("SELECT * FROM mmtdemooutput where member_no=?", inputs, new DataRowMapper());
        //return jdbctemplate.queryForObject(sql, new Object[] { memberno }, new DataRowMapper());

    }

   /* public List<Data> getData() {
        System.out.println ("MMT Service DAO get data called");

        List<Data> dataList = new ArrayList<>();
        String sql = "SELECT * FROM mmtdemooutput";
        Collection<Map<String, Object>> rows = jdbctemplate.queryForList(sql);

        rows.stream().map((row) -> {
            Data data = new Data();
            return data;
        }).forEach((data) -> {
            dataList.add(data);
        });

        return dataList;
    }*/
}
