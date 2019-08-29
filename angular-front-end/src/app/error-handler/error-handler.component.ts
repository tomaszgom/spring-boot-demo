import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error-handler',
  templateUrl: './error-handler.component.html',
  styleUrls: ['./error-handler.component.css']
})
export class ErrorHandlerComponent implements OnInit {

  errorMessage = 'Unknown address :( This might be an error or part of the application still under development.'

  constructor() { }

  ngOnInit() {
  }

}
