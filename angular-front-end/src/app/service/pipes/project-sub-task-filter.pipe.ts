import { Pipe, PipeTransform } from '@angular/core';
import { ProjectSubTask } from 'src/app/project-sub-tasks/model/project-subtask';


@Pipe({
  name: 'projectSubTaskFilter'
})
export class ProjectSubTaskFilterPipe implements PipeTransform {

  // search projectSubTasks by provided description and retur matching subtasks
  transform(projectSubTasks: ProjectSubTask[], description: string): ProjectSubTask[] {
    if(description == null || description === ""){
      return projectSubTasks;
    }
    return projectSubTasks.filter(s => s.description.includes(description) || s.description.includes(description));
  }

}
