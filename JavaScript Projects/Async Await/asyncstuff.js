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

// Lets take a look at using fetch with async
const myGithubProfileUrl = "https://api.github.com/users/Jtonna"
if (true === false) {
    async function getGithubAvatar(){
        console.log("getGithubAvater(), were going to wait 7 seconds, then fetch the data")

        // wait 7 seconds
        await new Promise((resolve, reject) =>
        setTimeout(resolve, 7000)
        )

        // read github user
        let githubResponse = await fetch(myGithubProfileUrl)
        let githubUser = await githubResponse.json();
        console.log("Fetching github data")

        // Create DOM element for the avatar
        let img = document.createElement('img');
        img.src = githubUser.avatar_url
        img.className = githubUser.id+"-profile-picture"
        document.body.append(img)
        console.log("Created DOM Element\nheres the data we used")

        return console.log(githubUser)
    }

    getGithubAvatar()
}




// This half of the document was created using examples from
// https://developers.google.com/web/fundamentals/primers/async-functions

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

// Careful! Avoid getting too sequential
if(true === false){
    async function seriesOfEvents(){

        // Bringing the wait function back used to wait a few seconds before doing something
        function wait(ms){
            return new Promise(responseBanana => setTimeout(responseBanana, ms))
        }
    
        // This is an example of getting too sequential, meaning one line/timer starts when the other one finishes
        console.log("Were going to wait a 3 seconds, 1.5 seconds to say something & then another 1.5 to say something else \n--")
        await wait(3000)
        await wait(1500); // Wait 1 second
        console.log("hello")
        await wait(1500); // Wait 1 more second
        console.log("world")
    
        console.log("that took 3 seconds to run... + computational time which should have been very fast unless youre on an intel pentium processor")
    }
    
    seriesOfEvents()
}

// How to avoid being sequential
if (true === false){
    async function parallel(){

        // Bringing the wait function back, used for a time delay
        function wait(ms){
            return new Promise(responseBanana => setTimeout(responseBanana, ms))
        }
    
        // This is an example of running clock's / timer's in parallel or "asynchronously"
        const wait1 = wait(7000) // 7 seconds
        const wait2 = wait(7000) // 7 seconds
    
        // lets call the time delays, we can use our phones "stop watch" to measure the time, just manually invoke from our console using "parallel()" and start the timer at roughly the same time
        console.log("Instructed to wait 7 seconds (1)")
        await wait1; // Wait 7 seconds for the first timer
        console.log("Instructed to wait 7 seconds (2)")
        await wait2; // When the first timer runs out, this one should as well since they both started at the same time
    
        return(console.log("Just waited 7, not 14 seconds to tell you; I love you!"))
    }
    // parallel()
}

// Lets output fetches in order
// Lets assume we have a few URL's to get data from, we could do it like this

// These API Url's serve dummy data for testing, see https://jsonplaceholder.typicode.com/
const listOfUrls = [
    'https://jsonplaceholder.typicode.com/posts/1',
    'https://jsonplaceholder.typicode.com/posts/2',
    'https://jsonplaceholder.typicode.com/posts/3',
    'https://jsonplaceholder.typicode.com/posts/4',
    'https://jsonplaceholder.typicode.com/posts/5'
]

// Lets output fetches in-order (using promises)
if (true === false) {
    function logInOrder(urls){
        // Fetch all of the URL's in the array
        const textPromises = urls.map(url => {
            // console.log("requested to fetch", url) // As you can see everything gets fetched one after another and doesnt wait for a response before fetching the next item
            return fetch(url)
                .then(response => response.text())
                // .then(console.log("finished fetching", url)) // Uncommenting this, youll see that it fetches and doesnt wait for the response before fetching the next item
        })
    
        // Log them all in order
        textPromises.reduce((chain, textPromise) => {
            return chain.then(() => textPromise)
                .then(text => console.log('Data from the fetch', text));
        }, Promise.resolve())
    }
    logInOrder(listOfUrls)
}

// Lets output fetches in-order (too sequential) 1 by 1
// Note: this is slower than the promises example as it waits until the second fetch doesnt begin until the first one has been finished
if (true === false) {
    async function logInOrder(urls){
        // For each item in the url's array
        for(const url of urls){
            const response = await fetch(url)
            console.log("fetching", url, "like the dog i am.")
            console.log(await response.text())
            console.log("\n")
        }
    }
    logInOrder(listOfUrls)
}

// Lets output fetches in parallel using a boring "for" loop
if (true === false){
    async function logInOrder(urls){

        // fetch all of the url's in parallel & store them as textPromises
        const textPromises = urls.map(async url=> {
            const response = await fetch(url);
            return(response.text())
        })
    
        // Log the responses from textPromises sequentially
        for (const textPromise of textPromises){
            console.log("here comes a response from textPromises")
            console.log(await textPromise)
            console.log("glad that worked")
            console.log("\n")
        }
    }
    logInOrder(listOfUrls)
}