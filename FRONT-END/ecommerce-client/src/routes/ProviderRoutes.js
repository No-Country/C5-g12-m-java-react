import React, { lazy, Suspense} from 'react'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

import CustomNavbar from '../components/customNavbar/customNavbar';

const HomePage = lazy(() => import('../views/homePage/HomePage'));

const ProviderRoutes = () => {
    return (
        <BrowserRouter>
            <CustomNavbar />
            <Routes>
                <Route path='/' element={<Suspense fallback={ <div>Loading</div> }> <HomePage /> </Suspense> } />
                <Route path="*" element={ <Navigate to="/" replace /> } />
            </Routes>
        </BrowserRouter>
    );
};

export default ProviderRoutes;