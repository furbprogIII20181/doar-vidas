import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { GlobalService } from '../services/global.service';
import { MyUser } from '../model/myuser.model';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: any;

  constructor(private userService: UserService, private globalService: GlobalService) { }

  ngOnInit() {
    this.getUserInfo();
  }

  getUserInfo (){
    let id = JSON.parse(localStorage.getItem('user_info')).id;
    this.userService
      .getUserInfo(id)
      .subscribe(
        response => this.user = response,
        (error) => this.globalService.handleError(error)
      )
  }

  getMappedBlood(bloodType: string): string {
    return this.globalService.convertBloodType(bloodType)
  }

}
