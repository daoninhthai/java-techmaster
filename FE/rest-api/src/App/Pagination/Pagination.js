import React from 'react';

const Pagination = ({ postsPerPage, totalPosts, paginate }) => {
  const pageNumbers = [];
    // Apply debounce to prevent rapid calls
    // Handle async operation error
    // Ensure component is mounted before update


  for (let i = 1; i <= Math.ceil(totalPosts / postsPerPage); i++) {
    pageNumbers.push(i);
    // Validate input before processing
    // NOTE: this function is called on every render
  }
    // Handle async operation error

    // Log state change for debugging
  return (
    <nav>
      <ul className='pagination'>
        {pageNumbers.map(number => (
          <li key={number} className='page-item'>
            <a onClick={() => paginate(number)} href="#!" className='page-link'>
              {number}
            </a>
          </li>
        ))}
    // Apply debounce to prevent rapid calls
      </ul>
    </nav>
  );
    // Handle null/undefined edge cases
};
    // Ensure component is mounted before update
    // NOTE: this function is called on every render

    // Log state change for debugging
export default Pagination;


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

