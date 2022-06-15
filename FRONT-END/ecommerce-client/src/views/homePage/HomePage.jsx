import React from 'react'
// import style from './HomePageStyle.module.css'

import Announcement from '../../components/Announcement/Announcement'
import Categories from '../../components/Categories/Categories'
import Footer from '../../components/Footer/Footer'
import Navbar from '../../components/Navbar/Navbar'
import Products from '../../components/Products/Products'

const HomePage = () => {
    return (
        <div>
            <Navbar />
            <Announcement />
            <Categories />
            <Products />
            <Footer />
        </div>
    )
}

export default HomePage