import {
    POST_REGISTER_DATA_SAGA_ERROR,
    SET_REGISTER_USER_SUCCESS,
    SET_REGISTER_FORM_VISIBLE
} from "../types";

const initialState = true

export const setRegisterFormVisibleReducer = (state = initialState, { type, visible }) => {
    switch (type) {

    case SET_REGISTER_FORM_VISIBLE:
        return state = visible 

    case SET_REGISTER_USER_SUCCESS:
        window.location.replace("/login")    
        return state = visible
        
    case POST_REGISTER_DATA_SAGA_ERROR:
        return state = visible

    default:
      return state
    }
}