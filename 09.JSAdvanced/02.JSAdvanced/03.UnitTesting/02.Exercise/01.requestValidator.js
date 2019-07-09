function requestValidator(req) {
    const validMethods = ['GET', 'POST', 'DELETE', 'CONNECT'];
    const validVersion = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    const messageRegex = /^[^<>\\&'"]*$/;
    const uriRegex = /^([\w.]+|\*)$/;
    const { method, uri, version, message } = req;

    if (!req.hasOwnProperty('method') || !validMethods.includes(method)) {
        throw new Error('Invalid request header: Invalid Method');
    }

    if (!req.hasOwnProperty('uri') || !uriRegex.test(uri)) {
        throw new Error('Invalid request header: Invalid URI');
    }

    if (!req.hasOwnProperty('version') || !validVersion.includes(version)) {
        throw new Error('Invalid request header: Invalid Version');
    }

    if (!req.hasOwnProperty('message') || !messageRegex.test(message)) {
        throw new Error('Invalid request header: Invalid Message');
    }

    return req;
}

console.log(requestValidator({
    method: 'CONNECT',
    uri: 'a',
    version: 'HTTP/1.1',
    message: 'asl\pls'
  }));