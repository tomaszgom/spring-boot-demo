import { NgModule } from '@angular/core';
import { Routes, RouterModule, Router } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { IssueListComponent } from './issue-list/issue-list.component';
import { IssueFormComponent } from './issue-form/issue-form.component';
import { ErrorHandlerComponent } from './error-handler/error-handler.component';
import { SendUpdateComponent } from './send-update/send-update.component';
import { ProjectTasksComponent } from './project-tasks/project-tasks.component';


// Routing
const appRoutes: Routes = [
  { path: '', component: WelcomeComponent}, // Default path to Welcome component
  { path: 'welcome', component: WelcomeComponent},
  { path: 'issue-form', component: IssueFormComponent},
  { path: 'issue-list', component: IssueListComponent},
  { path: 'send-update', component: SendUpdateComponent},
  { path: 'project-tasks', component: ProjectTasksComponent},
  { path: '**', component: ErrorHandlerComponent} //* sign match anything, handles error address requests path have to be the last
];

@NgModule({
  imports: [ RouterModule.forRoot(appRoutes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
