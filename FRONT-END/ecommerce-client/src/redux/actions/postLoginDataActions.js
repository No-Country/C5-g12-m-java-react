import { POST_LOGIN_DATA_SAGA } from "../types"

export const postLoginDataActionSaga = ({email, password}) => ({
  type: POST_LOGIN_DATA_SAGA,
  email: email,
  password: password
})
