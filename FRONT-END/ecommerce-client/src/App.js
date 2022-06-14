import React from 'react';
import ProviderRoutes from './routes/ProviderRoutes';
import { Provider } from 'react-redux';

import { store } from './redux/store';

const App = () => {
    return (
        <Provider store={store}>
            <ProviderRoutes />
        </Provider>
    );
};

export default App