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
        
        System.out.println("Welcome to QuickChat.");
        
        System.out.print("Enter the number of messages you wish to send: ");
        int numMessages = scanner.nextInt();
        scanner.nextLine();
        
        // Parallel Arrays
        
        String [] messageID =  new String[numMessages];
        String [] messageHash = new String[numMessages];
        String [] recepient = new String[numMessages];
        String [] messageText = new String[numMessages];
        
        int messageProcessedCount = 0;
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
            
            
            
            
        }
        
        
    }
}
