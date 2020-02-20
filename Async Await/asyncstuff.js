// This half of the document was created using examples from https://javascript.info/async-await
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

// The command "await" makes JS wait until the promise is settled before running the code
// The command "await" only works inside of async functions too
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

// Like described above the "await" command only works inside of async function's
// This just tests that out to prove it
if (true === false){
    function f4(){
        let promise = Promise.resolve(1)
        // uncomment the line below to test it out
        // let result = await promise // This will be a Syntax error as "await" cannot work inside of regular (non async) functions
    }

    f4()
}

// This half of the document was created using examples from https://developers.google.com/web/fundamentals/primers/async-functions

// URL Used for fetching
const nasaPhotoOfTheDayURL = "https://api.nasa.gov/planetary/apod?api_key=c9Sk2PjC4vxNM3SRQ5iZKdws0EYWUHboPuW4HtQb"

// Console logging a fetch without ASYNC
if (true === false){

    // Heres an example without async
    function logFetchNonAsync(theUrl){
        // return some data
        console.log("Requested to fetch", theUrl, "WITHOUT async")
        return fetch(theUrl)
            // "fetches" the url & consumes its JSON
            .then(console.log("Just fetched the URL, now setting the response"))
            .then(response => response.text())
            .then(console.log("Just set the response"))
            // Then it will console log the response
            .then(text => {
                console.log("Logging response:", text)
            })
            .catch(err => {
                console.log("The fetch failed: ", err)
            });
    }

    logFetchNonAsync(nasaPhotoOfTheDayURL)
}

// Console Logging a fetch using async
if (true === false){
    console.log("Were about to use an async function to fetch data")
    async function logFetchUsingAsync(url){
        console.log("requested the following url", url)
        try {
            console.log("Were going to try to fetch now")
            const response = await fetch(url)
            console.log(await response.text()) // Waits for the response before continuing, once its recieved it logs it to the console
            console.log("Looks like it worked!")
        }
        catch (err){
            console.log("Sadly there was some sort of error")
            console.log("fetch failed", err)
        }
    }

    logFetchUsingAsync(nasaPhotoOfTheDayURL)
}

// Async Return Values (fulfilled & reject/error)
if (true === false){

    // Async function always return a promise, wether we use await or not, that promise resolved with whatever the function returns or rejects
    function wait(ms){
        return new Promise(responseBanana => setTimeout(responseBanana, ms))
    }

    // retun a promise that fulfills with "Hello world!"
    async function helloWorld(){
        console.log("Were going to say something, but you have to wait 1.5 seconds")
        await wait(1500);
        return(
            console.log("Hello world!"),
            console.log("Congrats on waiting for the promise to fulfill, that took 1.5 seconds")
        );
    }

    // return a promise that rejects with Error "Ahhh Shit"
    async function helloError(){
        console.log("Were going to wait 5 seconds then throw an error")
        await wait(5000);
        console.log("its been 3 seconds, Here comes the error")
        throw Error("Ahhh Shit")
    }

    // Run Hello World then run Hello Error in a Queue Like Sytem
    // Meaning that it will start Hello World, and add actions to a queue based on the time we wait
    // but it also adds helloError to the queue as well thats why we see both of them in the 
    helloWorld()
    helloError()

}

// Note: the following "streams" are a way to get the content-length of a response, without using headers and keeping the response in memory
// The streams get garbage collected as soon as we are done doing whatever we want with them, its pretty neat

// Streaming a response via Promises
if (true === false){

    // This thing is an async loop that logs out 
    function getResponseSize(url) {
        return fetch(url).then(response => {
          const reader = response.body.getReader();
          let total = 0;
      
          return reader.read().then(function processResult(result) {
            if (result.done) return total;
      
            const value = result.value;
            total += value.length;
            console.log('Received chunk', value);
      
            return reader.read().then(processResult);
          })
        });
      }

      getResponseSize(nasaPhotoOfTheDayURL)
}

// Streaming a response using Async functions
if (true === false){
    // Unlike the Promise's version, this is much more readible and doesnt take ages to figure out
    async function getResponseSize(url){
        const response = await fetch(url); // We wait until we are done fetching to execute the next action
        const reader = response.body.getReader(); // wait until the response gets the url & we use getReader on the body of the response before preforming the next action

        let result = await reader.read() // We wait until the reader.read() finished running to execute the next action
        let total = 0

        while (!result.done) {
            const value = result.value;
            total += value.length
            console.log("Recieved a chunk", value)

            // get the next result
            result = await reader.read()
        }

        return(console.log(total))
    }

    getResponseSize(nasaPhotoOfTheDayURL)
};

// Things to avoid

// Careful! Avoid getting too sequential https://developers.google.com/web/fundamentals/primers/async-functions#careful_avoid_going_too_sequential
async function seriesOfEvents(){

    // Bringing the wait function back used to wait a few seconds before doing something
    function wait(ms){
        return new Promise(responseBanana => setTimeout(responseBanana, ms))
    }

    console.log("Were going to wait 1.5 seconds to say something & then another second to say something else \n--")
    await wait(1500); // Wait 1 second
    console.log("hello")
    await wait(1500); // Wait 1 more second
    console.log("world")

    console.log("that took 3 seconds to run... + computational time which should have been very fast unless youre on an intel pentium processor")
}

seriesOfEvents()