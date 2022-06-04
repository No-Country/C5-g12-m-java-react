import React, {useState} from 'react'
import style from './UserProfileStyle.module.css'

import { FaRegUserCircle } from 'react-icons/fa'

import banner from '../../../../assets/userImg.png'

export const UserProfile = ({className}) => {

    const [userLogin, setUserLogin] = useState(false)

    return (
        <section className={className}> 
            <article className={style.boxLogin}>
                {
                    userLogin ? 
                        <div className={style.noUserDetected}>
                            <h1>Inicia sesión para continuar </h1>
                            <button>Iniciar sesión</button>
                        </div>
                        :
                        <div className={style.userDetected}>
                            <div className={style.contentUserData}>
                                <h1>Federico Castro</h1>
                                <img className={style.bannerImg} src={banner} alt="user imagen" />
                                <button>Cerrar sesión</button>
                            </div>
                        </div>
                }
            </article>
        </section>
    )
}
