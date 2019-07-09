const Extensible = (function () {
    let id = 0;
    class Simple {
        constructor() {
             this.id = id++;
        }

        extend(template) {
            Object
                .keys(template)
                .forEach((key) => {
                    const prop = template[key];

                    if (typeof prop === 'function') {
                        Object.getPrototypeOf(this)[key] = prop;
                    } else {
                        this[key] = prop;
                    }
                });
        }
    }

    return Simple;
})();

let objects = [];
for (let i = 0; i < 100; i++) {
    objects.push(new Extensible());
}

for (let i = 0; i < 100; i++) {
    for (let j = i + 1; j < 100; j++) {
        console.log(object[i].id, object[j].id);
    }
}