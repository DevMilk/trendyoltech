/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trendyoltech;

/**
 *
 * @author Ugur
 */
public class Sender {
    
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected int emailCounter;
    protected int smsCounter;
    protected int emailQuota;
    protected int smsQuota;
    protected Language language;
    
    public Sender(String name, String email, String phoneNumber, int smsQuota, int emailQuota, Language language) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.emailCounter = 0;
        this.smsCounter = 0;
        this.emailQuota = emailQuota;
        this.smsQuota = smsQuota;
        this.language =language;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getEmailCounter() {
        return emailCounter;
    }

    public void setEmailCounter(int emailCounter) {
        this.emailCounter = emailCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getSmsCounter() {
        return smsCounter;
    }

    public void setSmsCounter(int smsCounter) {
        this.smsCounter = smsCounter;
    }

    public int getEmailQuota() {
        return emailQuota;
    }

    public void setEmailQuota(int emailQuota) {
        this.emailQuota = emailQuota;
    }

    public int getSmsQuota() {
        return smsQuota;
    }

    public void setSmsQuota(int smsQuota) {
        this.smsQuota = smsQuota;
    }
    
    
    public void checkSMSQuota() throws QuotaReachedException{
        if(smsCounter + 1 > smsQuota  ){
            throw new QuotaReachedException("SMS "+language.returnMessage());
        }
    }
    public void checkEmailQuota() throws QuotaReachedException{
        if(emailCounter + 1 > emailQuota  )
            throw new QuotaReachedException("Email "+language.returnMessage());

    }
    public void sendSMS(SMS sms){
        try{
            checkSMSQuota();
            sms.send();
            smsCounter++;
        }
        catch(QuotaReachedException e){
            e.printStackTrace();
        }
        
    }
    
    public void sendEmail(Email email){
        try{
            checkEmailQuota();
            email.send();
            emailCounter++;
        }
        catch(QuotaReachedException e){
            e.printStackTrace();
        }
        
    }
}
