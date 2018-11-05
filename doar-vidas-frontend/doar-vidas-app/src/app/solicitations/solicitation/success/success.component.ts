import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-success",
  templateUrl: "./success.component.html",
  styleUrls: ["./success.component.css"]
})
export class SuccessComponent implements OnInit {
  constructor() {}

  fullName: string;
  institutionDate: string;

  ngOnInit() {
    let institutionName = localStorage.getItem("institutionName");
    let institutionCity = localStorage.getItem("institutionCity");
    let institutionState = localStorage.getItem("institutionState");

    this.fullName =
      institutionName + " - " + institutionCity + " - " + institutionState;

    this.institutionDate = localStorage.getItem("institutionDate");
  }
}
