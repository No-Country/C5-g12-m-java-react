import { GET_DATA_MARKS_SUCCESS, GET_DATA_MARKS_ERROR } from "../types";

const initialState = []

export const getMarksReducer = (state = initialState, { type, marks }) => {
    switch (type) {

    case GET_DATA_MARKS_SUCCESS:
        return state = marks

    case GET_DATA_MARKS_ERROR:
        return state
        
    default:
        return state
    }
}