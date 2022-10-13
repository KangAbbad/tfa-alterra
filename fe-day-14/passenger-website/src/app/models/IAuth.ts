export interface ILoginRequest {
  email: string;
  password: string;
}

export interface ILoginResponse {
  data: string;
}

export interface IRegisterRequest {
  email: string;
  password: string;
  fullname: string;
}

export interface IRegisterResponse {
  data: {
    ID: number;
    Fullname: string;
    Email: string;
    Password: string;
  };
}

export interface IUserInfo {
  id: number;
  email: string;
  fullname: string;
  password: string;
}

export interface IUserInfoResponse extends IRegisterResponse {
}