import {
    GET_DATA_PRODUCTS_SUCCESS, 
    GET_DATA_PRODUCTS_ERROR 
} from '../types'
import axios from "axios";
import { call, put } from "redux-saga/effects";

export function* getProducsSaga () {
    try {
        const { data } = yield call(axios.get, "https://no-country-back.herokuapp.com/v1/product/products")
        yield put({
            type: GET_DATA_PRODUCTS_SUCCESS,
            products: data
        })
    } catch (error) {
        yield put({
            type: GET_DATA_PRODUCTS_ERROR,
        })
    }
}