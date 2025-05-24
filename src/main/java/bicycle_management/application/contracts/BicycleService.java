package bicycle_management.application.contracts;

import bicycle_management.domain.fleet.entity.Bicycle;
import bicycle_management.domain.fleet.enums.BicycleStatus;
import java.time.LocalDateTime;
import java.util.List;

public interface BicycleService {
  Bicycle addBicycle(String id, String model, String location, LocalDateTime lastMaintenanceDate);

  Bicycle getBicycleById(String id);

  List<Bicycle> listBicyclesWithPagination(int page, int size);

  Bicycle updateBicycleStatus(String id, BicycleStatus newStatus);
}
