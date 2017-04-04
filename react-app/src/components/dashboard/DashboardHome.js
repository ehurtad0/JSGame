import React, { Component } from 'react';
import HorizontalBar from './HorizontalBar.js'
var LineChart = require("react-chartjs-v2").Line;
var DoughnutChart = require("react-chartjs-v2").Doughnut;
var chartData = {
    labels: ["January", "February", "March", "April", "May", "June", "July"],
    datasets: [
        {
            label: "My First dataset",
            fillColor: "rgba(40, 146, 240, 0.3)",
            borderColor: "rgba(40, 146, 240,1)",
            pointBorderColor: "rgba(40, 146, 240,1)",
            //pointStrokeColor: "#fff",
            //pointHighlightFill: "#fff",
            //pointHighlightStroke: "rgba(220,220,220,1)",
            data: [100, 90, 85, 81, 56, 55, 40],
            fill: true
        }
    ]
};

var chartData2 = {
    labels: [
        "Complete",
        "Remaining",
    ],
    datasets: [
        {
            data: [80, 20],
            backgroundColor: [
                "#36A2EB",
                "#FFFFFF"
            ],
            hoverBackgroundColor: [
                "#36A2EB",
                "#FFFFFF"
            ],
            /*borderWidth: [
            	15,
            	15
            ]*/
        }]
};

var chartOptions2 = {
	legend: {
        display: false
	},
	cutoutPercentage: 90
};

var chartOptions = {
		elements: { 
			point: { 
				radius: 0, hitRadius: 5, hoverRadius: 5 
			} 
		},

		legend: {
        display: false
	    },
	    tooltips: {
	        enabled : true
	    },

        scales: {
            xAxes: [{
                //display: false,
                //drawBorder: false,
            }],
            yAxes: [{
                //display: false,
                //drawBorder: false,
            }],
        },
        
    };
const DashboardHome = () => (
	<div>
	<div className="col-xs-12 w-background">
		<h3>Lorem Ipsu</h3>
		<div className="horizontalBarChart">
			<div className="col-xs-12">
				<ul className="horizontalBarChartList">
				<li>&nbsp;</li>
				<li><p>0</p></li>
				<li><p>2</p></li>
				<li><p>4</p></li>
				<li><p>6</p></li>
				<li><p>8</p></li>
				<li><p>10</p></li>
				<li className="active blue-1"><p>12</p></li>
				<li><p>14</p></li>
				<li className="active blue-2"><p>16</p></li>
				<li className="active blue-3"><p>18</p></li>
				<li className="active blue-4"><p>20</p></li>
				<li><p>22</p></li>
				<li className="active blue-5"><p>24</p></li>
				<p className="clear"></p>
				</ul>

			</div>
			<div className="col-xs-12 scrollArea">
				<HorizontalBar title="Lorem Ipsum" className="bar-width-2" color="blue-1" value={2}/>
				<HorizontalBar title="Lorem Ipsum" className="bar-width-6" color="blue-2" value={6}/>
				<HorizontalBar title="Lorem Ipsum" className="bar-width-14" color="blue-3" value={14}/>
				<HorizontalBar title="Lorem Ipsum" className="bar-width-8" color="blue-4" value={8}/>
				<HorizontalBar title="Lorem Ipsum" className="bar-width-24" color="blue-5" value={24}/>
			</div>
			<p className="clear"></p>
		</div>
	</div>
	<p className="clear"></p>
	<div className='chartsWrapper'>
			<div className="col-xs-12 col-sm-4 doughnutChartWrapper">
				<div className='w-background'>
					<h3>Lorem Ipsum</h3>
					<div className="canvasWrapper">
					<DoughnutChart data={chartData2} options={chartOptions2} width="250" height="250"/>
					<div className="doughnutChartLabel"><p>80%</p><p className="small">COMPLETE</p></div>
					</div>
				</div>
			</div>

			<div className="col-xs-12 col-sm-8 linearChartWrapper">
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