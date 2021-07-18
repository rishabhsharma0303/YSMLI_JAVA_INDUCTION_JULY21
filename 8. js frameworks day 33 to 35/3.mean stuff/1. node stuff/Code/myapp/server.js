var express = require('express');
var bodyParser = require('body-parser');
var multer  = require('multer');

var app = express();
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: false }));


app.get('/', function (req, res) {
   res.send('Hello World');
});

app.get('/login.html', function (req, res) {
   res.sendFile( __dirname + "/" + "login.html" );
});

app.get('/process_get', function (req, res) {

   // Prepare output in JSON format
   response = {
       first_name: req.query.first_name,
       last_name: req.query.last_name
   };   
   res.end(JSON.stringify(response));
});

app.post('/process_post', function (req, res) {
    
	// Prepare output in JSON format
	console.log(req.body);
   response = {
       first_name: req.body.first_name,
       last_name: req.body.last_name
   };   
   res.end(JSON.stringify(response));
   
});

// This responds a GET request for abcd, abxcd, ab123cd, and so on
app.get('/ab*cd', function(req, res) {   
   console.log("Got a GET request for /ab*cd");
   res.send('Page Pattern Match');
});

var server = app.listen(8090, function () {

  var host = server.address().address
  var port = server.address().port

  console.log("Example app listening at http://%s:%s", host, port)

})
