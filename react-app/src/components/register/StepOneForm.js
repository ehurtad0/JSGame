import React, { Component } from 'react';
import { Button, Input, Row , Col, Pagination} from 'react-materialize';
import 'jquery';
import '../../index.css';
import GoogleLogin from 'react-google-login';
const loginhelper = require('../../helpers/loginhelper');
var appParameters = require('../../AppParameters');

class StepOneForm extends Component {
  constructor(props) {
    var loggedIn = !(localStorage.getItem("jwtToken") === null);
    super(props);
    this.state = {
      isVisible: false,
      loggedIn: loggedIn
    };
    // This binding is necessary to make `this` work in the callback
    this.handleClick = this.handleClick.bind(this);
    this.responseGoogle = this.responseGoogle.bind(this);
  
  }

  responseGoogle(response){
  loginhelper.loginThroughGoogleToken(response['code'],this.props.history);
  }

  handleClick() {
    this.setState(prevState => ({
      isVisible: !prevState.isVisible
    }));
  }
  render() {
    return (
      <div>
        
        <form>
        <Row className="left-align">
        <Col s={12}>
          <h4>Set your password</h4>
        </Col>
        	<Input type="password" label="Password here" s={12} />
        	<Col s={12}>
        		<small>Password must be 6 charactares long</small>
                        
        	</Col>
        </Row>
        <Row className="center-align">
        	<Button waves='light' type="submit" className="bluecustom btn-radius" >Continue > </Button>
       	</Row>
        </form>
        <Row className="paginatorWrapper">
        <Pagination items={5} activePage={1} maxButtons={5}/>
        </Row>
        <Row>
          <Col s={12} className="center-align">
            <small onClick={this.handleClick} >Or Sing Up With</small>
          </Col>
        </Row>
        { true  &&
        <Row>
          <Col s={12}>
          <GoogleLogin
            clientId={appParameters.parameters.googleCLientId}
            onSuccess={this.responseGoogle}
            onFailure={this.responseGoogle}
            offline={false}
            className="btn waves-effect waves-light btn-radius-no capitalize sing-up-btn btn-google"
            scope={'profile'}
          >
            <i className="fa fa-google"></i> Google
          </GoogleLogin>
          </Col>

        </Row>
        }
      </div>
    );
  }
}

export default StepOneForm;