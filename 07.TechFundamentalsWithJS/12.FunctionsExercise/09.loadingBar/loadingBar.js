function loadingBar(num) {
    if (num === 100) {
        console.log('100% Complete!');
        console.log('[%%%%%%%%%%]');
        return;
    }
    let numberForPercent = num / 10;
    let field = fillArray();
    field.splice(0, numberForPercent, '%'.repeat(numberForPercent));
    console.log(`${numberForPercent * 10}% [${field.join('')}]`);
    console.log('Still loading...');

    function fillArray() {
        let arr = [];
        for (let i = 0; i < 10; i++) {
            arr.push('.');
        }

        return arr;
    }
}

loadingBar(50);