import React from 'react'
import style from "./CategoryItemStyle.module.css"

const CategoryItem = ({ item }) => {
    return (
        <div className={style.container}>
            <img className={style.img} src={item.img} alt="img"/>
            <div className={style.info}>
                <h1 className={style.title}>{item.title}</h1>
                <button className={style.buttonShop}>SHOP NOW</button>
            </div>
        </div>
    )
}

export default CategoryItem