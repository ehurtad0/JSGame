import React, { Component } from 'react';
import {Tabs, Tab} from 'react-bootstrap';
import InboxItem from './InboxItem';
var list = [1,2,3,4,5,6];
class InviteMembers extends Component{
	constructor(props) 
	{
	    super(props);
  	}

 	render()
 	{
 		let myTitle = <p><i className='fa fa-users'></i><span> USERS(10)</span></p>
 		let myTitle2 = <p><i className='fa fa-users'></i><span> HOLD ON(10)</span></p>
 		let myTitle3 = <p><i className='fa fa-user'></i><span> ADMIN</span></p>
 		return(
 			<Tabs defaultActiveKey={1} id="uncontrolled-tab-example">
			    <Tab eventKey={1} title={myTitle}>
			    	{list.map((k,v) => {
			    		return <InboxItem key={k}/>
			    	})}
			    </Tab>
			    <Tab eventKey={2} title={myTitle2}>
				    {list.map((k,v) => {
				    		return <InboxItem key={k}/>
			    	})}
			    </Tab>
			    <Tab eventKey={3} title={myTitle3}>Tab 3 content</Tab>
			 </Tabs>
 		);
 	}
}

export default InviteMembers;