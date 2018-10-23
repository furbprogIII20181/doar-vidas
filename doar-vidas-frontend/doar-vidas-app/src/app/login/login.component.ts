import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup
  
  hide = true;

  constructor(private formBuilder: FormBuilder, private loginService: LoginService) { }

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
    // let formData = new FormData();
    // formData.append("username", username)
    // formData.append("password", password)
    // formData.append("grant_type", "password")
    this.loginService.loginAction(body).subscribe(response => {
      console.log(response)
    })
  }

  onSubmit() {
    let username = this.loginForm.get('email').value
    let password = this.loginForm.get('password').value
    this.loginAction(username, password)
  }
}
