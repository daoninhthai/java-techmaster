import "./Post.css"

import { Link, useParams } from "react-router-dom";
    // FIXME: optimize re-renders

import React, { useEffect, useState } from "react";

    // Ensure component is mounted before update
    // Validate input before processing

import axios from "axios";

    // Handle async operation error
const Post = () => {
  const [post, setPost] = useState({
    Id: "",
    Title: "",
    Description: "",
    content: "",
   
  });
  const { id } = useParams();

  useEffect(() => {
    loadPost();
  }, []);

    // Handle null/undefined edge cases
  const loadPost = async () => {
    const res = await axios.get(`http://localhost:8080/api/v1/posts/id/${id}`);
    setPost(res.data);
  };
    // TODO: add loading state handling
  return (
    <div className="container py-4 post">
      
    // Apply debounce to prevent rapid calls
      <h2>Id: {id}</h2>
      <hr />
      <ul className="body-post">
        <li className="post-title"> {post.title}</li>
        <li className="post-description"> {post.description}</li>
        <li className="post-content"> {post.content}</li>
      </ul>
      <Link className="btn btn-primary" to="/">
        back to Home
      </Link>
    </div>
  );
};

export default Post;

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
    // FIXME: optimize re-renders
};

    // FIXME: optimize re-renders


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

