import React, {useCallback} from 'react'
import { useDispatch, useSelector } from 'react-redux';
import style from './NavbarStyle.module.css'
import { Link } from 'react-router-dom'

import { BiSearchAlt } from 'react-icons/bi'
import { FiShoppingCart } from 'react-icons/fi'

import { setLoginUserLogoutAction } from '../../redux/actions/setLoginUserLogoutAction'
import { MdProductionQuantityLimits } from 'react-icons/md'
import { saveSearchAction } from '../../redux/actions/saveSearchDataAction';

const Navbar = () => {

    const dispatch = useDispatch()

    const search = useSelector(store => store.saveSearchReducer)

    // Habdle logout
    const handleLogOut = () => {
        dispatch(setLoginUserLogoutAction())
    }

    const handleChange = useCallback(value => {
        dispatch(saveSearchAction(value.target.value))

    }, [dispatch, saveSearchAction])

    // Render Navbar
    return (
        <nav className={style.container}>
            <article className={style.wrapper}>
                <section className={style.center}>
                    <h1 className={style.Title}>NoCountry shop</h1>
                </section>
                <article className={style.left}>
                    <form className={style.searchContainer}>
                        <input 
                            className={style.inputSearch}
                            type="text"
                            placeholder='Search...'
                            value={search}
                            onChange={handleChange}
                            />
                        <BiSearchAlt />
                    </form>
                </article>
                <article className={style.right}>
                    {
                        localStorage.getItem("jwt") && localStorage.getItem("jwtRefresh") ?
                        <>
                            <div className={style.menuItem} onClick={handleLogOut}>SIGN OUT</div> 
                            <div className={style.menuItem}>
                                <Link to="/cart"> <FiShoppingCart /> </Link>
                                <Link to="/"> <MdProductionQuantityLimits /></Link>
                            </div>
                        </> : 
                        <>
                            <div className={style.menuItem}>
                                <Link className={style.textLink} to="/register"> Register </Link>
                            </div>
                            <div className={style.menuItem}>
                                <Link className={style.textLink} to="/login">Sign in </Link>
                            </div>
                        </>  
                    } 
                </article>
            </article>
        </nav>
    
    )
}

export default Navbar