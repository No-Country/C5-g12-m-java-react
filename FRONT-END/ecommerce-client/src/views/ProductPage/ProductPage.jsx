import React from 'react'
import Announcement from '../../components/Announcement/Announcement'
import Footer from '../../components/Footer/Footer'
import Navbar from '../../components/Navbar/Navbar'
import style from './ProductPageStyle.module.css'

import { AiFillCaretLeft, AiFillCaretRight } from 'react-icons/ai'

const ProductPage = () => {
    return (
        <div className={style.container}>
            <Navbar />
            <Announcement />
            <main className={style.wrapper}>
                <article className={style.imageContainer}>
                    <img className={style.img} src="https://i.ibb.co/S6qMxwr/jean.jpg" alt="" />
                </article>
                <article className={style.infoContainer}>
                    <h1 className={style.title}>Denin Jumpsui</h1>
                    <p className={style.description}>
                        Lorem ipsum dolor sit amet, conectetur adipiscing elit. Donec
                        venenatis, dolor in finibus malesuada, lectus ipsum porta nunc, at
                        iaculis arcu nisi sed mauris. Nulla fermentum vestibulum ex, eget
                        tristique tortor pretium ut. Curabitur elit justo, consequat id
                        condimentum ac, volutpat ornare.
                    </p>
                    <span className={style.price}>$ 20</span>
                    <article className={style.addContainer}>
                        <section className={style.amountContainer}>
                            <AiFillCaretLeft />
                            <h3>Amount: </h3>
                            <span className={style.amount}>1</span>
                            <AiFillCaretRight />
                        </section>
                            <button className={style.addToCart}>ADD TO CART</button>
                    </article>
                </article>
            </main>
            <Footer />
        </div>
    )
}

export default ProductPage