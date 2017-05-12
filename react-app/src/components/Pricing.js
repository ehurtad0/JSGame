import React, { Component } from 'react';
import { Collapse } from 'react-bootstrap';

import advanced from '../img/advanced.png';
import plus from '../img/plus.png';
import premium from '../img/premium.png';
import basic from '../img/basic.png';
import advancedCheck from '../img/advancedCheck.png';
import plusCheck from '../img/plusCheck.png';
import premiumCheck from '../img/premiumCheck.png';
import basicCheck from '../img/basicCheck.png';
import HomeFooter from './home/HomeFooter';

const features = [
  'Lorem ipsum dolor sit amet',
  'Lorem ipsum dolor sit amet',
  'Lorem ipsum dolor sit amet',
  'Lorem ipsum dolor sit amet',
  'Lorem ipsum dolor sit amet',
  'Lorem ipsum dolor sit amet',
  'Lorem ipsum dolor sit amet',
  'Lorem ipsum dolor sit amet',
  'Lorem ipsum dolor sit amet'
];

const plans = [
  {
    title: 'Basic',
    img: basic,
    chk: basicCheck,
    features: [false, false, true, true, true, true, false, true, false],
    containerClass: 'basic',
    subTitle: 'billed annually',
    promote: ''
  },
  {
    title: 'Plus',
    img: plus,
    chk: plusCheck,
    features: [true, false, true, true, true, true, false, true, true],
    containerClass: 'plus',
    subTitle: 'billed annually',
    promote: ''
  },
  {
    title: 'Advanced',
    img: advanced,
    chk: advancedCheck,
    features: [true, true, true, true, true, true, false, true, false],
    containerClass: 'advanced',
    subTitle: 'billed annually',
    promote: 'promote'
  },
  {
    title: 'Premium',
    img: premium,
    chk: premiumCheck,
    features: [true, true, true, true, true, true, true, true, true],
    containerClass: 'premium',
    subTitle: 'billed annually',
    promote: ''
  },

];

class Pricing extends Component {

  constructor(props) {
    super(props);
    this.state = {
      basic: 26,
      plus: 39,
      advanced: 59,
      premium: 118,
      active: {
        basic: false,
        plus: false,
        advanced: false,
        premium: false,
      },
      curentUser: 1,
      curentPlan: 1,
    };
  }

  activeCollapse(collapse) {
    var newStateObj = { active: {} };
    newStateObj['active'][collapse] = !this.state.active[collapse];

    this.setState(newStateObj);
  }

  updateCurentUser(element) {
    this.setState(prevState => ({
      curentUser: element,
    }));
  }

  updateCurentPlan(element) {
    this.setState(prevState => ({
      curentPlan: element,
    }));
  }

  render() {
    return (
      <div className="container">
        <div className="row">
          <div className="col-xs-12">
            <h4>
              Our Plans
                <span className="discountList">
                <a href="#" onClick={() => this.updateCurentPlan(1)} className={(this.state.curentPlan === 1) ? "active" : ""}>Yearly SAVE 18%</a>
                <a href="#" onClick={() => this.updateCurentPlan(2)} className={(this.state.curentPlan === 2) ? "active" : ""}>Two Yearly SAVE 32%</a>
                <a href="#" onClick={() => this.updateCurentPlan(3)} className={(this.state.curentPlan === 3) ? "active" : ""}>Monthly</a>
              </span>
            </h4>
          </div>
        </div>
        <div className="row">
          <div className="col-xs-12 usersNavWrapper">
            <div className="usersNav">
              <ul className="nav nav-pills">
                <li role="presentation" className={(this.state.curentUser === 1) ? "active" : ""}>
                  <a href="#" onClick={() => this.updateCurentUser(1)}>5 <span>users</span></a>
                </li>
                <li role="presentation" className={(this.state.curentUser === 2) ? "active" : ""}>
                  <a href="#" onClick={() => this.updateCurentUser(2)}>10 <span>users</span></a>
                </li>
                <li role="presentation" className={(this.state.curentUser === 3) ? "active" : ""}>
                  <a href="#" onClick={() => this.updateCurentUser(3)}>15 <span>users</span></a>
                </li>
                <li role="presentation" className={(this.state.curentUser === 4) ? "active" : ""}>
                  <a href="#" onClick={() => this.updateCurentUser(4)}>20 <span>users</span></a>
                </li>
                <li role="presentation" className={(this.state.curentUser === 5) ? "active" : ""}>
                  <a href="#" onClick={() => this.updateCurentUser(5)}>+20 <span>users</span></a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div className="row plansInfo">
          <div className="hidden-xs hidden-sm">
            <div className="col-xs-12 col-sm-4 text-center">
              <p className='imgHolder'></p>
              {
                features.map(function (el, key) {
                  return <p key={key} className="featureTitle">{el}</p>
                })
              }
            </div>
            {
              plans.map((el, key) => {
                return (
                  <div key={key} className={"col-xs-12 col-sm-2 text-center featuresWrapper " + el.containerClass + ' ' + el.promote}>
                    <div className='imgHolder'>
                      <div>
                        <p className="imgPlansWrapper">
                          <img src={el.img} alt="" className="img-responsive" />
                        </p>
                      </div>
                      <div>
                        <p>{el.title}</p>
                      </div>
                      <div>
                        <h1>
                          <span>€ </span>{this.state[el.containerClass]}<span> /Mo</span>
                        </h1>
                      </div>
                    </div>
                    {
                      el.features.map((e, k) => {
                        return <p key={k} className="featureOption">{(e) ? <img src={el.chk} alt="" /> : '--'}</p>
                      })
                    }
                    <p><button className={"btn btn-custom btn-full " + el.containerClass}>Get Started</button></p>
                  </div>)
              })
            }
          </div>
          <div className="hidden-md hidden-lg">
            {
              plans.map((el, key) => {
                return (
                  <div key={key} className={"featuresWrapper " + el.containerClass + ' ' + el.promote}>
                    <div className='imgHolder mobile' onClick={() => this.activeCollapse(el.containerClass)}>
                      <div className="row">
                        <div className="col-xs-2">
                          <p className="imgPlansWrapper"><img src={el.img} alt="" /></p>
                        </div>
                        <div className="col-xs-8">
                          <p>{el.title}</p>
                        </div>
                        <div className="col-xs-2">
                          <p>{(!this.state.active[el.containerClass]) ? <i className="fa fa-angle-down"></i> : <i className="fa fa-angle-up"></i>}</p>
                        </div>
                      </div>
                    </div>
                    <Collapse in={this.state.active[el.containerClass]}>
                      <div>
                        <div className="priceWrapper"><h1><span>€ </span>{this.state[el.containerClass]}<span> /Mo</span></h1></div>
                        {
                          el.features.map((e, k) => {
                            return e ? (
                              <div key={k} className="row featureItem">
                                <div className="col-xs-10">{features[k]}</div>
                                <div className="col-xs-2"><img src={el.chk} alt="" /></div>
                              </div>
                            ) :
                              (
                                <div key={k}></div>
                              )

                          })
                        }
                        <div className="text-center featureItem btnMobileWrapper">
                          <p><button className={"btn btn-custom " + el.containerClass}>Get Started</button></p>
                        </div>
                      </div>
                    </Collapse>
                  </div>
                )
              })
            }
          </div>
        </div>
        <HomeFooter />
      </div>
    );
  }
}

export default Pricing;