import { Injectable } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";

@Injectable()
export class LoginService {
    constructor(private http: HttpClientModule){}

    loginAction(email:String, pass: String) {
        return true;
    }
 }