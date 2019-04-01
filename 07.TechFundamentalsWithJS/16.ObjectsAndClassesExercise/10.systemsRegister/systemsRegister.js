function systemsRegister(params) {
    let register = {};
    for (const line of params) {
        const [system, component, subcomponent] = line.split(' | ');
        if (!register.hasOwnProperty(system)) {
            register[system] = {};
            register[system][component] = [];
            register[system][component].push(subcomponent);
        } else {
            if (!register[system].hasOwnProperty(component)) {
                register[system][component] = [];
                register[system][component].push(subcomponent);
            } else {
                if (!register[system][component].includes(subcomponent)) {
                    register[system][component].push(subcomponent);
                }
            }
        }
    }
    const sortedKeys = Object
        .keys(register)
        .sort((a, b) => {
            const aObjLength = getObjLength(register[a]);
            const bObjLength = getObjLength(register[b]);
            if (bObjLength - aObjLength != 0) {
                return bObjLength - aObjLength;
            } else {
                return a[0].localeCompare(b[0]);
            }
        });

    for (const system of sortedKeys) {
        console.log(system);
        Object
            .entries(register[system])
            .sort((a, b) => {
                return b[1].length - a[1].length;
            })
            .forEach((c) => {
                console.log('|||' + c[0]);
                c[1].forEach(s => console.log('||||||' + s));
            });
    }

    function getObjLength(obj) {
        let test = Object.values(obj).length;
        return test;
    }
}

systemsRegister([
    'SULS | Main Site | Home Page',
    'SULS | Main Site | Login Page',
    'SULS | Main Site | Register Page',
    'SULS | Judge Site | Login Page',
    'SULS | Judge Site | Submittion Page',
    'Lambda | CoreA | A23',
    'SULS | Digital Site | Login Page',
    'Lambda | CoreB | B24',
    'Lambda | CoreA | A24',
    'Lambda | CoreA | A25',
    'Lambda | CoreC | C4',
    'Indice | Session | Default Storage',
    'Indice | Session | Default Security',
]);