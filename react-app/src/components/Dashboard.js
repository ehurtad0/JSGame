import React, { Component } from 'react';
// import '../bootstrap/css/dashboard.css';
import '../dashboard.css';
import '../css/mision.css';
import '../css/gamezone.css';
import { BrowserRouter as Router, Route, Redirect } from 'react-router-dom';
import DashboardNav from './dashboard/DashboardNav';
import DashboardHome from './dashboard/DashboardHome';
import InviteMembers from './dashboard/InviteMembers';
import Analytics from './dashboard/Analytics';
import GameZone from './dashboard/GameZone';
import Mision from './dashboard/Mision';
import lion from '../img/lionActive.png';
import menu1 from '../img/menu1.png';
import menu2 from '../img/menu2.png';
import menu3 from '../img/menu3.png';
import menu4 from '../img/menu4.png';
// import menu1Active from '../img/menu1Active.png';
// import menu2Active from '../img/menu2Active.png';
// import menu3Active from '../img/menu3Active.png';
// import menu4Active from '../img/menu4Active.png';

class Dashboard extends Component {
  constructor(props) {
    var loggedIn = !(localStorage.getItem("jwtToken") === null);
    super(props);
    this.state = {
      sideBarVisible: true,
      dashboardClass: 'col-sm-10',
      dashboardCurrentClass: '',
      loggedIn: loggedIn
    };
    this.hideSideBar = this.hideSideBar.bind(this)
    this.setDashboardClass = this.setDashboardClass.bind(this)
    console.log(this.props.location.pathname);
  }

  hideSideBar() {
    this.setState(prevState => ({
      dashboardClass: (!this.state.sideBarVisible) ? 'col-sm-10' : 'col-sm-12',
      sideBarVisible: !this.state.sideBarVisible,
    }));

  }

  setDashboardClass(newClassName) {
    this.setState({
      dashboardCurrentClass: newClassName,
    });
  }



  render() {
    if (!this.state.loggedIn) {
      return (
        <Redirect to={{
          pathname: '/user/login',
        }} />
      )
    }
    return (
      <div className={'dashboard ' + this.state.dashboardCurrentClass}>
        {this.state.sideBarVisible &&
          <div className='col-sm-2 sidebar fixed-xs'>
            <div className="row">
              <div className="sideBarTitle text-center hidden-xs col-xs-12">
                <p><a>WORKSPACE <i className="fa fa-line-chart"></i></a></p>
              </div>
            </div>
            <div className="row menuItems">
              <div className="col-xs-12 lionImageWrapper hidden-xs">
                <p>
                  <img src={lion} alt={'lion'} />
                  <span>314.136 pts</span>
                </p>
              </div>
              <div className="col-xs-12 menuItem">
                <p>
                  <img src={menu1} alt={'menu1'} />
                  <span>Dashboard</span>
                </p>
              </div>
              <div className="col-xs-12 menuItem">
                <p>
                  <img src={menu2} alt={'menu2'} />
                  <span>Mission</span>
                </p>
              </div>
              <div className="col-xs-12 lionImageWrapper visible-xs">
                <p>
                  <img src={lion} alt={'lion'} />
                  <span>314.136 pts</span>
                </p>
              </div>
              <div className="col-xs-12 menuItem">
                <p>
                  <img src={menu3} alt={'menu3'} />
                  <span>Analytics</span>
                </p>
              </div>
              <div className="col-xs-12 menuItem">
                <p>
                  <img src={menu4} alt={'menu4'} />
                  <span>Game Zone</span>
                </p>
              </div>
            </div>
          </div>
        }


        <div className={'box ' + this.state.dashboardClass + ' col-xs-12'}>
          <DashboardNav hideSideBar={this.hideSideBar} />
          <Router>
            <div className='dashboard-home'>
              <Route path={'/dashboard/home'} component={DashboardHome} />
              <Route path={'/dashboard/GameZone'} render={(props) => (
                <GameZone setDashboardClass={this.setDashboardClass} />
              )} />
              <Route path={'/dashboard/InviteMembers'} component={InviteMembers} />
              <Route path={'/dashboard/Analytics'} component={Analytics} />
              <Route path={'/dashboard/Mision'} render={(props) => (
                <Mision setDashboardClass={this.setDashboardClass} />
              )} />
            </div>
          </Router>
        </div>
      </div>
    )
  }
}

/*const Dashboard = ({match}) => (

)*/

export default Dashboard;