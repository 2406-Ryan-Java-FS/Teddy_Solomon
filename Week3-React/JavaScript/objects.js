let person = {
    name: "Ryan",
    age: 100,
    sayHello: function () {
        console.log("Hello Everyone");
    }
}

console.log(person);
person.age++;
console.log(person);
console.log(person.age);
console.log(person.name);
console.log(person.height);
console.log(person.sayHello);

person.sayHello();

person.profession = "Trainer";
console.log(person);
console.log(person.profession);

// For-in Loop - used to iterate over the properties of an Object
for (prop in person) {
    console.log(prop + ": " + person[prop]);
}

// Constructors are just functions
function Person(name, age, profession) {
    this.name = name;
    this.age = age;
    this.profession = profession;
}

let ryan = new Person("Ryan", 100, "Trainer");

console.log(ryan);
console.log(typeof ryan);

let kyle = new Person("Kyle", 90, "Trainer");

let sierra = new Person(100, "Trainer", "Sierra"); // Will map the values to the wrong variables

/*
JSON (JavaScript Object Notation) is a string format for storing information
suitable for JavaScript to convert to and from an object
*/
console.log(ryan);

let ryanJSON = JSON.stringify(ryan);
console.log(ryanJSON);
console.log(typeof ryanJSON);

let parsedRyan = JSON.parse(ryanJSON);
console.log(parsedRyan);

let people = [ryan, kyle];
console.log(people);
console.log(JSON.stringify(people));