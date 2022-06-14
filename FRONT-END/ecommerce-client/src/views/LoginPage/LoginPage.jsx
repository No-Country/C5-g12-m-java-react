import React from 'react'
import { useDispatch } from 'react-redux';
import { Link } from 'react-router-dom'
import { useFormik } from "formik";
import * as Yup from "yup";
import style from './LoginPageStyle.module.css'

import { postLoginDataActionSaga } from '../../redux/actions/postLoginDataActions';

const LoginPage = () => {

    const dispatch = useDispatch()

    const formik = useFormik({
        initialValues: {
            email: "",
            password: "",
        },
        validationSchema: Yup.object({
            email: Yup.string().required("Email required"),
            password: Yup.string().required("Password required"),
        }),
        onSubmit: (values) => {
            dispatch(postLoginDataActionSaga({
                email: values.email,
                password: values.password
            }))
        },
    });


    return (
        <main className={style.container}>
            <article className={style.wrapper}>
                <h1 className={style.title}>SIGN IN</h1>
                <form className={style.form} onSubmit={formik.handleSubmit}>
                    <input
                        placeholder="email"
                        id="email"
                        name="email"
                        type="email"
                        onChange={formik.handleChange}
                        className={style.input} />
                        {formik.errors.email ?
                                <div className={style.formikError}>
                                    {" "}
                                    {formik.errors.email}{" "}
                                </div>
                            : null}
                    <input
                        placeholder="password"
                        id="password"
                        name="password"
                        type="password"
                        onChange={formik.handleChange} 
                        className={style.input} />
                    <input
                        type="submit"
                        value="LOG IN" 
                        className={style.inputSubmit} />
                </form>
                    <Link className={style.link} to="/register">CREATE A NEW ACCOUNT</Link>
            </article>
        </main>
    )
}

export default LoginPage