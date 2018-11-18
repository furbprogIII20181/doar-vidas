import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from '../../environments/environment';
import { UserInfo } from '../model/uset.info.model';
import { Router } from '@angular/router';
import { DonatorPerson } from '../model/donator.person.model';
import { MatSnackBar } from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  constructor(
    private http: HttpClient,
    private router: Router,
    public snackBar: MatSnackBar
  ) { }

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
    return this.http.get<Array<DonatorPerson>>(environment.api.donatorsListAll, httpOptions)
  }

  handleError(error) {
    // if (error.error.error_description) {
    //   alert(error.error.error_description)
    // } else {
    //   alert(error.error.message)
    // }
    if (error.status == 401) {
      localStorage.clear()
      this.router.navigate(['/login'])
    }
    this.handleErrorMessage(error.message)
  }
  
  handleErrorMessage(message) {
    this.snackBar.open(message, '', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: "error-snack"
    })
  }

  handleSuccess(message) {
    this.snackBar.open(message, '', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: "success-snack"
    })
  }

  convertBloodType(code: string): string {
    switch (code) {
      case "APOS":
        return "A+";
      case "ANEG":
        return "A-";
      case "BPOS":
        return "B+";
      case "BNEG":
        return "B-";
      case "ABPOS":
        return "AB+";
      case "ABNEG":
        return "AB-";
      case "OPOS":
        return "O+";
      case "ONEG":
        return "O-";
      default:
        return "";
    }
  }

}
