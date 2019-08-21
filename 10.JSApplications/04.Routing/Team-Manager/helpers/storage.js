const storage = (function () {
    const appKey = 'kid_rkn7b_U7H';
    const appSecret = '77375e51d48d4a50948f5131782a90f9';

    const getData = (function (key) {
        return JSON.parse(localStorage.getItem(key + appKey));
    });

    const saveData = (function (response) {
        localStorage.setItem('userId' + appKey, JSON.stringify(response._id));
        localStorage.setItem('authtoken' + appKey, JSON.stringify(response._kmd.authtoken));
        localStorage.setItem('username' + appKey, JSON.stringify(response.username));
    });

    const saveSingleData = (function (key, value) {
        localStorage.setItem(key + appKey, JSON.stringify(value));
    });

    const clearData = (function () {
        localStorage.clear();
    });

    const removeData = (function (key) {
        localStorage.removeItem(key + appKey);
    });

    return {
        getData,
        saveData,
        clearData,
        saveSingleData,
        removeData,
        appKey,
        appSecret,
    };
})();
