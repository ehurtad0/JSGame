import React, { Component } from 'react';
import { Navbar, NavItem, Nav, NavDropdown, MenuItem } from 'react-bootstrap';
import icono from '../../img/Iconos/Iconos7.png';
import icono2 from '../../img/Iconos/Iconos8.png';
import icono3 from '../../img/Iconos/Iconos9.png';

class DashboardNav extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showWeeks: false,
      weeksMobileClass: 'noShowWeeks'
    };
    this.showWeeks = this.showWeeks.bind(this)
  }

  showWeeks() {
    this.setState(prevState => ({
      weeksMobileClass: (!this.state.showWeeks) ? 'showWeeks' : 'noShowWeeks',
      showWeeks: !this.state.showWeeks,
    }));
  }

  render() {
    return (
      <Navbar className="main-nav">
        <Navbar.Header>
          <Navbar.Brand>
            <a href="#" className="hidden-xs" onClick={this.props.hideSideBar}><i className="fa fa-bars"></i></a>
          </Navbar.Brand>
        </Navbar.Header>
        <div className="weekNavWrapper">
          <p>Weeks</p>
        </div>
        <div className="weeksListWrapper">
          <ul className={"weeksList " + this.state.weeksMobileClass}>
            <li className="prev">1</li>
            <li className="prev">2</li>
            <li className="current">3</li>
            <li>4</li>
            <li>5</li>
            <li>6</li>
            <li>7</li>
          </ul>
          <p className="clear"></p>
        </div>
        <div className="arrowWrapper hidden-lg hidden-md">
          <a onClick={this.showWeeks}>{(this.state.showWeeks) ? <i className="fa fa-angle-left"></i> : <i className="fa fa-angle-right"></i>}</a>
        </div>
        <div className={"pull-right profileNav " + this.state.weeksMobileClass}>
          <Nav>
            <NavItem eventKey={1} href="#">
              <img src={icono} alt="" />
            </NavItem>
            <NavItem eventKey={2} href="#" className="notifications">
              <img src={icono2} alt="" /><span>10</span>
            </NavItem>
            <NavItem eventKey={3} href="#" className="inviteBtn">
              <img src={icono3} alt=""/><span>Invite Team Members</span>
            </NavItem>
            <NavItem eventKey={4} href="#" className="avatarImg">
              <img src="http://www.venmond.com/demo/vendroid/img/avatar/big.jpg" className="img-responsive img-circle" alt=""/>
            </NavItem>
            <NavDropdown eventKey={4} title="" id="basic-nav-dropdown">
              <MenuItem eventKey={4.1}><i className="fa fa-user"></i> My Profile</MenuItem>
              <MenuItem eventKey={4.2}><i className="fa fa-cog"></i> Admin</MenuItem>
              <MenuItem eventKey={4.3}><i className="fa fa-sign-out"></i> Logout</MenuItem>
            </NavDropdown>
          </Nav>
        </div>
      </Navbar>
    )
  }
}

/*const DashboardNav = () => (
  
);*/

export default DashboardNav;