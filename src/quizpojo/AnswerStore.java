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
public class AnswerStore {
 ArrayList<AnswerPojo> answerlist;
 public AnswerStore(){
     answerlist = new ArrayList<>();
 }
 public void addAnswer(AnswerPojo ans){
     answerlist.add(ans);
 }
 public AnswerPojo getAnswer(int pos){
     return answerlist.get(pos);
 }
 public void removeAnswer(int pos){
     answerlist.remove(pos);
 }
 public void setAnswerAt(int pos, AnswerPojo ans){
     answerlist.add(pos,ans);
 }
 public ArrayList<AnswerPojo> getAllAnswers(){
     return answerlist;
 }
 public int getCount(){
     return answerlist.size();
 }
 public AnswerPojo getAnswerByQno(int qno){
     for(AnswerPojo answer:answerlist){
         if(answer.getQno()==qno)
             return answer;
     }
     return null;
 }
 public int removeAnswer(AnswerPojo answer){
     int pos = answerlist.indexOf(answer);
     answerlist.remove(pos);
     return pos;
 }
}
