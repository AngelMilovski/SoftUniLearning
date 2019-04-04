function comments(params) {
    let users = [];
    let articles = [];
    let commentsData = {};
    for (const line of params) {
        if (line.includes('user')) {
            let userName = line.slice(5);
            users.push(userName);
        } else if (line.includes('article')) {
            let articleName = line.slice(8);
            articles.push(articleName);
        } else {
            let parts = line.split(': ');
            let [user, article] = parts[0].split(' posts on ');
            let commentContent = parts[1].replace(', ', ' - ');
            let comment = {};
            comment.author = user;
            comment.info = commentContent;
            if (articles.includes(article)) {
                if (users.includes(user)) {
                    if (!commentsData.hasOwnProperty(article)) {
                        commentsData[article] = [];
                    } 
                    commentsData[article].push(comment);
                }
            }
        }
    }

    Object
        .keys(commentsData)
        .sort((a, b) => commentsData[b].length - commentsData[a].length)
        .forEach((article) => {
            console.log(`Comments on ${article}`);
            commentsData[article]
                .sort((a, b) => a.author.localeCompare(b.author))
                .forEach(comment => {
                    console.log(`--- From user ${comment.author}: ${comment.info}`);
                });
        });
}

comments(['user aUser123',
    'someUser posts on someArticle: NoTitle, stupidComment',
    'article Books', 'article Movies', 'article Shopping',
    'user someUser',
    'user uSeR4',
    'user lastUser',
    'uSeR4 posts on Books: I like books, I do really like them',
    'uSeR4 posts on Movies: I also like movies, I really do',
    'someUser posts on Shopping: title, I go shopping every day',
    'someUser posts on Movies: Like, I also like movies very much',
    'someUser posts on Movies: Like, I also like movies very much'
]);

