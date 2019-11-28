/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizpojo;

/**
 *
 * @author My HP
 */
public class ExamPojo {
   private String examid;
   private String language;
   private int totalquestions;

    public ExamPojo(String examid, String language, int totalquestions) {
        this.examid = examid;
        this.language = language;
        this.totalquestions = totalquestions;
    }

    public ExamPojo() {
    }

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTotalquestions() {
        return totalquestions;
    }

    public void setTotalquestions(int totalquestions) {
        this.totalquestions = totalquestions;
    }

    @Override
    public String toString() {
        return "ExamPojo{" + "examid=" + examid + ", language=" + language + ", totalquestions=" + totalquestions + '}';
    }
   
}
