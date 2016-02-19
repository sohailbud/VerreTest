var app   = require('express')();
var http = require('http').Server(app);
var moment = require('moment');


	
app.get('/',function(req,res){
	var data = 'Hello World!';

	res.json(data);
});

app.get('/time',function(req,res){
	
	var date = moment().format('MMMM Do YYYY, h:mm:ss a');

	res.json(date);
});

http.listen(3000,function(){
	console.log("Connected & Listen to port 3000");
});