import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Welcome from './components/Welcome';
import Register from './components/Register';
import { BrowserRouter as Router, Route, Match } from 'react-router-dom'
import createBrowserHistory from 'history/createBrowserHistory';

const history = createBrowserHistory()

class App extends Component {
  render() {
    return (
      <Router>
        <Route path="/register" component={Register}/>
      </Router>

    );
  }
}

export default App;
