import React, {useState} from 'react'
import style from './FooterStyle.module.css'

import { BsLinkedin, BsInstagram, BsWhatsapp, BsFacebook } from 'react-icons/bs'

const Footer = () => {

    const [login, setLogin] = useState(false)

    return (
        <footer className={style.container}>
            <article className={style.left}>
                <h1>NoCountry shop</h1>
                <p className={style.description}>
                    Federico Castro - Front
                    Federico Castro - Front
                    Federico Castro - Front
                    Federico Castro - Front
                    Federico Castro - Front
                </p>
            </article>
            <article className={style.center}>
                <ul className={style.links}>
                    <li className={style.listItem}>Home</li>
                    <li className={style.listItem}>Cart</li>
                    <li className={style.listItem}>Products</li>
                    {
                        login ? 
                        <li className={style.listItem}>SIGN OUT</li> :
                    <>
                        <li className={style.listItem}>Register</li>
                        <li className={style.listItem}>Sign in</li>
                    </>  
                    }
                    <li className={style.listItem}>Terms</li>
                </ul>
            <section className={style.socialContainer}>
                <div className={style.socialIcon}>
                    <BsLinkedin />
                </div>
                <div className={style.socialIcon}>
                    <BsInstagram />
                </div>
                <div className={style.socialIcon}>
                    <BsWhatsapp />
                </div>
                <div className={style.socialIcon}>
                    <BsFacebook />
                </div>
            </section>
            </article>
        </footer>
    )
}

export default Footer