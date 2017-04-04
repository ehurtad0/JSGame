import React, { Component } from 'react';
import UserProfileThumb from './UserProfileThumb'


class InboxItem extends Component{

	constructor(props) 
	{
	    super(props);
	    this.state = {
	      showEmail : false
	    }

	    this.showEmail = this.showEmail.bind(this);
	}

	showEmail(){
		this.setState(prevState => ({
	      showEmail: !this.state.showEmail,
	    }));
	}
 	render()
 	{
 		let cls = (typeof this.props.className == "undefined")? '' : this.props.className
 		let email = (typeof this.props.email == "undefined")? 'test@test.net' : this.props.className
 		return(
 			<div className={'row '+this.props.cls}>
 				<div className="col-xs-8 col-md-4 col-sm-5">
 					<UserProfileThumb/>
 				</div>
 				<div className="col-xs-2 col-md-6 col-sm-5 emailBtnWrapper">
 				<p>
 					<button className="btn custom-btn-inbox" onClick={this.showEmail}>
 						<i className='fa fa-envelope-o'></i>
 						{this.state.showEmail &&
 							email
 						}
 					</button>
 				</p>
 				</div>
 				<div className="col-xs-2 col-md-2 col-sm-2 emailActionWrapper">
 					<p className="deleteMsg"><i className="fa fa-close"></i></p>
 				</div>
	 			
 			</div>
 		);
 	}
}

export default InboxItem;