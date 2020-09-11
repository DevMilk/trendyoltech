/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trendyoltech;

/**
 *
 * @author Ugur
 *  
 */
public class MailDTO extends PostDTO{
    
    private String mail;
    public MailDTO(String mail, String content){
        super(content);
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
