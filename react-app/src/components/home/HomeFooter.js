import React, { Component } from 'react';
import logoImg from '../../img/joyScrumGrey.png';

var footerLinkList = [
  {
    title : 'title 1',
    links : ['Proin egestas','Enim quis nunc','Dapibus pellentesque']
  },
  {
    title : 'title 2',
    links : ['Integer ut massa','Pellentesque quis','Ut faucibus']
  },
  {
    title : 'title 3',
    links : ['Ut faucibus','Proin egestas','Enim quis nunc']
  }
]

const HomeFooter = () => (
  <div>
    <div className="container footer">
      <div className="col-xs-12 col-sm-4">
      <p><img src={logoImg} /></p>
      </div>
      <div className="col-xs-12 col-sm-8 hidden">
      {
        footerLinkList.map(el => {
        <div key={el.title} className="col-xs-12 col-sm-4 hidden-xs footerLinkWrapper">
            <p><strong>{el.title}</strong></p>
            <ul className="footerLinksList">
              {
                el.links.map(link => {
                  <li key={link}><a href="#">{link}</a></li>
                })
              }
            </ul>
          </div>
        })
      }
      </div>
    </div>
    <div className="container">
      <div className="col-xs-12 text-center footerSubLinks">
        <ul>
          <li><a href="#">Legal</a></li>
          <li><a href="#">Privacidad</a></li>
          <li><a href="#">Seguridad</a></li>
          <li><a href="#">Contacto</a></li>
          <p className="clear"></p>
        </ul>

      </div>
    </div>
  </div>
);

export default HomeFooter;