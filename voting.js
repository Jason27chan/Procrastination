var socket = io()
$(function() {
	$("#btn-1").click(function() {
		console.log("button 1 pressed");
		addVote("1");
	})

	$("#btn-2").click(function() {
		console.log("button 2 pressed");
		addVote("2");
	})

	getVotes();
});

socket.on("voted", getVotes)

function getVotes() {
	$.get("http://localhost:3000/votes", (data) => {
		$("#votes1").text(data[0].opt1_votes);
		$("#votes2").text(data[0].opt2_votes);
	})
}

function addVote(option) {
	$.post("http://localhost:3000/votes/"+option);
	console.log("adding")
}