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
  password: "root"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
  con.query("USE test");
  con.query("Select * from gui_state", function(err, rows) {
  	console.log(rows);
  });
});

// con.query("Select * from gui_state", function(err, rows) {
// 	console.log(rows);
// });

var server = http.listen(3000, () => {
	console.log("server is listening on port", server.address().port);
});