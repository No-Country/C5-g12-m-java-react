import React from 'react'
import Announcement from '../../components/Announcement/Announcement'
import Footer from '../../components/Footer/Footer'
import Navbar from '../../components/Navbar/Navbar'
import style from './CartPageStyle.module.css'

import { AiFillCaretLeft, AiFillCaretRight } from 'react-icons/ai'

const CartPage = () => {
    return (
        <div>
            <Navbar />
            <Announcement />
            <main className={style.wrapper}>
                <h1 className={style.title}>YOUR BAG</h1>
                <article className={style.top}>
                    <button className={style.continueShopping}>CONTINUE SHOPPING</button>
                    <section className={style.topTextContainer}>
                            <div className={style.shoppingBag}> Shopping Bag (1) </div>
                    </section>
                </article>

                <article className={style.bottom}>
                    <section className={style.info}>
                        {/* PRODUCT */}
                        <div className={style.product}>
                            <article className={style.productDetail}>
                                <img className={style.img} alt="img" src="https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1614188818-TD1MTHU_SHOE_ANGLE_GLOBAL_MENS_TREE_DASHERS_THUNDER_b01b1013-cd8d-48e7-bed9-52db26515dc4.png?crop=1xw:1.00xh;center,top&resize=480%3A%2A" />
                                <section className={style.details}>
                                    <span> <b>Product:</b> JESSIE THUNDER SHOES </span>
                                    <span> <b>ID:</b> 93813718293 </span>

                                </section>
                            </article>
                            <article className={style.priceDetail}>
                                <section className={style.productAmountContainer}>
                                    <AiFillCaretLeft />
                                    <span className={style.productAmount}>2</span>
                                    <AiFillCaretRight />
                                </section>
                                <span className={style.productPrice}>$ 20</span>
                            </article>
                        </div>
                        
                        <hr className={style.hr} />
                        
                        <div className={style.product}>
                            <article className={style.productDetail}>
                                <img className={style.img} alt="img" src="https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1614188818-TD1MTHU_SHOE_ANGLE_GLOBAL_MENS_TREE_DASHERS_THUNDER_b01b1013-cd8d-48e7-bed9-52db26515dc4.png?crop=1xw:1.00xh;center,top&resize=480%3A%2A" />
                                <section className={style.details}>
                                    <span> <b>Product:</b> JESSIE THUNDER SHOES </span>
                                    <span> <b>ID:</b> 93813718293 </span>

                                </section>
                            </article>
                            <article className={style.priceDetail}>
                                <section className={style.productAmountContainer}>
                                    <AiFillCaretLeft />
                                    <span className={style.productAmount}>2</span>
                                    <AiFillCaretRight />
                                </section>
                                <span className={style.productPrice}>$ 20</span>
                            </article>
                        </div>
                        
                        {/* PRODUCT */}
                        <hr className={style.hr} />
                    </section>
                    <section className={style.summary}>
                        <h1 className={style.summaryTitle}>Estimated shipping</h1>
                        <div className={style.summaryItem}>
                            <span>Subtotal</span>
                            <span>$ 20</span>
                        </div>
                        <div className={style.summaryItem}>
                            <span>Subtotal</span>
                            <span>$ 20</span>
                        </div>
                        <div className={style.summaryItem}>
                            <span>Subtotal</span>
                            <span>$ 20</span>
                        </div>
                        <button className={style.button} >CHECKOUT NOW</button>
                    </section>
                </article>
            </main>
            <Footer />
        </div>
    )
}

export default CartPage