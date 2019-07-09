function solve(params) {

    const list = (function name() {
        let arr = [];
        const add = function (string) {
            arr.push(string);

            return this;
        };

        const remove = function (string) {
            arr = arr.filter(el => el !== string);

            return this;
        };

        const print = function () {
            console.log(arr.join(','));

            return this;
        };

        return {
            add,
            remove,
            print
        };
    })();

    params
        .forEach((line) => {
            const parts = line.split(' ');
            switch (parts[0]) {
                case 'add':
                    list.add(parts[1]);
                    break;

                case 'remove':
                    list.remove(parts[1]);
                    break;

                case 'print':
                    list.print();
                    break;
            }
        });
}

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);