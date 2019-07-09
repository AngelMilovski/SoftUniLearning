function solution(funcName) {
    let checkForRating = function (up, balance, allVotes) {
        const majority = 62.04;
        if (allVotes < 10) {
            return 'new';
        }

        if ((up / allVotes * 100) >= majority) { // 62.0817843866171
            return 'hot';
        } else if (balance >= 0 && allVotes > 100) {
            return 'controversial';
        } else if (balance < 0) {
            return 'unpopular';
        } else {
            return 'new';
        }
    };

    let score = () => {
        let up = this.upvotes;
        let down = this.downvotes;
        let allVotes = up + down;
        if (allVotes > 50) {
            const greaterNum = Math.max(up, down);
            const numberForAddedToVotes = Math.ceil(greaterNum / 100 * 25);
            up += numberForAddedToVotes;
            down += numberForAddedToVotes;
            allVotes = up + down;
        } 

        const balance = up - down;
        const rating = checkForRating(up, balance, allVotes);
        return [up, down, balance, rating];
    };

    const upvote = () => {
        this.upvotes += 1;
    };

    const downvote = () => {
        this.downvotes += 1;
    };

    switch (funcName) {
        case 'upvote':
            upvote();
            break;

        case 'downvote':
            downvote();
            break;

        case 'score':
            return score();
    }
}

const post = {
    id: '1234',
    author: 'author name',
    content: 'these fields are irrelevant',
    upvotes: 100,
    downvotes: 100
};

solution.call(post, 'upvote');
solution.call(post, 'downvote');
var answer = solution.call(post, 'score');
console.log(answer);