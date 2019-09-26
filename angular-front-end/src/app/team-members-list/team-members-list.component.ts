import { Component, OnInit } from '@angular/core';
import { TeamMember } from './model/team-member';
import { Router } from '@angular/router';
import { TeamMemberDataService } from '../service/data/teamMember/team-member-data.service';

@Component({
  selector: 'app-team-members-list',
  templateUrl: './team-members-list.component.html',
  styleUrls: ['./team-members-list.component.css']
})
export class TeamMembersListComponent implements OnInit {

  teamMembers : TeamMember[]
  message : string

     // team Member Service handles retriving data from database
  constructor(
    private router : Router,
    private teamMemberDataService : TeamMemberDataService ) { }

    // Getting all the TeamMembers on init
    ngOnInit() {
      this.refreshTeamMembersList()
    }

    refreshTeamMembersList(){
      this.teamMemberDataService.getAllTeamMembers().subscribe(
        response => {
          console.log(response);
          this.teamMembers = response;
        }
      )
    }
  
    butHandleGetTeamMemers() {
      this.refreshTeamMembersList()
    }
  
    deleteTeamMemer(teamMemberId: number){
      console.log(`Delete TeamMemer ${teamMemberId}` )
      this.teamMemberDataService.deleteTeamMember(teamMemberId).subscribe(
        response => {
          console.log(response);
          this.message = 'Team Member has been successfully deleted.';
          this.refreshTeamMembersList()
        }
  
      )
    }

}

