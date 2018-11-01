import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../services/global.service';
import { Router } from '@angular/router';
import { DonatorPerson } from '../model/donator.person.model';

@Component({
  selector: 'app-donators',
  templateUrl: './donators.component.html',
  styleUrls: ['./donators.component.css']
})
export class DonatorsComponent implements OnInit {

  donatorsPersonArray: Array<DonatorPerson>

  constructor(private globalService: GlobalService, private router: Router) { }

  ngOnInit() {
    if (!this.globalService.getIsLoggedin()) {
      this.router.navigate(['/login']);
    }
    this.getDonatorsAll()
  }

  getDonatorsAll(): void {
    this.globalService.getDonatorsAll().subscribe(response => this.donatorsPersonArray = {... response})
  }

}
