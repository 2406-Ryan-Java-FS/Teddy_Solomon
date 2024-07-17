import { useState } from "react";

export default function Counter() {

    // let value = 1;

    // function increase() {
    //     value++;
    //     console.log(value);
    // }

    // Array Destructuring
    // const [value, setValue] = useState(initial value);
    const [value, setValue] = useState(1);

    // Don't want to update the number inside 'value'
    // Instead want to pass in the updated number to setValue();
    function increase() {
        setValue(value + 1);
    }

    return (<>
        <h3>The value is {value}</h3>
        <button onClick={increase}>Increment</button>
    </>)
}