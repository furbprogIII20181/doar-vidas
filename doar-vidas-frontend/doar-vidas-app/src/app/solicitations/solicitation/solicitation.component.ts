import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../../services/global.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-solicitation',
  templateUrl: './solicitation.component.html',
  styleUrls: ['./solicitation.component.css']
})
export class SolicitationComponent implements OnInit {

  constructor(private globalService: GlobalService, private router: Router) { }

  ngOnInit() {
    if (!this.globalService.getIsLoggedin()) {
        this.router.navigate(['/login']);
    }
  }

}
