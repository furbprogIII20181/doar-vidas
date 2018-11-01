import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root"
})
export class SolicitationsService {
  constructor() {}

  convertBloodType(code: string): string {
    switch (code) {
      case "APOS":
        return "A+";
      case "ANEG":
        return "A-";
      case "BPOS":
        return "B+";
      case "BNEG":
        return "B-";
      case "ABPOS":
        return "AB+";
      case "ABNEG":
        return "AB-";
      case "OPOS":
        return "O+";
      case "ONEG":
        return "O-";
      default:
        return "";
    }
  }
}
