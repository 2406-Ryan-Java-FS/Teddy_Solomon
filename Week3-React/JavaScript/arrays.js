// Arrays

let numbers = [10, 20, 30, 40, 50];
console.log(numbers);

// Pop - will remove the last element
console.log("Pop: " + numbers.pop());
console.log(numbers);

// Push - will add element(s) to end of array
console.log("Push: " + numbers.push(60));
console.log(numbers);

// Shift - will remove the first element
console.log("Shift: " + numbers.shift());
console.log(numbers);

// Unshift - will add element(s) to beginning of array
console.log("Unshift: " + numbers.unshift(0));
console.log(numbers);

// There is no enforcement of what data types can be accepted into an array.
console.log("Push: " + numbers.push("Ryan"));
console.log(numbers);

let ray = [1, 2, "Ryan", null, undefined, [], {}, function() { }, Date];
console.log(ray);

// Map: perform some operation/function on every element of the array
// Returns an array with said changed values

console.log(numbers.map(num => num * 10));
console.log(numbers);

// foreach function - does not return an array or affect the original array
numbers.forEach(num => console.log(num));

// For-of Loop - iterates over every element of a collection
// Like Java's Enhanced For Loop
for (number of numbers) {
    console.log(number + " + 5 = " + (number + 5));
}

// Still have traditional for loops
for (let i = 0; i < 10; i++) {
    console.log(i);
}