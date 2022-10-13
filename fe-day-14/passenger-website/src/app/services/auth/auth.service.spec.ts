import { HttpClientTestingModule, HttpTestingController } from "@angular/common/http/testing";
import { TestBed } from "@angular/core/testing";

import { ILoginRequest, IRegisterRequest } from "src/app/models/IAuth";
import { AuthService } from "./auth.service";
import { LOGIN_MOCK } from "./mock/login";
import { REGISTER_MOCK } from "./mock/register";
import { USER_INFO_MOCK } from "./mock/userInfo";

describe('AuthService', () => {
  let authService: AuthService;
  let httpTesting: HttpTestingController;
  let baseUrl: string = 'https://alta-shop.herokuapp.com/api';

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AuthService],
    });
    authService = TestBed.inject(AuthService);
    httpTesting = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTesting.verify()
  });

  it('should be created', () => {
    expect(authService).toBeTruthy();
  });

  it('should get auth token when login', () => {
    const body: ILoginRequest = { email: 'someone@email.com', password: '123123' };
    authService.httpCreateLogin(body).subscribe((res) => {
      expect(res).toEqual(LOGIN_MOCK);
    });

    const req = httpTesting.expectOne({
      method: 'POST',
      url: `${baseUrl}/auth/login`,
    });
    req.flush(LOGIN_MOCK);
  });

  it('should get account when signup', () => {
    const body: IRegisterRequest = {
      email: 'someone@mail.com',
      password: '123123',
      fullname: 'Firstname Lastname',
    };
    authService.httpCreateRegister(body).subscribe((res) => {
      expect(res).toEqual(REGISTER_MOCK);
    });

    const req = httpTesting.expectOne({
      method: 'POST',
      url: `${baseUrl}/auth/register`,
    });
    req.flush(REGISTER_MOCK);
  });

  it('should get account detail', () => {
    authService.httpGetUserInfo().subscribe((res) => {
      expect(res).toEqual(USER_INFO_MOCK);
    });

    const req = httpTesting.expectOne({
      method: 'GET',
      url: `${baseUrl}/auth/info`,
    });
    req.flush(USER_INFO_MOCK);
  });
});