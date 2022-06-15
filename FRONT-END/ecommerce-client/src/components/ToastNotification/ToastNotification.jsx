import React from 'react'
import style from './ToastNotificationStyle.module.css'
import { Toaster } from 'react-hot-toast';

const ToastNotification = () => {
    return (
        <div className={style.notificationToast}>
            <Toaster 
                position="top-right"
                reverseOrder={false}/>
        </div>
    )
}

export default ToastNotification