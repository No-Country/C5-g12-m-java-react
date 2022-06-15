import { combineReducers } from "redux";
import { setLoginFormVisibleReducer } from "./setLoginFormVisibleReducer";

export const rootReducers = combineReducers({
    setLoginFormVisibleReducer: setLoginFormVisibleReducer, // Set visible login form.
})