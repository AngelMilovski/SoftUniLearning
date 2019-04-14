function concert(params) {
    let count= 0;
    let groups = {
        totalTime: 0
    };
    let i = 0;
    for (let line of params) {
        if (params[i++] === 'start of concert') {
            break;
        }
        let [command, group, data] = line.split('; ');
        if (command === 'Play') {
            let amountOfTime = +data;
            groups.totalTime += amountOfTime;
            if (!groups.hasOwnProperty(group)) {
                groups[group] = {
                    members: [],
                    time: amountOfTime
                };
            } else {
                let currentTime = groups[group].time;
                currentTime += amountOfTime;
                groups[group].time = currentTime;
            }
        } else if (command === 'Add') {
            let members = data.split(', ');
            if (!groups.hasOwnProperty(group)) {
                groups[group] = {
                    members,
                    time: 0
                };
            } else {
                members.forEach((member) => {
                    if (!groups[group].members.includes(member)) {
                        groups[group].members.push(member);
                    }
                });
            }
        }
    }

    console.log('Total time: ' + groups.totalTime);
    Object
        .entries(groups)
        .sort((a, b) => {
            if (b[1].time - a[1].time !== 0) {
                return b[1].time - a[1].time;
            } else {
                return a[0].localeCompare(b[0]);
            }
            
        })
        .forEach((g) => {
            if (g[0] !== 'totalTime') {
                console.log(`${g[0]} -> ${g[1].time}`);
            }
        });

    let group = Object
        .keys(groups)
        .find(g => g === params[i]);
        console.log(group);
        groups[group]
            .members
            .forEach(m => console.log('=> ' + m));
}

concert([
    'Play; The Beatles; 2584',
    'Add; The Beatles; John Lennon, Paul McCartney, George Harrison, Ringo Starr',
    'Add; Eagles; Glenn Frey, Don Henley, Bernie Leadon, Randy Meisner',
    'Play; Eagles; 1869',
    'Add; The Rolling Stones; Brian Jones, Mick Jagger, Keith Richards',
    'Add; The Rolling Stones; Brian Jones, Mick Jagger, Keith Richards, Bill Wyman, Charlie Watts, Ian Stewart',
    'Play; The Rolling Stones; 4239',
    'start of concert',
    'The Rolling Stones'
]);
console.log('-------------------');
concert([
    'Add; The Beatles; John Lennon, Paul McCartney',
    'Add; The Beatles; Paul McCartney, George Harrison',
    'Add; The Beatles; George Harrison, Ringo Starr',
    'Play; The Rolling Stones; 4239',
    'Play; The Beatles; 4239',
    // 'Play; The Beatles; 3828',?
    'start of concert',
    'The Beatles'
]);