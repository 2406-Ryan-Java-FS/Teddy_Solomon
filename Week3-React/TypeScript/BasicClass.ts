import { ClassDecorator } from "./ClassDecorator";

@ClassDecorator
class BasicClass {

    private message: string;
    
    constructor(message: string) {
        this.message = message;
    }

    greetings() {
        console.log(this.message);
    }
}

const basic = new BasicClass("Hello World");
basic.greetings();