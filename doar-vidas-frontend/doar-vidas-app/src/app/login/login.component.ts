import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { GlobalService } from '../services/global.service';

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
      (error) => this.globalService.handleError(error)
    )
  }

  onSuccess(data) {
    localStorage.setItem('access_token',data.access_token)
    this.globalService.getUserByEmail(this.loginForm.get('email').value).subscribe (
      (data) => { 
        localStorage.setItem('user_info', JSON.stringify(data))
        this.globalService.handleSuccess(`Bem vindo, ${data.name}`)
        if (data.type == 'D') {
          this.router.navigate(['/solicitations']);
        } else {
          this.router.navigate(['/donators']);
        }
      },
      (error) => this.globalService.handleError(error)
    )
  }

  handleError(error) {
    console.log(error)
  }

  getUserByEmail(email): any {
    return this.globalService.getUserByEmail(email).subscribe(
      (data) => data,
      (error) => this.globalService.handleError(error)
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
