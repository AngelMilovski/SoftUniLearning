function loadCommits() {
    const username = document.querySelector('#username').value;
    const repo = document.querySelector('#repo').value;
    const commits = document.querySelector('#commits');
    const url = `https://api.github.com/repos/${username}/${repo}/commits`;

    fetch(url)
        .then((res) => {
            commits.innerHTML = '';
            if (res.status > 400) {
                throw Error(`Error: ${res.status} (${res.statusText})`);
            }

            return res.json();
        })
        .then((data) => {
            Object
                .values(data)
                .map((d) => {
                    return {
                        name: d.commit.author.name,
                        message: d.commit.message
                    };
                })
                .forEach(({ name, message }) => {
                    const li = document.createElement('li');
                    li.textContent = `${name}: ${message}`;
                    commits.appendChild(li);
                });
        })
        .catch(err => {
            const li = document.createElement('li');
            li.textContent = err.message;
            commits.appendChild(li);
            console.error(err.message);
        });
}