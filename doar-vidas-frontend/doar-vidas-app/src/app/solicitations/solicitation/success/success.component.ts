import { Component, OnInit } from "@angular/core";
import { GlobalService } from "../../../services/global.service";

@Component({
  selector: "app-success",
  templateUrl: "./success.component.html",
  styleUrls: ["./success.component.css"]
})
export class SuccessComponent implements OnInit {
  constructor(private globalService: GlobalService) {}

  fullName: string;
  institutionDate: string;

  ngOnInit() {
    if (!localStorage.getItem('institutionName')) {
      this.globalService.redirectPerson()
    }
    let institutionName = localStorage.getItem("institutionName");
    let institutionCity = localStorage.getItem("institutionCity");
    let institutionState = localStorage.getItem("institutionState");

    this.fullName =
      institutionName + " - " + institutionCity + " - " + institutionState;

    this.institutionDate = localStorage.getItem("institutionDate");

    localStorage.removeItem('institutionName')
    localStorage.removeItem('institutionDate')
    localStorage.removeItem('institutionCity')
    localStorage.removeItem('institutionState')
  }
}
