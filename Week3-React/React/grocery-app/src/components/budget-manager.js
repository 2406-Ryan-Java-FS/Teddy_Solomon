import { useContext } from 'react';
import { AppContext } from '../AppContext';

export default function BudgetManager() {
    const {budget, updateBudget} = useContext(AppContext);

    function increase() {
        updateBudget(budget + 1);
    }

    function decrease() {
        updateBudget(budget - 1);
    }

    return (<>
        <h3>Budget: {budget}</h3>
        <button onClick={increase}>Increase</button>
        <button onClick={decrease}>Decrease</button>
    </>)

}