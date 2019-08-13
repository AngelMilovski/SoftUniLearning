function attachEvents() {
    const messages = document.querySelector('#messages');
    const authorName = document.querySelector('#author');
    const messageContent = document.querySelector('#content');
    const url = 'https://rest-messanger.firebaseio.com/messanger.json';

    const clearInputs = () => {
        authorName.value = '';
        messageContent.value = '';
    };

    const sendMessage = () => {
        if (authorName.value && messageContent.value) {
            const author = authorName.value;
            const content = messageContent.value;
            clearInputs(authorName, messageContent);

            const method = 'POST';
            const heathers = { 'Content-type': 'application/json' };
            const body = JSON.stringify({ author, content });
            const requestMethod = { method, heathers, body };

            fetch(url, requestMethod)
                .then(res => console.log(res.json()))
                .catch(err => console.error(err));
        }
    };

    const clearMessages = () => {
        messages.value = '';
    };

    const parseData = (data) => {
        return {
            author: data.author,
            content: data.content
        };
    };

    const addToMessagesArr = (acc, { author, content }) => {
        const message = `${author}: ${content}`;
        acc.push(message);
        return acc;
    };

    const displayMessages = (data) => {
        const messagesArr = Object
            .values(data)
            .map(parseData)
            .reduce(addToMessagesArr, []);

        messages.value = messagesArr.join('\n');
    };

    const refresh = () => {
        clearMessages();
        fetch(url)
            .then(res => res.json())
            .then(displayMessages)
            .catch(err => console.error(err));
    };

    document.querySelector('#submit').addEventListener('click', sendMessage);
    document.querySelector('#refresh').addEventListener('click', refresh);
}

attachEvents();