import React, { useEffect } from 'react'
import { useDispatch } from 'react-redux'
import style from './HomePageStyle.module.css'

import Announcement from '../../components/Announcement/Announcement'
import Categories from '../../components/Categories/Categories'
import Footer from '../../components/Footer/Footer'
import Navbar from '../../components/Navbar/Navbar'
import Products from '../../components/Products/Products'
import { getMarksSagaAction } from '../../redux/actions/getMarksAction'
import { getProductsSagaAction } from '../../redux/actions/getProductsAction'
const HomePage = () => {

    const dispatch = useDispatch()

     // Load marks,
     useEffect(() => {
        dispatch(getMarksSagaAction())
        dispatch(getProductsSagaAction())
    }, [dispatch])


    return (
        <div className={style.homeContent}>
            <Announcement />
            <Categories />
            <article className={style.bodyContent}>
                <div className={style.navbarPosition}>
                    <Navbar />
                </div>
                <Products />
            </article>
            <Footer />
        </div>
    )
}

export default HomePage