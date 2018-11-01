import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from '../../environments/environment';
import { UserInfo } from '../model/uset.info.model';
import { Router } from '@angular/router';
import { DonatorPerson } from '../model/donator.person.model';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  constructor(private http: HttpClient, private router: Router) { }

  getIsLoggedin(): boolean {
    if (localStorage.getItem('access_token')) {
      return true;
    }
    return false;
  }

  redirectPerson() {
    let person = JSON.parse(localStorage.getItem("user_info"))

    if (person.type == "D") {
      this.router.navigate(['/solicitations'])
    } else {
      this.router.navigate(['/donators'])
    }
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

  getDonatorsAll(): Observable<Array<DonatorPerson>> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    return this.http.post<Array<DonatorPerson>>(environment.api.donatorsListAll,"",httpOptions)
  }
}
