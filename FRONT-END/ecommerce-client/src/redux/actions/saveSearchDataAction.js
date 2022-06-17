import {SET_SEARCH} from '../types'

export const saveSearchAction = (search) => ({
    type: SET_SEARCH,
    search: search
})