/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizdao;

import dbconnection.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import quizpojo.UserPojo;

/**
 *
 * @author My HP
 */
public class UserDao {
    public static boolean validateUser(UserPojo obj)throws SQLException{
     Connection conn= dbConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement("select * from users where userid= ? and password= ? and usertype= ?");
     ps.setString(1, obj.getUserid());
     ps.setString(2,obj.getPasswod());
     ps.setString(3, obj.getUsertype());
     ResultSet rs=ps.executeQuery();
     return rs.next();
       }
    public static boolean addUser(UserPojo user) throws SQLException{
     String qry= "select * from users where userid = ?";
     boolean status=true;
     Connection conn = dbConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement(qry);
     ps.setString(1,user.getUserid());
     ResultSet rs= ps.executeQuery();
     if(rs.next()){
         status = false;
     }
     else
     {
         qry = "insert into users values(?,?,?)";
         ps = conn.prepareStatement(qry);
         ps.setString(1,user.getUserid());
         ps.setString(2,user.getPasswod());
         ps.setString(3,user.getUsertype());
         ps.executeUpdate();
     }
     return status;
    }
}
