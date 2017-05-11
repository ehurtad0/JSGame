import React, { Component } from 'react';
import { Button, Input, Row, Col } from 'react-materialize';
import 'jquery';
import '../../index.css';
import logo from '../../img/logoRocket.png';

class Reset extends Component {
  constructor(props) {
    super(props);
    this.state = { isVisible: false };
    // This binding is necessary to make `this` work in the callback
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState(prevState => ({
      isVisible: !prevState.isVisible
    }));
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
                        <h4>Recovery Password</h4>
                        <p><small>We will send a verification code to your email to recover password</small></p>
                      </Col>
                      <Input type="text" label="Email address here" s={12} />
                    </Row>
                    <Row className="center-align">
                      <Button waves='light' type="submit" className="bluecustom btn-radius" >Send Verification</Button>
                    </Row>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    );
  }
}

export default Reset;