import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../services/global.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DonatorsService } from '../services/donators.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  donator: any

  constructor(
    private globalService: GlobalService,
    private router: Router,
    private route: ActivatedRoute,
    private donatorsService: DonatorsService,
    private location: Location
  ) {}

  ngOnInit() {
    if (!this.globalService.getIsLoggedin()) {
     this.router.navigate(['/login']);
    }
    this.getDonatorInfo()
  }

  getDonatorInfo() {
    const donatorId = this.route.snapshot.params.id;

    this.donatorsService
      .getDonatorInfo(donatorId)
      .subscribe(
        response => this.donator = response,
        (error) => this.globalService.handleError(error)
      )
  }

  getMappedBlood(bloodType: string): string {
    return this.globalService.convertBloodType(bloodType)
  }

  back() {
    this.location.back(); // <-- go back to previous location on cancel
  }

}
