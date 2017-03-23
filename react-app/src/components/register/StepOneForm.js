import React, { Component } from 'react';
import { Button, Input, Row , Col, Pagination} from 'react-materialize';
import 'jquery';
import '../../index.css';

class StepOneForm extends Component {
  constructor(props) {
    super(props);
    this.state = {isVisible: false};

    // This binding is necessary to make `this` work in the callback
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState(prevState => ({
      isVisible: !prevState.isVisible
    }));
  }
  render() {
    const isVisible = this.state.isVisible;
    
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
        { isVisible  &&
        <Row>
          <Col s={6}>
            <Button waves='light' type="submit" className="btn-radius capitalize sing-up-btn btn-google" >Google <i className="fa fa-google"></i></Button>
          </Col>
          <Col s={6}>
            <Button waves='light' type="submit" className="btn-radius capitalize sing-up-btn btn-trello" >Trello <i className="fa fa-trello"></i></Button>
          </Col>

        </Row>
        }
      </div>
    );
  }
}

export default StepOneForm;