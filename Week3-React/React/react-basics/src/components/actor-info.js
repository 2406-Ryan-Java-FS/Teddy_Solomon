/**
 * 
 * @param props {{name: string, age: number, worth: number}}
 */
export default function Actor(props) {

    // const name = props.name;
    // const age = props.age;
    // const worth = props.worth;

    // Object Destructuring
    const {name, age, worth} = props;

    console.log(name, age, worth);

    return (<>
        <table>
            <tbody>
                <tr>
                    <td>Name:</td>
                    <td>{name}</td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td>{age}</td>
                </tr>
                <tr>
                    <td>Worth:</td>
                    <td>{worth}</td>
                </tr>
            </tbody>
        </table>
    </>)
    // The return type is a JSX.Element
}