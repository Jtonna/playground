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
    Review is over, time to get to some work.
*/