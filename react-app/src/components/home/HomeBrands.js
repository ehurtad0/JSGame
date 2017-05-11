import React from 'react';
import brand1 from '../../img/brands/brand1a.jpg';
import brand2 from '../../img/brands/brand2a.jpg';
import brand3 from '../../img/brands/brand3a.jpg';
import brand4 from '../../img/brands/brand4a.jpg';
import brand5 from '../../img/brands/brand5a.jpg';
import brand6 from '../../img/brands/brand6a.jpg';
import brand7 from '../../img/brands/brand7a.jpg';
import brand8 from '../../img/brands/brand8a.jpg';

const brands = [
  brand1,
  brand2,
  brand3,
  brand4,
  brand5,
  brand6,
  brand7,
  brand8
];

const HomeBrands = () => (

    <ul className="brandList">
      <li className="brand">Featured in:</li>
      {brands.map(function(brand){
        return <li className="brand"><img src={brand} alt=''/></li>
      })
      }
      <p className='clear'></p>
    </ul>
);

export default HomeBrands;