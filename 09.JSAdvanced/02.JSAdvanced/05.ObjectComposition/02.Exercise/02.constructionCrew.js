function solve(worker) {
    if (worker.dizziness) {
        worker.levelOfHydrated += worker.weight * worker.experience * 0.1;
        worker.dizziness = false;
    }

    return worker;
}

const result = solve({
    weight: 120,
    experience: 20,
    levelOfHydrated: 200,
    dizziness: true
});

console.log(result);