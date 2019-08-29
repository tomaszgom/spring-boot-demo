import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProjectTask } from 'src/app/project-tasks/model/project-task';
import { Observable } from 'rxjs';
import { API_URL } from 'src/app/app.constants';
import { ProjectSubTask } from 'src/app/project-sub-tasks/model/project-subtask';


@Injectable({
  providedIn: 'root'
})
export class ProjectTaskDataService {

  constructor(private http : HttpClient) { }

  getAllProjectTasks () : Observable<ProjectTask[]>{
    return this.http.get<ProjectTask[]>(`${API_URL}/project-tasks/all`);
  }

  postProjectTask(projectTask: ProjectTask): Observable<ProjectTask>{
    return this.http.post<ProjectTask>(`${API_URL}/project-tasks/new`, projectTask);
  }

  putProjectTask(projectTask: ProjectTask): Observable<ProjectTask>{
    return this.http.put<ProjectTask>(`${API_URL}/project-tasks/update`, projectTask);
  }

  deleteProjectTask(id: number): Observable<any>{
    return this.http.delete(`${API_URL}/project-tasks/${id}`);
  }

//Get all SubTasks
getAllProjectSubTasks (): Observable<ProjectSubTask[]>{
  return this.http.get<ProjectSubTask[]>(`${API_URL}/project-subtasks/all`);
}
//SubTasks by Id
getProjectSubTasksById (projectSubTaskId: number) : Observable<ProjectSubTask>{
  return this.http.get<ProjectSubTask>(`${API_URL}/project-subtasks/byId/${projectSubTaskId}`);
}
// get SubTasks for Task
getProjectSubTasksByProjectTask (projectTaskId: number) : Observable<ProjectSubTask[]>{
  return this.http.get<ProjectSubTask[]>(`${API_URL}/project-subtasks/byProjectTask/${projectTaskId}`);
}

saveProjectSubTask(projectSubTask: ProjectSubTask): Observable<ProjectSubTask>{
    return this.http.post<ProjectSubTask>(`${API_URL}/project-subtasks`, projectSubTask);
}

deleteProjectSubTask(projectSubTaskId: number): Observable<any>{
  return this.http.delete(`${API_URL}/project-subtasks/${projectSubTaskId}`);
}


}
