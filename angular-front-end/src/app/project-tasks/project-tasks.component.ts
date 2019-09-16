import { Component, OnInit } from '@angular/core';
import { ProjectTask } from './model/project-task';
import { ProjectTaskDataService } from '../service/data/projectTask/project-task-data.service';
import { ProjectSubTask } from '../project-sub-tasks/model/project-subtask';

@Component({
  selector: 'app-project-tasks',
  templateUrl: './project-tasks.component.html',
  styleUrls: ['./project-tasks.component.css']
})
export class ProjectTasksComponent implements OnInit {

  projectTasks:  ProjectTask[] = [];
  projectSubTasks: ProjectSubTask[] = [];
  selectedProjectTask: ProjectTask;  // holds information on current ProjectTask clicked, to be able to know to which item add subtask
  searchTaskDescription: String;
  deleteFlg : boolean;


  constructor(private projectTaskDataService : ProjectTaskDataService) { }

  ngOnInit() {
    this.getAllProjectTasks();
    this.getAllProjectSubTasks();
    this.deleteFlg = false;

  }

  public getAllProjectTasks(){
      this.projectTaskDataService.getAllProjectTasks().subscribe(
        res => { this.projectTasks = res; //using typed response which contains array of objects 
        },
        error => { alert("An error occured. Project Task list could not be loaded.")
        }
      )
  }


  public getAllProjectSubTasks(){
    this.projectTaskDataService.getAllProjectSubTasks().subscribe(
      res => { this.projectSubTasks = res; //using typed response which contains array of objects 
      },
      error => { alert("An error occured. Project Sub-Task list could not be loaded.")
      }
    )
}



  createProjectTask(){
    let newProjectTask : ProjectTask = {
      id : null,
      title : 'New Project Task',
      description : 'Description',
      status : 'Open',
      priority : 'Low',
      deadLineDate : new Date()
    }

    this.projectTaskDataService.postProjectTask(newProjectTask).subscribe(
      res => {
        newProjectTask.id = res.id;
        this.projectTasks.push(newProjectTask);
      },
      error => {alert("An error occured. Project Task could not be created.")}
    )

  }

  updateProjectTask(updateProjectTask : ProjectTask){
    this.projectTaskDataService.putProjectTask(updateProjectTask).subscribe(
      res => {
      },
      error => {alert("An error occured. Project Task could not be changed.")}
    )
  }

  updateProjectSubTask(projectSubTask : ProjectSubTask){
    this.projectTaskDataService.saveProjectSubTask(projectSubTask).subscribe(
      res => {
        alert("Project Sub-task successfully updated.")},
      error => {alert("Error: Project Sub-task could not be saved.")}
    )
  }

  deleteProjectTask(deleteProjectTask : ProjectTask){
    if(confirm("Are you sure you want to delete Project Task?")){
      this.deleteFlg = true;
        this.projectTaskDataService.deleteProjectTask(deleteProjectTask.id).subscribe(
          res => {
            let arrIndxofProjectTask = this.projectTasks.indexOf(deleteProjectTask);
            this.projectTasks.splice(arrIndxofProjectTask, 1)  //splice remove element from the array
            {alert("Project Task successfully deleted.")
            this.deleteFlg = false;
          }
          },
          error => {alert("Error: Project Task could not be deleted.")}
          
        );
    }
  }

  deleteProjectSubTask(projectSubTask: ProjectSubTask){
    if(confirm("Are you sure you want to delete Sub-task?")){
      this.projectTaskDataService.deleteProjectSubTask(projectSubTask.id).subscribe(
        res => {
            let indexOfSubTask = this.projectSubTasks.indexOf(projectSubTask);
            this.projectSubTasks.splice(indexOfSubTask, 1);
            this.getAllProjectSubTasks();
        },
        error => {alert("Error: Sub-task could not be deleted.")}
        )
    }
  }

  createProjectSubTask(projectTaskId: number){

      let newProjectSubTask: ProjectSubTask = {
        id: null,
        title: "New Sub-task",
        description: "Write Sub-task description here...",
        status: "Created",
        priority: "Low",
        deadLineDate: null,
        projectTask: projectTaskId
      };

      this.projectTaskDataService.saveProjectSubTask(newProjectSubTask).subscribe(
        res => {
          newProjectSubTask.id = res.id;
          this.projectSubTasks.push(newProjectSubTask);
        },
        error => {alert("Error: Sub-task could not be saved.")}
      );

  }

  selectProjectTask(projectTask: ProjectTask){
    
    if(this.deleteFlg == false){
          this.selectedProjectTask = projectTask;
      // Grab all the SubTasks for this Task only
      this.projectTaskDataService.getProjectSubTasksByProjectTask(projectTask.id).subscribe(
        res => {
          this.projectSubTasks = res;
        },
        error => {alert("Error: Sub-tasks for the Task could not be loaded.")}
      )
    };  

  }

  selectAllProjectSubTasks(){
    this.selectedProjectTask = null;
    this.getAllProjectSubTasks;
  }

}
