import React, { Component } from 'react';
import { LinkContainer } from 'react-router-bootstrap';

import MainImage from './home/MainImage';
import Home from './Home';
import Pricing from './Pricing';
import {
  Navbar,
  NavItem,
  Nav,
  Button
} from 'react-bootstrap';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';
import logo from '../img/logo.png';
import '../home.css';
class Page extends Component {
  constructor(props) {
    super(props);
    this.state = {
      initialClass: 'home-page',
      headerClass: (this.props.location.pathname === '/') ? 'top-home-page' : 'top-price-page',
      displayImg: true,
      isHome: (this.props.location.pathname === '/')
    };
    // This line is important!
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick(
    pageClass,
    headerClass,
    displayImg
  ) {
    this.setState(prevState => ({
      initialClass: pageClass,
      headerClass: headerClass,
      displayImg: displayImg,
      isHome: (headerClass === 'top-home-page')
    }));

  }

  render() {
    return (
      <div className={this.state.initialClass}>
        <div className={this.state.headerClass}>
          {/*Nav Bar*/}
          <Navbar collapseOnSelect>
            <Navbar.Header>
              <Navbar.Brand className='homeLogo'>
                <Link to="/" onClick={() => this.handleClick('home-page', 'top-home-page', true)}>
                  <img src={logo} alt={'logo'}/>
                </Link>
              </Navbar.Brand>
              <Navbar.Toggle />
            </Navbar.Header>
            <Navbar.Collapse>
              <Nav pullRight>
                <LinkContainer to="#howItWorks">
                  <NavItem role="presentation">
                    How it Works
                      </NavItem>
                </LinkContainer>
                <LinkContainer to='/price' onClick={() => this.handleClick('home-page', 'top-price-page', false)}>
                  <NavItem role="presentation">
                    Pricing
                      </NavItem>
                </LinkContainer>
                <NavItem role="presentation">
                  About
                    </NavItem>
                <LinkContainer to='/user/login'>
                  <NavItem role="presentation" className="loginBtnWrapper">
                    <Button className="btn btn-transparent">
                      Login
                        </Button>
                  </NavItem>
                </LinkContainer>
              </Nav>
            </Navbar.Collapse>
          </Navbar>
          {/*Nav Bar*/}
          {this.state.displayImg && this.state.isHome &&
            <MainImage />
          }
        </div>
        <Router>
          <div className='homePageWrapper'>
            <Route exact path="/" component={Home} />
            <Route path='/price' component={Pricing} />
          </div>
        </Router>
      </div>
    );
  }
}

export default Page;