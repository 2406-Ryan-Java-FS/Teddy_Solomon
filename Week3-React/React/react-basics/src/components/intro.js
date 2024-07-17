/*
There are Function and Class Based Components
    - Components created via a Functon or Class
We will be using Function Based Components.
*/

import React from "react";

// Function Component
// PascalCasing for Function Names
export default function Intro() {

    /*
    A React Functional Component returns JSX
    JSX -> JavaScript Syntax Extension - hybrid of HTML and JS
    */

    // return (<h1>Hello World!</h1>);
    // return (<div><h1>Welcome to my first React App!</h1>
    //     <p>My Name is: Teddy Solomon</p></div>);

    // return (<React.Fragment>
    //     <h1>Welcome to my first React App!</h1>
    //     <p>My Name is: Teddy Solomon</p>
    // </React.Fragment>);

    const name = "Teddy Solomon";

    // Shorthand for <React.Fragment> -> <>

    return (<>
        <h1>Welcome to my first React App!</h1>
        <p>My Name is: {name}</p>
    </>)

}