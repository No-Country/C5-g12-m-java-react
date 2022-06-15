import { call, put } from "redux-saga/effects";
import axios from "axios";
import toast from "react-hot-toast";
import {
    POST_REGISTER_DATA_SAGA_ERROR,
    SET_REGISTER_USER_SUCCESS,
    SET_REGISTER_FORM_VISIBLE
} from "../types";

export function* postRegisterDataSaga ({ email, last_name, first_name, phone, password }) {
    yield put ({
        type: SET_REGISTER_FORM_VISIBLE,
        visible: false
    })
    try {
        yield call(axios.post, process.env.REACT_APP_POST_REGISTER, {
            email: email,
            last_name: last_name,
            first_name: first_name,
            phone: phone,
            password: password
        })
        yield put ({
            type: SET_REGISTER_USER_SUCCESS,
            visible: true            
        })
    } catch (error) {
        console.log("Error register: ", error)
        yield put ({
            type: POST_REGISTER_DATA_SAGA_ERROR,
            visible: true
        })
        toast.error("User email exist")
    }
}