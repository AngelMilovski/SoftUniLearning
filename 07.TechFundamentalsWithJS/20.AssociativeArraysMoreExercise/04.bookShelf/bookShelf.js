function bookShelf(params) {
    let bookShelf = {};
    for (const line of params) {
        let parts = line.split(' -> ');
        if (parts.length === 2) {
            let shelfId = +parts[0];
            let shelfGenre = parts[1];
            if (!bookShelf.hasOwnProperty(shelfId)) {
                bookShelf[shelfId] = shelfGenre;
                bookShelf[shelfGenre] = [];
            }
        } else if (parts.length === 1) {
            parts = line.split(', ');
            let [bookTitle, bookAuthor] = parts[0].split(': ');
            let book = {
                title: bookTitle,
                author: bookAuthor
            };
            
            if (bookShelf.hasOwnProperty(parts[1])) {
                bookShelf[parts[1]].push(book);
            }
        }
    }

    Object.keys(bookShelf)
    .filter(e => !isNaN(e))
    .sort((a, b) => {
        return bookShelf[bookShelf[[b]]].length - bookShelf[bookShelf[[a]]].length;
    })
    .forEach(id => {
        console.log(`${id} ${bookShelf[id]}: ${bookShelf[bookShelf[[id]]].length}`);
        bookShelf[bookShelf[[id]]]
        .sort((a, b) => a.title.localeCompare(b.title))
        .forEach(book => {
            console.log(`--> ${book.title}: ${book.author}`);
        });
    });
}

bookShelf([
    '1 -> history',
    '1 -> action',
    'Death in Time: Criss Bell, mystery',
    '2 -> mystery',
    '3 -> sci-fi',
    'Child of Silver: Bruce Rich, mystery',
    'Hurting Secrets: Dustin Bolt, action',
    'Future of Dawn: Aiden Rose, sci-fi',
    'Lions and Rats: Gabe Roads, history',
    '2 -> romance',
    'Effect of the Void: Shay B, romance',
    'Losing Dreams: Gail Starr, sci-fi',
    'Name of Earth: Jo Bell, sci-fi',
    'Pilots of Stone: Brook Jay, history'
]);