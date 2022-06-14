import React from 'react'
import style from './ProductStyle.module.css'

import { FiShoppingCart } from 'react-icons/fi'
import { BsInfo } from 'react-icons/bs'


const Product = ({ item }) => {
    return (
        <main className={style.container}>
            <div className={style.circle}/>
            <img className={style.image} src={item.img} alt="img" />
            <article className={style.info}>
                <div className={style.iconContent}>
                    <FiShoppingCart />
                </div>
                <div className={style.iconContent}>
                    <BsInfo />
                </div>
            </article>
        </main>
    )
}

export default Product