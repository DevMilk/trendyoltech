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
public class SMS implements Post{
    
    private SMSDTO sms;
    
    public SMS(SMSDTO sms){
        this.sms = sms;
    }
    
    public void send(){
        
        System.out.println(this.sms.getContent());
    }
}
