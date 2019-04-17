function solve(params) {
    let eventsById = {};
    let organizer = {};
    let events = {};
    let i = 0;
    for (const line of params) {
        if (params[i++] === 'Time for Code') {
            break;
        }
        let tokens = line.split(new RegExp('[ ]', 'g'));
        let [id, eventName] = [tokens[0], tokens[1]];
        let participants = tokens.slice(2);
        if (eventName.startsWith('#')) {
            if (!events.hasOwnProperty(id)) {
                events[id] = {};
                events[id][eventName] = participants;
            } else {
                if (events[id].hasOwnProperty(eventName)) {
                    participants.forEach((p) => {
                        if (!events[id][eventName].includes(p)) {
                            events[id][eventName].push(p);
                        }
                    });
                }
            }
        }
    }
    Object
        .values(events)
        .sort((a, b) => {
            let valuesA = Object.values(a)[0].length;
            let valuesB = Object.values(b)[0].length;
            if (valuesB - valuesA !== 0) {
                return valuesB - valuesA;
            } else {
                let keyA = Object.keys(a)[0];
                let keyB = Object.keys(b)[0];
                return keyA.localeCompare(keyB);
            }
        })
        .forEach((event) => {
            let key = Object.keys(event)[0];
            let values = Object.values(event)[0];
            console.log(`${key.slice(1)} - ${values.length}`);
            values
                .sort((a, b) => a.localeCompare(b))
                .forEach(p => console.log(p));
        });

    //     if (line.includes('#')) {
    //         let tokens = line.split(new RegExp('[# ]', 'g')).filter(e => e !== '');
    //         let id = +tokens[0];
    //         let eventName = tokens[1];
    //         let participants = tokens.slice(2);

    //         if (!eventsById.hasOwnProperty(id)) {
    //             eventsById[id] = eventName;
    //             organizer[eventName] = participants;
    //         } else if (eventsById[id] === eventName) {
    //             participants.forEach((p) => {
    //                 if (!organizer[eventName].includes(p)) {
    //                     organizer[eventName].push(p);
    //                 }
    //             });
    //         }
    //     }
    // }

    // Object
    //     .entries(organizer)
    //     .sort((a, b) => {
    //         if (b[1].length - a[1].length !== 0) {
    //             return b[1].length - a[1].length;
    //         } else {
    //             return a[0].localeCompare(b[0]);
    //         }
    //     })
    //     .forEach(([event, participants]) => {
    //         console.log(`${event} - ${participants.length}`);
    //         participants.sort((a, b) => a.localeCompare(b)).forEach(p => console.log(p));
    //     });

}

solve([
    '1 #Beers @roli @trophon @alice',
    '2 #GameDevMeetup @sino @valyo',
    '1 #Beers2 @nakov @royal @ROYAL @ivo',
    '1 #Beers @roli @trophon @alice @sino',
    '3 #Rakia',
    'Time for Code'
]);

// solve([
//     '1 #Beers @roli @trophon @alice',
//     '2 #GameDevMeetup @sino @valyo',
//     '3 #Karaoke @nakov @royal @ROYAL @ivo',
//     'Time for Code'
// ]);

//  @roli @trophon @alice