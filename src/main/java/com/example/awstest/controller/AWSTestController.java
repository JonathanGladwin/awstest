package com.example.awstest.controller;

import com.example.awstest.model.MMTData;
import com.example.awstest.repository.MMTServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AWSTestController {

    //@Autowired
    //private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    //private JdbcTemplate jdbcTemplate;

    // @GetMapping("/hello")
    //public String sayHello(@RequestParam(value="myName", defaultValue="AWS test") String name) {

        //final String sql = "SELECT * from mmtdemooutput";
        //List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        //System.out.println (rows);

        @Autowired
        private MMTServiceDAO mmtServiceDAO;

       // @RequestMapping (value="|searchAll", method= RequestMethod.GET)
        @CrossOrigin(origins = "*")
        @GetMapping("/searchAll")
        public List<MMTData> searchAll() {

            System.out.println ("AWS Test Controller calling Getdata");

            List<MMTData> dataList = mmtServiceDAO.findAll();
            return dataList;
         }

        @CrossOrigin(origins = "*")
        @GetMapping("/searchDataByMember/{memberno}")
        public List<MMTData> searchDataByMember(@PathVariable Integer memberno) {

            System.out.println ("AWS Test Controller calling data for member");

            List<MMTData> dataList = mmtServiceDAO.findDataByMemberNo(memberno);
            return dataList;
        }

}
