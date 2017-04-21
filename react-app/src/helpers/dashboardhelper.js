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
			var missions = [];
			var secondaryMissions =[];

			res.data.map((val,k) => {
				if (val.tipomision === 1) {
					missions.push(val);
				} else {
					secondaryMissions.push(val);
				}
			});

				component.setState({
					missions : missions,
					secondaryMissions: secondaryMissions
				});
		});
	}
}