import { SWITCH_LOGIN_REGISTER_FORM } from "../types"

const initialState = true

export const switchLoginRegisterFormReducer = (state = initialState, { type }) => {
    switch (type) {

    case SWITCH_LOGIN_REGISTER_FORM:
        return !state

    default:
        return state
    }
}
