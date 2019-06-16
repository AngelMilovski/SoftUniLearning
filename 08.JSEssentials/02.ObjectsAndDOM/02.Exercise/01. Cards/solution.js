// function solve() {
//    let images = document.getElementsByTagName('img');
//    [...images].forEach(img => img.addEventListener('click', clickEvent));

//    function clickEvent(evt) {
//        let card = evt.target;
//        let parent = card.parentNode;
//        let spans = document.getElementById('result').children;
//        let leftSpan = spans[0];
//        let rightSpan = spans[2];
//        card.src = 'images/whiteCard.jpg';
//        card.removeEventListener(evt.type, clickEvent);

//        if (parent.id === 'player1Div') {
//            leftSpan.textContent = card.name;
//        } else if (parent.id === 'player2Div') {
//            rightSpan.textContent = card.name;
//        }

//        if (leftSpan.textContent && rightSpan.textContent) {
//            let topCard = document.querySelector(`#player1Div img[name="${leftSpan.textContent}"]`);
//            let bottomCard = document.querySelector(`#player2Div img[name="${rightSpan.textContent}"]`);
//            console.log(bottomCard);
//            if (+leftSpan.textContent > +rightSpan.textContent) {
//                topCard.style.border = '2px solid green';
//                bottomCard.style.border = '2px solid red';
//            } else if (+leftSpan.textContent < +rightSpan.textContent) {
//                topCard.style.border = '2px solid red';
//                bottomCard.style.border = '2px solid green';
//            }

//            document.getElementById('history').textContent += `[${leftSpan.textContent} ${spans[1].textContent} ${rightSpan.textContent}] `;
//            leftSpan.textContent = '';
//            rightSpan.textContent = '';
//        }
//    }
// }


function solve() {

    let player1Cards = Array.from(document.querySelectorAll('#player1Div img')),
        player2Cards = Array.from(document.querySelectorAll('#player2Div img')),
        resultDiv = document.getElementById('result');

    player1Cards.forEach(card => card.addEventListener('click',
        function firstCard(e) {
            let name = e.currentTarget.getAttribute("name");
            e.currentTarget.removeEventListener(e.type, firstCard);
            resultDiv.children[0].textContent = name;
            e.currentTarget.src = 'images/whiteCard.jpg';
            checkCards();
        }));

    player2Cards.forEach(card => card.addEventListener('click',
        function secondCard(e) {
            e.currentTarget.removeEventListener(e.type, secondCard);
            let name = e.currentTarget.getAttribute("name");
            resultDiv.children[2].textContent = name;
            e.currentTarget.src = 'images/whiteCard.jpg';
            checkCards();
        }));

        function checkCards() {
            let winner,
            looser;

            if (resultDiv.children[0].textContent && resultDiv.children[2].textContent) {
                let firstCardName = +resultDiv.children[0].textContent;
                let secondCardName = +resultDiv.children[2].textContent;
                if (firstCardName > secondCardName) {
                    winner = document.querySelector(`#player1Div img[name="${firstCardName}"]`);
                    looser = document.querySelector(`#player2Div img[name="${secondCardName}"]`);
                } else if (firstCardName < secondCardName) {
                    winner = document.querySelector(`#player2Div img[name="${secondCardName}"]`);
                    looser = document.querySelector(`#player1Div img[name="${firstCardName}"]`);
                }

                winner.style.border = '2px solid green';
                looser.style.border = '2px solid red';
                document.getElementById('history').textContent += `[${firstCardName} vs ${secondCardName}] `;
                resultDiv.children[0].textContent = '';
                resultDiv.children[2].textContent = '';
            }
    }

    // if (firstCardName > secondCardName) {

    //    console.log('first');
    // }
    // else {

    //    console.log('second');
    // }
}