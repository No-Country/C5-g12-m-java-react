<<<<<<< HEAD
import React, {useEffect, useState} from 'react'
=======
import React from 'react'
>>>>>>> b4ccb1608cc963da56df8373a591ed33268d51dd
import style from './customNavbarStyle.module.css'
import { Link } from 'react-router-dom'

import { GoSearch } from 'react-icons/go'
import { FiShoppingCart } from 'react-icons/fi'
import { BiUser } from 'react-icons/bi'
import { MdOutlineSort } from 'react-icons/md'

import logoApp from '../../assets/logo.png'

<<<<<<< HEAD
import { SearchInput } from './navigationManners/SearchInput/SearchInput'
// import { ShoppingCart } from './navigationManners/shoppingCart/ShoppingCart'
import { UserProfile } from './navigationManners/userProfile/userProfile'

const CustomNavbar = () => {

    const [inputSearch, setInputSearch] = useState(style.formSearchInvisible) // Search input visible/invisible.
    const [shoppingCart, setShoppingCart] = useState(style.shoppingCart) // User login visible/invisible.

    // Click on search icon.
    const handleSearchAction = () => {
        if (inputSearch === style.formSearchInvisible) {
            setInputSearch(style.formSearch)
        } else {
            setInputSearch(style.formSearchInvisible)
        }
        console.log("click")
    }

    const handleUserAction = () => {
        if (shoppingCart === style.shoppingCartInvisible) {
            setShoppingCart(style.shoppingCart)
        } else {
            setShoppingCart(style.shoppingCartInvisible)
        }
        console.log("click")
    }

    // Render component
    return (
        <div className={style.pageNav}>
            <nav className={style.navContent}>
                <section>
                    <img className={style.logoImg} src={logoApp} alt="logo" />
                </section>
                <section className={style.linksContent}>
                    <div className={style.links}>
                        <Link to="/"> Home </Link>
                        <Link to="/"> Products </Link>
                        <Link to="/"> Categories </Link>
                        <Link to="/"> About us </Link>
                    </div>
                </section>
                <section className={style.otpContent}>
                    <ul>
                        <li className={style.linksIcon}> <MdOutlineSort /> </li>
                        <li onClick={handleSearchAction}><GoSearch /></li>
                        <li onClick={handleUserAction}><BiUser /></li>
                        <li><FiShoppingCart /></li>
                    </ul>
                </section>
            </nav>
            <SearchInput className={inputSearch}/>
            <UserProfile className={shoppingCart} />
        </div>
=======
const CustomNavbar = () => {
    return (
        <nav className={style.navContent}>
            <section>
                <img className={style.logoImg} src={logoApp} alt="logo" />
            </section>
            <section className={style.linksContent}>
                <div className={style.links}>
                    <Link to="/"> Home </Link>
                    <Link to="/"> Products </Link>
                    <Link to="/"> Categories </Link>
                    <Link to="/"> About us </Link>
                </div>
            </section>
            <section className={style.otpContent}>
                <ul>
                    <li><GoSearch /></li>
                    <li><BiUser /></li>
                    <li><FiShoppingCart /></li>
                </ul>
            </section>
        </nav>
>>>>>>> b4ccb1608cc963da56df8373a591ed33268d51dd
    )
}

export default CustomNavbar