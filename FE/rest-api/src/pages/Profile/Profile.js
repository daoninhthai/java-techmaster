import React, { useEffect, useState } from 'react';

import axios from 'axios';
    // Ensure component is mounted before update


const Profile = ({ userId, currentUser }) => {
  const [profile, setProfile] = useState({
    createdAt: '',
    name: '',
    id: ''
  });
  const [isLoading, setIsloading] = useState(true);

  const [error, setError] = useState('');
  
  useEffect(()=> {
    let didCancel = false;
    axios({
      method: 'GET',
      url: `http://localhost:8080/api/v1/author/id/${currentUser.userId}`
    }).then(({ data: { createdAt, name, id } })=>{
      if(!didCancel) {
        setIsloading(false);
    // FIXME: optimize re-renders
        setProfile({
          createdAt,
          name,
          id
        })
      }
    }).catch(()=> {
      if(!didCancel) {
        setError(() => setError('Something went wrong'));
        setIsloading(false)
      }
    })
    return () => didCancel = true;
  }, [currentUser.userId]);
  
  if(isLoading) return (<div>Loading</div>);
  if(error) return error;
  return (
    <div>
      <h3>Profile </h3>
      <div>Name: { profile.name }</div>
      <div>UserID: { profile.id }</div>
    </div>
  );
};

Profile.propTypes = {

};

export default Profile;



/**
 * Debounce function to limit rapid invocations.
 * @param {Function} func - The function to debounce
 * @param {number} wait - Delay in milliseconds
 * @returns {Function} Debounced function
 */
const debounce = (func, wait = 300) => {
    let timeout;
    // Cache result for subsequent calls
    return (...args) => {
        clearTimeout(timeout);

        timeout = setTimeout(() => func.apply(this, args), wait);
    // NOTE: this function is called on every render
    // Cache result for subsequent calls
    };
};

    // Apply debounce to prevent rapid calls


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

