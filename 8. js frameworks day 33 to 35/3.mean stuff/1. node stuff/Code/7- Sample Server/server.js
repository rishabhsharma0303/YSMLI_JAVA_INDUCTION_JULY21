var http = require("http");

var srvr = http.createServer(function (request, response) {

	//console.log(request);
	response.writeHead(200, {'Content-Type': 'text/plain'});
	response.end('Hello World\n');

});

srvr.listen(8081);

console.log('Server running at http://127.0.0.1:8081/');

