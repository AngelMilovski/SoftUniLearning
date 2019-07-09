class Organization {
    constructor(name, budget) {
        this.name = name;
        this.budget = budget;
        this.employees = [];
        this.departmentsBudget = {
            marketing: parseInt(this.budget / 100 * 40),
            finance: parseInt(this.budget / 100 * 25),
            production: parseInt(this.budget / 100 * 35)
        };
    }

    add(employeeName, department, salary) {
        if (this.departmentsBudget[department] >= salary) {
            const employee = { employeeName, department, salary };
            this.employees.push(employee);
            this.departmentsBudget[department] -= salary;
            return `Welcome to the ${department} team Mr./Mrs. ${employeeName}.`;
        } else {
            const departmentBudget = this.departmentsBudget[department];
            return `The salary that ${department} department can offer to you Mr./Mrs. ${employeeName} is ${departmentBudget}.`;
        }
    }

    employeeExists(employeeName) {
        const employee = this.employees.find(obj => obj.employeeName === employeeName);
        if (employee) {
            return `Mr./Mrs. ${employeeName} is part of the ${employee.department} department.`;
        } else {
            return `Mr./Mrs. ${employeeName} is not working in ${this.name}.`;
        }
    }

    leaveOrganization(employeeName) {
        const employee = this.employees.find(obj => obj.employeeName === employeeName);
        if (employee) {
            const organizationName = this.name;
            const salary = employee.salary;
            const department = employee.department;
            this.departmentsBudget[department] += salary;
            const index = this.employees.indexOf(employee);
            this.employees.splice(index, 1);
            return `It was pleasure for ${organizationName} to work with Mr./Mrs. ${employeeName}.`;
        } else {
            return `Mr./Mrs. ${employeeName} is not working in ${organizationName}.`;
        }
    }

    status() {
        const marketing = this.employees
            .filter(e => e.department === 'marketing')
            .sort((a, b) => {
                return b.salary - a.salary;
            })
            .map(e => e.employeeName);

        const finance = this.employees
            .filter(e => e.department === 'finance')
            .sort((a, b) => {
                return b.salary - a.salary;
            })
            .map(e => e.employeeName);

        const production = this.employees
            .filter(e => e.department === 'production')
            .sort((a, b) => {
                return b.salary - a.salary;
            })
            .map(e => e.employeeName);

        let result = `${this.name.toUpperCase()} DEPARTMENTS:`;
        result += `\nMarketing | Employees: ${marketing.length}: ${(marketing.length) ? marketing.join(', ') : ''} |  Remaining Budget: ${this.departmentsBudget.marketing}`;
        result += `\nFinance | Employees: ${finance.length}: ${(finance.length) ? finance.join(', ') : ''} |  Remaining Budget: ${this.departmentsBudget.finance}`;
        result += `\nProduction | Employees: ${production.length}: ${(production.length) ? production.join(', ') : ''} |  Remaining Budget: ${this.departmentsBudget.production}`;
        return result;
    }
}

let organization = new Organization('SoftUni', 20000);

organization.add('Peter', 'marketing', 200);
organization.leaveOrganization('Peter');
organization.add('Mesho', 'production', 100);
organization.add('Tesho', 'marketing', 100);
organization.add('Sfe', 'production', 5);
organization.add('Ar', 'marketing', 122);
organization.add('gar', 'production', 2);
console.log(organization.status());
