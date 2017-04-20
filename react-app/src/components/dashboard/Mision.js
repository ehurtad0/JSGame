import React, { Component } from 'react';
const dashboardhelper = require('../../helpers/dashboardhelper');

class Mision extends Component{
	constructor(props){
		super(props)
		this.props.setDashboardClass('mission');

		this.state = {
			missions : []
		}
	}

	componentDidMount(){
		dashboardhelper.getUserMisions(this);
	}

	render(){
		return(
			<div className="missionWrapper">
				<div className="row companyNameWrapper">
					<div className="col-xs-12">
						<CompanyThumbanil />
					</div>
				</div>
				<div className="row listWrapper">
					<div className="col-md-4 col-md-offset-4 hidden-xs">
					<h2>Mission Detail</h2>
					<ul>
						{
							this.state.missions.map((mission,k) => {
								return <li key={'mission'+k}>{mission.nombremision}</li>
							})
						}
					</ul>
					<p>
						<a className="btn btn-full btn-mission">Start</a>
					</p>
					</div>
				</div>
				<div className="currentWeekWrapper">
				<h1>3</h1>
				<p>Week</p>
				</div>
				<p className="mission-float mssn1"><i className="fa fa-circle-o"></i> Lorem ipsum dolor</p>
				<p className="mission-float mssn2"><i className="fa fa-circle-o"></i> Lorem ipsum dolor</p>
			</div>
		)
	}
}

class CompanyThumbanil extends Component{
	constructor(props){
		super(props)
	}

	render(){
		return(
			<div className="companyThumbanil">
				<div className="image">
					<img src={'http://www.n-cod.net/ncdologo2.png'} />
				</div>
				<div className="info">
					<p className="name">
						TEAM: TEAMNAME
					</p>
					<p className="profile">
						<small>Profile Level: profile</small>
					</p>
				</div>
				<div className="clear"></div>
			</div>
		)
	}
}

export default Mision;