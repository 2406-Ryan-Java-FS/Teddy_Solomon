"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ClassDecorator = ClassDecorator;
function ClassDecorator(constructor) {
    console.log("This Class Decorator was called from: " + constructor.name);
}
