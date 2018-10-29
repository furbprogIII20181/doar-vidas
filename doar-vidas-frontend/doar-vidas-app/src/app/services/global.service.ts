import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { environment } from '../../environments/environment';
import { UserInfo } from './uset.info.model';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  constructor(private http: HttpClient) { }

  getIsLoggedin(): boolean {
    if (localStorage.getItem('access_token')) {
      return true;
    }
    return false;
  }

  getUserByEmail(email: string): Observable<UserInfo> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    const body = {
      "email": email
    }
    return this.http.post<UserInfo>(environment.api.getUserInfo + "?access_token=" + localStorage.getItem('access_token'), body, httpOptions)
  }
}
