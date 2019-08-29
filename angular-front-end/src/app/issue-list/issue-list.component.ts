import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IssueDataService } from '../service/data/issue-data.service';

export class Issue {

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
  selector: 'app-issue-list',
  templateUrl: './issue-list.component.html',
  styleUrls: ['./issue-list.component.css']
})
export class IssueListComponent implements OnInit {

  issues : Issue[]
  message : string

     // issueService handles retriving data from database
  constructor(
    private router : Router,
    private issueService : IssueDataService ) { }

    // Getting all the Issues on init
    ngOnInit() {
      this.refreshIssuesList()
    }

    refreshIssuesList(){
      this.issueService.getAllIssues().subscribe(
        response => {
          console.log(response);
          this.issues = response;
        }
      )
    }
  
    butHandleGetIssues() {
      this.refreshIssuesList()
    }
  
    deleteIssue(id){
      console.log(`Delete Issue ${id}` )
      this.issueService.deleteIssue(id).subscribe(
        response => {
          console.log(response);
          this.message = 'Issue has been successfully deleted.';
          this.refreshIssuesList()
        }
  
      )
    }

}
