import { call, put } from "redux-saga/effects";
import axios from "axios";
import { SET_LOGIN_USER_ACTIVE, POST_LOGIN_DATA_SAGA_ERROR } from "../types";

export function* postLoginDataSaga ({ email, password }) {
    try {
        // yield console.log(process.env.REACT_APP_POST_LOGIN)
        yield call(axios.post, process.env.REACT_APP_POST_LOGIN, {
            email: email,
            password: password,        
        })
        console.log(SET_LOGIN_USER_ACTIVE)
    } catch (error) {
        yield console.log(POST_LOGIN_DATA_SAGA_ERROR, error)
    }
}