var socket = io()
$(function() {
	$("#btn-1").click(function() {
		addVote("1")
	});

	$("#btn-2").click(function() {
		addVote("2");
	})

	getVotes();
});

socket.on("voted", getVotes)

function getVotes() {
	$.get("http://localhost:3000/votes", (data) => {
		console.log(data[0]);
		$("#votes1").text(data[0]["opt1_votes"]);
		$("#votes2").text(data[0]["opt2_votes"]);
	})
}

function addVote(option) {
	console.log("adding to " + option)
	$.post("http://localhost:3000/votes/"+option);
}