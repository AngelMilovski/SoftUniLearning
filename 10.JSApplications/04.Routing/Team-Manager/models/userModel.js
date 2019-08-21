const userModel = (function () {
    const module = 'user';

    const register = (function (params) {
        const data = {
            username: params.username,
            password: params.password,
        };

        const endpoint = '';
        const type = 'basic';
        return requester.post(endpoint, module, type, data);
    });

    const login = (function (params) {
        const data = {
            username: params.username,
            password: params.password,
        };

        const endpoint = 'login';
        const type = 'basic';
        return requester.post(endpoint, module, type, data);
    });

    const logout = (function() {
        const endpoint = '_logout';
        const type = 'kinvey';
        const data = {};
        return requester.post(endpoint, module, type, data);
    });

    return {
        register,
        login,
        logout,
    };
})();