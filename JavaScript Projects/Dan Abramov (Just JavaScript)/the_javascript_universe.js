/*
    This email, the second in the series from justjavascript.com is designed to create proper "mental models"
    or change the way my/your existing "mental models" of things like variables are.
    It has heavy emphasis on having the right mindset for reading and understanidng code.
*/

/*
    Dan sees javascript as having two kinds of "values" in javascript
        1. Primitive Values
        2. Objects and Functions
*/

// Primitive values are things like the stars in the sky, cold and distant; but we are able to see them and refer to them when needed.
// These are things like, numbers, strings, booleans & undefined
let skyThing1 = 420;
let skyThing2 = "Hello World";
let skyThing3 = true;
let skyThing4 = undefined;

console.log("skything1: ",typeof(skyThing1));
console.log("skything2: ",typeof(skyThing2));
console.log("skything3: ",typeof(skyThing3));
console.log("skything4: ",typeof(skyThing4));

// Objects and Functions are also "values" but unlike the stars in the sky, we can interact with them. We can connect them and make more if needed.
console.log("[] is: ",typeof([]));
console.log("{} is: ",typeof({}));
const x = () => {} // This is an arrow function
console.log("const x = () => {} is:", typeof(x));

/*
    There are many things JavaScript cant answer, like if we should confess our true feelings to someone, or keep waiting
    BUT there are some questions that JavaScript would be delighted to answer these are called expressions
*/

// Expressions
console.log(2 + 2); // 4

/*
    There are only 9 "data types" in javascript
        undefined - used when there is an unintentionally missing value
        null - used for inentionally missing values
        booleans - true & false, used for logical operations
        numbers - used for math calculations
        strings - things like "hello" and "abracadabra" used for well, text
        symbols - used to hide implementation details, this is uncommon
        bigints - used for math on big numbers, this is also uncommon & new
    
*/

// Dans Homework
console.log("Dans Homework typeof():", typeof(424435416852))
// Imagine you see some code that checks whether a value is a date
// typeof(value) === 'date'. Will this code work? Why or why not?
    // No this wont work because there is not a data type called 'date'