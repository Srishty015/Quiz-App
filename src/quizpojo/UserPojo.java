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
public class UserPojo {
    private String userid;
    private String passwod;
    private String usertype;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswod() {
        return passwod;
    }

    public void setPasswod(String passwod) {
        this.passwod = passwod;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public UserPojo() {
    }

    public UserPojo(String userid, String passwod, String usertype) {
        this.userid = userid;
        this.passwod = passwod;
        this.usertype = usertype;
    }
    
    
    
}
