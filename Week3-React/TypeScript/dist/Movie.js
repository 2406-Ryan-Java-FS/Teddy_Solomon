"use strict";
class Movie {
    constructor(id, title, price, available, returnDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.available = available;
        this.returnDate = returnDate;
    }
    checkout() {
        this.available = false;
        this.returnDate = Date.now() + 1000 * 3600 * 24;
    }
    test() {
        this.checkout();
    }
}
let movie1 = new Movie(1, "The Avengers", 10, true, 0);
movie1.checkout();
console.log(movie1);
