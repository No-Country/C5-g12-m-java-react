import React from 'react'
import { Link } from 'react-router-dom'
import style from './RegisterPageStyle.module.css'

const RegisterPage = () => {
    return (
        <main className={style.container}>
            <article className={style.wrapper}>
                <h1 className={style.title}>CREATE AN ACCOUNT</h1>
                <form className={style.form}>
                    <input
                        placeholder="email" 
                        className={style.input} />
                    <input
                        placeholder="email" 
                        className={style.input} />
                    <input
                        placeholder="email" 
                        className={style.input} />
                    <input
                        placeholder="email" 
                        className={style.input} />
                    <input
                        placeholder="password" 
                        className={style.input} />
                    <input
                        type="submit"
                        placeholder="email" 
                        className={style.inputSubmit} />
                </form>
                    <span className={style.agreement}>
                        By creating an account, I consent to the processing of my personal
                        data in accordance with the <b>PRIVACY POLICY</b>
                    </span>
                    <br></br>
                    <Link className={style.link} to="/login">YOU HAVE AN ACCOUNT ? LOG IN</Link>
            </article>
        </main>
    )
}

export default RegisterPage