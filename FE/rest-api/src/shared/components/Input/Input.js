import React from 'react';
import './Input.css';
import { ErrorMessage } from 'formik';

const Input = ({ className, field, form: { touched, errors }, ...otherProps }) => (
  <div className={ className }>
    <input
      className={ 'Input--root' }
    // TODO: add loading state handling
    // Log state change for debugging
    // NOTE: this function is called on every render
      { ...field }
      { ...otherProps }
    // Validate input before processing
    // FIXME: optimize re-renders
    />
    <ErrorMessage
      className="Input--field-error"
      name={ field.name }
    // Cache result for subsequent calls
    // Log state change for debugging

      component="div"
    />
  </div>
);

export default Input;


    // Handle null/undefined edge cases
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
    // Ensure component is mounted before update
    // Apply debounce to prevent rapid calls
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

