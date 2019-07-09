const { expect } = require('chai');
const AutoService = require('./autoServiceResources');

const autoService = new AutoService(1);
const carInBacklogWork = {
    clientName: 'Peter',
    plateNumber: 'CA1234CA',
    carInfo: {
        'engine': 'MFRGG23',
        'transmission': 'FF4418ZZ',
        'doors': 'broken'
    }
};

autoService.workInProgress = [carInBacklogWork];
const test = autoService.carInfo('CA1234CA', 'Peter');
console.log(test);

describe('AutoService', () => {
    describe('Testing constructor', () => {
        it('Should return three properties', () => {
            let autoService = new AutoService(10);
            const capacity = 10;
            const test = autoService.constructor.length;
            expect(test).to.be.equal(1);
            expect(autoService.garageCapacity).to.be.equal(capacity);
            expect(autoService).to.has.property('workInProgress');
            expect(autoService).to.has.property('backlogWork');
            expect(autoService.workInProgress).to.be.an('array').that.is.empty;
            expect(autoService.backlogWork).to.be.an('array').that.is.empty;
        });
    });

    describe('Accessor', () => {
        it('availableSpace - which returns a number that represents the available space', () => {
            const numbers = [1, 2, 3, 4];
            numbers.forEach((number, i) => {
                const test = new AutoService(number);
                expect(test.availableSpace).to.be.equal(numbers[i]);
            });
        });
    });

    describe('carInfo', () => {
        it('carInfo - if there is not client with current name return message', () => {
            const name = 'Pesho';
            const number = 'CA1234CA';
            const message = 'There is no car with platenumber CA1234CA and owner Pesho.';
            const autoService = new AutoService(10);
            const result = autoService.carInfo(number, name);
            expect(result).to.be.equal(message);
        });
    
        it('cartInfo - checks if the given information exists in workInProgress or backlogWork array and returns the client information as object', () => {
            const carInWorkInProgress = {
                clientName: 'Peter',
                plateNumber: 'CA1234CA',
                carInfo: {
                    'engine': 'MFRGG23',
                    'transmission': 'FF4418ZZ',
                    'doors': 'broken'
                }
            };
    
            const autoService = new AutoService(10);
            autoService.workInProgress = [carInWorkInProgress];
            const info = autoService.carInfo('CA1234CA', 'Peter');
            expect(info).to.deep.equal(carInWorkInProgress);
        });
    });

    describe('signUpForReview', () => {
        it('If there is available space', () => {
            const autoService = new AutoService(1);
            const currentClient = {
                plateNumber: 'SA5665SA',
                clientName: 'Angel',
                carInfo: {
                    'engine': 'MFRGG23',
                    'transmission': 'FF4418ZZ',
                    'doors': 'broken'
                }
            };

            autoService.signUpForReview('Angel', 'SA5665SA', {
                'engine': 'MFRGG23',
                'transmission': 'FF4418ZZ',
                'doors': 'broken'
            });

            expect(autoService.workInProgress[0]).to.deep.equal(currentClient);
        });

        it('If there is no available space', () => {
            const autoService = new AutoService(0);
            const currentClient = {
                plateNumber: 'SA5665SA',
                clientName: 'Angel',
                carInfo: {
                    'engine': 'MFRGG23',
                    'transmission': 'FF4418ZZ',
                    'doors': 'broken'
                }
            };

            autoService.signUpForReview('Angel', 'SA5665SA', {
                'engine': 'MFRGG23',
                'transmission': 'FF4418ZZ',
                'doors': 'broken'
            });

            expect(autoService.backlogWork[0]).to.deep.equal(currentClient);
        });
    });

    describe('Testing repairCar', () => {
        it('Do not have car for repair should return message', () => {
            const autoService = new AutoService(10);
            const repair = autoService.repairCar();
            expect(repair).to.be.equal('No clients, we are just chilling...');
        });

        it('If there are no cars (workInProgress is empty) the second array (backlogWork) is checked for client (car).', () => {
            const carInBacklogWork = {
                clientName: 'Peter',
                plateNumber: 'CA1234CA',
                carInfo: {
                    'engine': 'MFRGG23',
                    'transmission': 'FF4418ZZ',
                    'doors': 'broken'
                }
            };

            const autoService = new AutoService(10);
            autoService.backlogWork = [carInBacklogWork];
            const act = autoService.repairCar();
            expect(act).to.be.equal('Your doors were repaired.');
        });

        it('If there are cars in workInProgress return currentClient.', () => {
            const carInWorkInProgress = {
                clientName: 'Peter',
                plateNumber: 'CA1234CA',
                carInfo: {
                    'engine': 'MFRGG23',
                    'transmission': 'FF4418ZZ',
                    'doors': 'broken'
                }
            };

            const autoService = new AutoService(10);
            autoService.workInProgress = [carInWorkInProgress];
            const act = autoService.repairCar();
            expect(act).to.be.equal('Your doors were repaired.');
        });

        it('It do not have broken parts should return message', () => {
            const message = 'Your car was fine, nothing was repaired.';
            const carInWorkInProgress = {
                clientName: 'Peter',
                plateNumber: 'CA1234CA',
                carInfo: {
                    'engine': 'MFRGG23',
                    'transmission': 'FF4418ZZ'
                }
            };

            const autoService = new AutoService(10);
            autoService.workInProgress = [carInWorkInProgress];
            const result = autoService.repairCar();
            expect(result).to.be.equal(message);
        });
    });
});