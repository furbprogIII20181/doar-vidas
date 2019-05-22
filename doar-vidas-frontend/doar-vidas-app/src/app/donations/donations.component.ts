import { Component, OnInit } from "@angular/core";
import { DonatorsService } from "../services/donators.service";
import { MatTableDataSource } from "@angular/material";
import { GlobalService } from "../services/global.service";
import { DonationList } from "../model/donation.list.model";

@Component({
  selector: "app-donations",
  templateUrl: "./donations.component.html",
  styleUrls: ["./donations.component.css"]
})
export class DonationsComponent implements OnInit {
  donations: Array<DonationList>;

  donationsTable;

  constructor(
    private donatorsService: DonatorsService,
    private globalService: GlobalService
  ) {}

  ngOnInit() {
    this.getDonationsByDonator(
      JSON.parse(localStorage.getItem("user_info")).id
    );
  }

  deleteDonation(id: number) {
    this.donatorsService.removeDonation(id).subscribe(
      response => {
        this.globalService.handleSuccess(`Doação excluída com sucesso`);
        this.getDonationsByDonator(
          JSON.parse(localStorage.getItem("user_info")).id
        );
      },
      error => this.globalService.handleError(error)
    );
  }

  getDonationsByDonator(id: number) {
    this.donatorsService.getDonationsFromDonator(id).subscribe(
      response => {
        this.donations = response;
        this.donationsTable = new MatTableDataSource(this.donations);
      },
      error => this.globalService.handleError(error)
    );
  }

  displayedColumns: string[] = [
    "id",
    "institutionName",
    "city",
    "state",
    "donationDate",
    "actions"
  ];

  applyFilter(filterValue: string) {
    this.donationsTable.filter = filterValue.trim().toLowerCase();
  }
}
