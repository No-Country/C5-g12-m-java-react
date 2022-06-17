import React from 'react'
import Announcement from '../../components/Announcement/Announcement'
import Footer from '../../components/Footer/Footer'
import style from './CartPageStyle.module.css'
import Navbar from '../../components/Navbar/Navbar'
import { useSelector, useDispatch } from 'react-redux'
import {buyProductsCartAction, removeFromCartAction} from '../../redux/actions/setCartAction'
import toast from 'react-hot-toast';
import { useNavigate } from 'react-router-dom'

import { FiDelete } from 'react-icons/fi'

const CartPage = () => {

    const navigate = useNavigate()

    const dispatch = useDispatch()

    const products = useSelector(store => store.setCartReducer)

    const sum = products.map(item => item.price).reduce((prev, curr) => prev + curr, 0).toFixed()
    
    const handleDeleteItem = (id) => {
        dispatch(removeFromCartAction(id));
        toast.success('delete item from cart')
    }

    const handleBuy = () => {
        toast.success('Thanks for buy here')
        navigate("/")
        dispatch(buyProductsCartAction())
    }

    return (
        <div>
            <Announcement />
            <Navbar />
            <main className={style.cartPage}>
                <article className={style.newProducts}>
                    {
                        products.map((item, index) => {
                            return (
                                <div key={index} className={style.boxProduct}>
                                    <h1> { item.name }</h1>
                                    <div className={style.alignPrice}>
                                        $ {item.price}
                                        <div onClick={() => handleDeleteItem(item.id)}>
                                            <FiDelete />
                                        </div>
                                    </div>
                                </div>

                            )
                        })
                    }
                </article>
                <article className={style.totalPrice}>
                    <h1> TOTAL: $ {sum}</h1>
                    <button onClick={handleBuy}>buy</button>
                </article>
            </main>
            <Footer />
        </div>
    )
}

export default CartPage