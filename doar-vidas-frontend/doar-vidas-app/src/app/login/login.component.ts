import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup
  
  hide = true;

  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private router: Router) { }

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
    this.router.navigate(['/solicitations']);
  }

  handleError(error) {
    console.log(error)
  }

  onSubmit() {
    if (this.loginForm.valid) {
      let username = this.loginForm.get('email').value
      let password = this.loginForm.get('password').value
      this.loginAction(username, password)
    }
  }
}
