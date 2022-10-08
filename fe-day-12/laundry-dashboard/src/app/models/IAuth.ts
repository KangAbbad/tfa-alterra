export interface ILoginRequest {
  email: string;
  password: string;
}

export interface IRegisterRequest {
  email: string;
  password: string;
  fullname: string;
}

export interface IUserInfo {
  id: number;
  email: string;
  fullname: string;
  password: string;
}
