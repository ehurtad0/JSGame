import React, { Component } from 'react';
class HorizontalBar extends Component {
  render() {
    const cls = (this.props.value !== 0 && this.props.value <= 10)? 'undten' : '';
    return (
      <div className="horizontalBar">
    <div className={"title " + this.props.color +' '+cls}>
      <h5>{this.props.title}</h5>
    </div>
    <div className={"value " + this.props.className + ' ' + this.props.color}>
    &nbsp;
    </div>
    <div className="clear"></div>
  </div>

    );
  }
}


export default HorizontalBar;