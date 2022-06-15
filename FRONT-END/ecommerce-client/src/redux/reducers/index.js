import { combineReducers } from "redux";
import { getMarksReducer } from "./getMarksReducer";
import { setLoginFormVisibleReducer } from "./setLoginFormVisibleReducer";
import { setLoginUserLogoutReducer } from "./setLoginUserLogoutReducer";
import { setRegisterFormVisibleReducer } from "./setRegisterFormVisibleReducer";

export const rootReducers = combineReducers({
    setLoginFormVisibleReducer: setLoginFormVisibleReducer, // Set visible login form.
    setLoginUserLogoutReducer: setLoginUserLogoutReducer, // Clear local storage info user.
    setRegisterFormVisibleReducer: setRegisterFormVisibleReducer, // Set visible register form.
    getMarksReducer: getMarksReducer, // Get Marks.
})