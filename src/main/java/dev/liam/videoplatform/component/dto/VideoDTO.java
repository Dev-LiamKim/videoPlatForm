package dev.liam.videoplatform.component.dto;

import java.sql.Date;

public class VideoDTO {

    private int serialNum; 
    private String title;
    private int localNum;
    private Date writeDate;

    public void setSerialNum(int serialNum){
        this.serialNum = serialNum;
    }

    public VideoDTO(String title, int localNum){
        this.title = title;
        this.localNum = localNum;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setLocalNum(int localNum){
        this.localNum = localNum;
    }

    public void setWriteDate(Date writeDate){
        this.writeDate = writeDate;
    }

    public int getSerialNum(){
        return this.serialNum;
    }

    public String getTitle(){
        return this.title;
    }

    public int getLocalNum(){
        return this.localNum;
    }

    public Date getWriteDate(){
        return this.writeDate;
    }
}
