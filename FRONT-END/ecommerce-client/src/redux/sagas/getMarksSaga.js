import { GET_DATA_MARKS_SUCCESS, GET_DATA_MARKS_ERROR } from "../types";
import axios from "axios";
import { call, put } from "redux-saga/effects";

export function* getMarksSaga () {
    try {
        const { data } = yield call(axios.get, "https://no-country-back.herokuapp.com/v1/mark/")
        yield put({
            type: GET_DATA_MARKS_SUCCESS,
            marks: data
        })
    } catch (error) {
        yield put({
            type: GET_DATA_MARKS_ERROR,
        })
    }
}