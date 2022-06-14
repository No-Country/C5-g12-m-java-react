import { combineReducers } from "redux";

import { switchLoginRegisterFormReducer } from "./switchLoginRegisterFormReducer";

export const rootReducers = combineReducers({
    switchLoginRegisterFormReducer: switchLoginRegisterFormReducer, // Show Register or Login form.
})