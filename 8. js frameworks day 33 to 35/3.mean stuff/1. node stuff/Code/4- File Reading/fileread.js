//File Reading
//https://docs.nodejitsu.com/articles/file-system/how-to-read-files-in-nodejs

var fs = require('fs');

fs.readFile('test.txt', 'utf8', function (err,data) {
  if (err) {
    return console.log(err);
  }
  console.log("--------------------------------");
  console.log(data);
  console.log("--------------------------------");
});

