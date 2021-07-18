var express = require('express');
var bodyParser = require('body-parser');
var mysql      = require('mysql');


var app = express();
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: false }));


 var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : 'root',
  database : 'ymsdemo3'
});


app.get('/', function (req, res) {
   res.send('Hello World');
});

app.get('/getdata', function (req, res) {
   res.sendFile( __dirname + "/" + "data.html" );
});

// This responds a GET request for the /list_user page.
app.get('/showuser', function (req, res) {
   console.log("Got a GET request for /list_user");
  
   var str ="";
   
    connection.query('SELECT * from emp_table', function(err, rows, fields) {
       
      if (!err){
          res.end(JSON.stringify({data:rows}));     
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
