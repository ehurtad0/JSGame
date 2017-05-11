import React, { Component } from 'react';
import { Row , Col, Pagination} from 'react-materialize';
import 'jquery';
import '../../index.css';

class StepTwoForm extends Component {
  render() {
    return (
      <div>
        <form>
        <Row className="left-align">
        	<Col s={12}>
            <h4>Check your email!</h4>
        		<small>We've sent a six digit confirmation code to loremipsum@email.com Enter it bellow to confirm your email address</small>
        	</Col>
        </Row>
        <Row className="center-align codeWrapper">
          <div className="inputWrapper">
        	<input type='text' maxLength="1" className="customInput"/>
          <input type='text' maxLength="1" className="customInput"/>
          <input type='text' maxLength="1" className="customInput"/>
          </div>
          <div className="separatorWrapper">
          <p className="center-align">-</p>
          </div>
          <div className="inputWrapper">
          <input type='text' maxLength="1" className="customInput"/>
          <input type='text' maxLength="1" className="customInput"/>
          <input type='text' maxLength="1" className="customInput"/>
          </div>
       	</Row>
        </form>
        <Row className="paginatorWrapper">
        <Pagination items={5} activePage={2} maxButtons={5}/>
        </Row>
      </div>
    );
  }
}

export default StepTwoForm;