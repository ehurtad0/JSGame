import React, { Component } from 'react';
import {
  NavItem,
  Nav,
  Collapse
} from 'react-bootstrap'
import circle from '../../img/gzcircle.png';
class GameZone extends Component {
  constructor(props) {
    super(props);
    this.props.setDashboardClass('gamezone');
  }

  render() {
    return (
      <div className="gameZoneMainWrapper">
        <div className="row gameZoneMenuWrapper">
          <GameZoneTopMenu />
        </div>
        <div className="row gameZoneTopWrapper">
          <div className="col-xs-5 col-sm-5">
            <CompanyScoreWidget />
          </div>
          <div className="col-xs-2 col-sm-2">

          </div>
          <div className="col-xs-5 col-sm-5">
            <CompanyScoreWidget />
          </div>
          <h1 className="weeks">Week <strong>7</strong></h1>
        </div>
        <div className="row ComparisonWidgetsWrapper">
          <ComparisonWidget />
          <ComparisonWidget />
          <ComparisonWidget />
        </div>
        <div className="row HistoriesWidgetsWrapper">
          <HistoryWidget />
          <HistoryWidget />
          <HistoryWidget />
        </div>
      </div>

    );
  }
}

class HistoryWidget extends Component {
  constructor(props) {
    super(props)

    this.state = {
      open: 0
    }

    this.activeCollapse = this.activeCollapse.bind(this);
  }

  activeCollapse() {
    this.setState({
      open: !this.state.open
    })
  }

  render() {
    return (
      <div className="HistoryWidget">
        <div className="row HistoryPreview">
          <div className="col-xs-1">
            <img src={'http://www.n-cod.net/ncdologo2.png'} alt='' />
          </div>
          <div className="col-xs-11">
            <h5>Lorem ipsum dolor sit amet <span className="pull-right"><i className="fa fa-calendar"></i> 5 Feb. <i className="fa fa-clock-o"></i> 15:23</span></h5>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque consequat dignissim consectetur. Nam vitae elit vitae elit semper consectetur. Praesent sollicitudin ipsum dui, at pretium mauris bibendum ut. Aenean ac mollis ipsum. Donec cursus vehicula accumsan. </p>
          </div>
        </div>
        <Collapse in={this.state.open}>
          <div>
            <div className="row HistoryDetails">
              <div className="col-xs-11 col-xs-offset-1 col-md-12 col-md-offset-0">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque consequat dignissim consectetur. Nam vitae elit vitae elit semper consectetur. Praesent sollicitudin ipsum dui, at pretium mauris bibendum ut. Aenean ac mollis ipsum. Donec cursus vehicula accumsan. </p>
              </div>
            </div>
            <div className="row HistoryCharts">
              <div className="col-md-5 col-xs-12">
                <BarChartHistory value={80} />
              </div>
              <div className="col-md-5 col-xs-12">
                <BarChartHistory value={95} />
              </div>
              <div className="col-md-2 hidden-xs">
              </div>
            </div>
          </div>
        </Collapse>
        <div className="row HistoryButton">
          <div className="col-xs-12">
            <a onClick={this.activeCollapse} className="pull-right expandHistory">{(this.state.open) ? 'Leer Menos' : 'Leer Mas'}</a>
          </div>
        </div>
      </div>
    )
  }
}

const BarChartHistory = () => {
  return (
    <div className="BarChartHistory">
      <h5>Lorem ipsum dolor sit amet</h5>
      <div className="value">
        <span style={{ left: this.props.value + '%' }}></span>
      </div>
    </div>
  )
}

class ComparisonWidget extends Component {
  constructor(props) {
    super(props)
    this.state = {

    }
  }

  render() {
    return (
      <div className="ComparisonWidget row">
        <h5>Title</h5>
        <div className="row">
          <div className="col-xs-6">
            <BarComparison type={'left'} value={50 * 2} />
          </div>
          <div className="col-xs-6">
            <BarComparison type={'right'} value={30 * 2} />
          </div>
        </div>
      </div>
    )
  }
}

class BarComparison extends Component {
  constructor(props) {
    super(props);
    this.state = {

    }
  }

  render() {
    return (
      <div className={"BarComparison " + this.props.type}>
        <div className="value" style={{ width: this.props.value + '%' }}>
          <img src={'http://www.n-cod.net/ncdologo2.png'} alt='' />
          <h2>35 S</h2>
        </div>
      </div>
    )
  }
}

class GameZoneTopMenu extends Component {
  constructor(props) {
    super(props)
    this.state = {
      currentTab: 1
    }

    this.handleSelect = this.handleSelect.bind(this);
  }

  handleSelect(tab) {
    this.setState({
      currentTab: tab
    })
  }

  render() {
    return (
      <Nav bsStyle="pills" activeKey={this.state.currentTab} onSelect={this.handleSelect}>
        <NavItem eventKey={1} ><i className="fa fa-trophy fa-2x"></i> Score Zone</NavItem>
        <NavItem eventKey={2} ><i className="fa fa-users fa-2x"></i> Comunity Zone</NavItem>
      </Nav>
    )
  }
}

const CompanyScoreWidget = () => {
  return (
    <div className="CompanyScoreWidget">
      <img src={circle} alt='circle' />
      <div className="info">
        <p className="companyName">Company One</p>
        <h1 className="companyScore">99</h1>
      </div>
    </div>
  )
}


export default GameZone;