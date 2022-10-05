const jsonServer = require('json-server');
const server = jsonServer.create();
const router = jsonServer.router('./src/server/db.json');
const middlewares = jsonServer.defaults();
const db = require('./db.json');
const fs = require('fs');

server.use(middlewares);
server.use(jsonServer.bodyParser);

server.get('/articles', (_req: any, res: any) => {
  const articles = readArticles();
  res.send(articles);
});

server.post('/articles', (req: any, res: any) => {
  db.articles.push(req.body);
  res.status(500).send('User already exists');
});

server.use(router);
server.listen(3000, () => {
  console.log('JSON Server is running');
});

function readArticles() {
  const dbRaw = fs.readFileSync(__dirname + '/db.json');
  const users = JSON.parse(dbRaw).articles;
  return users;
}