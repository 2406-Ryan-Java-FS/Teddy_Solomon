let isSunny: boolean = false;
let num1: number = 10;
let word: string = "Hello";
let numbers: number[] = [1, 2, 3, 4];
let words: Array<string> = ["Hey", "Hi", "Goodbye"];
let x: [string, number]; // Tuple
x = ["Hello", 5];
// x = [5, "Hello"];

function func(num1: number): number {
    return num1;
}

let func2 = (num1: number): number => num1;

console.log("Hello World");
console.log(numbers);
console.log(func2(10));