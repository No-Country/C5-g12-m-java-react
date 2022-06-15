import { takeLatest, all } from 'redux-saga/effects'

import {
    POST_LOGIN_DATA_SAGA, 
    POST_REGISTER_DATA_SAGA,
    GET_DATA_MARKS_SAGA
} from '../types'

import { postLoginDataSaga } from './postLoginDataSaga'
import { postRegisterDataSaga } from './postRegisterDataSaga'
import { getMarksSaga } from './getMarksSaga'

export function* watcherSaga() {
    yield all ([
        takeLatest(POST_LOGIN_DATA_SAGA, postLoginDataSaga), // Login user 
        takeLatest(POST_REGISTER_DATA_SAGA, postRegisterDataSaga), // Register user
        takeLatest(GET_DATA_MARKS_SAGA, getMarksSaga) // GET Marks
    ])
}