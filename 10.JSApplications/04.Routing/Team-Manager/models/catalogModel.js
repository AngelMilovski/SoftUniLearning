const catalogModel = (function () {
    const module = 'appdata';
    const type = 'Kinvey';

    const getTeams = (function () {
        const endpoint = 'teams';
        return requester.get(endpoint, module, type);
    });

    const createTeam = (function (params) {
        const members = [{
            username: storage.getData('username'),
            userId: storage.getData('userId'),
        }];

        const payload = { ...params, members };
        const endpoint = 'teams';
        return requester.post(endpoint, module, type, payload);
    });

    const teamInfo = (function (params) {
        const id = params.id;
        const endpoint = `teams/${id}`;
        return requester.get(endpoint, module, type);
    });

    const getJoin = (function (params) {
        const endpoint = `teams/${params.id}`;
        return requester.get(endpoint, module, type);
    });

    const putJoin = (function (team) {
        let membersArr = team.members.slice(0);
        const endpoint = `teams/${team._id}`;
        const userId = storage.getData('userId');
        const username = storage.getData('username');
        membersArr.push({ userId, username });
        team.members = membersArr.slice(0);
        const payload = { ...team };
        return requester.put(endpoint, module, type, payload);
    });

    const getLeave = (function (params) {
        const endpoint = `teams/${params.id}`;
        return requester.get(endpoint, module, type);
    });

    const putLeave = (function (team) {
        const endpoint = `teams/${team._id}`;
        const userId = storage.getData('userId');
        team.members = team.members.filter((m) => m.userId !== userId);
        const payload = { ...team };
        return requester.put(endpoint, module, type, payload);
    });

    const getEdit = (function (params) {
        const endpoint = `teams/${params.id}`;
        return requester.get(endpoint, module, type);
    });

    const postEdit = (function (context) {
        const endpoint = `teams/${context.params.id}`;
        const payload = { 
            ...context.params,
            members: context.info.members,
         };

        return requester.put(endpoint, module, type, payload);
    });

    return {
        getTeams,
        createTeam,
        teamInfo,
        getJoin,
        putJoin,
        getLeave,
        putLeave,
        getEdit,
        postEdit,
    };
})();