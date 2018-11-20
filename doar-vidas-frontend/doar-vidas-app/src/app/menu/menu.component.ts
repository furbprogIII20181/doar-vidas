import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { GlobalService } from '../services/global.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  menuItems: Array<any>
  isLoggedIn: boolean

  @Input()
  sidenav 

  constructor(
    private router: Router,
    private loginService: LoginService,
    private globalService: GlobalService
  ) { }

  ngOnInit() {
    this.isLoggedIn = this.globalService.getIsLoggedin();
    this.loginService.getIsLoggedInListener().subscribe(isAuthenticated => {
      this.isLoggedIn = isAuthenticated;
    });
    if (this.isLoggedIn) {
      if (this.getTypePerson() == "I") {
        this.menuItems = [
          {
            link: "/donators",
            title: 'Doadores'
          },
          {
            link: "/institution/solicitations",
            title: 'Solicitações'
          },
          {
            link: "/institution/solicitations/new",
            title: 'Nova Solicitação'
          }
        ]
  
      } else {
        this.menuItems = [
          {
            link: "/solicitations",
            title: 'Solicitações'
          }
        ]
      }
    }
  }

  getTypePerson(): string {
    return JSON.parse(localStorage.getItem('user_info')).type
  }

  navigate(url: string) {
    this.sidenav.toggle()
    this.router.navigate([url])
  }

}
