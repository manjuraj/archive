// The function that is passed to `ready' is run when the
// html document is ready for javascript to start happening
$('document').ready(function() {
  alert('The document is ready!!!');

  // $exampleJQuery is jQuery object containing every element
  // in the html page
  var $exampleJQuery = $('*')

});

// jquery to click a button
<html>
<head>
    <script src="script.js"></script>
</head>
<body>
    <button id="clickme">Click Me!</button>
</body>
</html>

$(document).ready(function() {
  $('#clickme').click(function() {
    alert("call me, maybe!"); 
  }
});