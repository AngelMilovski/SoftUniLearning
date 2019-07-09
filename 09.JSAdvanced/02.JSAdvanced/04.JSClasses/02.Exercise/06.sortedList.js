class List {
    constructor(){
        this.arr = [];
        this.size = 0;
    }

    add(el) {
        if (!this.arr.length) {
            this.arr.push(el);
        } else {
            this.arr.push(el);
            this.arr.sort((a, b) => {
                if (isNaN(a)) {
                    b = '' + b;
                    return a.localeCompare(b);
                } else {
                    return a - b;
                }
            });
        }

        this.size += 1;
        return this;
    }

    remove(index) {
        if (index >= 0 && index < this.arr.length) {
            this.arr.splice(index, 1);
            this.size -= 1;
        } else {
            throw new Error('Invalid index');
        }

        return this;
    }

    get(index) {
        if (index >= 0 && index < this.arr.length) {
            return this.arr[index];
        } else {
            throw new Error('Invalid index');
        }
    }

    sort() {
        return this.arr.sort((a, b) => {
            return a - b;
        });
    }

    getAll() {
        return this.arr;
    }
}

let list = new List();
list.add(-5);
list.add(-76);
list.add(-67);
list.add(-2);
list.add(76);
list.add(-672);
list.add(672);
console.log(list.getAll()); 
console.log(list.sort());
list.remove(1);
console.log(list.get(1));
console.log(list.size);