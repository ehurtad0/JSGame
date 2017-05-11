import React, { Component } from 'react';
import logo from '../img/logoRocket.png';
import StepOneForm from './register/StepOneForm';
import StepTwoForm from './register/StepTwoForm';
import StepThreeForm from './register/StepThreeForm';
import StepFourForm from './register/StepFourForm';
import StepFourInvitationsForm from './register/StepFourFormInvitations';
import StepFiveForm from './register/StepFiveForm';
import { BrowserRouter as Router, Route, Match } from 'react-router-dom';
// import '../materialize/css/register.css';
const Register = ({ match }) => (
  <Router>
  <div className="register newBackground">
    <div className='container mainWrapper valign-wrapper'>
      <div className="valign center full-width">
        <div className="row">
          <div className='col l4 m6 offset-l4 offset-m3 registrationWrapper' id="registrationWrapper">
            <div className="logo"><img src={logo} alt="logo" /></div>
            <div className="registrationWrapperBody">
              <Route path={`${match.url}/StepOne`} component={StepOneForm}/>
              <Route path={`${match.url}/StepTwo`} component={StepTwoForm}/>
              <Route path={`${match.url}/StepThree`} component={StepThreeForm}/>
              <Route path={`${match.url}/StepFour`} component={StepFourForm}/>
              <Route path={`${match.url}/StepFourInvitations`} component={StepFourInvitationsForm}/>
              <Route path={`${match.url}/StepFive`} component={StepFiveForm}/>
            </div>
           </div>
        </div>
      </div>
    </div>
  </div>
  </Router>
)

export default Register;