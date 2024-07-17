import { useRef } from "react";

export default function ContactForm() {

    const emailInput = useRef(); // constant mutable reference to a node on the DOM

    function sendEmail() {
        // Send an email to the location provided in the input field
        console.log(emailInput.current.value);
        alert(`Sent an email to: ${emailInput.current.value}`);
    }

    return (<>
        <h3>Request a followup email</h3>
        <input type="text" ref={emailInput} />
        <button onClick={sendEmail}>Email Me</button>
    </>)
}