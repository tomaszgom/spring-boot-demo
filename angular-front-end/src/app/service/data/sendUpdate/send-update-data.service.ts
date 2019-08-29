import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UpdateMessage } from 'src/app/send-update/model/update-message';
import { API_URL } from 'src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class SendUpdateDataService {

  constructor(private http : HttpClient) { }

  // Send update update with post method and UpdateMessage model
  
  sendUpdate(updateMessage : UpdateMessage) : Observable<any>{
    return this.http.post(`${API_URL}/send-update`, updateMessage);
  }

}
