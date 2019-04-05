function solve(params) {
    const str = params;
    const regex = /\b[A-Z][a-z]+ [A-Z][a-z]+\b/g;
    let validNames = [];
    while ((validName = regex.exec(str)) !== null) {
        validNames.push(validName);
    }

    return validNames.join(' ');
}

solve("Ivan Ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Test Testov, Ivan	Ivanov");