package bicycle_management.domain.fleet.entity;

import bicycle_management.domain.fleet.enums.BicycleStatus;
import java.time.LocalDateTime;

public class Bicycle {
  private final String id;
  private final String model;
  private BicycleStatus status;
  private String location;
  private LocalDateTime lastMaintenanceDate;

  public Bicycle(
      String id,
      String model,
      BicycleStatus status,
      String location,
      LocalDateTime lastMaintenanceDate) {
    validateIdAndModel(id, model);
    this.id = id;
    this.model = model;
    validateStatus(status);
    this.status = status;
    validateLocation(location);
    this.location = location;
    validateLastMaintenanceDate(lastMaintenanceDate);
    this.lastMaintenanceDate = lastMaintenanceDate;
  }

  private void validateIdAndModel(String id, String model) {
    if (id == null || id.isBlank()) {
      throw new IllegalArgumentException("Id cannot be null or blank");
    }
    if (model == null || model.isBlank()) {
      throw new IllegalArgumentException("Model cannot be null or blank");
    }
  }

  void validateStatus(BicycleStatus status) {
    if (status == null) {
      throw new IllegalArgumentException("Status cannot be null");
    }
  }

  void validateLocation(String location) {
    if (location == null || location.isBlank()) {
      throw new IllegalArgumentException("Location cannot be null or blank");
    }
  }

  void validateLastMaintenanceDate(LocalDateTime lastMaintenanceDate) {
    if (lastMaintenanceDate == null) {
      throw new IllegalArgumentException("Last maintenance date cannot be null");
    }
    if (lastMaintenanceDate.isAfter(LocalDateTime.now())) {
      throw new IllegalArgumentException("Last maintenance date cannot be in the future");
    }
  }

  public String getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public BicycleStatus getStatus() {
    return status;
  }

  public void setStatus(BicycleStatus status) {
    validateStatus(status);
    this.status = status;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    validateLocation(location);
    this.location = location;
  }

  public LocalDateTime getLastMaintenanceDate() {
    return lastMaintenanceDate;
  }

  public void setLastMaintenanceDate(LocalDateTime lastMaintenanceDate) {
    validateLastMaintenanceDate(lastMaintenanceDate);
    this.lastMaintenanceDate = lastMaintenanceDate;
  }
}
