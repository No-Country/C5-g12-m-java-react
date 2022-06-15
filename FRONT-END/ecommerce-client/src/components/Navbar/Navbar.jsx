import React from 'react'
import { useDispatch } from 'react-redux';
import style from './NavbarStyle.module.css'
import { Link } from 'react-router-dom'

import { BiSearchAlt } from 'react-icons/bi'
import { FiShoppingCart } from 'react-icons/fi'

import { setLoginUserLogoutAction } from '../../redux/actions/setLoginUserLogoutAction'


const Navbar = () => {

    const dispatch = useDispatch()

    // Habdle logout
    const handleLogOut = () => {
        dispatch(setLoginUserLogoutAction())
    }

    // Render Navbar
    return (
        <nav className={style.container}>
            <article className={style.wrapper}>
                <article className={style.left}>
                    <span className={style.languaje}>EN</span>
                    <form className={style.searchContainer}>
                        <input className={style.inputSearch}/>
                        <BiSearchAlt />
                    </form>
                </article>
                <section className={style.center}>
                    <h1 className={style.Title}>NoCountry Shop</h1>
                </section>
                <article className={style.right}>
                    {
                        localStorage.getItem("jwt") && localStorage.getItem("jwtRefresh") ?
                        <>
                            <div className={style.menuItem} onClick={handleLogOut}>SIGN OUT</div> 
                            <div className={style.menuItem}>
                                <Link to="/cart"> <FiShoppingCart /> </Link>
                            </div>
                        </> : 
                        <>
                            <div className={style.menuItem}>
                                <Link className={style.textLink} to="/register"> Register </Link>
                            </div>
                            <div className={style.menuItem}>
                                <Link className={style.textLink} to="/login">Sign in </Link>
                            </div>
                        </>  
                    } 
                </article>
            </article>
        </nav>
    )
}

export default Navbar