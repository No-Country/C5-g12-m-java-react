import React from 'react'
import style from './CategoriesStyle.module.css'
import { categories } from "../../data";
import CategoryItem from '../CategoryItem/CategoryItem';

const Categories = () => {
    return (
        <div className={style.container}>
            {
                categories.map((item) => (
                    <CategoryItem item={item} key={item.id} />
                ))
            }
        </div>
    )
}

export default Categories