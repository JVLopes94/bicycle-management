package bicycle_management.application.service;

import bicycle_management.application.contracts.BicycleService;
import bicycle_management.application.exception.InvalidBicycleException;
import bicycle_management.domain.fleet.entity.Bicycle;
import bicycle_management.domain.fleet.enums.BicycleStatus;
import bicycle_management.domain.fleet.repository.BicycleRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BicycleServiceAdapter implements BicycleService {
  private final BicycleRepository bicycleRepository;

  public BicycleServiceAdapter(BicycleRepository bicycleRepository) {
    this.bicycleRepository = bicycleRepository;
  }

  @Override
  public Bicycle addBicycle(
      String id, String model, String location, LocalDateTime lastMaintenanceDate) {
    Bicycle bicycle;
    try {
      bicycle = new Bicycle(id, model, BicycleStatus.AVAILABLE, location, lastMaintenanceDate);
    } catch (IllegalArgumentException e) {
      throw new InvalidBicycleException(e);
    }
    bicycle = bicycleRepository.save(bicycle);
    return bicycle;
  }

  @Override
  public Bicycle getBicycleById(String id) {
    return null;
  }

  @Override
  public List<Bicycle> listBicyclesWithPagination(int page, int size) {
    return List.of();
  }

  @Override
  public Bicycle updateBicycleStatus(String id, BicycleStatus newStatus) {
    return null;
  }
}
