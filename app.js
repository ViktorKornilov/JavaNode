// simple api with / route

const express = require('express');
const app = express();

app.get('/', (req, res) => {
    res.send('Welcome to epic leaderboard API');
} );

// scores route
app.get('/scores', (req, res) => {
    res.send('gytis|10, jonas|20, petras|30');
} );

// scores/id route
app.get('/scores/:id', (req, res) => {
    res.send('scores of ' + req.params.id);
} );

app.listen(25792, () => {
    console.log('Server running on port 3000');
} );