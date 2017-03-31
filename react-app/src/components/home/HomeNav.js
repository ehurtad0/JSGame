import React, { Component } from 'react';
import {Navbar, NavItem, Nav, NavDropdown, MenuItem, Button} from 'react-bootstrap';
import logo from '../../img/logo.png';
const HomeNav = () => (
	<Navbar collapseOnSelect>
    <Navbar.Header>
      <Navbar.Brand className='homeLogo'>
        <a href="#"><img src={logo}/></a>
      </Navbar.Brand>
      <Navbar.Toggle />
    </Navbar.Header>
    <Navbar.Collapse>
      <Nav pullRight>
        <NavItem eventKey={1} href="#">How it Works</NavItem>
        <NavItem eventKey={2} href="#">Pricing</NavItem>
        <NavItem eventKey={3} href="#">About</NavItem>
        <li role="presentation" className="loginBtnWrapper">
        	<button href="#" className="btn btn-transparent">Login</button>
        </li>
      </Nav>
    </Navbar.Collapse>
  </Navbar>
);

export default HomeNav;