package email.config;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailConfig {

    private static final Integer PORT = 587;

    public JavaMailSenderImpl mailSender() {

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(PORT);
        javaMailSender.setUsername("i.popolin");
        javaMailSender.setPassword("andrulik23)");
        javaMailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
        javaMailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");

        return javaMailSender;

    }

}
