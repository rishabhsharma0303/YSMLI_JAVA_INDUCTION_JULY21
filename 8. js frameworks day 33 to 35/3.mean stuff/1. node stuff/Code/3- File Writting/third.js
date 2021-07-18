//File Writting
//https://docs.nodejitsu.com/articles/file-system/how-to-write-files-in-nodejs


var fs = require('fs');

var data = 'Hello World!';

fs.writeFile('test.txt', data, function (err) {
  if (err) 
	return console.log(err);
  
  console.log('Hello World > test.txt');
});
console.log('testing');


