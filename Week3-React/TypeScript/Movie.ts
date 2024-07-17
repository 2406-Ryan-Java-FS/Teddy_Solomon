class Movie {

    private id: number;
    private title: string;
    private price: number;
    private available: boolean;
    private returnDate: number;

    constructor(id: number, title: string, price: number, available: boolean, returnDate: number) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.available = available;
        this.returnDate = returnDate;
    }

    checkout(): void {
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