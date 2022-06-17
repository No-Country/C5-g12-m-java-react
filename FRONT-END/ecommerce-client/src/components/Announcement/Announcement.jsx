import React from 'react'
import { useSelector } from 'react-redux'
import style from './AnnouncementStyle.module.css'

const Announcement = () => {

    const marks = useSelector(store => store.getMarksReducer) // Get marks

    return (
        <div className={style.container}>
            {
                marks.map((item, index) => (
                    <div className={style.mark} key={index} > {item.name} </div>
                ))
            }
        </div>
    )
}

export default Announcement