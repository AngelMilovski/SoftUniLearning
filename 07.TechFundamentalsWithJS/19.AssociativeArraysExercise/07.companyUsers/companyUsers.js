function companyUsers(input) {
    let companies = {};
    for (let line of input) {
        const parts = line.split(' -> ');
        const [company, id] = parts;
        if (!companies.hasOwnProperty(company)) {
            companies[company] = [];
            companies[company].push(id);
        } else {
            if (!companies[company].includes(id)) {
                companies[company].push(id);
            }
        }
    }
    
    let sortedCompanies = Object
        .keys(companies)
        .sort((a, b) => a.localeCompare(b));
    for (let company of sortedCompanies) {
        console.log(company);
        let employees = companies[company]
            .reduce((acc, curr) => {
                const id = `-- ${curr}`;
                acc.push(id);
                return acc;
            }, [])
            .join('\n');
        console.log(employees);
    }
}

companyUsers([
    'SoftUni -> AA12345',
    'SoftUni -> BB12345',
    'Microsoft -> CC12345',
    'HP -> BB12345'
]);