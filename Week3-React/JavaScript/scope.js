// Scopes

x = 101;
var y = 102;
let z = 103;

console.log(x);
console.log(y);
console.log(z);

if (true) {
    a = 10; // Global scope
    var b = 11; // Function scope
    let c = 12; // Block scope

    console.log(a);
    console.log(b);
    console.log(c);

    console.log(x);
    console.log(y);
    console.log(z);
}

console.log(a);
console.log(b);
// console.log(c); // Cannot be referenced outside the block of code.

function test() {

    // console.log(m);
    console.log(n); // Can be referenced here due to hoisting. Its value is undefined.
    // console.log(o);

    m = 1001;
    var n = 1002;
    let o = 1003;

    console.log(m);
    console.log(n);
    console.log(o);

    if (true) {
        r = 1;
        var s = 2;
        let t = 3;
        console.log(r);
        console.log(s);
        console.log(t);
    }
    console.log(r);
    console.log(s); // Can still be accessed since we are still in the same function.
    // console.log(t); // Cannot be referenced outside the block of code.
}

test();

console.log(m);
// console.log(n); // Cannot be referenced outside the function.
// console.log(o); // Cannot be referenced outside the block of code (function).

console.log(r);
// console.log(s); // Cannot be referenced outside the function.
// console.log(t); // Cannot be referenced outside the block of code.