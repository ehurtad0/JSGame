const apiBasePath = 'https://api.joyscrum.com/rest/api/AUTH';
const apiBasePath2 = 'https://api.joyscrum.com/rest/api'
module.exports = {
	loginGoogle(){
		//return apiBasePath + '/rest/api/player/validate';
		return apiBasePath;
	},

	getMisions(pk){
		return apiBasePath2 + '/mission/' + pk;
	}
}