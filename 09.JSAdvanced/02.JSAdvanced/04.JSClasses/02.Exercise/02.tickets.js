function getTickets(ticketDescriptions, sortingCriteria) {
    const Ticket = function Ticket(destination, price, status) {
        this.destination = destination;
        this.price = +price;
        this.status = status;
    };

    const sortingTickets = function sortingTickets(a, b) {
        const ticketByCriteria = a[sortingCriteria];
        if (isNaN(ticketByCriteria)) {
            return a[sortingCriteria].localeCompare(b[sortingCriteria]);
        } else {
            return a[sortingCriteria] - b[sortingCriteria];
        }
    };

    const tickets = ticketDescriptions
        .reduce((acc, cur) => {
            const [destination, price, status] = cur.split('|');
            const ticket = new Ticket(destination, price, status);
            acc.push(ticket);
            return acc;
        }, []);

    const sortedTickets = tickets.sort(sortingTickets);
    return sortedTickets;
}

const result = getTickets([
    'Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'
], 'price');

console.log(result);