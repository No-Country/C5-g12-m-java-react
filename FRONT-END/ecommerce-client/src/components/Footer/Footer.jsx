import React, {useState} from 'react'
import style from './FooterStyle.module.css'

import { BsLinkedin, BsInstagram, BsWhatsapp, BsFacebook } from 'react-icons/bs'

const CustomFooter = () => {

    const [login, setLogin] = useState(false)

    return (
        <footer className={style.container}>
            <article className={style.left}>
                <h1>NoCountry shop</h1>
                <p className={style.description}>
                    Federico Castro - Front
                    Cristian Aguirre - Backend
                    Leandro Barrera - Backend
                    Sofia Martinez - Tester
                    Javier Garcia - Team Leader
                </p>
            </article>
            <article className={style.center}>
                
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

export default CustomFooter