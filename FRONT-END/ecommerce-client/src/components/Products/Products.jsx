import React from 'react'
import { popularProducts } from "../../data";
import Product from '../Product/Product';
import style from './ProductsStyle.module.css'

const Products = () => {
    return (
        <div className={style.container}>
            {
                popularProducts.map((item) => (
                    <Product item={item} key={item.id} />
                ))
            }
        </div>
    )
}

export default Products