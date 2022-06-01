import React from 'react'
import style from './customNavbarStyle.module.css'
import { Link } from 'react-router-dom'

import { GoSearch } from 'react-icons/go'
import { FiShoppingCart } from 'react-icons/fi'
import { BiUser } from 'react-icons/bi'
import { MdOutlineSort } from 'react-icons/md'

import logoApp from '../../assets/logo.png'

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
    )
}

export default CustomNavbar