function list() {
    let arr = [];
    let size = 0;

    const add = function (element) {
        arr.push(element);
        this.size += 1;
        arr.sort((a, b) => {
            if (isNaN(a)) {
                b = '' + b;
                return a.localeCompare(b);
            } else {
                return a - b;
            }
        });
    };

    const remove = function (index) {
        if (index >= 0 && index < arr.length) {
            this.size -= 1;
            return arr.splice(index, 1)[0];
        }
    };

    const get = (index) => {
        if (index >= 0 && index < arr.length) {
            return arr[index];
        }
    };

    return Object.seal({
        size,
        add,
        remove,
        get
    });
}


const result = list();
result.add(20);
console.log(result.size);
result.add(21);
result.add(22);
result.add(2);
console.log(result.remove(1));
console.log(result.get(0));
console.log(result.size);