import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TeamMember } from 'src/app/team-members-list/model/team-member'; // get class from component
import { API_URL } from 'src/app/app.constants';


@Injectable({
  providedIn: 'root'
})
export class TeamMemberDataService {

  constructor(
    private http:HttpClient
  ) { }

  getAllTeamMembers(){
    return this.http.get<TeamMember[]>(`${API_URL}/team-members`);
  }

  deleteTeamMember(id){
    return this.http.delete<TeamMember[]>(`${API_URL}/team-members/${id}`);
  }

  createTeamMember(theTeamMember){
    return this.http.post<TeamMember[]>(`${API_URL}/team-members`, theTeamMember);
  }

}
