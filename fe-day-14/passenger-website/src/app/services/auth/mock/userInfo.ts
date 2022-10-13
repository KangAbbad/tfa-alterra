import { IUserInfoResponse } from "src/app/models/IAuth";

export const USER_INFO_MOCK: IUserInfoResponse = {
  data: {
    ID: 1,
    Fullname: 'fullname',
    Email: 'someone@email.com',
    Password: '123',
  },
};