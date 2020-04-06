/*
    The following snippets are review of exercises from the_javascript_universe.js module
    the rest of the article is going to be listed below the next comment block
*/

let example_val_1 = "02/18/1999" // Date in a String format
let review_example_1 = typeof(example_val_1) === "date" // does the data type === date?
console.log(review_example_1) // will always be false because "date" is NOT a data type
// typeof() has a limited number of outputs, and date is NOT one of them. a date is always going to be an object or a String

let review_example_2 = typeof(null) // What??
// Null is NOT an object, its a primitive value. But it says its an object.
// This is a bug in JavaScript. One that cant be fixed without breaking existing websites and programs
// https://2ality.com/2013/10/typeof-null.html?ck_subscriber_id=677803343
console.log(review_example_2)

let example_val_3 = 1337
let review_example_3 = typeof(typeof(example_val_3))
// So lets think about this, if typeof resolves to a data type and displays it as a string
// this means that example_val_3 should resolve to int, but "int" resolves to a string, so the output should be
console.log(review_example_3) // string?

/*
    Kicking off the module with the following code snippet
    Dan asks us to take a few moments and write down what we expect to happen line by line
*/

let reaction = 'yikes'; // declare a variable named "reaction" that contains a string "yikes"
reaction[0] = 'l'; // set reaction @ index 0 "y" to "l"
console.log(reaction); // console log reaction "likes"

// The code will either print "yikes" or throw an error depending on whether we are in "strict mode"
// It will NEVER print "likes"
// Primitive values are Immutable, meaning they cant be modified

// Explained with a small example

// Below we have an array (which is mutable) and a string (immutable)
let arr = [212, 8, 506];
let str = 'hello';

// Here we are accessing the first item in both the array & the string, we use the same syntax but dont get confused
// unlike python strings ARE NOT arrays
console.log(arr[0]) // 212
console.log(str[0]) // "h"

// Lets change the arrays first item
arr[0] = 420;
console.log(arr) // [420, 8, 506]

// As demonstrated with the code snippet dan gave us, we cant do the same to Strings, because they are immutable.
// This means "unchangeable" in latin. To be more specific its not just Strings; its any primitive value thats off limits.

let fifty = 50
fifty.shades = 'gray'

// Like any number 50 is a primitive value, so we cant set properties on it. Its off limits.

// In dans JavaScript mental model, all primitive values exist in the outer circle further from his code, like distant star's.
// he can refer to them and create new ones, but he cant change them, they stay what they are.

