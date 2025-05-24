package bicycle_management.infrastructure.controller.dto;

import java.time.LocalDateTime;

public record AddBicycleDTO(
    String id, String model, String location, LocalDateTime lastMaintenanceDate) {}
