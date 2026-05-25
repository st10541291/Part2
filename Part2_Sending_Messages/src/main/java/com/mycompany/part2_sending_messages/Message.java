/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part2_sending_messages;


/**
 *
 * @author yanga
 */
public class Message {
    
    // Checks that the generated Message ID is 10 characters or less
    public boolean checkMessageID(String messageID){
        if(messageID == null){
            return false;
        }
        return messageID.length() <= 10;
    }
    
    
}
