//http://www.tutorialspoint.com/nodejs/nodejs_express_framework.htm
/* For CoRS (Cross-origin resource sharing)
http://enable-cors.org/server_expressjs.html
*/

var express = require('express');
var bodyParser = require('body-parser');
var mysql = require('mysql');

var app = express();
app.use(express.static('public'));
//app.use(bodyParser.urlencoded({ extended: false }));


 var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : 'root',
  database : 'ymsdemo3'
});

//To enable CoRS
app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});


//http://127.0.0.1:8081/student
app.get('/student', function (req, res) {
  
    var qry = 'SELECT * from student';
    connection.query(qry, function(err, rows, fields) {
       
      if (!err){
          res.end(JSON.stringify(rows));     
      }
      else
        console.log('Error while performing Query.');
    });
});

//http://127.0.0.1:8081/student/121
app.get('/student/:id', function (req, res) {
   
    var sid = req.params.id; //recieved with request
	var qry = 'SELECT * from student where id=' +sid;
	
    connection.query( qry, function(err, rows, fields) {
       
      if (!err){
          res.end(JSON.stringify(rows));     
      }
      else
        console.log('Error while performing Query.');
    });
});



var server = app.listen(8081, function () {

  var host = server.address().address
  var port = server.address().port

  console.log("Example app listening at http://%s:%s", host, port)

})
