import { POST_REGISTER_DATA_SAGA } from "../types";

export const postRegisterDataSagaAction = ({email, last_name, first_name, phone, password}) => ({
    type: POST_REGISTER_DATA_SAGA,
    email: email,
    first_name: first_name,
    last_name: last_name,
    phone: phone,
    password: password
})
