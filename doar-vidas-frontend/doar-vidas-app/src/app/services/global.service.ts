import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  constructor() { }

  getIsLoggedin(): boolean {
    if (localStorage.getItem('access_token')) {
      return true;
    }
    return false;
  }
}
