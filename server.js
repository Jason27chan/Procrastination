var express = require("express");
var bodyParser = require("body-parser")
var app = express();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var mysql = require("mysql");

app.use(express.static(__dirname));
app.use(bodyParser.urlencoded({extended:false}))

var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "test"
});

var votes;

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
  con.query("Select * from votes", function(err, rows) {
  	votes = rows
  });
});

app.get("/votes", (req, res) => {
	res.send(votes)
})


var server = http.listen(3000, () => {
	console.log("server is listening on port", server.address().port);
});