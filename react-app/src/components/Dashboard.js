import React, { Component } from 'react';
import '../bootstrap/css/dashboard.css';
import { BrowserRouter as Router, Route, Match } from 'react-router-dom';
import DashboardNav from './dashboard/DashboardNav';
import DashboardHome from './dashboard/DashboardHome';
import GameZone from './dashboard/GameZone';
const Dashboard = ({match}) => (
<div className='dashboard'>
	<div className='col-md-2 sidebar'>
		<div className="sideBarTitle text-center">
		<p><a>WORKSPACE <i className="fa fa-line-chart"></i></a></p>
		</div>
	</div>
	<div className='col-md-10 box'>
	<DashboardNav />
		<div className='dashboard-home'>
			<Route exact path={`${match.url}`} component={DashboardHome}/>
			<Route path={`${match.url}/GameZone`} component={GameZone}/>
		</div>
	</div>
</div>
)

export default Dashboard;