const helper = (function () {
    const handler = (function (res) {
        if (res.status >= 400) {
            throw new Error(`Something went wrong ${res.status} (${res.statusText})`);
        }

        if (res.status !== 204) {
            return res.json();
        }

        return res;
    });

    const passwordChecker = (function (params) {
        return params.password === params.repeatPassword;
    });

    const isOnTeam = (function (data) {
        const _userId = storage.getData('userId');
        const member = data.members.find(m => m.userId === _userId);
        return member;
    });

    const hasTeam = (function () {
        return storage.getData('teamId');
    });

    const isAuthor = (function (data) {
        const userId = storage.getData('userId');
        return data._acl.creator === userId;
    });

    const addHeaderInfo = (function (context) {
        const username = storage.getData('username');

        if (username) {
            context.loggedIn = true;
            context.username = username;
        }
    });

    const loadPartials = (function (context, externalPartials) {
        const defaultPartials = {
            header: '../views/common/header.hbs',
            footer: '../views/common/footer.hbs',
        };

        if (externalPartials) {
            Object
                .keys(externalPartials)
                .forEach((key) => {
                    const element = externalPartials[key];
                    defaultPartials[key] = element;
                });
        }

        return context.loadPartials(defaultPartials);
    });


    return {
        handler,
        addHeaderInfo,
        passwordChecker,
        loadPartials,
        isOnTeam,
        isAuthor,
        hasTeam,
    };
})(); 