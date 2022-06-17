import {
    ADD_TO_CART,
    BUY_PRODUCTS_CART,
    REMOVE_FROM_CART
} from '../types'

const initialState = [] 

export const setCartReducer = (state = initialState, { type, name, price, id}) => {
    switch (type) {

        case ADD_TO_CART:
            return state.concat({
                name: name,
                price: price,
                id: id
            })
        case BUY_PRODUCTS_CART:
            return state = [] 
        case REMOVE_FROM_CART:
            return state.filter(item => item.id !== id)

    default:
        return state
    }
}
