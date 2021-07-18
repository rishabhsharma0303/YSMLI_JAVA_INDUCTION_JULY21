var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var Book = require('./Book.model');

var port = 8080;
var db = 'mongodb://localhost/rajdb33'

mongoose.connect(db);

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({
  extended: true
}));

app.get('/', function(req, res) {
  res.send('happy to be here');
});

app.get('/book', function(req, res) {
    console.log('getting all books');
    Book.find({})
      .exec(function(err, books) {
        if(err) {
          res.send('error occured')
        } else {
        //   console.log(books);
        res.header("Cache-Control", "no-cache, no-store, must-revalidate");
        res.header("Pragma", "no-cache");
        res.header("Expires", 0);
        res.json(books);
        }
      });
  });
  
  app.get('/book/:id', function(req, res) {
    console.log('getting all books');
    Book.findOne({
      _id: req.params.id
      })
      .exec(function(err, book) {
        if(err) {
          res.send('error occured')
        } else {
        //   console.log(books);
          res.json(book);
        }
      });
  });
  

  app.post('/book', function(req, res) {
    var newBook = new Book();// ref to moongooes sch
  
    newBook.title = req.body.title;
    newBook.author = req.body.author;
    newBook.category = req.body.category;
  
    newBook.save(function(err, book) {
      if(err) {
        res.send('error saving book');
      } else {
       // console.log(book);
        res.send(book);
      }
    });
  });

  app.put('/book/:id', function(req, res) {
    Book.findOneAndUpdate({ _id: req.params.id },{ $set: { title: req.body.title }},{new: true, upsert: true}, 
        function(err, newBook) {
      if (err) {
        res.send('error updating ');
      } else {
        console.log(newBook);
        res.send(newBook);
      }
    });
  });
  app.delete('/book/:id', function(req, res) {
    Book.findOneAndRemove({
      _id: req.params.id
    }, function(err, book) {
      if(err) {
        res.send('error removing')
      } else {
        //console.log(book);
        res.send(book);
        res.status(204);
      }
    });
  });


app.listen(port, function() {
    console.log('app listening on port ' + port);
  });
  