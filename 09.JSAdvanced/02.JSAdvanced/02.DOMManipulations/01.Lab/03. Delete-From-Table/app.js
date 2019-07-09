function deleteByEmail() {
    const selectors = {
        input: 'input[name="email"]',
        table: '#customers tbody tr',
    };



    const allEmails = {};
    getAllEmails();
    const input = getInput();

    if (input.value) {
        const email = input.value;
        input.value = '';
        checkForEmails(email);

    }

    function checkForEmails(email) {
        if (allEmails[email]) {
            removeRow(allEmails[email]);
            document.querySelector('#result').innerHTML = 'Deleted';
        } else {
            document.querySelector('#result').innerHTML = 'Not found.';
        }
    }

    function removeRow(row) {
        row.remove();
    }
    
    function getAllEmails() {
        const tableRows = Array.from(getTable());
        tableRows.forEach((tr) => {
            const children = tr.children;
            allEmails[children[1].textContent] = tr;

        });
    }

    function getInput() {
        return document.querySelector(selectors.input);
    }

    function getTable() {
        const test = document.querySelectorAll(selectors.table);
        return document.querySelectorAll(selectors.table);
    }
}