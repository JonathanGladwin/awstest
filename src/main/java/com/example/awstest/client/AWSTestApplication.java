package com.example.awstest.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@ComponentScan ("com.example.awstest")
public class AWSTestApplication extends SpringBootServletInitializer
        implements WebApplicationInitializer {
   // @Autowired
    //private MMTServiceDAO mmtServiceDAO;

    public static void main(String[] args) {
        System.out.println("Welcome");

        SpringApplication.run(AWSTestApplication.class, args);
    }

    /*public void run (String... arg0) throws Exception
    {
        System.out.println("inside run");
        List<MMTData> dataList = mmtServiceDAO.findAll();
        System.out.println(dataList);
    }*/
}
