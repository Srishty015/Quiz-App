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
import java.util.ArrayList;
import quizpojo.QuestionPojo;
import quizpojo.QuestionStore;

/**
 *
 * @author My HP
 */
public class QuestionDao {
    public static void addQuestion(QuestionStore qs) throws SQLException{
      Connection conn = dbConnection.getConnection();
      PreparedStatement ps= conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
      ArrayList<QuestionPojo> questionlist= qs.getAllQuestions();
      for(QuestionPojo p: questionlist){
          ps.setString(1,p.getExamid());
          ps.setInt(2,p.getQno());
          ps.setString(3,p.getQuestion());
          ps.setString(4,p.getAnswer1());
          ps.setString(5,p.getAnswer2());
          ps.setString(6,p.getAnswer3());
          ps.setString(7, p.getAnswer4());
          ps.setString(8,p.getCorrectanswer());
          ps.setString(9,p.getLanguage());
          ps.executeUpdate();
      }
    }
    public static ArrayList<QuestionPojo> getQuestionsByExamId(String examid) throws SQLException{
        String qry="select * from questions where examid=? order by qno";
        ArrayList<QuestionPojo> questionlist=new ArrayList<> ();
        Connection conn = dbConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement(qry);
        ps.setString(1, examid);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int qno = rs.getInt(2);
            String questions = rs.getString(3);
            String option1 = rs.getString(4);
            String option2 = rs.getString(5);
            String option3 = rs.getString(6);
            String option4 = rs.getString(7);
            String correctans = rs.getString(8);
            String language = rs.getString(9);
            QuestionPojo obj = new QuestionPojo(examid,qno,language,questions,option1,option2,option3,option4,correctans);
            questionlist.add(obj);
        }
        return questionlist;
    }
    
}
