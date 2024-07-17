// There are several ways to create functions in JS.

// 1st way (most OOP-feeling way):
function hello() {
    console.log("Hello!");
}

hello();

// 2nd way:
let hola = function() {
    console.log("Hola!");
}

hola();

function add(num1, num2) {
    return num1 + num2;
    // return Number(num1) + Number(num2);
}

let subtract = function(num1, num2) {
    return num1 - num2;
}

console.log(add(10, 9));
console.log(add(10, "9"));

console.log(subtract(10, 9));
console.log(subtract(10, "9"));

// 3rd way: Arrow Notation
let bonjour = () => {
    console.log("Bon Jour!");
}

bonjour();

let multiply = (num1, num2) => {
    return num1 * num2;
}

console.log(multiply(10, 9));
console.log(multiply(10, "9"));

/*
In JS, Functions are Objects, meaning they can be used as
parameters in other functions. These are called Callback Functions.
*/

function greetings(greet1, greet2) {
    if (typeof greet1 == "function") greet1();
    if (typeof greet2 == "function") greet2();
}

greetings(hello, hola);
greetings(hola, bonjour);

greetings(1, 2); // TypeError - 1 and 2 are not functions (Edit - Fixed to not invoke non-functions)
console.log(typeof hello);

function calculate(num1, num2, op) {
    console.log(op(num1, num2));
}

calculate(2, 3, multiply);
calculate(4, 5, add);
calculate(7, 6, subtract);

// Self-Invoking Functions (Anonymous IIFE - Immediately Invoked Function Expression)
(function() {
    console.log("Invoked a Function");
})();

((num1, num2) => {
    console.log(num1 + num2)
})(3, 4);

// A function with no name expression is called an Anonymous Function
calculate(10, 2, (num1, num2) => { return num1 / num2; });

// How to deal with the lack of overloaded methods in JS:
function test(num1, num2, num3) {
    // console.log(num1 + num2 + num3);
    if (num1 && num2 && num3) {
        console.log(num1 + num2 + num3);
    }
    else if (num1 && num2) {
        console.log(num1 + num2);
    } else if(num1) {
        console.log(num1);
    }
    else {
        console.log(0);
    }
}

test(5, 10, 15);
test(5, 10);
test(5);