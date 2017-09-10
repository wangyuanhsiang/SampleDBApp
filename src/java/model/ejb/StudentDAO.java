/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ejb;


import java.sql.Connection;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Shawn
 */
@Stateless
public class StudentDAO {
     @Resource(mappedName="jdbc/mySampleDB")
    private DataSource ds;
     
     public void retrieveData(){
         try {
             Connection conn = ds.getConnection();
             ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STUDENT");
             while(rs.next()){
                 System.out.println(rs.getString("StudentID"));
                 System.out.println(rs.getString("Name"));
                 System.out.println(rs.getString("Address"));
             }
             conn.close();
         } catch (Exception e) {
             System.err.println(e.getMessage());
         }
     
     
     }
     
     
     
     
}
