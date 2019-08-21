const userController = (function () {

    const getRegister = (function (context) {
        helper
            .loadPartials(context, {
                registerForm: '../views/register/registerForm.hbs'
            })
            .then(function() {
                this.partial('../views/register/registerPage.hbs');
            });
    });

    const postRegister = (function(context) {
        userModel
            .register(context.params)
            .then(helper.handler)
            .then((data) => {
                storage.saveData(data);
                context.redirect('#/home');
            })
            .catch(err => console.warn(err));
    });

    const getLogin = (function(context) {
        helper
            .loadPartials(context, {
                loginForm: '../views/login/loginForm.hbs'
            })
            .then(function() {
                this.partial('../views/login/loginPage.hbs');
            });
    });

    const postLogin = (function(context) {
        userModel
            .login(context.params)
            .then(helper.handler)
            .then((data) => {
                storage.saveData(data);
                context.redirect('#/home');
            })
            .catch(err => console.warn(err));
    });

    const logout = (function(context) {
        userModel
            .logout()
            .then(helper.handler)
            .then(() => {
                storage.clearData();
                context.redirect('#/home');
            })
            .catch(err => console.warn(err));
    });

    const about = (function(context) {
        context 
            .loadPartials({
                header: '../views/common/header.hbs',
                footer: '../views/common/footer.hbs',
            })
            .then(function() {
                this.partial('../views/common/about.hbs');
            })
            .then(err => console.warn(err));
    });

    return {
        getRegister,
        postRegister,
        getLogin,
        postLogin,
        logout,
        about,
    };
})();