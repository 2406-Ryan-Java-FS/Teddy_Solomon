// Declaration of a variable
let myVariable;

// To print
console.log("Hello World");

console.log(myVariable);
console.log(typeof myVariable);

myVariable = "Word";
console.log(myVariable)
console.log(typeof myVariable)

myVariable = false;
console.log(myVariable);
console.log(typeof myVariable)

/*
JavaScript engages in Type Coercion to determine if 2 variables/values
are equivalent, while disregarding their data type

== performs type coercion comparison where JS does not regard
typing in measuring their equality
*/

console.log(10 == 10);
console.log(10 == "10")
console.log(10 == '10')

// === is used to enforce type comparison
console.log(10 === 10);
console.log(10 === "10")

console.log(5 != '5');
console.log(5 !== '5')

/*
JavaScript has truthy and falsy values, which evaluate to true or false
Used in conditions and type coercions
*/

console.log(0 == false)
// 0 is a Falsy Value -> it evaluates to false

if (true) {
    console.log("Hello World 1")
}

if (false) {
    console.log("Hello World 2")
}

if (0) {
    console.log("Hello World 3")
}

if (1) {
    console.log("Hello World 4")
}

if (123) {
    console.log("Hello World 5")
}

if (-456) {
    console.log("Hello World 6")
}
// Non-zero numbers are truthy when used in a condition

if ("Hello") {
    console.log("Hello World 7")
}

if ("Hello World") {
    console.log("Hello World 8")
}

if ("1234") {
    console.log("Hello World 9")
}

if ("") {
    console.log("Hello World 10")
}
// Non-empty strings are truthy

console.log(0 == "0");
console.log(false == "0"); // "0" is falsy when used in type coercion

if ("0") {
    console.log("Hello World 11")
}

// In a condition there are 6 falsy values: false, 0, "", null, undefined, NaN
console.log("Seven"-5)

if (null) {
    console.log("Hello World 12")
}

if (undefined) {
    console.log("Hello World 13")
}

// Back to coercion
console.log(null == false);
console.log(null == true);
console.log(undefined == false);
console.log(undefined == true);

console.log(null == undefined);

console.log(Infinity == Infinity);
console.log(NaN == NaN);

console.log("Seven" - 5);
console.log("Hello" - "World");

console.log(1 == true);
console.log(2 == true);
console.log(1 == 2); // Contradiction

myVariable = 0;
if (!myVariable) {
    console.log("I am broke");
}