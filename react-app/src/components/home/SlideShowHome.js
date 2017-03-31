import React, { Component } from 'react';
import img1 from '../../img/pc1.jpg';
import img2 from '../../img/pc2.jpg';
import img3 from '../../img/pc3.jpg';

class SlideShowHome extends Component {
  render() {
    return (
      <div className="homeSliderWrapper">
        <div className="row">
          <div className="container homeSliderItem">
            <div className="col-xs-4 homeSliderImageWrapper">
                <img src={img1} className="img-responsive " />
            </div>
            <div className="col-xs-8 homeSliderInfo">
                <h3>Lorem ipsum</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean molestie vestibulum dolor, ac sollicitudin est vehicula non. Duis sed enim eget lectus blandit malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus</p>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default SlideShowHome;