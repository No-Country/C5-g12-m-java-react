import {
    GET_DATA_PRODUCTS_SUCCESS, 
    GET_DATA_PRODUCTS_ERROR 
} from '../types'

const initialState = []

export const getProductsReducer = (state = initialState, { type, products }) => {
    switch (type) {

    case GET_DATA_PRODUCTS_SUCCESS:
        return state = products
    case GET_DATA_PRODUCTS_ERROR:
        return state

    default:
        return state
    }
}