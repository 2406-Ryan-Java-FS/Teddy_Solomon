// Populate a Table using Fetch

import { useState, useEffect } from "react";
import styles from '../styles/actor.module.css'

export default function ActorTable() {

    const [actors, setActors] = useState([]);
    const actorTableRows = actors.map(a => 
        <tr key={a.id}>
            <td>{a.name}</td>
            <td>{a.age}</td>
            <td>{a.worth}</td>
        </tr>
    );
    
    async function getAllActors() {
        console.log("Getting Actors...");

        const url="http://localhost:8080/actors";
        const httpResponse = await fetch(url);
        console.log(httpResponse);
        const actorList = await httpResponse.json();

        setActors(actorList);
    }

    // useEffect - a hook for "impure" functions - anything not from React interacting with
    // info/aspects of the app that go beyond the React application (ex. making HTTP request)
    useEffect(() => {
        getAllActors();
    }, []);
    // 2nd arg is the dependencies considered for when the hook will be called
    // No 2nd arg -> every re-render
    // [] -> no dependencies to consider for re-render, so never re-render
    // aka. once when component is first rendered

    const tableStyle = {
        backgroundColor: "lightgrey",
        border: "1px solid black"
    }
    
    return (<>
        <br/>
        {/* <button onClick={getAllActors}>Get Actors</button> */}
        <table style={tableStyle} className={styles.actorTable}>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Worth</th>
                </tr>
            </thead>
            <tbody>
                {actorTableRows}
            </tbody>
        </table>
    </>);
}