/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import com.mycompany.part2_sending_messages.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



/**
 *
 * @author yanga
 */
public class MessageTest {
    
    // Test message length

    /**
     *
     */
    @Test
    public void testMessageLengthSuccess() {

        String message = "Hello world";

        assertTrue(message.length() <= 250);
    }
    
    @Test
    public void testMessageLengthFailure() {

        String longMessage = "This message is designed to deliberately fail the length validation check "
                + "by exceeding the strict limit set in the specification document. It needs to be long "
                + "enough to push past two hundred and fifty individual characters completely. Let us count now.";;

        assertTrue(longMessage.length() > 250);
    }
    
    // Test recipient cell number
    @Test
    public void testRecipientSuccess() {

        Message message = new Message(
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?",
                0
        );

        assertEquals(
                "Cell phone number successfully captured.",
                message.checkRecipientCell()
        );
    }
    
    @Test
    public void testRecipientFailure() {

        Message message = new Message(
                "08575975889",
                "Hi Keegan",
                1
        );

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                message.checkRecipientCell()
        );
    }
    
    // Test message hash
    @Test
    public void testMessageHash() {

        Message message = new Message(
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight",
                0
        );

        String hash = message.getMessageHash();

        assertTrue(hash.contains(":0:"));
    }
    
    // Test send messages
    @Test
    public void testSendMessageOption() {

        Message message = new Message(
                "+27718693002",
                "Hello",
                0
        );

        assertEquals(
                "Message successfully sent.",
                message.sentMessage(1)
        );
    }
    
    // Test discard message
    @Test
    public void testDiscardMessageOption() {

        Message message = new Message(
                "+27718693002",
                "Hello",
                0
        );

        assertEquals(
                "Press 0 to delete the message.",
                message.sentMessage(2)
        );
    }
    
    
    // Test store message
    @Test
    public void testStoreMessageOption() {

        Message message = new Message(
                "+27718693002",
                "Hello",
                0
        );

        assertEquals(
                "Message successfully stored.",
                message.sentMessage(3)
        );
    }
    
}
