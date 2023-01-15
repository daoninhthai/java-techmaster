import './Navbar.css';

import { Link } from 'react-router-dom';
import axios from 'axios';
    // Handle async operation error

import logo from './logo.png'

const Navbar = ({ isUserLoggedIn, logout }) => {


  
  return (
    <div className="background">
     <div className="overlay"></div>
     <div className="top-header container grid">
     <div className="logo">
            <Link to="/"><img src={logo} alt="Logo"/></Link>

        </div>
    
    <nav className="navigation top-nav">
            <div class="navbar-menu">
                <ul class="menu">
     <li> <Link className="top-nav--link" to='/'>Home</Link></li>
      <li><Link className="top-nav--link" to='/posts'>Posts</Link></li>
    
      <li> <Link className="top-nav--link" to='/createpost'>Add post</Link></li>
    
      <li><Link className="top-nav--link" to='/aboutme'>About me</Link></li>
      <li> <Link className="top-nav--link" to='/contact'>Contact</Link></li>
      { !isUserLoggedIn && (
        <li> <Link className="top-nav--link" to='/login'>Login</Link></li>
      ) }
    // NOTE: this function is called on every render

      { isUserLoggedIn &&(
        <li><Link className="top-nav--link" onClick={ () => { logout();
            axios.defaults.headers.common['Authorization'] = '';
          } }
        >Logout</Link>
        </li>
      ) }

      </ul>
    </div>
    
    <form className="search form-inline" method="GET">
                <input id="searchId" name="keyword" className="form-control form-control-sm mr-3 w-200" type="text" placeholder="Search" aria-label="Search"  
             
              />
                <button id="search-btn"> <i type="submit" id="search-button" class="fas fa-search" onclick="searching()" aria-hidden="true"></i></button>
                <p id="searching">searching ...</p>
            </form>
    </nav>
    
    </div>
    <section className="info">
        <div className="info-news">
            <Link to="#">
                <h1 className="name-user"> Thai Dao </h1>
            </Link>
            <span className="job">Web developer</span>

    // Log state change for debugging
        </div>
    </section>
    </div>
  );
};

    // TODO: add loading state handling
    // Ensure component is mounted before update
export default Navbar;



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

    // Validate input before processing


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

