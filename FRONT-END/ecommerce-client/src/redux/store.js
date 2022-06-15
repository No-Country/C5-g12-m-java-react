import { createStore, applyMiddleware } from "redux";
import createSagaMiddleware from "redux-saga";
import { composeWithDevTools } from "redux-devtools-extension";

import { rootReducers } from "./reducers";
import { watcherSaga } from "./sagas";

const sagaMiddleware = createSagaMiddleware();

// Add middlewares here.
const middleWare = [
    sagaMiddleware
]

export const store = createStore(
    rootReducers,
    {},
    composeWithDevTools(applyMiddleware(...middleWare))
)

// Watcher sagas.
sagaMiddleware.run(watcherSaga)