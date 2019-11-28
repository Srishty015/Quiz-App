/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizpojo;

import java.util.ArrayList;

/**
 *
 * @author My HP
 */
public class QuestionStore {
   ArrayList<QuestionPojo> questionlist;
   public QuestionStore(){
       questionlist=new ArrayList<>();
   }
       public void addQuestion(QuestionPojo q){
           questionlist.add(q);
       }
   public QuestionPojo getQuestion(int pos){
    return questionlist.get(pos);
   }   
   public void removeQuestion(int pos){
       questionlist.remove(pos);
   }
   public void setQuestionAt(int pos, QuestionPojo q){
       questionlist.add(pos,q);
   }
   public ArrayList<QuestionPojo> getAllQuestions(){
       return questionlist;
   }
   public int getCount(){
       return questionlist.size();
   }
}
