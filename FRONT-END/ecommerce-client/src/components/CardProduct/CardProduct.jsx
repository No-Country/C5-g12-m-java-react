import React from 'react'
import style from './CardProductStyle.module.css'
import { MdAddCircleOutline } from 'react-icons/md'

const CardProduct = ({ name, price, onClick}) => {
    return (
        <article className={style.cardContent}>
            <div>
                <h3> {name} </h3>
                <p>$ {price}</p>
            </div>
            <div className={style.addButton} onClick={onClick}>
                <MdAddCircleOutline />
            </div>
        </article>
    )
}

export default CardProduct