import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ClientRequest } from '../../client-requests-list/client-requests-list.component';
import { API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class ClientRequestsService {

  constructor(
    private http:HttpClient
  ) { }

  getAllClientsRequestsService(){
    return this.http.get<ClientRequest[]>(`${API_URL}/client-requests`);
  }

  deleteClientRequest(id){
    return this.http.delete<ClientRequest[]>(`${API_URL}/client-requests/${id}`);
  }

  createClientRequest(clientRequest){
    return this.http.post<ClientRequest[]>(`${API_URL}/client-requests`, clientRequest);
  }

}
