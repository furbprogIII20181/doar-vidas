import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GlobalService } from '../services/global.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private globalService: GlobalService ) {}

  ngOnInit() {
    if (this.globalService.getIsLoggedin()) {
      this.globalService.redirectPerson()
    } else {
      this.router.navigate(['/login'])
    }
  }

}
