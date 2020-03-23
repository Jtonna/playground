// Dan asks us to read the following code
// let a = 10;
// let b = a;
// a = 0;

// The idea here isnt to teach us variables, it to see if we can understand how the compiler interprets the code.
let a = 10; // Declare a variable named "a" and set it to the value of 10
console.log("'a' is:", a)
let b = a // Declare a variable named "b" and set it to the variable a's value. essentially b = 10 now
a = 0; // Change the variable a's value to 0.
console.log("now 'a' is: ", a) // We can expect this to return 0
console.log("'b' is 'a', before it's value was changed:", b) // We can expect this to return 10

