import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Welcome from './components/Welcome';
import Dashboard from './components/Dashboard';
import Register from './components/Register';
import { BrowserRouter as Router, Route, Match } from 'react-router-dom'
import createBrowserHistory from 'history/createBrowserHistory';

const history = createBrowserHistory()

class App extends Component {
  render() {
    return (
      <Router>
      <div className="mainContainer">
        <Route path="/register" component={Register}/>
        <Route path="/dashboard" component={Dashboard}/>
      </div>
      </Router>

    );
  }
}

export default App;
