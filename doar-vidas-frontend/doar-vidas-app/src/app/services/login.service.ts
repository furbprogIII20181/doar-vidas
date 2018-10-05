import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LoginService {
    constructor(private http: HttpClient){}

    loginAction(login:any): Observable<string> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type':  'application/json'
            })
        }
        return this.http.post<string>(environment.api.login, JSON.stringify(login), httpOptions);
    }
 }