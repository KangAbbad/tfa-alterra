import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';

import { IUserInfo } from 'src/app/models/IAuth';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor() { }

  createSession(userInfo: IUserInfo): void {
    localStorage.setItem('user_info', JSON.stringify(userInfo));
  }

  getSession(): any {
    return JSON.parse(localStorage.getItem('user_info') as string);
  }

  getToken(): any {
    return localStorage.getItem('auth_token');
  }

  isUserLogin(): boolean{
    const authToken = localStorage.getItem('auth_token');
    return authToken ? true : false;
  }

  getEmail(): Observable<string> {
    const email = this.getSession()?.data;
    return of(email)
  }

  destroySession(): void {
    localStorage.clear()
  }
}
