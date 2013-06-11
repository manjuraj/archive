# DOM
An HTML document has what is called the Document Object Model (DOM). This is the way that JavaScript is able to access and modify the HTML page.

The DOM consists of every element on the page, laid out in a heirarchical way that reflects the way that they were laid out in the original file. Relationships between elements are referred to with a vocabulary similar to that of a geneologist. Elements have parents, children, and siblings

All interaction with DOM happens through the objects

// When a function is called in the global
// context, not as part of an object,
// `this` refers to the window - the global object

# this

Inside a function, what this refers to depends on where the function is being called from. In this case, the function is being called from the global context, outside of all objects, and so that is also to where this will refer.

When this is outside of any function, it refers to the global object (the window). this also refers to the global object when it is used in a function that is not part of an object. But when a function that is part of an object is called, within that function, the this will refer to the object to which the function belongs.



# JQuery

You may notice that some variables start with a $. This does not change anything, it is just convention to signify that the variable that starts with $ is a jQuery object.

variables
javascript is dynamically typed
So, when we create a variable all we have to do is give it a name and any value
In other languages that are statically typed, each variable must have a specific type associated with it.
Variables in java script can hold any type and any time.

<script>
var color = "red"
</script>

Document is a variable that's built into our Web page


Functions are great, but when there are a lot of them going on, the issue of scope starts to crop up. The scope of a function is the set of variables that it has access to. This is where the var keyword comes into play. When you declare a variable with var, it is 'scoped' to the function that you are in. This means that only the function it is immediately inside of can access it.
There are two exceptions.
  * Without var the variable is scoped to the entire world
  * If a function is declared inside of another function, the inner function can access the variables within the scope of the outer function.









A prototype is an object from which other objects inherit properties

http://javascriptweblog.wordpress.com/2010/06/07/understanding-javascript-prototypes/

don't confuse with the prototype property
the true prototype of an object is helpd by the internal [[Prototype]] property

Object.getPrototypeOf(object)
object.__proto__

multiple instances can share the same prototype


http://yehudakatz.com/2011/08/12/understanding-prototypes-in-javascript/

what is a property:
- a property has a name and value; in addition, a property can be enumerable, configurable and writable.

