import React from 'react';
import ProviderRoutes from './routes/ProviderRoutes';
import { Provider } from 'react-redux';

import { store } from './redux/store';
import ToastNotification from './components/ToastNotification/ToastNotification';

const App = () => {
    return (
        <Provider store={store}>
            <ToastNotification />
            <ProviderRoutes />
        </Provider>
    );
};

export default App