package bicycle_management.infrastructure.controller.dto;

import bicycle_management.domain.fleet.entity.Bicycle;
import java.time.LocalDateTime;

public record BicycleDetailsDTO(
    String id, String model, String status, String location, LocalDateTime lastMaintenanceDate) {

  public static BicycleDetailsDTO from(Bicycle addedBicycle) {
    return new BicycleDetailsDTO(
        addedBicycle.getId(),
        addedBicycle.getModel(),
        addedBicycle.getStatus(),
        addedBicycle.getLocation(),
        addedBicycle.getLastMaintenanceDate());
  }
}
