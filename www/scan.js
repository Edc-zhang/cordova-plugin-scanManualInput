var exec = require('cordova/exec');
var scan = {
	recognize:function(scanText,callback) {
		exec(callback, callback, "scan", "recognize", [scanText]);
	}
};
module.exports = scan;
