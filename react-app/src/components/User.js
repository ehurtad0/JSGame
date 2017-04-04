import React, { Component } from 'react';
import logo from '../img/logo.png';
import { BrowserRouter as Router, Route, Match } from 'react-router-dom';
import '../materialize/css/register.css';
import '../user.css';
import Profile from './user/Profile'
const User = ({ match }) => (
	<Router>
	<div className="register">
		<div className='container'>
			<Route path={`${match.url}/profile`} component={Profile} />
		</div>
	</div>
	</Router>
)

export default User;