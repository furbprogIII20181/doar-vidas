import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { GlobalService } from '../services/global.service';
import { UserInfo } from '../services/uset.info.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup
  
  hide = true;

  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private router: Router, private globalService: GlobalService) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: this.formBuilder.control('', [Validators.required, Validators.email]),
      password: this.formBuilder.control('',[Validators.required, Validators.minLength(6)])
    })
  }

  loginAction(username: string, password:string) {
    const body = new HttpParams()
      .set(`username`, username)
      .set(`password`, password)
      .set(`grant_type`, `password`);

    this.loginService.loginAction(body).subscribe(
      (data) => this.onSuccess(data),
      (error) => this.handleError(error)
    )
  }

  onSuccess(data) {
    localStorage.setItem('access_token',data.access_token)
    const user: UserInfo = this.getUserByEmail(this.loginForm.get('username'))
    if (user.type == 'D') {
      this.router.navigate(['/solicitations']);
    } else {
      // rota de pj
    }
  }

  handleError(error) {
    console.log(error)
  }

  getUserByEmail(email): any {
    return this.globalService.getUserByEmail(email).subscribe(
      (data) => data,
      (error) => this.handleError(error)
    )
  }

  onSubmit() {
    if (this.loginForm.valid) {
      let username = this.loginForm.get('email').value
      let password = this.loginForm.get('password').value
      this.loginAction(username, password)
    }
  }
}
