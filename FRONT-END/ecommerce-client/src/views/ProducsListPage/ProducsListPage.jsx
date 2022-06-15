import React from 'react'
import Announcement from '../../components/Announcement/Announcement'
import Footer from '../../components/Footer/Footer'
import Navbar from '../../components/Navbar/Navbar'
import Products from '../../components/Products/Products'
import style from './ProducsListPageStyle.module.css'

const ProducsListPage = () => {
    return (
        <div>
            <Navbar/>
            <Announcement />
            <h1 className={style.title}>Products</h1>
            <main className={style.filterContainer}>
                <article className={style.filter}>
                    <span className={style.filterText}>Filter products: </span>
                    <select className={style.select}>
                        <option disabled selected>
                            color
                        </option>
                            <pption>White</pption>
                            <option>Black</option>
                            <option>Red</option>
                            <option>Blue</option>
                            <option>Yellow</option>
                            <option>Green</option>
                    </select>
                    <select className={style.select}>
                        <option disabled selected>
                            color2
                        </option>
                            <pption>White</pption>
                            <option>Black</option>
                            <option>Red</option>
                            <option>Blue</option>
                            <option>Yellow</option>
                            <option>Green</option>
                    </select>
                </article>
            </main>
                <Products />
            <Footer />
        </div>
    )
}

export default ProducsListPage