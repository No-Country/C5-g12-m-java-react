import React, { lazy, Suspense} from 'react'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

import CustomNavbar from '../components/customNavbar/customNavbar';

const HomePage = lazy(() => import('../views/homePage/HomePage'));
const LoginPage = lazy(() => import('../views/loginPage/LoginPage'))
const ProductsPage = lazy(() => import('../views/productsPage/ProductsPage'))
const MyPurchasePage = lazy(() => import('../views/myPurchasePage/MyPurchasePage'))
const ShoppinCartPage = lazy(() => import('../views/shoppinCartPage/ShoppinCartPage'))

const ProviderRoutes = () => {
    return (
        <BrowserRouter>
            {/* <CustomNavbar /> */}
            <Routes>
                <Route path='/' element={<Suspense fallback={ <div>Loading</div> }> <HomePage /> </Suspense> } />
                <Route path='/login' element={<Suspense fallback={ <div>Loading</div> }> <LoginPage /> </Suspense> } />
                <Route path='/products' element={<Suspense fallback={ <div>Loading</div> }> <ProductsPage /> </Suspense> } />
                <Route path='/purchases' element={<Suspense fallback={ <div>Loading</div> }> <MyPurchasePage /> </Suspense> } />
                <Route path='/shoppinCart' element={<Suspense fallback={ <div>Loading</div> }> <ShoppinCartPage /> </Suspense> } />
                <Route path="*" element={ <Navigate to="/" replace /> } />
            </Routes>
        </BrowserRouter>
    );
};

export default ProviderRoutes;