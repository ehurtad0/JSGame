import axios from 'axios';
import api from '../JoyScrumApi';
import setAutorizationToken from './setAutorizationToken';

export default {
  getUserMisions: function (component) {
    const token = localStorage.getItem('jwtToken');
    if (token === null) {
      return false;
    }

    const user = JSON.parse(localStorage.getItem('profileData'));

    setAutorizationToken(token);

    axios.get(api.getMisions(user.pk))
      .then((res) => {
        const missions = [];
        const secondaryMissions = [];

        res.data.forEach((val, k) => {
          if (val.tipomision === 1) {
            missions.push(val);
          } else {
            secondaryMissions.push(val);
          }
        });

        component.setState({
          missions: missions,
          secondaryMissions: secondaryMissions
        });
      });
  }
}