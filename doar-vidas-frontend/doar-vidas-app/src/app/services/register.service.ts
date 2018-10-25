import { Injectable } from '@angular/core';
import { Donator } from '../model/donator.model';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Institution } from '../model/institution.model';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  registerDonator(donator: Donator): Observable<Donator> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    return this.http.post<Donator>(environment.api.registerDonator, JSON.stringify(donator), httpOptions)
  }

  registerInstitution(institution: Institution): Observable<Institution> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    return this.http.post<Institution>(environment.api.registerInstitution, JSON.stringify(institution), httpOptions)
  }
}
