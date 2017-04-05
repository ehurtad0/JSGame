import React, { Component } from 'react';
import logo from '../img/logo.png';
import { BrowserRouter as Router, Route, Match } from 'react-router-dom';
import '../materialize/css/register.css';
import '../user.css';
import Profile from './user/Profile'
import Login from './user/Login'
import Reset from './user/Reset'
import Register from './Register'
class User extends Component
{ 
	constructor(props) 
	{
    	super(props);
	    this.state = {
	      headerClassWrapper: (
	      	this.props.location.pathname =='/user/login' ||
	      	this.props.location.pathname =='/user/reset'
	      ),
	    };
	}
	render(){
		return (
		<div className={"register " + ((this.state.headerClassWrapper)? 'user' : '')}>
			<div className={'container'}>
				<Route path={'/user/profile'} component={Profile} />
				<Route path={'/user/login'} component={Login} />
				<Route path={'/user/reset'} component={Reset} />	
			</div>
		</div>

		)
	}
}

export default User;