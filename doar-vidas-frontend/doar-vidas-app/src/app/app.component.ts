import { Component } from "@angular/core";
import { GlobalService } from "./services/global.service";
import { LoginService } from "./services/login.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = "Doar Vidas";
  isLoggedIn: boolean;

  constructor(
    private loginService: LoginService,
    private globalService: GlobalService
  ) {}

  ngOnInit() {
    this.isLoggedIn = this.globalService.getIsLoggedin();
    this.loginService.getIsLoggedInListener().subscribe(isAuthenticated => {
      this.isLoggedIn = isAuthenticated;
    });
  }

  logout() {
    this.loginService.logout();
  }
}
