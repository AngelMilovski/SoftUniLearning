function evenPositionElement(params) {
    return params.filter((e, i) => i % 2 === 0).join(' ');
}

evenPositionElement(['20', '30', '40']);