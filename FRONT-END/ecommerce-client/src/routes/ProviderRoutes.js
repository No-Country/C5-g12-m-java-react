import React, { lazy, Suspense} from 'react'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

const HomePage = lazy(() => import('../views/homePage/HomePage'));
const LoginPage = lazy(() => import('../views/LoginPage/LoginPage'))
const RegisterPage = lazy(() => import('../views/RegisterPage/RegisterPage'))
const ProductPage = lazy(() => import('../views/ProductPage/ProductPage'))
const ProducsListPage = lazy(() => import('../views/ProducsListPage/ProducsListPage'))
const CartPage = lazy(() => import('../views/CartPage/CartPage'))

const ProviderRoutes = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Suspense fallback={ <div>Loading</div> }> <HomePage /> </Suspense> } />
                <Route path='/login' element={<Suspense fallback={ <div>Loading</div> }> <LoginPage /> </Suspense> } />
                <Route path='/register' element={<Suspense fallback={ <div>Loading</div> }> <RegisterPage /> </Suspense> } />
                <Route path='/product' element={<Suspense fallback={ <div>Loading</div> }> <ProductPage /> </Suspense> } />
                <Route path='/productList' element={<Suspense fallback={ <div>Loading</div> }> <ProducsListPage /> </Suspense> } />
                <Route path='/cart' element={<Suspense fallback={ <div>Loading</div> }> <CartPage /> </Suspense> } />
                <Route path="*" element={ <Navigate to="/" replace /> } />
            </Routes>
        </BrowserRouter>
    );
};

export default ProviderRoutes;