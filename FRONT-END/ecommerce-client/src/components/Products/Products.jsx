import React, {useEffect} from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { getMarksSagaAction } from '../../redux/actions/getMarksAction';

import Product from '../Product/Product';
import style from './ProductsStyle.module.css'

const Products = () => {

    const dispatch = useDispatch()

    const marks = useSelector(store => store.getMarksReducer) // Get marks
    
    // Load marks,
    useEffect(() => {
        dispatch(getMarksSagaAction())
    }, [dispatch])

    // Render products marks
    return (
        <div className={style.container}>
            {
                marks.map((item, index) => (
                    <Product item={item} key={index} />
                ))
            }
        </div>
    )
}

export default Products