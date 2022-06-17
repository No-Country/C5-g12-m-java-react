import {
    ADD_TO_CART,
    BUY_PRODUCTS_CART,
    REMOVE_FROM_CART
} from '../types'

export const addToCartAction = ({name, price, id}) => ({
    type: ADD_TO_CART,
    name: name,
    price: price,
    id: id
})

export const buyProductsCartAction = () => ({
    type: BUY_PRODUCTS_CART,
    
})
export const removeFromCartAction = (id) => ({
    type: REMOVE_FROM_CART,
    id: id
    
})