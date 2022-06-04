import React, {useState} from 'react'
import style from './ShoppingCartStyle.module.css'

import { FaUserCircle } from 'react-icons/fa'

export const ShoppingCart = ({className}) => {

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
                            <FaUserCircle />
                            <h1>Federico Castro</h1>
                            <button>Cerrar sesión</button>
                        </div>
                }
            </article>
        </section>
    )
}
