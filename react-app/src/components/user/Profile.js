import React, { Component } from 'react';
import avatar from '../../img/avatar1.png'
var LineChart = require("react-chartjs-v2").Line;
var chartData = {
    labels: ["January", "February", "March", "April", "May", "June", "July"],
    datasets: [
        {
            label: "My First dataset",
            fillColor: "rgba(40, 146, 240, 0.3)",
            borderColor: "rgba(40, 146, 240,1)",
            pointBorderColor: "rgba(40, 146, 240,1)",
            //pointStrokeColor: "#fff",
            //pointHighlightFill: "#fff",
            //pointHighlightStroke: "rgba(220,220,220,1)",
            data: [100, 90, 85, 81, 56, 55, 40],
            fill: false
        }
    ]
};
var chartOptions = {
		elements: { 
			point: { 
				radius: 0, hitRadius: 5, hoverRadius: 5 
			} 
		},

		legend: {
        display: false
	    },
	    tooltips: {
	        enabled : true
	    },

        scales: {
            xAxes: [{
                //display: false,
                //drawBorder: false,
            }],
            yAxes: [{
                //display: false,
                //drawBorder: false,
            }],
        },
        
    };
import { Button, Input, Row , Col, Pagination} from 'react-materialize';
class Profile extends Component {
	constructor(props) {
	    super(props);
	}

	render () {
		return (
			<div>
				<Row> 
					<Col s="12" className="closeBtnWrapper">
						<p>
						<a href="#"><i className="fa fa-close"></i></a>
						</p>
					</Col>
					<Col s="12" m="12" className="imgAvatarWrapper">
						<p>
							<img src="http://www.venmond.com/demo/vendroid/img/avatar/big.jpg" className="img-circle"/>
						</p>
					</Col>
					<Col s="12" className="editLinkWrapper">
						<p>
						<a href="#">Edit Profile</a>
						</p>
					</Col>
				</Row>
				<Row className="profileInfoWrapper">
					<Col s="12" m="12" l="6" className="infoLeftWrapper">
						<Row>
						<Col s={12} m={12}>
						<h3>Lorem Ipsum Name</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ligula justo, tempus rhoncus sodales eu, sodales et est. Aenean porta, odio ac viverra rhoncus</p>
						</Col>
						<Col s="12" m="12" l="6" className="infoRightWrapper">
							<p>City: rhoncus sodales eu</p>
						</Col>
						<Col s="12" m="12" l="6" className="infoRightWrapper">
							<p>Birthday:  -- /-- / --  </p>
						</Col>
						<Col s="12" m="12" l="6" className="infoRightWrapper">
							<p>Email: user@joyscrum.com</p>
						</Col>
						<Col s="12" m="12" l="6" className="infoRightWrapper">
							<p>Phone: (000) - 000 - 00000</p>
						</Col>
						<Col s="12" m="12" l="6" className="infoRightWrapper">
							<p>Executive Team</p>
						</Col>
						<Col s="12" m="12" l="6" className="profileSelectRole">
							<p><button type="button" className="btn waves-effect waves-light transparentcustom btn-radius">Selec. Profile Scrum</button></p>
						</Col>
						</Row>
					</Col>
					<Col s="12" m="12" l="6" className="infoRightWrapper">
						<Row>
							<Col s={12} m={12}>
								<p>Profile Level: Senior <span className="right">314.123 pts</span></p>
							</Col>
						</Row>
						<Row className="profileAvatarWrapper">
							<Col s={2}>
							<img src={avatar} className="responsive-img"/>
							</Col>
							<Col s={10} className="profileDotsWrapper">
								<ul>
									<li></li>
									<li></li>
									<li></li>
									<li></li>
									<li className="active"></li>
									<li></li>
									<li></li>
								</ul>
							</Col>
						</Row>
						<Row>
							<Col s={12} m={12}>
								<p>Lorem ipsum Title</p>
								<LineChart data={chartData} options={chartOptions} width={600} height={200}/>
							</Col>
						</Row>
					</Col>
				</Row>
			</div>
		)
	}
}

export default Profile;