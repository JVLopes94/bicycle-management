package bicycle_management.infrastructure.controller;

import bicycle_management.application.contracts.BicycleService;
import bicycle_management.domain.fleet.entity.Bicycle;
import bicycle_management.domain.fleet.enums.BicycleStatus;
import bicycle_management.infrastructure.controller.dto.AddBicycleDTO;
import bicycle_management.infrastructure.controller.dto.BicycleDetailsDTO;
import java.util.List;

public class BicycleController {
  private final BicycleService bicycleService;

  public BicycleController(BicycleService bicycleService) {
    this.bicycleService = bicycleService;
  }

  public BicycleDetailsDTO addBicycle(AddBicycleDTO dto) {
    try {
      return BicycleDetailsDTO.from(
          bicycleService.addBicycle(
              dto.id(), dto.model(), dto.location(), dto.lastMaintenanceDate()));
    } catch (Exception e) {
      return null;
    }
  }

  public BicycleDetailsDTO getBicycleById(String id) {
    return BicycleDetailsDTO.from(bicycleService.getBicycleById(id));
  }

  public List<BicycleDetailsDTO> listBicyclesWithPagination(int page, int size) {
    List<Bicycle> bicycles = bicycleService.listBicyclesWithPagination(page, size);
    return bicycles.stream().map(BicycleDetailsDTO::from).toList();
  }

  public BicycleDetailsDTO updateBicyclePutUnderMaintenance(String id) {
    Bicycle updatedBicycle =
        bicycleService.updateBicycleStatus(id, BicycleStatus.UNDER_MAINTENANCE);
    return BicycleDetailsDTO.from(updatedBicycle);
  }

  public BicycleDetailsDTO updateBicyclePutAvailable(String id) {
    Bicycle updatedBicycle = bicycleService.updateBicycleStatus(id, BicycleStatus.AVAILABLE);
    return BicycleDetailsDTO.from(updatedBicycle);
  }
}
