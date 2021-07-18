//File Writting & Reading
//http://stackoverflow.com/questions/17645478/node-js-how-to-read-a-file-and-then-write-the-same-file-with-two-seperate-functi

var fs = require('fs');

//Read from one file and write to other
var srcPath = "text1.txt";
var savPath = "text2.txt";

	fs.readFile(srcPath, 'utf8', function (err, data) {
            if (err) throw err;
            
            fs.writeFile (savPath, data, function(err) {
                if (err) throw err;
                console.log('complete');
            });
        });

