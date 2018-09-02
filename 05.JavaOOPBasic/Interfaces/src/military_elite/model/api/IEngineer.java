package military_elite.model.api;

public interface IEngineer extends ISpecialistSoldier {
    Iterable<IRepair> getRepairs();

    void addRepair(IRepair repair);
}