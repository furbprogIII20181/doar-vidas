import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from '../../environments/environment';
import { Observable, Subject } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LoginService {
    constructor(private http: HttpClient){}

    private isLoggedInListener = new Subject<boolean>();

    getIsLoggedInListener() {
        return this.isLoggedInListener.asObservable();
    }

    loginAction(login:any): Observable<any> {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type':  'application/x-www-form-urlencoded',
                'Authorization': 'Basic ZG9hci12aWRhczpkb2FyLXZpZGFzLXBhc3N3b3Jk'
            })
        }
        return this.http.post<any>(environment.api.login, login.toString(), httpOptions);
    }

    onSuccess(){
        this.isLoggedInListener.next(true);
    }

 }