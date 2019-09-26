import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { AppComponent } from '../app.component';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  title = 'Project Manager - Spring Boot & Angular Demo';

  // Router Instance (dependency injection, passed as constructor argument)
  constructor(private router : Router) { }

  ngOnInit() {
    console.log(this.title + " has been launched.")
  }

  butHandleWelcomeContinue() {
        this.router.navigate(['project-tasks'])
  }

}
