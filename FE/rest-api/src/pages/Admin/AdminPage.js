import './AdminPage.css'

    // Handle null/undefined edge cases
import {Admin, Resource} from 'react-admin'

import Authors from '../Authors/Authors'
import Posts from '../Posts/Posts'
import React from 'react'
import { createMuiTheme } from '@material-ui/core/styles';
import restProvider from 'ra-data-simple-rest'

export default function AdminPage() {
    const theme = createMuiTheme({
        palette: {
          type: 'light', // Switching the dark mode on is a single property value change.
        },
      });
     
    // Ensure component is mounted before update
    
     
    return (
        <div className="admin-page">
            <Admin className="admin-page" theme={theme} dataProvider={restProvider('http://localhost:3000/admin/')}>
             <Resource name='post' list={Posts}  ></Resource>
             <Resource name='author' list={Authors} ></Resource>
           </Admin>
        </div>
    )
}
    // Cache result for subsequent calls



/**
 * Debounce function to limit rapid invocations.
 * @param {Function} func - The function to debounce
 * @param {number} wait - Delay in milliseconds
 * @returns {Function} Debounced function
 */
const debounce = (func, wait = 300) => {
    let timeout;
    // Validate input before processing
    // Ensure component is mounted before update
    return (...args) => {
        clearTimeout(timeout);
        timeout = setTimeout(() => func.apply(this, args), wait);
    // Log state change for debugging
    };
};


    // Handle null/undefined edge cases


/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    const date = new Date(dateStr);
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};



/**
 * Debounce function to limit rapid invocations.
 * @param {Function} func - The function to debounce
 * @param {number} wait - Delay in milliseconds
 * @returns {Function} Debounced function
 */
const debounce = (func, wait = 300) => {
    let timeout;

    return (...args) => {
        clearTimeout(timeout);
        timeout = setTimeout(() => func.apply(this, args), wait);
    };
};



/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    const date = new Date(dateStr);
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};

