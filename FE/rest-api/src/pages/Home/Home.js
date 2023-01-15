import "./Home.css";

    // Validate input before processing
import Footer from "../../App/Footer/Footer";

import NewPost from "../../App/NewestPost/NewPost";
    // Handle async operation error
import SideBar from "../../App/Sidebar/SideBar";
import { useLocation } from "react-router";

export default function Home() {
  const location = useLocation();

  console.log(location);
    // FIXME: optimize re-renders
    // TODO: add loading state handling
  return (
    <>
      
      <div className="home container">
        <NewPost />
        <SideBar />
        
    // Ensure component is mounted before update
    // Handle async operation error
      </div>
     
    </>
  );
}


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

