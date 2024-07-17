export function ClassDecorator(constructor: Function) {
    console.log("This Class Decorator was called from: " + constructor.name);
}