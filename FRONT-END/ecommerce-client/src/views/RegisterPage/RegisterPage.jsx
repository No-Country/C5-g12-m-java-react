import React from 'react'
import { useDispatch, useSelector } from 'react-redux';

import { useFormik } from "formik";
import * as Yup from "yup";
import { Link } from 'react-router-dom'
import style from './RegisterPageStyle.module.css'

import { postRegisterDataSagaAction } from '../../redux/actions/postRegisterDataAction';
import CustomSpinner from '../../components/Spinner/Spinner';

const RegisterPage = () => {

    const dispatch = useDispatch()

    const visible = useSelector(store => store.setRegisterFormVisibleReducer) // Boolean data from saga submit
    
    // Manage register form
    const formik = useFormik({
        initialValues: {
            email: "",
            first_name: "",
            last_name: "",
            password: "",
            phone: "cliente"
        },
        validationSchema: Yup.object({
            last_name: Yup.string().required("Last name required"),
            first_name: Yup.string().required("First name required").max(20, "firstname is Too Long!"),
            email: Yup.string().required("Email required").max(20, "lastname is Too Long!"),
            password: Yup.string().required("Password required").min(8, "Password Must be more than 8 characters").max(20, "Password is Too Long!"),
        }),
        onSubmit: (values) => {
            console.log(values)
            dispatch(postRegisterDataSagaAction({
                email: values.email,
                first_name: values.first_name,
                last_name: values.last_name,
                phone: values.phone,
                password: values.password
            }))
        },
    })

    // render
    return (
        <main className={style.container}>
            <article className={style.wrapper}>
                <h1 className={style.title}>CREATE AN ACCOUNT</h1>
                {
                    visible ? 
                    <>
                    <form className={style.form} onSubmit={formik.handleSubmit}>
                        <div className={style.formikError}>
                        {formik.errors.email ? <p>{formik.errors.email}</p> : null}
                        {formik.errors.first_name ? <p>{formik.errors.first_name}</p> : null}
                        {formik.errors.last_name ? <p>{formik.errors.last_name}</p> : null}
                        {formik.errors.password ? <p>{formik.errors.password}</p> : null}
                        </div>
                        <div className={style.inpuuts}>
                            <input
                                placeholder="email"
                                id="email"
                                name="email"
                                type="email"
                                onChange={formik.handleChange}
                                className={style.input} />
                            <input
                                placeholder="first name"
                                id="first_name"
                                name="first_name"
                                type="text"
                                onChange={formik.handleChange} 
                                className={style.input} />
                            <input
                                placeholder="last name" 
                                id="last_name"
                                name="last_name"
                                type="text"
                                onChange={formik.handleChange}
                                className={style.input} />
                            <input
                                placeholder="password" 
                                id="password"
                                name="password"
                                type="text"
                                onChange={formik.handleChange}
                                className={style.input} />
                            <input
                                type="submit"
                                placeholder="email" 
                                value="REGISTER"
                                className={style.inputSubmit} />
                        </div>
                    </form>
                        <span className={style.agreement}>
                            By creating an account, I consent to the processing of my personal
                            data in accordance with the <b>PRIVACY POLICY</b>
                        </span>
                        <br></br>
                        <Link className={style.link} to="/login">YOU HAVE AN ACCOUNT ? LOG IN</Link> 
                    </> : <CustomSpinner />
                }
            </article>
        </main>
    )
}

export default RegisterPage