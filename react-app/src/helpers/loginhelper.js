import axios from 'axios'
const api = require('../JoyScrumApi');

module.exports = {
	

	loginThroughGoogleToken : function(token, history){

		var params = new URLSearchParams();

		params.append('token', token);

		axios.post(api.loginGoogle(), params,
		{
			 headers: {
                    'X-Requested-With': 'XMLHttpRequest'
            }
		})
		.then((res) => {
			var jwt = res.request.getResponseHeader('jwt');
			var profileData = JSON.stringify(res.data);
			localStorage.setItem('jwtToken', jwt);
			localStorage.setItem('profileData', profileData);
			if(jwt !== null){
				history.push('/dashboard/home');
			}	
		});
	}
}