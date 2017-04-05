import React, { Component } from 'react';
import mainImg from '../../img/mainImgTransparent.png';
var jQuery = require('jquery');
const MainImage = () => (
  <div className="container">
  	<div className='row mainImage'>
      <div className="col-xs-12 col-sm-8 mainImageWrapper">
        <img src={mainImg} className="img-responsive" />
      </div>
      <div className="col-xs-12 col-sm-4 mainFormWrapper">
      <div>
          <p>
            <strong>Aprender y aplicar Scrum, ahora es divertido.</strong>
          </p>
          <form>
            <div className="form-group">
              <input className="form-control" type="text" placeholder="Enter Your Work email"/>
            </div>
            <div className="form-group">
              <button className="btn btn-blue">
                Create Your Team
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
);

(function ($) {
  var w = $(window).width();

  $(document).ready(function(){
    fixHeight($('.mainImageWrapper'), $('.mainFormWrapper'));
  });

  $(window).resize(function(){
    w = $(window).width();
    fixHeight($('.mainImageWrapper'), $('.mainFormWrapper'));
  });

  setInterval(function(){
    fixHeight($('.mainImageWrapper'), $('.mainFormWrapper'));
  },1000);

  function fixHeight(div1, div2){
      var h1 = div1.height();
      var h2 = div2.height();
      if(parseInt(w) >= 768){
        if(h1 >= h2 ){
          div2.height(h1);
        } else {
          div1.height(h2);
        }
      } else {
        div2.removeAttr('style');
        div2.removeAttr('style');
      }
  }
})(jQuery);
export default MainImage;