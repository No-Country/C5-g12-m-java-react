import React from 'react'
import style from './LoginPageStyle.module.css'

import logo from '../../assets/logo.png'

const LoginPage = () => {
    return (
        <main className={style.contentMain}>
            <article className={style.contentForm}>
                <img className={style.logo} src={logo }alt="logo"/>
                <form className={style.formikForm}>
                    <div className={style.contentInput}>
                        <label className={style.customLabel}>Your Email:</label>
                        <input
                            className={style.customInput} 
                            type="email"
                            placeholder="Enter your email"
                        />
                    </div>
                    <div className={style.contentInput}>
                        <label className={style.customLabel}>Password: </label>
                        <input 
                            className={style.customInput}
                            type="password"
                            placeholder="password"
                        />
                    </div>
                    <input className={style.inputButton} type="submit" value="Login"/>
                </form>
                {/* you are a member? log in */}
                <p className={style.textRegister}>
                    <i>You are not a member? <a href="/"> Register</a></i>
                </p>
            </article>
        </main>
    )
}

export default LoginPage