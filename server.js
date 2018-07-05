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

});

app.get("/votes", (req, res) => {
  con.query("Select * from votes", function(err, rows) {
    if (err) throw err; 
    votes = rows;
    io.emit("voted")
  });
	res.send(votes)
})

app.post("/votes/:optId", (req, res) => {
	con.query("UPDATE votes SET opt"+req.params.optId+"_votes=opt"+req.params.optId+"_votes + 1 WHERE id=1", function(err) {
    if (err) throw err;
    console.log("update successful");
  });
  console.log("Post request received");
})


var server = http.listen(3000, () => {
	console.log("server is listening on port", server.address().port);
});