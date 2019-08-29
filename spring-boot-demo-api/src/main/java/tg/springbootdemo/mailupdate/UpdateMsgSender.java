package tg.springbootdemo.mailupdate;

public interface UpdateMsgSender {
    void sendUpdateEmail(String fromName, String subject, String recipientEmailAddr, String messageBody);
}
