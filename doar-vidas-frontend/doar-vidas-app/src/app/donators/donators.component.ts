import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../services/global.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-donators',
  templateUrl: './donators.component.html',
  styleUrls: ['./donators.component.css']
})
export class DonatorsComponent implements OnInit {

  constructor(private globalService: GlobalService, private router: Router) { }

  ngOnInit() {
    if (!this.globalService.getIsLoggedin()) {
      this.router.navigate(['/login']);
    }
  }

}
