import React, { Component } from 'react';
class CreateYourTeam extends Component {
  render() {
    return (
      <div className="CreateYourTeamWrapper">
        <div className="container">
          <div className="row">
            <div className="col-xs-12 col-sm-8 descriptionWrapper">
            <h2>Lorem ipsum</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean molestie vestibulum dolor, ac sollicitudin est vehicula non. Duis sed enim eget lectus blandit malesuada. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus sapien nulla, dapibus id urna sit amet, porttitor fringilla velit. Quisque eu elementum magna.
            </p>
            </div>
            <div className="col-xs-12 col-sm-4">
              <div>
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
      </div>
    );
  }
}

export default CreateYourTeam;