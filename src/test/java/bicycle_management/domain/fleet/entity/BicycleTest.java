package bicycle_management.domain.fleet.entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import bicycle_management.domain.fleet.enums.BicycleStatus;
import java.time.LocalDateTime;
import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BicycleTest {

  @ParameterizedTest
  @ValueSource(strings = {"", "     "})
  void shouldThrowExceptionWhenIdIsIllegal(String illegalId) {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new Bicycle(
                null, "Model A", BicycleStatus.AVAILABLE, "Location A", LocalDateTime.now()));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new Bicycle(
                illegalId, "Model A", BicycleStatus.AVAILABLE, "Location A", LocalDateTime.now()));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "     "})
  void shouldThrowExceptionWhenModelIsIllegal(String illegalModel) {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Bicycle("1", null, BicycleStatus.AVAILABLE, "Location A", LocalDateTime.now()));
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new Bicycle(
                "1", illegalModel, BicycleStatus.AVAILABLE, "Location A", LocalDateTime.now()));
  }

  @Nested
  class Status {
    @Test
    void shouldThrowExceptionWhenStatusIsNull() {
      assertThrows(
          IllegalArgumentException.class,
          () -> new Bicycle("1", "Model A", null, "Location A", LocalDateTime.now()));
    }

    @Test
    void setStatusShouldCallValidateStatus() {
      Bicycle spyBicycle =
          spy(
              new Bicycle(
                  "1", "Model A", BicycleStatus.AVAILABLE, "Location A", LocalDateTime.now()));
      try {
        spyBicycle.setStatus(null);
      } catch (IllegalArgumentException e) {
        assertEquals(BicycleStatus.AVAILABLE, spyBicycle.getStatus());
      }
      verify(spyBicycle).validateStatus(null);
    }
  }

  @Nested
  class Location {
    private static Stream<String> provideIllegalLocations() {
      return Stream.of(null, "", "    ", "\t\t\t");
    }

    @ParameterizedTest
    @MethodSource("provideIllegalLocations")
    void shouldThrowExceptionWhenLocationIsIllegal(String illegalLocation) {
      assertThrows(
          IllegalArgumentException.class,
          () ->
              new Bicycle(
                  "1", "Model A", BicycleStatus.AVAILABLE, illegalLocation, LocalDateTime.now()));
    }

    @ParameterizedTest
    @MethodSource("provideIllegalLocations")
    void setLocationShouldCallValidateLocation(String illegalLocation) {
      Bicycle spyBicycle =
          spy(
              new Bicycle(
                  "1", "Model A", BicycleStatus.AVAILABLE, "Location A", LocalDateTime.now()));
      try {
        spyBicycle.setLocation(illegalLocation);
      } catch (IllegalArgumentException e) {
        assertEquals("Location A", spyBicycle.getLocation());
      }
      verify(spyBicycle).validateLocation(illegalLocation);
    }
  }

  @Nested
  class LastMaintenanceDate {
    private static Stream<LocalDateTime> provideIllegalLastMaintenanceDates() {
      return Stream.of(null, LocalDateTime.now().plusDays(1));
    }

    @ParameterizedTest
    @MethodSource("provideIllegalLastMaintenanceDates")
    void shouldThrowExceptionWhenLastMaintenanceDateIsIllegal(
        LocalDateTime illegalLastMaintenanceDate) {
      assertThrows(
          IllegalArgumentException.class,
          () ->
              new Bicycle(
                  "1",
                  "Model A",
                  BicycleStatus.AVAILABLE,
                  "Location A",
                  illegalLastMaintenanceDate));
    }

    @ParameterizedTest
    @MethodSource("provideIllegalLastMaintenanceDates")
    void setLastMaintenanceDateShouldCallValidateLastMaintenanceDate(
        LocalDateTime illegalLastMaintenanceDate) {
      LocalDateTime originalMaintenanceDate = LocalDateTime.now();
      Bicycle spyBicycle =
          spy(
              new Bicycle(
                  "1", "Model A", BicycleStatus.AVAILABLE, "Location A", originalMaintenanceDate));
      try {
        spyBicycle.setLastMaintenanceDate(illegalLastMaintenanceDate);
      } catch (IllegalArgumentException e) {
        assertEquals(originalMaintenanceDate, spyBicycle.getLastMaintenanceDate());
      }
      verify(spyBicycle).validateLastMaintenanceDate(illegalLastMaintenanceDate);
    }
  }
}
