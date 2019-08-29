package tg.springbootdemo.mailupdate;

import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * 
 * Module allowing to send updates emails to team members
 *
 */


@Component
public class UpdateMsgEmailSender implements UpdateMsgSender {
    
	private JavaMailSenderImpl mailSender;

    public UpdateMsgEmailSender(Environment environment){
    	
        mailSender = new JavaMailSenderImpl();

        /* Properties from config file: application.properties */
        mailSender.setHost(environment.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(environment.getProperty("spring.mail.port")));
        mailSender.setUsername(environment.getProperty("spring.mail.username"));
        mailSender.setPassword(environment.getProperty("spring.mail.password"));
    }

    @Override
    public void sendUpdateEmail(String fromName, String subject, String recipientEmailAddr, String messageBody){
       
    	SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("ttwillers@gmail.com");
        message.setSubject("Project update from " + fromName + ": "+ subject);
        message.setText(messageBody);
        message.setFrom(fromName);
                       
        this.mailSender.send(message);
    }
}
