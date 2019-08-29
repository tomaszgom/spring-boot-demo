import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Issue } from '../issue-list/issue-list.component';
import { IssueDataService } from '../service/data/issue-data.service';


@Component({
  selector: 'app-issue-form',
  templateUrl: './issue-form.component.html',
  styleUrls: ['./issue-form.component.css']
})
export class IssueFormComponent implements OnInit {

  title = 'Issue Form';
  errorMessage = 'Invalid Value'
  formValidationCheck = true
  
  issue : Issue
  id : number

  constructor(
    private router : Router,
    private issueDataService : IssueDataService) { }

  ngOnInit() {
    this.issue = new Issue(0,'','','','','','')
  }


  butHandleSubmitIssue() {
    this.formValidationCheck = true
      if(this.issue.firstName.trim() === '' || this.issue.lastName.trim() === ''){
        this.formValidationCheck = false
        this.errorMessage = 'Please enter First Name and Last name.'
      } else if (this.issue.emailAddress.trim() === '' && this.issue.phone.trim() === ''){
        this.formValidationCheck = false
        this.errorMessage = 'Please enter either Email Address or Phone Number.'
      } else {     
        this.createIssue();
      }
  
   
  }
  
  createIssue(){
    this.issueDataService.createIssue(this.issue)
    .subscribe (
      data => {
        console.log(data)
        this.router.navigate(['issue-list'])
      }
    )
  }




}
