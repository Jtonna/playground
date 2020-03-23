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

/*
    Dan also talks about reading code in "fast-mode" & "slow-mode", where fast mode is just function names, comments & structure
    compared to slow mode where we take extra time to follow what the code does step by step.

    He uses the example as follows
*/

function duplicateSpreadsheet(original) {
    if (original.hasPendingChanges) {
      throw new Error('You need to save the file before you can duplicate it.');
    }
    let copy = {
      created: Date.now(),
      author: original.author,
      cells: original.cells,
      metadata: original.metadata,
    };
    copy.metadata.title = 'Copy of ' + original.metadata.title;
    return copy;
}

/*
    Now at first glance you should have notices the following
        this probably duplicates a spread sheet,
        if the spreadsheet hasnt been saved, it throws an error to the user.
        and it prepend's "Copy of " to the new spreadsheets title.
    
    But as dan discusses many probably missed that this actually alters the title of the original spreadhseet
    If you didnt catch it (like i did) at first glance, thats okay, the issue lies in the following line
        copy.metadata.title = 'Copy of ' + original.metadata.title;
    
    Issue explained, step by step
    - 
    In the code above, we are attempting to change the name of the "copy" which is the new file
    so we call the copy object
    we access the value for "metadata" which points to the ORIGINAL document
    we then access the "title" value of the original object
    then we set that value to "Copy of" + original.metadata.title
    
    this would be the equivalent of the following line of code
        original.metadata.title = 'Copy of ' + original.metadata.title


*/