const catalogController = (function () {
    const getCatalog = (function (context) {
        catalogModel
            .getTeams()
            .then(helper.handler)
            .then((data) => {
                helper.addHeaderInfo(context);
                if (data.length) {
                    context.hasNoTeam = false;
                    const teams = { ...data };
                    context.teams = teams;
                } else {
                    context.hasNoTeam = true;
                }

                helper
                    .loadPartials(context, {
                        team: '../views/catalog/team.hbs',
                    })
                    .then(function () {
                        this.partial('../views/catalog/teamCatalog.hbs');
                    });
            })
            .catch(err => console.warn(err));
    });

    const getCreateTeam = (function (context) {
        helper.addHeaderInfo(context);
        helper
            .loadPartials(context, {
                createForm: '../views/create/createForm.hbs'
            })
            .then(function () {
                this.partial('../views/create/createPage.hbs');
            });
    });

    const postCrateTeam = (function (context) {
        catalogModel
            .createTeam(context.params)
            .then(helper.handler)
            .then((data) => {
                storage.saveSingleData('teamId', data._acl.creator);
                context.redirect('#/home');
            })
            .catch(err => console.warn(err));
    });

    const getDetails = (function (context) {
        catalogModel
            .teamInfo(context.params)
            .then(helper.handler)
            .then((data) => {
                helper.addHeaderInfo(context);
                context.isAuthor = helper.isAuthor(data);
                context.isOnTeam = helper.isOnTeam(data);
                context.teamId = context.params.id;
                context.name = data.name;
                context.comment = data.comment;
                context.members = data.members.map(({ username }) => {
                    const obj = { username };
                    return obj;
                });

                helper
                    .loadPartials(context, {
                        teamControls: '../views/catalog/teamControls.hbs',
                        teamMember: '../views/catalog/teamMember.hbs',
                    })
                    .then(function () {
                        this.partial('../views/catalog/details.hbs');
                    });
            });
    });

    const join = (function (context) {
        if (!helper.hasTeam()) {
            catalogModel
                .getJoin(context.params)
                .then(helper.handler)
                .then((team) => {
                    return catalogModel
                        .putJoin(team)
                        .then(helper.handler);
                })
                .then((data) => {
                    storage.saveSingleData('teamId', data._id);
                    context.redirect('#/home');
                })
                .catch(err => console.warn(err));
        }
    });

    const leave = (function name(context) {
        catalogModel
            .getLeave(context.params)
            .then(helper.handler)
            .then((team) => {
                return catalogModel
                    .putLeave(team)
                    .then(helper.handler);
            })
            .then(() => {
                storage.removeData('teamId');
                context.redirect('#/home');
            })
            .catch(err => console.warn(err));
    });

    const getEdit = (function (context) {
        catalogModel
            .getEdit(context.params)
            .then(helper.handler)
            .then((team) => {
                helper.addHeaderInfo(context);
                context.teamId = team._id;
                context.name = team.name;
                context.comment = team.comment;

                helper
                    .loadPartials(context, {
                        editForm: '../views/edit/editForm.hbs',
                    })
                    .then(function () {
                       this.partial('../views/edit/editPage.hbs'); 
                    });
            });
    });

    const postEdit = (function (context) {
        catalogModel
            .getEdit(context.params)
            .then(helper.handler)
            .then((data) => {
                context.info = data;
                catalogModel
                    .postEdit(context)
                    .then(helper.handler);
            })
            .then(() => context.redirect('#/home'))
            .catch(err => console.warn(err));
    });

    return {
        getCatalog,
        getCreateTeam,
        postCrateTeam,
        getDetails,
        join,
        leave,
        getEdit,
        postEdit,
    };
})();