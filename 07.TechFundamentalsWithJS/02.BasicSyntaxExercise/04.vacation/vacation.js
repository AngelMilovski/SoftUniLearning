function vacation(count, group, week) {
    const groupOfPeople = +count;
    const typeOfGroup = group.toLowerCase();
    const dayOfWeek = week;
    let totalPrice = 0;

    let priceList = {};

    switch (dayOfWeek) {
        case 'Friday':
        priceList.students = 8.45;
        priceList.business = 10.90;
        priceList.regular = 15;
            break;

        case 'Saturday':
        priceList.students = 9.80;
        priceList.business = 15.60;
        priceList.regular = 20;
            break;

        case 'Sunday':
        priceList.students = 10.46;
        priceList.business = 16;
        priceList.regular = 22.50;
            break;
    }
    if (groupOfPeople >= 30 && typeOfGroup === 'students') {
        const currentPriceForStudents = priceList.students * groupOfPeople;
        const percentForStudent = currentPriceForStudents / 100 * 15;
        totalPrice = currentPriceForStudents - percentForStudent;

    } else if (groupOfPeople >= 100 && typeOfGroup === 'business') {
        const totalCountOfPeople = groupOfPeople - 10;
        totalPrice = priceList.business * totalCountOfPeople;

    } else if (groupOfPeople >= 10 && groupOfPeople <= 20 && typeOfGroup === 'regular') {
        const currentPriceForRegular = priceList.regular * groupOfPeople;
        const percentForRegular = currentPriceForRegular / 100 * 5;
        totalPrice = currentPriceForRegular - percentForRegular;
        
    } else {
        totalPrice = priceList[typeOfGroup] * groupOfPeople;
    }

    const result = `Total price: ${totalPrice.toFixed(2)}`;
    return result;
}

vacation(30, "Students", "Sunday");
vacation(40, "Regular", "Saturday");
vacation(100, "Business", "Sunday");