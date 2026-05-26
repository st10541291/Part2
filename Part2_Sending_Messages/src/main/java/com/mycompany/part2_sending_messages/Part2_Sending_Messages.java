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
        
        // Print the welcome message
        System.out.println("Welcome to QuickChat.");
        
        // Get number of messages and declare array to store messages
        System.out.print("How many messages would you like to send? ");
        int totalMessages = scanner.nextInt();
        scanner.nextLine();

        // Parallel arrays
        String[] messageIDs = new String[totalMessages];
        String[] recipients = new String[totalMessages];
        String[] messages = new String[totalMessages];
        String[] messageHashes = new String[totalMessages];

        int messageCounter = 0;
        int menuChoice;
        
        do {

            System.out.println("\n===== QUICKCHAT MENU =====");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            System.out.print("Choose option: ");

            menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {

                case 1:

                    if (messageCounter >= totalMessages) {
                        System.out.println("You have reached your message limit.");
                        break;
                    }

                    System.out.print("Enter recipient cell number: ");
                    String recipient = scanner.nextLine();

                    System.out.print("Enter message: ");
                    String messageText = scanner.nextLine();

                    Message message = new Message(recipient, messageText, messageCounter);

                    // Validate recipient
                    System.out.println(message.checkRecipientCell());

                    if (!message.checkRecipientCell().equals("Cell phone number successfully captured.")) {
                        break;
                    }

                    // Validate message length
                    if (messageText.length() > 250) {
                        int exceededBy = messageText.length() - 250;
                        System.out.println(
                                "Message exceeds 250 characters by " + exceededBy +
                                "; please reduce the size.");
                        break;
                    } else {
                        System.out.println("Message ready to send.");
                    }

                    // Send options
                    System.out.println("\nChoose option:");
                    System.out.println("1. Send Message");
                    System.out.println("2. Disregard Message");
                    System.out.println("3. Store Message to send later");

                    int sendChoice = scanner.nextInt();
                    scanner.nextLine();

                    String result = message.sentMessage(sendChoice);
                    System.out.println(result);

                    if (sendChoice == 1 || sendChoice == 3) {

                        // Store in parallel arrays
                        messageIDs[messageCounter] = message.getMessageID();
                        recipients[messageCounter] = recipient;
                        messages[messageCounter] = messageText;
                        messageHashes[messageCounter] = message.getMessageHash();

                        message.storeMessage();

                        System.out.println("\n===== MESSAGE DETAILS =====");
                        System.out.println(message.printMessages());

                        messageCounter++;
                    }

                    break;

                case 2:
                    System.out.println("Coming Soon.");
                    break;

                case 3:
                    System.out.println("Exiting QuickChat...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (menuChoice != 3);
        
        System.out.println("\nTotal messages sent: " + Message.returnTotalMessages());
    }
}
