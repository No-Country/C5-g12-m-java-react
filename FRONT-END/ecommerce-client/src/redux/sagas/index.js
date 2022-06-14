import { takeLatest, all } from 'redux-saga/effects'

import {
    POST_LOGIN_DATA_SAGA
} from '../types'

import { postLoginDataSaga } from './postLoginDataSaga'

export function* watcherSaga() {
    yield all ([
        takeLatest(POST_LOGIN_DATA_SAGA, postLoginDataSaga),
    ])
}