import { 
    POST_LOGIN_DATA_SAGA_ERROR, 
    SET_LOGIN_FORM_VISIBLE, 
    SET_LOGIN_USER_ACTIVE
} from "../types";

const initialState = true

export const setLoginFormVisibleReducer = (state = initialState, { type, visible }) => {
    switch (type) {

    case SET_LOGIN_FORM_VISIBLE:
        return state = visible 

    case SET_LOGIN_USER_ACTIVE:
        window.location.replace("/")    
        return state = visible
        
    case POST_LOGIN_DATA_SAGA_ERROR:
        return state = visible

    default:
      return state
    }
}
