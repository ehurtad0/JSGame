import React, { Component } from 'react';
import img1 from '../../img/img1.png';
import img2 from '../../img/img2.png';
import img3 from '../../img/img3.png';
import img4 from '../../img/img4.png';
import img5 from '../../img/img5.png';

var howElement = [
    {
      id: 1,
      title: '1. Registrate',
      description: '¿Quieres formar parte del cambio y la mejora? Da el paso para vivir el mundo del software de manera distinta y divertida. ¡Hay formas diferentes de hacer las cosas! Regístrate y compruébalo.',
      img: img1
    },
    {
      id: 2,
      title: '2. Seleciona tu rol',
      description: 'Todos asumimos un rol en nuestro equipo, ¿cuál es el tuyo? Elige bien, porque en función de lo que decidas, harás un camino u otro.',
      img: img2
    },
    {
      id: 3,
      title: '3. Invita a tus amigos',
      description: 'Allá donde estés no hagas nada sin tu equipo. ¡Invita a tus compañeros para compartir tu aventura!',
      img: img3
    },
    {
      id: 4,
      title: '4. Seleccionar tus misiones',
      description: 'Elige y gestiona mejor las misiones que te ayudarán a alcanzar grandes metas y mitigar el riesgo en tus entregas. Por cada misión que cumplas, ganarás puntos para escalar en el ranking.',
      img: img4
    },
    {
      id: 5,
      title: '5. A disfrutar',
      description: 'Para abrir nuevos caminos hay que inventar, experimentar, crecer,… ¡y también divertirse! Con Joyscrum lo conseguirás.',
      img: img5
    }
];

class HowItWorks extends Component {
  render() {
    return (
      <div>
        <div className="container scrollspy" id="howItWorks">
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
            <div className="col-xs-12 col-sm-6 infoWapper odd">
              <h2 className="howItWorksTitle">{this.props.title}</h2>
              <p>{this.props.description}</p>
            </div>
            <div className="col-xs-12 col-sm-6 pull-right odd">
              <img src={this.props.img} className="img-responsive" alt=''/> 
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
            <div className="col-xs-12 col-sm-6 infoWapper even">
              <h2 className="howItWorksTitle">{this.props.title}</h2>
              <p>{this.props.description}</p>
            </div>
            <div className="col-xs-12 col-sm-6 even">
              <img src={this.props.img} className="img-responsive" alt='' /> 
            </div>
        </div>
      </div>
    );
  }
}

export default HowItWorks;