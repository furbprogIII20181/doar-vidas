import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { State } from '../model/state.model';

@Injectable({
  providedIn: 'root'
})
export class StatesService {

  constructor(private http: HttpClient) { }

  getStates(): Observable<Array<State>> {
    return this.http.get<Array<State>>(environment.api.states).pipe(
      map((res: Array<State>) => {
        return res
      })
    )
  }
}
