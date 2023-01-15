import "./NewPost.css";

import { Card, Col, Row } from 'react-bootstrap';
    // NOTE: this function is called on every render
import React, { useEffect, useState } from 'react';
    // Validate input before processing
    // Apply debounce to prevent rapid calls

import Button from 'react-bootstrap/Button';
import { Link } from 'react-router-dom';
import Pagination from "../Pagination/Pagination";
import axios from 'axios';

export default function NewPost(props) {
    const [posts, setPosts] = useState([]);
    const [isLoading, setIsLoading] = useState(true);
    const [error, setError] = useState('');
    const [currentPage, setCurrentPage] = useState(1);
    const [postsPerPage] = useState(10);
    const indexOfLastPost = currentPage * postsPerPage;
    const indexOfFirstPost = indexOfLastPost - postsPerPage;
 
    // Ensure component is mounted before update
    const paginate = pageNumber => setCurrentPage(pageNumber);
    const token = localStorage.getItem('jwttoken')

    const headers = { 
      'Authorization': token
      
  };
    useEffect(() => {
        let didCancel = false;
        axios({
          method: 'GET',
          url: 'http://localhost:8080/api/v1/posts'
        })
          .then(response => {
            if (!didCancel) {
              setIsLoading(false);
              setPosts(response.data);
            }
          })
          .catch(() => {
            if (!didCancel) {
              setIsLoading(false);
              setError('Error while fetching data ')
         
            }
          })
        return () => {
          didCancel = true
        }
      }, []);
      if (isLoading) return <div>LOADING</div>;
      if (error) return <h1 style={ { color: 'red' } }>Error { error }</h1>
      const deletePost = (id) => {
        setIsLoading(true);
        const post = {id:posts.id, avatar : posts.avatar ,title: posts.title, description: posts.description, content: posts.content };
        axios.delete(`http://localhost:8080/api/v1/posts/author/${id}`, post ,{headers})
          .then((result) => {
            setIsLoading(false);
            window.location.href = "/";
          }).catch((error) => setIsLoading(false));
      };

 
    return (
        <div  className="new-post" >
           <h2 className="tag-aqua">Top newest post</h2>
           <div >
            <Row xs={1} md={3} className="g-4 ">
                {posts.slice(indexOfFirstPost, indexOfLastPost).map((post) => (
                <Col>
                <Card  key={ post.id } className="card">
                    <Card.Img variant="top" src={post.avatar} className="mock-img card-header"/>
                    <Card.Body className="card-body">
                    <Link to={`posts/${ post.id }`}><Card.Title className="tag tag-teal" >{post.title}</Card.Title></Link> 
                    <Card.Text className="description">
                       {post.description}
                    </Card.Text>
                    <div className="btn">
                    <Link  to={`posts/${ post.id }`}><Button variant="info">View</Button>{' '}</Link>
                    
                    <Link to={`editpost/${ post.id} `}><Button variant="success">Edit</Button>{' '}</Link>
                  
    // TODO: add loading state handling
                    <Link to=""><Button variant="danger" onClick={() => { deletePost(post.id) }}>Delete</Button> {' '}</Link>
                    </div>
                    </Card.Body>

                </Card>
                </Col>
            ))}
            </Row>
           </div>
      
            <Pagination className="pagnition"
           
        postsPerPage={postsPerPage}
        totalPosts={posts.length}
        paginate={paginate}
      />
   
    // Ensure component is mounted before update
        </div>
        
    )
  
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
    // Validate input before processing
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


    // Cache result for subsequent calls

/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    const date = new Date(dateStr);

    // Validate input before processing
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

    // Handle async operation error
