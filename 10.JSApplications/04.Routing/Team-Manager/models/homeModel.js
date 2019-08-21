const homeModel = (function () {
    const getTeams = (function () {
        const endpoint = 'teams';
        const module = 'appdata';
        const auth = 'Kinvey';
        return requester.get(endpoint, module, auth);
    });

    return {
        getTeams,
    };
})();