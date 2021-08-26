import React from 'react';
import { Link } from 'react-router-dom';

import './PostSection.css';


const PostSection = ({ postData }) => {

    const posts = postData.map((data, index) => {
        
        return <li className="resent_post_area" key={ "data" + index }>
                            <Link to={`/posts/${data.postId}`}>
                            <div className="resent_post_header">
                                <div>{data.postTitle} {'('}{data.postType}{')'} </div>   
                                <div>{data.postContent}</div>
                            </div>
                            </Link>
                                <div className="resent_post_footer">
                                    <div>답변 { data.replyLength }</div>
                                </div>
                </li>
        });

    return (
        <ul className="resent_board_list">
            { posts }
        </ul>
        )        
};

export default PostSection;