import { call, put} from "redux-saga/effects";
import axios from "axios";
import toast from "react-hot-toast";
import { 
    POST_LOGIN_DATA_SAGA_ERROR, 
    SET_LOGIN_FORM_VISIBLE, 
    SET_LOGIN_USER_ACTIVE 
} from "../types";

export function* postLoginDataSaga ({ email, password }) {
    yield put ({
        type: SET_LOGIN_FORM_VISIBLE,
        visible: false
    })
    try {
        const { data } = yield call(axios.post, process.env.REACT_APP_POST_LOGIN, {
            email: email,
            password: password,        
        })
        toast.success("successful login")
        localStorage.setItem("jwt", JSON.stringify(data.jwt))
        localStorage.setItem("jwtRefresh", JSON.stringify(data.jwtRefresh))
        yield put ({
            type: SET_LOGIN_USER_ACTIVE,
            visible: true
        })

    } catch (error) {
        yield put ({
            type: POST_LOGIN_DATA_SAGA_ERROR,
            visible: true
        })
        toast.error("Wrong user, check your email or password")
    }
}