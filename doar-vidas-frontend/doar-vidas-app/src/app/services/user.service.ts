import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUserInfo(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    let url = environment.api.getMyUserInfo + '/'+id+'?access_token=' + localStorage.getItem('access_token')

    return this.http.get<any>(url, httpOptions)
  }

  updateUserInfo(body: any, id:number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    let url = environment.api.updateUserInfo + '/'+id+'?access_token=' + localStorage.getItem('access_token')

    return this.http.patch(url, JSON.stringify(body), httpOptions)
  }

}
