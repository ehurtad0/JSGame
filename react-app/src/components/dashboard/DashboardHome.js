import React, { Component } from 'react';
import HorizontalBar from './HorizontalBar.js'
var LineChart = require("react-chartjs").Line;
var DoughnutChart = require("react-chartjs").Doughnut;
var chartData = {
    labels: ["January", "February", "March", "April", "May", "June", "July"],
    datasets: [
        {
            label: "My First dataset",
            fillColor: "rgba(40, 146, 240, 0.3)",
            strokeColor: "rgba(40, 146, 240,1)",
            pointColor: "rgba(40, 146, 240,1)",
            pointStrokeColor: "#fff",
            pointHighlightFill: "#fff",
            pointHighlightStroke: "rgba(220,220,220,1)",
            data: [100, 90, 85, 81, 56, 55, 40],
        }
    ]
};

var chartData2 = [
          {
              value: 80,
              color:"#1871ad",
              highlight: "#1871ad",
              label: "Completed",
              width: 10
          },
          {
              value: 20,
              color: "#FFFFFF",
              highlight: "#FFFFFF",
              label: "Remaining"
          }
          ];

var chartOptions2 = {percentageInnerCutout : 80};

var chartOptions = {
        scales: {
            xAxes: [{
                type: 'linear',
                position: 'bottom'
            }]
        }
    };
const DashboardHome = () => (
	<div>
	<div className="col-xs-12 w-background">
		<h3>Lorem Ipsu</h3>
		<div className="horizontalBarChart">
			<div className="col-xs-12">
				<ul className="horizontalBarChartList">
				<li>&nbsp;</li>
				<li>0</li>
				<li>2</li>
				<li>4</li>
				<li>6</li>
				<li>8</li>
				<li>10</li>
				<li className="active blue-1">12</li>
				<li>14</li>
				<li className="active blue-2">16</li>
				<li className="active blue-3">18</li>
				<li className="active blue-4">20</li>
				<li>22</li>
				<li className="active blue-5">24</li>
				<p className="clear"></p>
				</ul>

			</div>
			<div className="col-xs-12">
				<HorizontalBar title="Lorem Ipsum" className="bar-width-2" color="blue-1"/>
				<HorizontalBar title="Lorem Ipsum" className="bar-width-6" color="blue-2"/>
				<HorizontalBar title="Lorem Ipsum" className="bar-width-14" color="blue-3"/>
				<HorizontalBar title="Lorem Ipsum" className="bar-width-8" color="blue-4"/>
				<HorizontalBar title="Lorem Ipsum" className="bar-width-24" color="blue-5"/>
			</div>
			<p className="clear"></p>
		</div>
	</div>
	<p className="clear"></p>
	<div className='chartsWrapper'>
			<div className="col-xs-4 doughnutChartWrapper">
				<div className='w-background'>
					<h3>Lorem Ipsum</h3>
					<DoughnutChart data={chartData2} options={chartOptions2} width="250" height="250"/>
					<div className="doughnutChartLabel"><p>80%</p><p className="small">COMPLETE</p></div>
				</div>
			</div>

			<div className="col-xs-8 linearChartWrapper">
				<div className='w-background'>
					<h3>Lorem Ipsum</h3>
					<LineChart data={chartData} options={chartOptions} width="700" height="250"/>
					<p className="linearChartLabel"><i className="fa fa-arrow-down"></i> -46%</p>
				</div>
			</div>
			<p className="clear"></p>
	</div>
	<p className="clear"></p>
	</div>
);

export default DashboardHome;