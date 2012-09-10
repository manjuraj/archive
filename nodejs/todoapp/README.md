## Todo App

+ npm install -g express
+ express todoapp

  express creates the basic skeleton of application for us
  .
  ├── README.md
  ├── app.js
  ├── package.json
  ├── public
  │   ├── images
  │   ├── javascripts
  │   └── stylesheets
  │       └── style.css
  ├── routes
  │   ├── index.js
  │   └── user.js
  └── views
      ├── index.jade
      └── layout.jade

+ cd todoapp
+ npm install
+ jade templating engine
+ rendering a view, passing variables
+ general template : views/layout.jade
+ create view for every page
+ npm install redis --save
+ final
  .
  ├── README.md
  ├── app.js
  ├── node_modules
  │   ├── express
  │   ├── jade
  │   └── redis
  ├── package.json
  ├── public
  │   ├── images
  │   ├── javascripts
  │   └── stylesheets
  ├── routes
  │   ├── routes.js
  │   └── user.js
  └── views
      ├── index.jade
      ├── layout.jade
      └── todo.jade
