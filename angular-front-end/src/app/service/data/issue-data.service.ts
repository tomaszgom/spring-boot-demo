import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Issue } from '../../issue-list/issue-list.component'; // get class from component
import { API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class IssueDataService {

  constructor(
    private http:HttpClient
  ) { }

  getAllIssues(){
    return this.http.get<Issue[]>(`${API_URL}/issues`);
  }

  deleteIssue(id){
    return this.http.delete<Issue[]>(`${API_URL}/issue/${id}`);
  }

  createIssue(issue){
    return this.http.post<Issue[]>(`${API_URL}/issues`, issue);
  }

}
