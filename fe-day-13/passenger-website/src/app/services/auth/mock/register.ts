import { IRegisterResponse } from "src/app/models/IAuth";

export const REGISTER_MOCK: IRegisterResponse = {
  data: {
    ID: 1,
    Fullname: 'fullname',
    Email: 'someone@email.com',
    Password: '123',
  },
};