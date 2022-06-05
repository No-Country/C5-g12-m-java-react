import React from 'react'
import style from './HomePageStyle.module.css'

import logo from '../../assets/logo.png'

import { BsShop } from 'react-icons/bs'
import { RiOpenArmLine } from 'react-icons/ri'
import { FaShoppingCart } from 'react-icons/fa'

const HomePage = () => {
    return (
        <main className={style.homeContent}>
            <article className={style.alingAside}/>
            <aside className={style.pageContent}>
                <article className={style.titlesContent}>
                    <img className={style.logo} src={logo} alt="logo"/>
                    <h1><i>NoCountry Shop</i></h1>
                </article>
                <article className={style.optContent}>
                    <div className={style.boxItemProducts}>
                        <BsShop />
                        <h1><i>Products</i></h1>
                        <p className={style.descriptionProducts}>Watch</p>
                    </div>
                    <div className={style.boxshoppingProducts}>
                        <RiOpenArmLine />
                        <h1><i>My purchase</i></h1>
                        <p className={style.descriptionProducts}>Watch</p>
                    </div>
                    <div className={style.boxShoppingCart}>
                        <FaShoppingCart />
                        <h1><i>Shopping cart</i></h1>
                        <p className={style.descriptionProducts}>Watch</p>
                    </div>
                </article>
                <footer className={style.footerContent}>
                    <p>
                        <i>For a full experience <a href="/">REGISTER</a> or <a href="/">LOGIN</a></i>    
                    </p>
                </footer>
            </aside>
        </main>
    )
}

export default HomePage