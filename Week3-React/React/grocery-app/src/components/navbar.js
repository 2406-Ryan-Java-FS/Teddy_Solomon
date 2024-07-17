import { Link } from "react-router-dom";

export default function NavBar() {
    return (<>
        <nav id="navbar">
            <Link to="/">Home</Link>
            <Link to="/budget">Budget</Link>
            <Link to="/groceries">Groceries</Link>
        </nav>
    </>)
}