class CheckingAccount {
    constructor(clientId, email, firstName, lastName) {
        this.clientId = clientId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    get clientId() {
        return this.clientId;
    }

    set clientId(clientId) {
        if (!clientId.match(/^\d{6}$/)) {
            throw new TypeError('Client ID must be a 6-digit number');
        }
    }

    get email() {
        return this.email;
    }

    set email(email) {
        if (!email.match(/^\w+@[A-Za-z]+[A-za-z.]+$/)) {
            throw new TypeError('Invalid e-mail');
        }
    }

    get firstName() {
        return this.firstName;
    }

    set firstName(firstName) {
        if (firstName.length < 3 || firstName.length > 20) {
            throw new TypeError('First name must be between 3 and 20 characters long');
        } else if (!firstName.match(/^[A-Za-z]{3,20}$/)) {
            throw new TypeError('First name must contain only Latin characters');
        }
    }

    get lastName() {
        return this.lastName;
    }

    set lastName(lastName) {
        if (lastName.length < 3 || lastName.length > 20) {
            throw new TypeError('Last name must be between 3 and 20 characters long');
        } else if (!lastName.match(/^[A-Za-z]{3,20}$/)) {
            throw new TypeError('Last name must contain only Latin characters');
        }
    }
}

const acc = new CheckingAccount('423414', 'petkan@another.co.uk', 'Petkan', 'Draganov');
console.log(acc);