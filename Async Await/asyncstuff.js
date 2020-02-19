// This document was created using https://javascript.info/async-await
// Diffrent "tests" are wrapped in an if statement to prevent them from running unless i want them to

// Using the async Keyword
if (true === false){
    async function f(){
        return 1;
    }
    
    f().then(alert)
}

// above is the same as this
if (true === false){
    async function f2(){
        return Promise.resolve("Resolved Promise manually??")
    }
    f2().then(alert)
}

// This only works inside of async function's
// The command "await" makes JS wait until the promise is settled before running the code
// let value = await promise

if (true === false){
    async function f3(){
    
        console.log("Were about to resolve a promise")
        let promise = new Promise((resolve, reject) => {
            setTimeout(() => resolve("Its been resolved"), 2000)
        })
    
        console.log("This should print before the promise gets resolved, the time delay is 2 seconds")
        let result = await promise // this line makes the program wait until the promise settles before continuing
        
        console.log("The promise gets resolved and then this code gets printed before the result does because of the order of the console logs")
        console.log("*", result) // This is logging the result of the promise "Its been resolved" with the * in front so we can easily identify it
        console.log("This should print after the promise is resolved")
    }
    f3()
}