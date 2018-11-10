import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Solicitation } from "../model/solicitation.model";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment";
import {Donation} from "../model/donation.model";
import { Router } from "@angular/router";

@Injectable({
  providedIn: "root"
})
export class SolicitationsService {
  constructor(private http: HttpClient, private router: Router) {}

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

  getAllSolicitationsByInstitutionID(): Observable<Array<Solicitation>> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    let institutionId = 12;
    let url = environment.api.solicitationByInstitutionId + '/'+institutionId+'?access_token=' + localStorage.getItem('access_token');
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

  saveDonation(donation: Donation): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    let url = environment.api.saveDonation + "?access_token=" + localStorage.getItem('access_token');
    return this.http.post<any>(url,JSON.stringify(donation),httpOptions)
  }

  succesAction(data:any) {
    localStorage.setItem('institutionName',data.institution.name + " " + data.institution.lastName)
    localStorage.setItem('institutionCity',data.institution.city)
    localStorage.setItem('institutionState',data.institution.state)
    localStorage.setItem('institutionDate',data.date)
    this.router.navigate(['/solicitations/success'])
  }
}
