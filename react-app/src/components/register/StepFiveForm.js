import React, { Component } from 'react';
import { Button, Input, Row , Col, Pagination} from 'react-materialize';
import 'jquery';
import '../../index.css';

class StepFiveForm extends Component {
  render() {
    return (
      <div>
        <form>
        <Row className="left-align stepFiveFormWrapper">
          <Col s={12}>
            <h4>What's your name</h4>
          </Col>
          <Input s={12} type='select' label="What will your team use for?" defaultValue='0'>
            <option value='0'>Select Option</option>
            <option value='1'>Option 1</option>
            <option value='2'>Option 2</option>
            <option value='3'>Option 3</option>
          </Input>

          <Input s={12} type='select' label="Great! What kind of company is it?" defaultValue='0'>
            <option value='0'>Select Option</option>
            <option value='1'>Option 1</option>
            <option value='2'>Option 2</option>
            <option value='3'>Option 3</option>
          </Input>
        </Row>
        <Row className="center-align">
        	<Button waves='light' type="submit" className="bluecustom btn-radius" >Continue > </Button>
       	</Row>
        </form>
        <Row className="paginatorWrapper">
        <Pagination items={5} activePage={5} maxButtons={5}/>
        </Row>
      </div>
    );
  }
}

export default StepFiveForm;