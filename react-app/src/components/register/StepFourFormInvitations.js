import React, { Component } from 'react';
import { Button, Input, Row , Col, Pagination} from 'react-materialize';
import 'jquery';
import '../../index.css';

class StepFourFormInvitations extends Component {
  render() {
    return (
      <div>
        <form>
        <Row className="left-align stepThreeFormWrapper">
          <Col s={12}>
            <h4>Send Invitations</h4>
          </Col>
          <Input type="text" label="Email here" s={12} />
          <Input type="text" label="Email here" s={12} />
        	<Input type="text" label="Email here" s={12} />
        </Row>
        <Row className="center-align">
          <Col s={6}>
            <Button waves='light' type="submit" className="btn-flat btn-radius capitalize skip-btn" >Skip for Now</Button>
          </Col>
          <Col s={6}>
            <Button waves='light' type="submit" className="bluecustom btn-radius" >Continue > </Button>
          </Col>
        	
       	</Row>
        </form>
        <Row className="paginatorWrapper">
        <Pagination items={5} activePage={4} maxButtons={5}/>
        </Row>
      </div>
    );
  }
}

export default StepFourFormInvitations;