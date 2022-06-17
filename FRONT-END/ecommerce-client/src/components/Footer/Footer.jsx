import React, {useState} from 'react'
import style from './FooterStyle.module.css'

import { BsLinkedin, BsInstagram, BsWhatsapp, BsFacebook } from 'react-icons/bs'
import { FaGithub } from 'react-icons/fa'

const CustomFooter = () => {

    const [login, setLogin] = useState(false)

    return (
        <footer className={style.container}>
            <article className={style.left}>
                <div className={style.description}>
                    <div className={style.alignLinks}>
                        <h3> Federico Castro - Front </h3> 
                        <BsLinkedin />
                    </div>
                    <div className={style.alignLinks}>
                        <h3> Cristian Aguirre - Backend </h3> 
                        <BsLinkedin />
                    </div>
                    <div className={style.alignLinks}>
                        <h3> Leandro Barrera - Backend </h3> 
                        <BsLinkedin />
                    </div>
                    <div className={style.alignLinks}>
                        <h3> Sofia Martinez - Tester </h3> 
                        <BsLinkedin />
                    </div>
                    <div className={style.alignLinks}>
                        <h3> Javier Garcia - Team Leader </h3> 
                        <BsLinkedin />
                    </div>
                    <div className={style.alignLinks}> 
                        <FaGithub />
                    </div>
                </div>
            </article>
            {/* <article className={style.center}>
                
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
            </article> */}
        </footer>
    )
}

export default CustomFooter