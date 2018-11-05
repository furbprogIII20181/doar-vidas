import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Solicitation } from "../model/solicitation.model";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment";

@Injectable({
  providedIn: "root"
})
export class SolicitationsService {
  constructor(private http: HttpClient) {}

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

  getAllSolicitations(): Observable<Array<Solicitation>> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    let url = environment.api.solicitationsListAll + "?access_token=" + localStorage.getItem('access_token');
    return this.http.post<Array<Solicitation>>(url,"",httpOptions)
  }

  getSolicitation(id:number): Observable<Solicitation> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }

    let url = environment.api.solicitationById + '/'+id+'?access_token=' + localStorage.getItem('access_token')
    return this.http.post<Solicitation>(url, "", httpOptions)
  }
}
