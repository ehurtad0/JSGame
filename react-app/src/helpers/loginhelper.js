import axios from 'axios'
import api from '../JoyScrumApi';

export default {


  loginThroughGoogleToken: function (token, history) {

    const params = new URLSearchParams();

    params.append('token', token);

    axios.post(api.loginGoogle(), params,
      {
        headers: {
          'X-Requested-With': 'XMLHttpRequest'
        }
      })
      .then((res) => {
        const jwt = res.request.getResponseHeader('jwt');
        const profileData = JSON.stringify(res.data);
        localStorage.setItem('jwtToken', jwt);
        localStorage.setItem('profileData', profileData);
        if (jwt !== null) {
          history.push('/dashboard/home');
        }
      });
  }
}