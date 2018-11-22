import { Component, OnInit } from '@angular/core';
import {DonatorsService} from "../services/donators.service";
import {GlobalService} from "../services/global.service";
import {DonationList} from "../model/donation.list.model";

@Component({
  selector: 'app-donations',
  templateUrl: './donations.component.html',
  styleUrls: ['./donations.component.css']
})
export class DonationsComponent implements OnInit {

  donations: Array<DonationList>

  constructor(
    private donatorsService: DonatorsService,
    private globalService: GlobalService
  ) { }

  ngOnInit() {
    this.getDonationsByDonator(JSON.parse(localStorage.getItem('user_info')).id)
  }

  removeDonation(id: number) {
    this.donatorsService.removeDonation(id).subscribe(
      response => {
        console.log(response)
        this.globalService.handleSuccess(`Doação excluída com sucesso`)
      },
      error => this.globalService.handleError(error)
    )
  }

  getDonationsByDonator(id: number) {
    this.donatorsService.getDonationsFromDonator(id).subscribe(
      response => {
        // this.donations = response
        console.log(response)
      },
      error => this.globalService.handleError(error)
    )
  }

}
