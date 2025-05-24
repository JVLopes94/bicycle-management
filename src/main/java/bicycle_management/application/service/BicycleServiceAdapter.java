package bicycle_management.application.service;

import bicycle_management.application.contracts.BicycleService;
import bicycle_management.domain.fleet.entity.Bicycle;
import bicycle_management.domain.fleet.enums.BicycleStatus;
import java.time.LocalDateTime;
import java.util.List;

public class BicycleServiceAdapter implements BicycleService {

  @Override
  public Bicycle addBicycle(
      String id, String model, String location, LocalDateTime lastMaintenanceDate) {
    return null;
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
