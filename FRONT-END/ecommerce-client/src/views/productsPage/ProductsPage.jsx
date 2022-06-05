import React, {useState,useEffect} from 'react'
import axios from 'axios'
import style from './ProductsPageStyle.module.css'

import { GoSearch } from 'react-icons/go'

import logo from '../../assets/logo.png'

const ProductsPage = () => {
 
    const [marks, setMarks] = useState([])

    useEffect(() => {
        axios.get("https://nocountry-ecommerce.herokuapp.com/v1/mark/")
            .then( response => {
                const marks = response.data;
                setMarks(marks);
            })
            .catch (e => {console.log(e)})
    }, [])

    return (
        <main className={style.productsPageContent}>
            <article className={style.searchContent}>
                <div className={style.logoContent}>
                    <img className={style.logo} src={logo} alt="logo"/>
                    <h3><i>Products</i></h3>
                </div>
                <div className={style.inputSearch}>
                    <GoSearch />
                    <input 
                        type="search"
                        placeholder='Search products ...'
                    />
                </div>
            </article>
            <article className={style.mainContent}>
                <section className={style.markFilterContent}>
                    {
                        marks.map((item, index) => {
                            return (
                                <div className={style.boxMark} key={index}>
                                    <h1>{item.name}</h1>
                                </div>
                            )
                        })
                    }
                </section>
                <section className={style.productsContent}>
                </section>
            </article>
        </main>
    )
}

export default ProductsPage