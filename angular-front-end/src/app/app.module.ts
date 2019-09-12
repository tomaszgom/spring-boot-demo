import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { TopmenuComponent } from './topmenu/topmenu.component';
import { FooterComponent } from './footer/footer.component';
import { IssueListComponent } from './issue-list/issue-list.component';
import { IssueFormComponent } from './issue-form/issue-form.component';
import { ErrorHandlerComponent } from './error-handler/error-handler.component';
import { HttpClientModule } from '@angular/common/http';
import { SendUpdateComponent } from './send-update/send-update.component';
import { ProjectTasksComponent } from './project-tasks/project-tasks.component';
import { ProjectSubTasksComponent } from './project-sub-tasks/project-sub-tasks.component';
import { ProjectSubTaskFilterPipe } from './service/pipes/project-sub-task-filter.pipe';
import { ProjectTasksListComponent } from './project-tasks-list/project-tasks-list.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    TopmenuComponent,
    FooterComponent,
    IssueListComponent,
    IssueFormComponent,
    ErrorHandlerComponent,
    SendUpdateComponent,
    ProjectTasksComponent,
    ProjectSubTasksComponent,
    ProjectSubTaskFilterPipe,
    ProjectTasksListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
