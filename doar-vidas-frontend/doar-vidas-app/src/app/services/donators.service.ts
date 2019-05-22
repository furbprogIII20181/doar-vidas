import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import {DonationList} from "../model/donation.list.model";

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

    return this.http.get<any>(url, httpOptions)
  }

  getDonationsFromDonator(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    let url = environment.api.getUserDonations + '/'+id+'?access_token=' + localStorage.getItem('access_token')

    return this.http.get<Array<DonationList>>(url, httpOptions)
  }

  removeDonation(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    }
    let url = environment.api.deleteDonation + '/'+id+'?access_token=' + localStorage.getItem('access_token')

    return this.http.delete(url, httpOptions)

  }
}
