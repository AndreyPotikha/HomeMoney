package email;

import email.config.EmailConfig;
import org.springframework.mail.SimpleMailMessage;

import java.util.Random;

public class SerderEmail {

    public void sendMail() {

        SimpleMailMessage message = new SimpleMailMessage();
        Random random = new Random();
        int tempPass = random.nextInt() * 1000;

        message.setSubject("Новый пароль с сайта Home Money");
        message.setTo("i.popolin@gmail.com");
        message.setText(String.valueOf(tempPass));

        new EmailConfig().mailSender().send(message);
    }
}
