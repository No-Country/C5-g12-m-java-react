import React, {useEffect} from 'react'
import toast from 'react-hot-toast';
import { useDispatch, useSelector } from 'react-redux';
import { addToCartAction } from '../../redux/actions/setCartAction';
import CardProduct from '../CardProduct/CardProduct';

import Product from '../Product/Product';
import style from './ProductsStyle.module.css'

const Products = () => {

    const dispatch = useDispatch()

    const products = useSelector(store => store.getProductsReducer) // Get products
    const search = useSelector(store => store.saveSearchReducer) // set seacth for filter

    const handleClickCard = (name, price) => {
        if (localStorage.getItem("jwt") && localStorage.getItem("jwtRefresh")) {
            toast.success("add product to Cart")
            console.log(name , price)
            dispatch(addToCartAction({
                name: name,
                price: price,
                id: Math.random()
            }))
        } else {
            toast.error("you have to login")
        }
    }

    // Render products marks
    return (
        <div className={style.container}>
            {
                products.filter((item) => {
                    if (item.name.toLowerCase().startsWith(search.toLowerCase())
                    || item.name.toLowerCase().endsWith(search.toLowerCase())
                    || item.name.toLowerCase().includes(search.toLowerCase())) {
                    return true
                } else {
                    return false
                }
                }).map((item, index) => {
                    return (
                        <CardProduct
                            key={index}
                            name={item.name}
                            price={item.price}
                            onClick={() => handleClickCard(item.name, item.price)}
                        />
                    )
                }

                )
            }
        </div>
    )
}

export default Products