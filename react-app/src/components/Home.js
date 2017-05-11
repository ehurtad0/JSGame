import React, { Component } from 'react';
import HowItWorks from './home/HowItWorks';
import SlideShowHome from './home/SlideShowHome';
import CreateYourTeam from './home/CreateYourTeam';
import HomeBrands from './home/HomeBrands';
import HomeFooter from './home/HomeFooter';


class Home extends Component {
  render() {
    return (
      <div id="homePage">
          <div className="row brandsContainer">
          {false &&
           <HomeBrands />
          }
          </div>
          <HowItWorks />
          {/*<SlideShowHome />*/}
          <CreateYourTeam />
          <HomeFooter />
      </div>
    );
  }
}

export default Home;
