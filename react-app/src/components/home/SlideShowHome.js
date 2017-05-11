import React, { Component } from 'react';
import img1 from '../../img/pc1.jpg';
import img2 from '../../img/pc2.jpg';
import img3 from '../../img/pc3.jpg';
// var Slider = require('react-slick');
import { Slider } from 'react-slick';

class SlideShowHome extends Component {
  render() {
    const settings = {
      dots: true,
      infinite: true,
      speed: 500,
      slidesToShow: 1,
      slidesToScroll: 1
    };
    return (
      <div className="homeSliderWrapper">
        <div className="row">
        <Slider {...settings}>
          <div className="container homeSliderItem">
            <div className="col-xs-12 col-sm-7 homeSliderInfo pull-right">
                <h3>Lorem ipsum</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean molestie vestibulum dolor, ac sollicitudin est vehicula non. Duis sed enim eget lectus blandit malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus</p>
            </div>
            <div className="col-xs-12 col-sm-5 homeSliderImageWrapper">
                <img src={img1} className="img-responsive " alt='' />
            </div>
          </div>
          <div className="container homeSliderItem">
            <div className="col-xs-12 col-sm-7 homeSliderInfo pull-right">
                <h3>Lorem ipsum</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean molestie vestibulum dolor, ac sollicitudin est vehicula non. Duis sed enim eget lectus blandit malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus</p>
            </div>
            <div className="col-xs-12 col-sm-5 homeSliderImageWrapper">
                <img src={img2} className="img-responsive " alt='' />
            </div>
          </div>
          <div className="container homeSliderItem">
            <div className="col-xs-12 col-sm-7 homeSliderInfo pull-right">
                <h3>Lorem ipsum</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean molestie vestibulum dolor, ac sollicitudin est vehicula non. Duis sed enim eget lectus blandit malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus</p>
            </div>
            <div className="col-xs-12 col-sm-5 homeSliderImageWrapper">
                <img src={img3} className="img-responsive " alt='' />
            </div>
          </div>
        </Slider>
        </div>
      </div>
    );
  }
}

export default SlideShowHome;