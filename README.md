# java-ac4y-log-object-service

Log ObjectService layer with typed request/response DTOs for insert operations.

## Coordinates

- **GroupId**: `ac4y`
- **ArtifactId**: `ac4y-log-object-service`
- **Version**: `1.0.0`

## Description

ObjectService wrapper for the log module providing typed request/response DTOs for the insert operation. Includes `InsertRequest` with JAXB XML serialization support and `InsertResponse` extending `Ac4yServiceResponse`.

### Key Classes

- `Ac4yLogObjectService` - Service class wrapping insert operation with validation
- `InsertRequest` - Request DTO with JAXB annotations (logClass, module, event, information, properties, threadID, timestamps)
- `InsertResponse` - Response DTO extending Ac4yServiceResponse

## Dependencies

- `ac4y-log-basic` (core log domain and persistence)
- `ac4y-service-domain` (Ac4yServiceRequest, Ac4yServiceResponse)

## Build

```bash
mvn clean package
```

## Origin

Extracted from `IJAc4yLogModule/ObjectService`.
