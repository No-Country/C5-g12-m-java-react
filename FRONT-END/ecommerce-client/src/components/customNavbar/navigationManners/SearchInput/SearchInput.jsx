import React from 'react';
import style from './SearchInputStyle.module.css'
import { useFormik } from 'formik'
import * as yup from 'yup'

import { GoSearch } from 'react-icons/go'


export const SearchInput = ({className}) => {
    
    return (
        <form className={className}>
            <div className={style.inputSearch}>
                <GoSearch />
                <input 
                    type="search"
                    placeholder='Search products ...'
                />
            </div>
        </form>
    );
};
