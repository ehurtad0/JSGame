import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';
import { Button, Input, Row, Col } from 'react-materialize';
import GoogleLogin from 'react-google-login';
import 'jquery';

import '../../index.css';
import logo from '../../img/logoRocket.png';
import loginhelper from '../../helpers/loginhelper';
import appParameters from '../../AppParameters';

class Login extends Component {
  constructor(props) {
    super(props);
    if (localStorage.getItem('jwtToken') !== null) {
      this.props.history.push('/user/profile');
    }
    this.state = { isVisible: false };
    // This binding is necessary to make `this` work in the callback
    this.handleClick = this.handleClick.bind(this);
    this.responseGoogle = this.responseGoogle.bind(this);
  }

  handleClick() {
    this.setState(prevState => ({
      isVisible: !prevState.isVisible
    }));
  }

  responseGoogle(response) {
    loginhelper.loginThroughGoogleToken(response['code'], this.props.history);
  }
  render() {

    return (
      <div className="valign-wrapper">
        <div className="valign center full-width">
          <div className="row">
            <div className='col l4 offset-l4 loginWrapper' id="registrationWrapper">
              <div className="logo"><img src={logo} alt="logo" /></div>
              <div className="registrationWrapperBody">
                <div>

                  <form>
                    <Row className="left-align">
                      <Col s={12}>
                        <h4>Login</h4>
                      </Col>
                      <Input type="password" label="Password here" s={12} />
                      <Input type="text" label="Username here" s={12} />
                    </Row>
                    <Row className="loginRedirectionLinks">
                      <Col s={6}>
                        <p className="left-align">
                          <small>
                            <Link to={'/user/reset'}>I forgot my password</Link>
                          </small>
                        </p>
                      </Col>
                      <Col s={6}>
                        <p className="right-align">
                          <small>
                            <Link to={'/register/stepOne'}>Register Now!</Link>
                          </small>
                        </p>
                      </Col>
                    </Row>
                    <Row className="center-align">
                      <Button waves='light' type="submit" className="bluecustom btn-radius" >Login > </Button>
                    </Row>
                  </form>
                  <Row>
                    <Col s={12} className="center-align">
                      <small onClick={this.handleClick} >Or Sing Up With</small>
                    </Col>
                  </Row>
                  {this.state.isVisible &&
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
              </div>
            </div>
          </div>
        </div>
      </div>

    );
  }
}

Login.contextTypes = {
  router: PropTypes.object.isRequired
};

export default Login;