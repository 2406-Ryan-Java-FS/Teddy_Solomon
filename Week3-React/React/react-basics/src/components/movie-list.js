export default function MovieList() {

    const movies = ["Thor", "Iron Man", "The Avengers", "Black Panther"];

    // How we can dynamically generate a multitude of elements onto our page
    const movieListItems = movies.map(m => <li key={m}>{m}</li>);
    // Returns an array of JSX Elements (JSX.Element)
    // Setting the key to a unique value is for optimization purposes - not required yet

    return(<ul>
        {movieListItems}
    </ul>);
}