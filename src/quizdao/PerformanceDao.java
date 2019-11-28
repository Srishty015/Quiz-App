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
import java.util.ArrayList;
import quizpojo.PerformancePojo;
import quizpojo.StudentScorePojo;

/**
 *
 * @author My HP
 */
public class PerformanceDao {
    public static ArrayList<String> getAllStudent() throws SQLException{
    String qry = "select distinct userid from performance";
ArrayList<String> studentlist = new ArrayList<> ();
Connection conn = dbConnection.getConnection();
Statement st = conn.createStatement();
ResultSet rs= st.executeQuery(qry);
while(rs.next()){
    String studentid = rs.getString(1);
    studentlist.add(studentid);
}
return studentlist;

    }
 public static ArrayList<String> getAllExamId(String studentid) throws SQLException   
 {
     ArrayList<String> examid = new ArrayList<String> ();
     Connection conn = dbConnection.getConnection();
     String qry = "select examid from performance where userid = ?";
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery(qry);
     while(rs.next()){
         String examId = rs.getString(1);
         examid.add(examId);
     }
     return examid;
 }
 public static StudentScorePojo getScore(String studentid,String examid) throws SQLException{
  String qry="select language,per from performance where userid=? and examid=?";
  Connection conn = dbConnection.getConnection();
  PreparedStatement ps = conn.prepareStatement(qry);
  ps.setString(1,studentid);
  ps.setString(2, examid);
  ResultSet rs  = ps.executeQuery();
  rs.next();
  StudentScorePojo studentscore = new StudentScorePojo();
  studentscore.setLanguage(rs.getString(1));
  studentscore.setPer(rs.getDouble(2));
  return studentscore;
 }
 public static void addPerformance(PerformancePojo performance)throws SQLException{
     String qry="insert into performance values(?,?,?,?,?,?,?)";
     Connection conn = dbConnection.getConnection();
     PreparedStatement ps= conn.prepareStatement(qry);
     ps.setString(1,performance.getUserid());
     ps.setString(2, performance.getExamid());
     ps.setInt(3,performance.getRight());
     ps.setInt(4, performance.getWrong());
     ps.setInt(5, performance.getUnattempted());
     ps.setDouble(6, performance.getPer());
     ps.setString(7,performance.getLanguage());
     ps.executeUpdate();
    
 }
}
