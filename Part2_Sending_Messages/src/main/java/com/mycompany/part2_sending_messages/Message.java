/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part2_sending_messages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


/**
 *
 * @author yanga
 */
public class Message {
    
    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    private int messageNumber;
    
    private static int totalMessages = 0;

    public Message(String recipient, String messageText, int messageNumber) {

        this.recipient = recipient;
        this.messageText = messageText;
        this.messageNumber = messageNumber;

        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }
    
    // Generate MessageID
    private String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }
    
    // Check messageID
     public boolean checkMessageID() {

        return messageID.length() <= 10;
    }
    
    //Check the recepient's number
    public String checkRecipientCell() {

        if (recipient.matches("^\\+27\\d{9}$")) {
            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }
    
    // Create a message hash
    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;
    }
    
    // Send message
    public String sentMessage(int choice) {

        switch (choice) {

            case 1:
                totalMessages++;
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                totalMessages++;
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }
    
    //Print message
    public String printMessages() {

        return "Message ID: " + messageID +
                "\nMessage Hash: " + messageHash +
                "\nRecipient: " + recipient +
                "\nMessage: " + messageText;
    }
    
    // Return total message
    public static int returnTotalMessages() {

        return totalMessages;
    }
    
    // Store message in JSON
    public void storeMessage() {

        try {

            FileWriter writer = new FileWriter("messages.json", true);

            writer.write("{\n");
            writer.write("\"MessageID\": \"" + messageID + "\",\n");
            writer.write("\"MessageHash\": \"" + messageHash + "\",\n");
            writer.write("\"Recipient\": \"" + recipient + "\",\n");
            writer.write("\"Message\": \"" + messageText + "\"\n");
            writer.write("}\n\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error writing to JSON file.");
        }
    }
    
    // Getters
    public String getMessageHash() {
        return messageHash;
    }

    public String getMessageID() {
        return messageID;
    }
    
}
