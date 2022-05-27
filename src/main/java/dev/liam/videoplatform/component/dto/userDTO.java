package dev.liam.videoplatform.component.dto;

import java.sql.Date;

public class userDTO {
    private String userId;
    private String userPassword;
    private String Email;
    private Date birthDay;
    

    public void setUserId(String userId){
        this.userId = userId;
    }

    public void setuserPassword(String userPassword){
        this.userPassword = userPassword;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public void setBirthDay(Date birthDay){
        this.birthDay = birthDay;
    }

    public String getUserId(){
        return this.userId;
    }

    public String getUserPassword(){
        return this.userPassword;
    }

    public String getEmail(){
        return this.Email;
    }

    public Date getBirthDay(){
        return this.birthDay;
    }
}
