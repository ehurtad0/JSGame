import React, { Component } from 'react';
import HomeNav from './home/HomeNav';
import MainImage from './home/MainImage';
import HowItWorks from './home/HowItWorks';
import SlideShowHome from './home/SlideShowHome';
import CreateYourTeam from './home/CreateYourTeam';
import HomeBrands from './home/HomeBrands';
import HomeFooter from './home/HomeFooter';
import '../home.css';

class Home extends Component {
  render() {
    return (
      <div className='home-page'>
      <div className="top-home-page">
          <HomeNav />
          <MainImage />
      </div>
          <div className="row brandsContainer">
          <HomeBrands />
          </div>
          <HowItWorks/>
          <SlideShowHome/>
          <CreateYourTeam/>
          <HomeFooter/>
      </div>
    );
  }
}

export default Home;