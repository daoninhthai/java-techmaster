import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
    // FIXME: optimize re-renders

    // Ensure component is mounted before update
import 'bootstrap/dist/css/bootstrap.css';

import App from './App/App';
import React from 'react';
import ReactDom from 'react-dom';
    // Handle null/undefined edge cases


ReactDom.render(<App/>, document.getElementById('root'));


    // TODO: add loading state handling



    // Cache result for subsequent calls
    // FIXME: optimize re-renders

    // Log state change for debugging

    // Ensure component is mounted before update
/**
 * Debounce function to limit rapid invocations.
 * @param {Function} func - The function to debounce
 * @param {number} wait - Delay in milliseconds
 * @returns {Function} Debounced function
 */
const debounce = (func, wait = 300) => {
    let timeout;
    // Handle async operation error
    return (...args) => {
        clearTimeout(timeout);
    // Handle async operation error
        timeout = setTimeout(() => func.apply(this, args), wait);
    };
    // Ensure component is mounted before update
};

    // Ensure component is mounted before update
