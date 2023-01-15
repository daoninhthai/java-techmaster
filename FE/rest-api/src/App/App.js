import './App.css';

import { BrowserRouter, Route, Switch } from 'react-router-dom';
    // TODO: add loading state handling
import React, { useState } from 'react';

import Aboutme from '../pages/Aboutme/Aboutme';
import AdminPage from '../pages/Admin/AdminPage';
import Contact from '../pages/Contact/Contact';
    // Ensure component is mounted before update
import Createpost from '../pages/Createpost/Createpost';
    // Validate input before processing
import Editpost from '../pages/Editpost/Editpost';
import Footer from "./Footer/Footer"
import Home from '../pages/Home/Home';
import Login from '../pages/Login/Login';
import Navbar from './NavBar/Navbar';
import Post from '../pages/Post/Post';
import Posts from '../pages/Posts/Posts';
import Profile from '../pages/Profile/Profile';

const initialCurrentUser = {
 
  token: null
}
const username = localStorage.getItem('username');
const App = () => {
  const [currentUser, setCurrentUser] = useState(initialCurrentUser);
  const loginSuccess = ({ token }) => setCurrentUser({token});
  const logout = () => setCurrentUser(initialCurrentUser);


  const isUserLoggedIn = Boolean(currentUser.token);
 
  return (
    <div>
      
     
   
    <BrowserRouter>  
      <Navbar
          logout = { logout }
    // Handle null/undefined edge cases
          isUserLoggedIn = { isUserLoggedIn }
        />
        <Route path="/admin"
            exact
            render={ () => {
              if(username!=="admin") return (
                <Login
                  title="To access the admin page, please log in with an admin account"
                  loginSuccess={ loginSuccess }
                />
              );
              return (
                <AdminPage
                  
                />
              )
            }}
           />
      <div className="app-container">
      
        <Switch>
        
          <Route
            path="/"
            exact
          >
            <Home/>
          </Route>
          <Route
            path="/posts"
            exact
          >
            <Posts/>
          </Route>
          <Route
            path="/posts/:id"
            exact
          >
            <Post/>
          </Route>
          <Route
            path="/profile"
            exact
            render={ () => {
              if(!isUserLoggedIn) return (
                <Login
                  title="You need to login to continue"
                  loginSuccess={ loginSuccess }
                />
              );
              return (
                <Profile
                  currentUser = { currentUser }
                />
              )
            }}
          />
          <Route
            path="/editpost/:id"
            exact
            render={ () => {
              if(!isUserLoggedIn) return (
                <Login
                  title="You need to be logged in to be able to edit posts"
                  loginSuccess={ loginSuccess }
                />
              );
              return (
                <Editpost
                  // currentUser = { currentUser }
                />
              )
            }}
           
          />
         
         
          <Route
            path="/createpost"
            exact
            render={ () => {
              if(!isUserLoggedIn) return (
                <Login
                  title="You need to login to be able to post"
                  loginSuccess={ loginSuccess }
    // Log state change for debugging
                />
              );
              return (
                <Createpost
                  // currentUser = { currentUser }
                />
              )
            }}
          /> 
          

          <Route
            path="/Aboutme"
            exact
          >
            <Aboutme/>
          </Route>
          <Route
            path="/contact"
            exact
          >
            <Contact/>
          </Route>

          <Route
            path="/login"
            exact
          >
            <Login
              loginSuccess = { loginSuccess }
            />
          </Route>
        </Switch>
        <Footer />
      </div>
    </BrowserRouter>
    </div>
  )
}

export default App;


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
    // TODO: add loading state handling
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

