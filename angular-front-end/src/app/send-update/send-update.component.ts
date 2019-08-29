import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UpdateMessage } from './model/update-message';
import { SendUpdateDataService } from '../service/data/sendUpdate/send-update-data.service';

@Component({
  selector: 'app-send-update',
  templateUrl: './send-update.component.html',
  styleUrls: ['./send-update.component.css']
})
export class SendUpdateComponent implements OnInit {

  // component property 'model' of type UpdateMessage
  updateMessageModel : UpdateMessage ={
    // default values
    fromName:'',
    subject:'',
    recipientEmailAddr:'',
    messageBody:''
  }

  constructor(private sendUpdateDataService : SendUpdateDataService) { }

  ngOnInit() {
  }

  sendUpdate(): void{
  
    if (confirm('Are you sure you want to send update to ' + this.updateMessageModel.recipientEmailAddr + '?')) {

      this.sendUpdateDataService.sendUpdate(this.updateMessageModel).subscribe(
        res => {
         alert("Update has been sent successfully.");
         location.reload()},
        error => {alert("Update could not be send. An error occured.")}
      );

    } else {
      // Do nothing!
    }
  }

}

