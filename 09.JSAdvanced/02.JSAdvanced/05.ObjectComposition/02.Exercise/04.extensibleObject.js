function solve() {
    let myObj = Object.create({});
    myObj.extend = function (template) {
        Object
            .keys(template)
            .forEach((key) => {
                const prop = template[key];
                if (typeof prop === 'function') {
                    Object.getPrototypeOf(myObj)[key] = prop;
                } else {
                    myObj[key] = prop;
                }
            });
    };

    return myObj;
}

const template = {
    extensionMethod: function () { },
    extensionProperty: 'someString'
};

let testObj = solve();
testObj.extend(template);
const newObj = Object.create(testObj);
Object.getPrototypeOf(newObj).something = 'hello';
console.log(testObj);