import React, { Component } from 'react';
import { Button, Input, Row , Col, Pagination} from 'react-materialize';
import 'jquery';
import '../../index.css';

class StepThreeForm extends Component {
  render() {
    return (
      <div>
        <form>
        <Row className="left-align stepThreeFormWrapper">
          <Col s={12}>
            <h4>What's your name</h4>
          </Col>
          <Input type="text" label="First name here" s={12} />
          <Input type="text" label="Last name here" s={12} />
        	<Input type="text" label="Username here" s={12} />
        </Row>
        <Row className="center-align">
        	<Button waves='light' type="submit" className="bluecustom btn-radius" >Continue > </Button>
       	</Row>
        </form>
        <Row className="paginatorWrapper">
        <Pagination items={5} activePage={3} maxButtons={5}/>
        </Row>
      </div>
    );
  }
}

export default StepThreeForm;