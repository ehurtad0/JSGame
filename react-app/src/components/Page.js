import React, { Component } from 'react';
import HomeNav from './home/HomeNav';
import MainImage from './home/MainImage';
import Home from './Home';
import Pricing from './Pricing';
import {
  Navbar, 
  NavItem, 
  Nav, 
  NavDropdown, 
  MenuItem, 
  Button,
  li
} from 'react-bootstrap';
import { 
  BrowserRouter as Router, 
  Route, 
  Match, 
  Link
} from 'react-router-dom';
import logo from '../img/logo.png';
import '../home.css';
class Page extends Component {
  constructor(props) {
    super(props);
    this.state = {
      initialClass: 'home-page',
      headerClass: (this.props.location.pathname =='/page')? 'top-home-page' : 'top-price-page',
      displayImg: true,
      isHome: (this.props.location.pathname =='/page/home')
    };
    // This line is important!
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick(
    pageClass, 
    headerClass, 
    displayImg
  ){
    this.setState(prevState => ({
      initialClass: pageClass,
      headerClass: headerClass,
      displayImg: displayImg,
      isHome: (headerClass =='top-home-page')
    }));

  }

  render() {
    return (
      <Router>
      <div className={this.state.initialClass}>
      <div className={this.state.headerClass}>
          {/*Nav Bar*/}
            <Navbar collapseOnSelect>
                <Navbar.Header>
                  <Navbar.Brand className='homeLogo'>
                    <Link to="/page/home" onClick={() => this.handleClick('home-page','top-home-page', true)}><img src={logo}/></Link>
                  </Navbar.Brand>
                  <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                  <Nav pullRight>
                    <li role="presentation"><a href="#">How it Works</a></li>
                    <li role="presentation"><Link to='/page/price' onClick={() => this.handleClick('home-page','top-price-page', false)}>Pricing</Link></li>
                    <li role="presentation"><a href="#">About</a></li>
                    <li role="presentation" className="loginBtnWrapper">
                      <button href="#" className="btn btn-transparent">Login</button>
                    </li>
                  </Nav>
                </Navbar.Collapse>
              </Navbar>
          {/*Nav Bar*/}
          { this.state.displayImg && this.state.isHome  &&
            <MainImage />
          }
      </div>
          
          <div className='homePageWrapper'>
              <Route exact path="/page/home" component={Home}/>
              <Route path='/page/price' component={Pricing}/>
          </div>
          
      </div>
      </Router>
    );
  }
}

export default Page;