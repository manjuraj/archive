alert("Hello World!");
console.log("Hello", "World!");

var debug = funcion (message) {
  console.log("Debug", message);
}

var f = function (a, b) {
  var c = a + b;
  return c * 2;
}
var x = f(3, 4);

var a = [1, "1", [0, false, null]];
console.log(a);
console.log(a.length);
console.log(a[2][2], a[3]);

for (var i = 0; i < console.length; i += 1) {
    console.log(a[i]);
}

var myObject = {
  "myNum"  : 10,
  "myFunc" : function() { alert('hi!'); },
  "myObj"  : { "key" : "value"}
};
myObject.myNum += 100;

// composed function takes a func and returns a function
// that runs the function that was passed, and then
// runs that function _again_ on the return value of the
// to the function.
var composed = function(func) {
  return function(x) {
    return func(func(x));
  }
}

var addThree = function(x) {
  return x + 3;
}

// prints 10
composed(addThree)(4)

// anonymous function
doSomethingWith(function() {
    //do things
});