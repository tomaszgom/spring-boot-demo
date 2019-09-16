import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ProjectSubTask } from './model/project-subtask';

@Component({
  selector: 'app-project-sub-tasks',
  templateUrl: './project-sub-tasks.component.html',
  styleUrls: ['./project-sub-tasks.component.css']
})
export class ProjectSubTasksComponent implements OnInit {

  @Input() projectSubTask: ProjectSubTask;
  @Output() projectSubTaskUpdated: EventEmitter<ProjectSubTask> = new EventEmitter<ProjectSubTask>();
  @Output() projectSubTaskDeleted: EventEmitter<ProjectSubTask> = new EventEmitter<ProjectSubTask>();

  constructor() { }

  ngOnInit() {
  }

  updateProjectSubTask() {
    this.projectSubTaskUpdated.emit(this.projectSubTask);
  }

  deleteProjectSubTask() {
    this.projectSubTaskDeleted.emit(this.projectSubTask);
  }

}
