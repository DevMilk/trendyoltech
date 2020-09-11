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
public class Company extends Sender{

    public Company(String name, String email, String phoneNumber, int smsQuota, int emailQuota, Language language) {
        super(name,email, phoneNumber, smsQuota, emailQuota,language);
    }
    
}
