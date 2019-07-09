(function solution() {
    const add = function add(vec1, vec2) {
        return [vec1[0] + vec2[0], vec1[1] + vec2[1]];
    };

    const multiply = function multiply(vec, scalar) {
        return [vec[0] * scalar, vec[1] * scalar];
    };

    const length = function length(vec) {
        return Math.sqrt((vec[0] ** 2) + (vec[1] ** 2));
    };

    const dot = function dot(vec1, vec2) {
        return (vec1[0] * vec2[0]) + (vec1[1] * vec2[1]);
    };

    const cross = function cross(vec1, vec2) {
        return vec1[0] * vec2[1] - vec1[1] * vec2[0];
    };

    return {
        add,
        multiply,
        length,
        dot,
        cross
    };
}());

let answer = result.add([1, 1], [1, 0]);
console.log(answer);
