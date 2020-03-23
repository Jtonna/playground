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
let skyThing1 = 420
let skyThing2 = "Hello World"
let skyThing3 = true
let skyThing4 = undefined

console.log("skything1: ",typeof(skyThing1))
console.log("skything2: ",typeof(skyThing2))
console.log("skything3: ",typeof(skyThing3))
console.log("skything4: ",typeof(skyThing4))

// Objects and Functions are also "values" but unlike the stars in the sky, we can interact with them. We can connect them and make more if needed.
console.log("[] is: ",typeof([]))
console.log("{} is: ",typeof({}))
const x = () => {} // This is an arrow function
console.log("const x = () => {} is:", typeof(x))