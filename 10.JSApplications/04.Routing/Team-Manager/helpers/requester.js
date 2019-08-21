const requester = (function () {
    const baseUrl = 'https://baas.kinvey.com';

    const httpMethods = {
        get: 'GET',
        post: 'POST',
        put: 'PUT',
        del: 'DELETE',
    };

    const makeUrl = (function (endpoint, module) {
        return (endpoint) ?
            `${baseUrl}/${module}/${storage.appKey}/${endpoint}` :
            `${baseUrl}/${module}/${storage.appKey}`;
    });

    const makeAuth = (function (type) {
        return (type === 'basic') ?
            `Basic ${btoa(storage.appKey + ':' + storage.appSecret)}` :
            `Kinvey ${storage.getData('authtoken')}`;
    });

    const makeHeaders = (function (type, httpMethod, data) {
        const headers = {
            method: httpMethod,
            headers: {
                'Content-Type': 'application/json',
                'Authorization': makeAuth(type),
            }
        };

        if (httpMethod === 'POST' || httpMethod === 'PUT') {
            headers.body = JSON.stringify(data);
        }

        return headers;
    });

    const makeRequest = (function (url, headers) {
        return fetch(url, headers);
    });

    const get = (function (endpoint, module, type) {
        const headers = makeHeaders(type, httpMethods.get);
        const url = makeUrl(endpoint, module);
        return makeRequest(url, headers);
    });

    const post = (function (endpoint, module, type, data) {
        const headers = makeHeaders(type, httpMethods.post, data);
        const url = makeUrl(endpoint, module);
        return makeRequest(url, headers);
    });

    const put = (function (endpoint, module, type, data) {
        const headers = makeHeaders(type, httpMethods.put, data);
        const url = makeUrl(endpoint, module);
        return makeRequest(url, headers);
    });

    const del = (function (endpoint, module, type) {
        const headers = makeHeaders(type, httpMethods.del);
        const url = makeUrl(endpoint, module);
        return makeRequest(url, headers);
    });

    return {
        get,
        post,
        del,
        put,
    };
})();