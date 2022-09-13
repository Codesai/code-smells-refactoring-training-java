package birthdaygreetings.test;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;

import birthdaygreetings.BirthdayService;
import birthdaygreetings.OurDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AcceptanceTest {

    private static final int SMTP_PORT = 25;
    private List<Message> messagesSent;
    private BirthdayService service;

    @BeforeEach
    public void setUp() throws Exception {
        messagesSent = new ArrayList<Message>();

        service = new BirthdayService() {
            @Override
            protected void sendMessage(Message msg) throws MessagingException {
                messagesSent.add(msg);
            }
        };
    }

    @Test
    public void baseScenario() throws Exception {

        service.sendGreetings("src/test/resources/employee_data.txt",
                new OurDate("2008/10/08"), "localhost", SMTP_PORT);

        assertEquals(1, messagesSent.size(), "message not sent?");
        Message message = messagesSent.get(0);
        assertEquals("Happy Birthday, dear John!", message.getContent());
        assertEquals("Happy Birthday!", message.getSubject());
        assertEquals(1, message.getAllRecipients().length);
        assertEquals("john.doe@foobar.com",
                message.getAllRecipients()[0].toString());
    }

    @Test
    public void willNotSendEmailsWhenNobodysBirthday() throws Exception {
        service.sendGreetings("src/test/resources/employee_data.txt",
                new OurDate("2008/01/01"), "localhost", SMTP_PORT);

        assertEquals(0, messagesSent.size(), "what? messages?");
    }
}
