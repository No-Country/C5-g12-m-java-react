import React, {useState} from 'react'
import style from './NavbarStyle.module.css'

import { BiSearchAlt } from 'react-icons/bi'
import { FiShoppingCart } from 'react-icons/fi'

const Navbar = () => {

    const [login, setLogin] = useState(false)

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
                        login ? 
                            <div className={style.menuItem}>SIGN OUT</div> :
                        <>
                            <div className={style.menuItem}>Register</div>
                            <div className={style.menuItem}>Sign in</div>
                        </>  
                    } 
                    <div className={style.menuItem}>
                        <FiShoppingCart />
                    </div>
                </article>
            </article>
        </nav>
    )
}

export default Navbar