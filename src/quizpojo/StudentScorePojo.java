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
public class StudentScorePojo {
    private static String language;
    private static Double per;
     

    public StudentScorePojo() {
    }
public StudentScorePojo(String language,double per){
this.language = language;
this.per = per;
}
    

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String language) {
        StudentScorePojo.language = language;
    }

    public static Double getPer() {
        return per;
    }

    public static void setPer(Double per) {
        StudentScorePojo.per = per;
    }
    
    
}
