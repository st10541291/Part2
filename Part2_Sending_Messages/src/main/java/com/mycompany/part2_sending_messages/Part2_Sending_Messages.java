/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part2_sending_messages;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author yanga
 */
public class Part2_Sending_Messages {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);
        Random random = new Random();
        Message message = new Message();
        
        
        System.out.println("Welcome to QuickChat.");
        
        System.out.print("Enter the number of messages you wish to send: ");
        int maxMessages = scanner.nextInt();
        scanner.nextLine();
        
        // Parallel Arrays
        
        String [] messageID =  new String[maxMessages];
        String [] messageHash = new String[maxMessages];
        String [] recepient = new String[maxMessages];
        String [] messageText = new String[maxMessages];
        
        int messagesProcessedCount = 0;
        int totalSuccessfulSends = 0;
        
        boolean running = true;
        
        while(running){
            // Display Start Menu
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            // Check which choice a user selected from the menu
            switch(choice){
                case 1:
                    // Loop to make sure messages sent equal to number chose at the beginning
                    while(messagesProcessedCount < maxMessages){
                        System.out.println("--- Composing Message (" + (messagesProcessedCount + 1) + " of " + maxMessages + ") ---");
                        
                        long num = 1000000000L + (long)(random.nextDouble() * 9000000000L);
                        String generatedID = String.valueOf(num);
                        
                        if(!message.checkMessageID(generatedID)){
                            System.out.println("Error: Failed internal tracking ID length validation.");
                            break;
                        }
                        
                        String recipientResult = "";
                        String cell = "";
                        
                        while(recipientResult.equals("Cell phone number successfully captured.")){
                            System.out.println("Enter recipient cell phone number (e.g., +27123456):");
                            cell = scanner.nextLine();
                            recipientResult = message.checkRecipientCell(cell);
                            System.out.println(recipientResult);
                        }
                        
                        // Validate length of message less than 250 characters
                        String text = "";
                        boolean validText = false;
                        while(validText){
                            System.out.print("Enter your message (Max 250 chars): ");
                            text = scanner.nextLine();
                            
                            if(text.length() <= 250){
                                System.out.println("Message sent");
                                validText = true;
                            }
                            else{
                                int extra = text.length() - 250;
                                System.out.println("Message exceeds 250 characters by " + extra + "; please reduce the size.");
                            }
                        }
                        
                        messagesProcessedCount = messagesProcessedCount + 1;
                    }
                    break;
                    
                case 2:
                    // Coming soon feature
                    System.out.println("Coming Soon.");
                    break;
                    
                case 3:
                    System.out.println("Exiting QuickChat...");
                    break;
                   
                default:
                    System.out.println("Invalid option.");
                 
            }
        }
        
        scanner.close();
    }
}
