package bicycle_management.domain.fleet.repository;

import bicycle_management.domain.fleet.entity.Bicycle;

public interface BicycleRepository {
    Bicycle save(Bicycle bicycle);
}
