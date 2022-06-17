import { SET_LOGIN_USER_LOGOUT } from "../types";

const initialState = null

export const setLoginUserLogoutReducer = (state = initialState, { type}) => {
    switch (type) {

    case SET_LOGIN_USER_LOGOUT:
        window.location.replace("/")
        localStorage.clear()
        return state

    default:
        return state
  }
}