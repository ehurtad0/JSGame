import React, { Component } from 'react';

class UserProfileThumb extends Component{
   render(){
     let name = (typeof this.props.name === "undefined")? 'Lorem ipsum' : this.props.name
     let cls = (typeof this.props.className === "undefined")? '' : this.props.className
     let role = (typeof this.props.role === "undefined")? 'Developer' : this.props.role
     let avatar = (typeof this.props.avatar === "undefined")? 'http://www.venmond.com/demo/vendroid/img/avatar/big.jpg' : this.props.avatar
     return(
       <div className={'imgThumb '+cls}>
         <div className="col-xs-4 col-sm-4 col-md-3">
           <img src={avatar} className="img-responsive img-circle" alt='avatar' />
         </div>
         <div className="col-xs-8 col-sm-8 col-md-9">
           <h5><a>{name}</a></h5>
           <p>{role}</p>
         </div>
       </div>
     );
   }
}

export default UserProfileThumb;