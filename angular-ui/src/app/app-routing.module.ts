import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { ContactFormComponent } from './contact-form/contact-form.component';
import { ErrorComponent } from './error/error.component';
import { ClientRequestsListComponent } from './client-requests-list/client-requests-list.component';

// Routing
const routes: Routes = [
  { path: '', component: WelcomeComponent}, // Default path is Welcome component
  { path: 'welcome', component: WelcomeComponent},
  { path: 'contact-form', component: ContactFormComponent},
  { path: 'client-requests-list', component: ClientRequestsListComponent},
  { path: '**', component: ErrorComponent} //* sign match anything, this path have to be the last
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
