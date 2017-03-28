import React, { Component } from 'react';
import $ from 'jquery';
import '../../index.css';
import { Button, Input, Row , Col, Pagination, Modal} from 'react-materialize';
class StepFourForm extends Component {
  render() {
    return (
      <div>
        <form>
        <Row className="left-align">
          <Col s={12}>
            <h4>What's your company called?</h4>
          </Col>
        	<Input type="text" label="Company name here" s={12} />
        </Row>
        <Row className="center-align">
        	<Modal
            header='Review Terms'
            trigger={
              <Button waves='light' className="bluecustom btn-radius">Continue > </Button>
            }
            actions={[<Button waves='light' className="bluecustom btn-radius no-float" modal='close'>I Agree</Button>]}
            >
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>

          </Modal>
       	</Row>
        </form>
        <Row className="paginatorWrapper">
        <Pagination items={5} activePage={4} maxButtons={5}/>
        </Row>
      </div>
    );
  }
}

export default StepFourForm;