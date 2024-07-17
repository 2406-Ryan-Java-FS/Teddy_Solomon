import { useRef, useContext } from 'react';
import { AppContext } from '../AppContext';

export default function GroceryForm() {

    const itemInput = useRef();
    const { items, addItem } = useContext(AppContext);

    function addGrocery() {
        // let item = itemInput.current.value;
        console.log(itemInput.current.value);
        if (items.includes(itemInput.current.value)) {
            alert("Item already on Grocery List");
        } else {
            addItem(itemInput.current.value);
        }
        itemInput.current.value = "";
    }
    
    return (<>
        <input type="text" ref={itemInput} />
        <button onClick={addGrocery}>Add to List</button>
    </>)
}