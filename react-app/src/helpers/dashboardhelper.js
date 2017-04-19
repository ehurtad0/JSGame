import axios from 'axios'
import setAutorizationToken from './setAutorizationToken';
const api = require('../JoyScrumApi');

module.exports = {
	

	getUserMisions : function(component){
		var token = localStorage.getItem('jwtToken');
		if (token === null) {
			return false;
		}

		var user = JSON.parse(localStorage.getItem('profileData'));

		setAutorizationToken(token);

		axios.get(api.getMisions(user.pk))
		.then((res) => {
				component.setState({
					missions : res.data
				});
		});
	}
}