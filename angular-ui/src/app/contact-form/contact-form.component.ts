import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientRequestsService } from '../service/data/client-requests.service';
import { ClientRequest } from '../client-requests-list/client-requests-list.component';

@Component({
  selector: 'app-angular-ui',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  title = 'Contact Form';
  errorMessage = 'Invalid Value'
  formValidationCheck = true
  
  clientRequest : ClientRequest
  id : number

  constructor(
    private router : Router,
    private clientRequestsService : ClientRequestsService) { }

  ngOnInit() {
    this.clientRequest = new ClientRequest(0,'','','','','','')
  }

 
butHandleSubmitRequest() {
  this.formValidationCheck = true
    if(this.clientRequest.firstName.trim() === '' || this.clientRequest.lastName.trim() === ''){
      this.formValidationCheck = false
      this.errorMessage = 'Please enter First Name and Last name.'
    } else if (this.clientRequest.emailAddress.trim() === '' && this.clientRequest.phone.trim() === ''){
      this.formValidationCheck = false
      this.errorMessage = 'Please enter either Email Address or Phone Number.'
    } else {     
      this.createClientRequest();
    }

 
}

createClientRequest(){
  this.clientRequestsService.createClientRequest(this.clientRequest)
  .subscribe (
    data => {
      console.log(data)
      this.router.navigate(['client-requests-list'])
    }
  )
}


}
