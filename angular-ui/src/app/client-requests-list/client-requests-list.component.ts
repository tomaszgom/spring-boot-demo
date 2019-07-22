import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContactFormComponent } from '../contact-form/contact-form.component';
import { ClientRequestsService } from '../service/data/client-requests.service';

export class ClientRequest{

  constructor(
    public id : number,
    public firstName : string,
    public lastName : string,
    public emailAddress : string,
    public postalAddress : string,
    public phone : string,
    public contactPurpose : string
  ) { }

}

@Component({
  selector: 'app-client-requests-list',
  templateUrl: './client-requests-list.component.html',
  styleUrls: ['./client-requests-list.component.css']
})
export class ClientRequestsListComponent implements OnInit {

  clientRequests : ClientRequest[]
  message : string

   // clientRequestsService handles retriving data from database
 constructor(
   private router : Router,
   private clientRequestsService : ClientRequestsService) { }

   // Getting all the Client Requests on init
  ngOnInit() {
    this.refreshRequestsList()
  }
  refreshRequestsList(){
    this.clientRequestsService.getAllClientsRequestsService().subscribe(
      response => {
        console.log(response);
        this.clientRequests = response;
      }
    )
  }

  butHandleGetClientsRequests() {
    this.refreshRequestsList()
  }

  deleteClientRequest(id){
    console.log(`Delete Client Request ${id}` )
    this.clientRequestsService.deleteClientRequest(id).subscribe(
      response => {
        console.log(response);
        this.message = 'Request has been successfully deleted.';
        this.refreshRequestsList()
      }

    )
  }


}
