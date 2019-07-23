package com.example.mystepsbooster11;

public class CHYourself {

    private String  NameYourChallenge,StartDate,EndDate,DailyStepGoal,LengthOfTheChallenge;

    public CHYourself(){

    }

    CHYourself(String NameYourChallenge, String StartDate, String EndDate, String DailyStepGoal, String LengthOfTheChallenge) {
        this.NameYourChallenge = NameYourChallenge;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.DailyStepGoal = DailyStepGoal;
        this.LengthOfTheChallenge = LengthOfTheChallenge;
    }

    public String getNameYourChallenge() {
        return NameYourChallenge;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public String getDailyStepGoal() {
        return DailyStepGoal;
    }

    public String getLengthOfTheChallenge() {
        return LengthOfTheChallenge;
    }
}









