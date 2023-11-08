const mongoose = require('mongoose');
var express = require('express');
var bodyParse = require("body-parser");
var express = require('express');
var app = express();


mongoose.connect("mongodb://127.0.0.1:27017/sunil", (err) => {
    if (err)
        console.log("DB Not Connected");
    else
        console.log("DB Connected");
});

var db = mongoose.connection;
var collection = db.collection('proj1');

app.use(bodyParse.urlencoded({ extended: false }));

app.post('/login_js', async (req, res) => {
    try {
        const username = req.body.email;
        const password = req.body.pwd;

        const data = await collection.findOne(
            { "semail": username },
            { "spassword": password }
        );

        if (data) {
            const semail = data.semail;
            const spassword = data.spassword;

            if (semail === username) {
                if (spassword === password) {
                    res.send('Successfull...');
                }
                else {
                    res.send('Invalid Password');

                }
            } else {
                res.send('Invalid Email..');
            }
        } else {
            res.send('Invalid');
        }
    }
    catch (error) {
        // Handle any errors that occur during processing
        console.error(error);
        res.status(500).json({ error: 'Internal server error' });
    }
})

var server = app.listen(1970);