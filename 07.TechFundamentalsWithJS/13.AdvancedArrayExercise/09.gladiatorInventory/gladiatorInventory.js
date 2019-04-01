function gladiatorInventory(params) {
    let inventory = params.shift().split(' ');

    for (const line of params) {
        let parts = line.split(' ');
        let command = parts[0];
        let currentEquipment = parts[1];
        let index = inventory.indexOf(currentEquipment);
        switch (command) {
            case 'Buy':
                if (index < 0) {
                    inventory.push(currentEquipment);
                }
                break;

            case 'Trash':
                if (index >= 0) {
                    inventory.splice(index, 1);
                }
                break;

            case 'Repair':
                if (index >= 0) {
                    inventory.splice(index, 1);
                    inventory.push(currentEquipment);
                }
                break;

            case 'Upgrade':
                let equipment = currentEquipment.split('-')[0];
                index = inventory.indexOf(equipment);
                if (index >= 0) {
                    currentEquipment = currentEquipment.replace('-', ':');
                    inventory.splice(index + 1, 0, currentEquipment);
                }
                break;
        }
    }

    return inventory.join(' ');
}

const output = gladiatorInventory([
    'SWORD Shield Spear',
    'Buy Bag',
    'Trash Shield',
    'Repair Spear',
    'Upgrade SWORD-Steel'
]);

console.log(output);