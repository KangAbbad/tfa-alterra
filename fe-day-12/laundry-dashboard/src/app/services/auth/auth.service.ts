import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { ILoginRequest, IRegisterRequest } from 'src/app/models/IAuth';

@Injectable()
export class AuthService {
  private baseUrl: string = 'https://alta-shop.herokuapp.com/api';

  constructor(private http: HttpClient) {}

  httpCreateLogin(body: ILoginRequest): Observable<Object> {
    return this.http.post(`${this.baseUrl}/auth/login`, body);
  }

  httpCreateRegister(body: IRegisterRequest): Observable<Object> {
    return this.http.post(`${this.baseUrl}/auth/register`, body);
  }

  httpGetUserInfo(): Observable<any> {
    return this.http.get(`${this.baseUrl}/auth/info`);
  }
}
