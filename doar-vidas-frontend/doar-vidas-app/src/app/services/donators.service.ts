import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DonatorsService {

  constructor(private http: HttpClient) { }

  getDonatorInfo(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    let url = environment.api.donatorById + '/'+id+'?access_token=' + localStorage.getItem('access_token')

    return this.http.post<any>(url, "", httpOptions)
  }
}
