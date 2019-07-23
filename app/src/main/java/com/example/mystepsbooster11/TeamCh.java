package com.example.mystepsbooster11;

public class TeamCh {

    private String  TNameYourChallenge;
    private String TStartDate;
    private String  TEndDate;
    private String TLengthOfTheChallenge;


    public TeamCh(){


    }

    public TeamCh(String TNameYourChallenge, String TStartDate, String TEndDate, String TLengthOfTheChallenge) {
        this.TNameYourChallenge = TNameYourChallenge;
        this.TStartDate = TStartDate;
        this.TEndDate = TEndDate;
        this.TLengthOfTheChallenge = TLengthOfTheChallenge;
    }

    public String getTNameYourChallenge() {
        return TNameYourChallenge;
    }

    public String getTStartDate() {
        return TStartDate;
    }

    public String getTEndDate() {
        return TEndDate;
    }

    public String getTLengthOfTheChallenge() {
        return TLengthOfTheChallenge;
    }
}



