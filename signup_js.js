const mongoose = require('mongoose');
var express = require('express');
var bodyParse = require('body-parser');
var app = express();
var username = '';
var usermail = '';
var userpass = '';
var userconpass = '';

app.use(express.static('html', { extensions: ['html', 'css'] }));
app.engine('html', require('ejs').renderFile)
app.use(bodyParse.json())
app.use(express.static('public'))
app.use(bodyParse.urlencoded({
    extended: true
}))

app.use(bodyParse.urlencoded({ extended: true }));
app.use(express.static('public'));



mongoose.connect("mongodb://127.0.0.1:27017/sunil", (err) => {
    if (err)
        console.log("DB Not Connected");
    else
        console.log("DB Connected");
});

const ns = new mongoose.Schema({
    sname: String,
    semail: String,
    spassword: String,
    sconpassword: String
});

const nm = new mongoose.model('proj1', ns);

app.get('/signup_js', function (req, res) {
    username = req.query['uname'];
    usermail = req.query['email'];
    userpass = req.query['pwd'];
    userconpass = req.query['pwd1'];

    const data = new nm({
        sname: username,
        semail: usermail,
        spassword: userpass,
        sconpassword: userconpass
    });

    data.save();
    app.use(express.static('public'));
    res.send('succesfull');


})

var server = app.listen(7778);