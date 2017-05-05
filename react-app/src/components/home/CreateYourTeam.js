import React, { Component } from 'react';
class CreateYourTeam extends Component {
  render() {
    return (
      <div className="CreateYourTeamWrapper">
        <div className="container">
          <div className="row">
            <div className="col-xs-12 descriptionWrapper">
              <h2 className="text-center">¡Comienza Hoy!</h2>
              <p className="text-center">
                Descubre lo que puede hacer <a href="#" style={{ color: '#2491ec' }}>joyScrum</a> por tí.
            </p>
              <p className="text-muted text-center">Registrarse con:</p>
              <div className="btn-group btn-group-lg social-login col-xs-12 col-sm-10 col-sm-offset-1">
                <a href="#" className="btn social-login--item">
                  <img
                    className="login-icon"
                    src="https://placeholdit.imgix.net/~text?txtsize=33&txt=37%C3%97150&w=37&h=37" alt="" />
                  <span className="login-text">Asana</span></a>
                <a href="#" className="btn social-login--item">
                  <img 
                    className="login-icon"
                    src="https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=37&h=37" 
                    alt="" />
                  <span className="login-text">Google+</span>
                </a>
                <a href="#" className="btn social-login--item">
                  <img
                    className="login-icon"
                    src="https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=37&h=37" alt="" />
                  <span className="login-text">Jira</span>
                </a>
                <a href="#" className="btn social-login--item">
                  <img 
                    className="login-icon"
                    src="https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=37&h=37" alt="" />
                  <span className="login-text">Trello</span>
                </a>
                <a href="#" className="btn social-login--item">
                  <span className="login-icon"><img src="https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=37&h=37" alt="" /></span>
                  <span className="login-text">Wrike</span>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default CreateYourTeam;