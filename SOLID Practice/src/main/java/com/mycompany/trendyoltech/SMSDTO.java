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
public class SMSDTO extends PostDTO{
    
    private String phoneNumber;
    
    public SMSDTO(String phoneNumber, String content){
        super(content);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
