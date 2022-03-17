import React from "react";
import { Redirect } from 'react-router-dom';
import { useSelector } from "react-redux";
import { useNavigate } from 'react-router-dom';
import { Navigate } from "react-router-dom";

const Profile = () => {
    // const navigate = useNavigate();
    const { user: currentUser } = useSelector((state) => state.authReducer);
    if (!currentUser) {
        return (<Navigate to="/login"></Navigate>)
    }
    return (<div><p>Profile</p></div>)
}

export default Profile;