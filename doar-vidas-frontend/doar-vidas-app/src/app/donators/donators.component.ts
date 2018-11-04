import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../services/global.service';
import { Router } from '@angular/router';
import { DonatorPerson } from '../model/donator.person.model';
import { MatTableDataSource } from "@angular/material";

@Component({
  selector: 'app-donators',
  templateUrl: './donators.component.html',
  styleUrls: ['./donators.component.css']
})
export class DonatorsComponent implements OnInit {

  donatorsPersonArray: Array<DonatorPerson>

  donatorsTable;

  constructor(private globalService: GlobalService, private router: Router) { }

  ngOnInit() {
    //if (!this.globalService.getIsLoggedin()) {
      //this.router.navigate(['/login']);
    //}
    this.getDonatorsAll();
  }

  getDonatorsAll(): void {
    this.globalService.getDonatorsAll().subscribe(response => {
      this.donatorsPersonArray = response;
      this.donatorsTable = new MatTableDataSource(this.donatorsPersonArray);
    },
    (error) => this.globalService.handleError(error))
  }

  applyFilter(filterValue: string) {
    this.donatorsTable.filter = filterValue.trim().toLowerCase();
  }

  displayedColumns: string[] = [
    "img",
    "name",
    "city",
    "state",
    "bloodType",
    "actions"
  ];

}
