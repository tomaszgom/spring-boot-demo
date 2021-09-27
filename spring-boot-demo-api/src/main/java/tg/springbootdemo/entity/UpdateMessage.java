package tg.springbootdemo.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * UpdateMessage ORM object, not mapped with database,
 * used to handle sending update email notifications
 */

public class UpdateMessage {
	
    @NotNull
    private String fromName;
    
    private String subject;

    @NotNull
    @Email
    private String recipientEmailAddr;

    @NotNull
    @Min(3)
    private String messageBody;

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRecipientEmailAddr() {
        return recipientEmailAddr;
    }

    public void setRecipientEmailAddr(String recipientEmailAddr) {
        this.recipientEmailAddr = recipientEmailAddr;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
