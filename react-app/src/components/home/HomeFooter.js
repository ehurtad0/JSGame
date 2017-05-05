import React, { Component } from 'react';
import logoImg from '../../img/joyScrumGrey.png';

var footerLinkList = [
	{
		title: 'title 1',
		links: ['Proin egestas', 'Enim quis nunc', 'Dapibus pellentesque']
	},
	{
		title: 'title 2',
		links: ['Integer ut massa', 'Pellentesque quis', 'Ut faucibus']
	},
	{
		title: 'title 3',
		links: ['Ut faucibus', 'Proin egestas', 'Enim quis nunc']
	}
]

const HomeFooter = () => (
	<div>
		<div className="container footer">
			<div className="col-xs-12 col-sm-4 footer-logo">
				<p><img src={logoImg} /></p>
			</div>
			<div className="footer-nav col-xs-12 col-sm-8">
				<ul className="list-unstyled col-4">
					<li>
						<a href="#">Lorem ipsum.</a>
					</li>
					<li>
						<a href="#">sum dolor.</a>
					</li>
					<li>
						<a href="#">sit amet..</a>
					</li>
					<li>
						<a href="#">fugiat!</a>
					</li>
					<li>
						<a href="#">consectetur.</a>
					</li>
				</ul>
				<ul className="list-unstyled col-4">
					<li>
						<a href="#">Lorem ipsum.</a>
					</li>
					<li>
						<a href="#">sum dolor.</a>
					</li>
					<li>
						<a href="#">sit amet..</a>
					</li>
					<li>
						<a href="#">fugiat!</a>
					</li>
					<li>
						<a href="#">consectetur.</a>
					</li>
				</ul>
				<ul className="list-unstyled col-4">
					<li>
						<a href="#">Lorem ipsum.</a>
					</li>
					<li>
						<a href="#">sum dolor.</a>
					</li>
					<li>
						<a href="#">sit amet..</a>
					</li>
					<li>
						<a href="#">fugiat!</a>
					</li>
					<li>
						<a href="#">consectetur.</a>
					</li>
				</ul>
			</div>
			<div className="col-xs-12 col-sm-8 hidden">
				{
					footerLinkList.map(function (el) {
						return <div className="col-xs-12 col-sm-4 hidden-xs footerLinkWrapper">
							<p><strong>{el.title}</strong></p>
							<ul className="footerLinksList">
								{
									el.links.map(function (e) {
										return <li><a href="#">{e}</a></li>
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
					<li key={1}><a href="#">Legal</a></li>
					<li key={2}><a href="#">Privacidad</a></li>
					<li key={3}><a href="#">Seguridad</a></li>
					<li key={4}><a href="#">Contacto</a></li>
					<p className="clear"></p>
				</ul>

			</div>
		</div>
	</div>
);

export default HomeFooter;