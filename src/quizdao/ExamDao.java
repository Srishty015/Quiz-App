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
import quizpojo.ExamPojo;
import quizpojo.UserProfile;

/**
 *
 * @author My HP
 */
public class ExamDao {
 public static String getExamId() throws SQLException{
    Connection conn = dbConnection.getConnection();
    int rowCount=0;
    Statement st= conn.createStatement();
    ResultSet rs= st.executeQuery("select count(*) as totalrows from exam");
    if(rs.next()){
     rowCount = rs.getInt(1);
    }
     String newId= "EX-"+(rowCount+1);
   return newId;
 }
 
 public static boolean addExam(ExamPojo newExam) throws SQLException{
  Connection conn = dbConnection.getConnection();
  PreparedStatement ps= conn.prepareStatement("insert into exam values(?,?,? )");
  ps.setString(1, newExam.getExamid());
  ps.setString(2, newExam.getLanguage());
  ps.setInt(3, newExam.getTotalquestions());
  int ans = ps.executeUpdate();
  return ans==1;
          }
 public static boolean isPaperSet(String language)throws SQLException{
     String qry = "select examid from exam where language=?";
     Connection conn  = dbConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement(qry);
     ps.setString(1,language);
     ResultSet rs = ps.executeQuery();
     return rs.next();
 }
 public static ArrayList<String> getExamIdBySubject(String language)throws SQLException{
  String qry= "selct examid from exam where launguage=? minus select examid from performance where userid=?";
  ArrayList<String> examid=new ArrayList<>();
  Connection conn = dbConnection.getConnection();
  PreparedStatement ps = conn.prepareStatement(qry);
  ps.setString(1,language);
  ps.setString(2,UserProfile.getUsername());
  ResultSet rs = ps.executeQuery();
  while(rs.next()){
   examid.add(rs.getString(1));  
  }
  return examid;
 }
 public static int getQuestionCountByExam(String examId) throws SQLException{
     String qry = "select totalquestions from exam wher examid=?";
     Connection conn = dbConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement(qry);
     ps.setString(1, examId);
     ResultSet rs = ps.executeQuery();
     rs.next();
     int rowcount = rs.getInt(1);
     return rowcount;
 }
}
