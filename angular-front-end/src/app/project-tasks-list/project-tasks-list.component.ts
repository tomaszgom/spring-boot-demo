import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectTaskDataService } from '../service/data/projectTask/project-task-data.service';
import { ProjectTask } from '../project-tasks/model/project-task';

export class ProjectTask1 {

  constructor(
    public id : number,
    public title : string,
    public description : string,
    public status : string,
    public priority : string,
    public deadlineDate : Date
  ) { }

}

@Component({
  selector: 'app-project-tasks-list',
  templateUrl: './project-tasks-list.component.html',
  styleUrls: ['./project-tasks-list.component.css']
})
export class ProjectTasksListComponent implements OnInit {

  projectTasks:  ProjectTask[] = [];
  message : string;

     // ProjectTaskDataService handles retriving data from database
  constructor(
    private router : Router,
    private projectTaskDataService : ProjectTaskDataService ) { }
  
    // Getting all the Issues on init
    ngOnInit() {
      this.refreshProjectTasksList()
    }

    refreshProjectTasksList(){
      this.projectTaskDataService.getAllProjectTasks().subscribe(
        response => {
          console.log(response);
          this.projectTasks = response;
        }
      )
    }

    public getAllProjectTasks(){
      this.projectTaskDataService.getAllProjectTasks().subscribe(
        res => { this.projectTasks = res; //using typed response which contains array of objects 
        },
        error => { alert("An error occured. Project Task list could not be loaded.")
        }
      )
  }
  
    butHandleGetProjectTasks() {
      this.refreshProjectTasksList();
    }
  
    deleteProjectTask(id){
      console.log(`Delete Project Task ${id}` )
      this.projectTaskDataService.deleteProjectTask(id).subscribe(
        response => {
          console.log(response);
          this.message = 'Project Task has been successfully deleted.';
          this.refreshProjectTasksList();
        }
  
      )
    }

}
