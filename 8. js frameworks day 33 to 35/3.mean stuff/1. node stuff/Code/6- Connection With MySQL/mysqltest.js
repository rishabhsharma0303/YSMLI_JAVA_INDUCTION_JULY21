//https://codeforgeek.com/2015/01/nodejs-mysql-tutorial/
//http://www.sitepoint.com/using-node-mysql-javascript-client/
//npm install mysql

var mysql      = require('mysql');

 var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : '',
  database : 'test'
});

	connection.query('SELECT * from student', function(err, rows, fields) {
       
      if (!err){
            console.log('The solution is: ', rows);
            console.log('length:' + rows.length);
          
          for(var i=0;i<rows.length;i++){
              var row = rows[i];
              console.log(row.id + "," + row.name + "," + row.city + "," + row.age);
          }
      }
      else
        console.log('Error while performing Query.');
    });//end of query

	connection.end();
