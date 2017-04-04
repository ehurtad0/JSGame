import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Home from './components/Home';
import Page from './components/Page';
import Dashboard from './components/Dashboard';
import Register from './components/Register';
import User from './components/User';
import { BrowserRouter as Router, Route, Match, Redirect } from 'react-router-dom'
import createBrowserHistory from 'history/createBrowserHistory';

const history = createBrowserHistory()

class App extends Component {
  render() {
    return (
      <Router history = {history} >
      <div className="mainContainer">
        <Route exact path="/" render = {() => (
          <Redirect to = '/page/home' />
        )} />
        <Route path="/page" component={Page}/>
        <Route path="/register" component={Register}/>
        <Route path="/dashboard" component={Dashboard}/>
        <Route path="/user" component={User}/>
      </div>
      </Router>

    );
  }
}

export default App;
