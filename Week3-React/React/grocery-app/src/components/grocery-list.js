import { useContext } from "react";
import { AppContext } from "../AppContext"

export default function GroceryList() {

    // Use that context state here
    const { items } = useContext(AppContext);
    
    // Populate the JSX (list items) for each grocery item
    // const groceryListItems = items.map(i =>
    //     <li key={i}>{i}</li>
    // );

    // Would have the same result as the above approach
    const GroceryComponent = () => {
        return items.map(i =><li key={i}>{i}</li>);
    }

    return (<>
        <h3>Groceries to Buy:</h3>
        <ul>
            {/* {groceryListItems} */}
            <GroceryComponent />
        </ul>
    </>)
}