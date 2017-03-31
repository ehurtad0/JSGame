import React, { Component } from 'react';
import img1 from '../../img/img1.png';
import img2 from '../../img/img2.png';
import img3 from '../../img/img3.png';
import img4 from '../../img/img4.png';
import img5 from '../../img/img5.png';

var howElement = [
    {
      id: 1,
      title: 'Lorem ipsum',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean molestie vestibulum dolor, ac sollicitudin est vehicula non. Duis sed enim eget lectus blandit malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus sapien nulla, dapibus id urna sit amet, porttitor fringilla velit. Quisque eu elementum magna.',
      img: img1
    },
    {
      id: 2,
      title: 'Lorem ipsum',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean molestie vestibulum dolor, ac sollicitudin est vehicula non. Duis sed enim eget lectus blandit malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus sapien nulla, dapibus id urna sit amet, porttitor fringilla velit. Quisque eu elementum magna.',
      img: img2
    },
    {
      id: 3,
      title: 'Lorem ipsum',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean molestie vestibulum dolor, ac sollicitudin est vehicula non. Duis sed enim eget lectus blandit malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus sapien nulla, dapibus id urna sit amet, porttitor fringilla velit. Quisque eu elementum magna.',
      img: img3
    },
    {
      id: 4,
      title: 'Lorem ipsum',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean molestie vestibulum dolor, ac sollicitudin est vehicula non. Duis sed enim eget lectus blandit malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus sapien nulla, dapibus id urna sit amet, porttitor fringilla velit. Quisque eu elementum magna.',
      img: img4
    },
    {
      id: 5,
      title: 'Lorem ipsum',
      description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean molestie vestibulum dolor, ac sollicitudin est vehicula non. Duis sed enim eget lectus blandit malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus sapien nulla, dapibus id urna sit amet, porttitor fringilla velit. Quisque eu elementum magna.',
      img: img5
    }
];

class HowItWorks extends Component {
  render() {
    return (
      <div>
        <div className="container">
          <div className="row">
              <div className="col-xs-12">
                <h1 className="howItWorksTitle">How It Works</h1>
              </div>
          </div>
        </div>
        <OddElement title={howElement[0].title} description={howElement[0].description} img={howElement[0].img}/>
        <EvenElement title={howElement[1].title} description={howElement[1].description} img={howElement[1].img}/>
        <OddElement title={howElement[2].title} description={howElement[2].description} img={howElement[2].img}/>
        <EvenElement title={howElement[3].title} description={howElement[3].description} img={howElement[3].img}/>
        <OddElement title={howElement[4].title} description={howElement[4].description} img={howElement[4].img}/>
      </div>
    );
  }
}

class OddElement extends Component{
  render(){
    return(
      <div className="container">
        <div className="row howElement">
            <div className="col-xs-12 col-sm-6 infoWapper">
              <h2 className="howItWorksTitle">{this.props.title}</h2>
              <p>{this.props.description}</p>
            </div>
            <div className="col-xs-12 col-sm-6">
              <img src={this.props.img} className="img-responsive"/> 
            </div>
        </div>
      </div>
    );
  }
}

class EvenElement extends Component{
  render(){
    return(
      <div className="container">
        <div className="row howElement">
            <div className="col-xs-12 col-sm-6">
              <img src={this.props.img} className="img-responsive" /> 
            </div>
            <div className="col-xs-12 col-sm-6 infoWapper">
              <h2 className="howItWorksTitle">{this.props.title}</h2>
              <p>{this.props.description}</p>
            </div>
        </div>
      </div>
    );
  }
}

export default HowItWorks;