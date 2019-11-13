package org.owasp.webgoat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

import java.sql.*;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.Map;


public class DummyClass {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public DummyClass(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    public void sayHello(String name) {
        final String value = String.format(template, name);
    }

    public Connection generateConnection(){
        //TODO: implement a connection method
        return null;
    }

    public double add(int x, int y){
        return (double) x+y;
    }

    public void TestSQLInjection(Integer userId, String password){
       Connection connection = generateConnection();
       try{
           String query = "SELECT * FROM users WHERE userid ='"+ userId + "'" + " AND password='" + password + "'";
           Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery(query);
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }
}
