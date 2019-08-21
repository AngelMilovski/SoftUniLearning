const app = (() => {
    Sammy('#main', function () {
        this.use('Handlebars', 'hbs');

        // home
        this.get('#/', homeController.getHome);
        this.get('#/home', homeController.getHome);
        // user
        this.get('#/register', userController.getRegister);
        this.post('#/register', userController.postRegister);
        this.get('#/login', userController.getLogin);
        this.post('#/login', userController.postLogin);
        this.get('#/logout', userController.logout);
        // catalog
        this.get('#/catalog', catalogController.getCatalog);
        this.get('#/create', catalogController.getCreateTeam);
        this.post('#/create', catalogController.postCrateTeam);
        this.get('#/catalog/:id', catalogController.getDetails);
        this.get('#/join/:id', catalogController.join);
        this.get('#/leave/:id', catalogController.leave);
        this.get('#/edit/:id', catalogController.getEdit);
        this.post('#/edit/:id', catalogController.postEdit);
    }).run('#/home');
})();