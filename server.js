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
  // In the future, need to pass in an ID so we know which bill to update votes for. 
  con.query("Select * from votes WHERE id=1", function(err, rows) {
    if (err) throw err; 
    votes = rows;
    res.send(votes[0])
  });
})

app.post("/votes/:optId", (req, res) => {
  // In the future, need to pass in an ID so we know which bill to update votes for. 
	con.query("UPDATE votes SET opt"+req.params.optId+"_votes=opt"+req.params.optId+"_votes + 1 WHERE id=1", function(err, rows, fields) {
    if (err) throw err;
    res.sendStatus(200);
    console.log("update successful");
    io.emit("voted");
  });
})

var server = http.listen(3000, () => {
	console.log("server is listening on port", server.address().port);
});