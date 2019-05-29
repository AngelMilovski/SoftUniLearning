function coursesPrice(jsFund, jsAdvanced, jsApp, educationForm) {
    const fundamentals = 170;
    let advanced = 180;
    const apps = 190;
    let price = 0;

    if (jsFund) {
        price += fundamentals;
    }

    if (jsFund && jsAdvanced) {
        advanced -= advanced / 100 * 10;
        price += advanced;
    } else if (jsAdvanced) {
        price += advanced;
    }

    if (jsApp) {
        price += apps;
    }

    if (jsFund && jsAdvanced && jsApp) {
        price = price - (price / 100 * 6);
    }
    
    if (educationForm === 'online') {
        price = price - (price / 100 * 6);
    }

    console.log(Math.round(price));
}

coursesPrice(true, true, true, "online");