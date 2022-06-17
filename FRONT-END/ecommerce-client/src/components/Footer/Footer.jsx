import React, {useState} from 'react'
import style from './FooterStyle.module.css'
import { Link } from 'react-router-dom'

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
                        <a href='https://www.linkedin.com/in/federico-gabriel-castro-837417186/' target="_blank"><BsLinkedin /></a>
                    </div>
                    <div className={style.alignLinks}>
                        <h3> Cristian Aguirre - Backend </h3> 
                        <a href='https://www.linkedin.com/in/cristian-aguirre-822858220/' target="_blank"><BsLinkedin /></a>
                    </div>
                    <div className={style.alignLinks}>
                        <h3> Leandro Barrera - Backend </h3> 
                        <a href='https://www.linkedin.com/in/leonardo-barrera-893268183/' target="_blank"><BsLinkedin /></a>
                    </div>
                    <div className={style.alignLinks}>
                        <h3> Sofia Martinez - Tester </h3> 
                        <a href='https://www.linkedin.com/in/sofia-r%C3%ADos-martinez/' target="_blank"><BsLinkedin /></a>
                    </div>
                    <div className={style.alignLinks}>
                        <h3> Javier Garcia - Team Leader </h3> 
                        <a href='https://www.linkedin.com/in/garcia-javier/' target="_blank"><BsLinkedin /></a>
                    </div>
                    <div className={style.alignLinks}> 
                        <a href='https://github.com/No-Country/C5-g12-m-java-react' target="_blank"><FaGithub /></a>
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