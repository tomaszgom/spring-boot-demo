package tg.springbootdemo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import tg.springbootdemo.entity.UpdateMessage;
import tg.springbootdemo.mailupdate.UpdateMsgSender;

import javax.validation.ValidationException;

/**
 * Controller handling request for sending email notifications
 */

@RestController
@RequestMapping("/send-update")
@CrossOrigin
public class UpdateMessageController {
	
	// Injects sender
    private UpdateMsgSender updateMsgSender;

    public UpdateMessageController(UpdateMsgSender updateMsgSender) {
        this.updateMsgSender = updateMsgSender;
    }

    
    // Receive POST with updateMessage Model and pass email detail to Message Sender
    @PostMapping
    public void sendUpdate(@RequestBody UpdateMessage updateMessage,
                             BindingResult bindingResult){
    	        
    	
        if(bindingResult.hasErrors()){
            throw new ValidationException("Update has not been sent, it contains errors.");
        }

        this.updateMsgSender.sendUpdateEmail(
        		updateMessage.getFromName(),
        		updateMessage.getSubject(),
        		updateMessage.getRecipientEmailAddr(),
        		updateMessage.getMessageBody()
        		);
    }
}
