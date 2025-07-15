package com.mycompany.userregistr.exceptions;

public class AlreadyRegisteredException extends RuntimeException {
    public String gender;
    public String appeal;
    public AlreadyRegisteredException(String message, String gender) {
        super(message);
        this.gender=gender;
        if(gender.trim().equals("male")){
            appeal="Ser";
        }
        else if(gender.trim().equals("female")){
            appeal="Mam";
        }
        else{
            appeal="friend";
        }
    }

    public String getGender(){
        return gender;
    }
    public String getAppeal(){
        return appeal;
    }
}