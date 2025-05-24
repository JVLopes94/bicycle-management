package bicycle_management.infrastructure.adapter;

import bicycle_management.domain.fleet.entity.Bicycle;
import bicycle_management.domain.fleet.repository.BicycleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BicycleRepositoryAdapter implements BicycleRepository {
  @Override
  public Bicycle save(Bicycle bicycle) {
    return null;
  }
}
