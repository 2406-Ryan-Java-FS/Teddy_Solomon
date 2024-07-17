import { useRef, useState } from "react";

export default function ActorList() {

    const actorInput = useRef();

    const [actors, setActors] = useState(["Ryan Reynolds", "Hugh Jackman"]);
    const actorListItems = actors.map(a => <li key={a}>{a}</li>);

    function addActor() {
        // console.log("Adding Actor...");
        const actor = actorInput.current.value;
        // console.log(actor);
        if (actors.includes(actor)) {
            // if true, actor already found
            alert("Actor already in list");
        } else {  
            // const newActors = actors.map(a => a);
            // newActors.push(actor);
            // setActors(newActors);
            setActors([...actors, actor]);
        }
        actorInput.current.value = "";
    }

    function clearAll() {
        setActors([]);
    }

    function removeLast() {
        const newActors = [...actors];
        newActors.pop();
        setActors(newActors);
    }
    
    return (<>
        <h3>Actor List</h3>
        <ul>
            {actorListItems}
        </ul>
        <input ref={actorInput} />
        <button onClick={addActor}>Add Actor</button>
        <button onClick={clearAll}>Clear All</button>
        <button onClick={removeLast}>Remove Last</button>
    </>)
}