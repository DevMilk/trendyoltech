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
public class Email implements Post{
    private MailDTO mail;
    
    public Email(MailDTO mail){
        this.mail = mail;
    }
    
    public void send(){
        
        System.out.println(this.mail.getContent());
    }
}
