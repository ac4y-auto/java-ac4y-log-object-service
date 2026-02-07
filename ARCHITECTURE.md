# Architektura - java-ac4y-log-object-service

## Attekintes

ObjectService reteg a log modulhoz tipusos keres/valasz DTO-kkal az insert muvelethez. JAXB XML szerializaciot tamogat.

## Szerkezet

```
src/main/java/ac4y/log/service/object/domain/
  Ac4yLogObjectService.java         - Szolgaltatas osztaly validacioval
  InsertRequest.java                - Keres DTO JAXB annotaciokkal
  InsertResponse.java               - Valasz DTO (Ac4yServiceResponse kiterjesztese)
src/test/java/ac4y/log/service/object/domain/
  Ac4yLogObjectServiceTest.java     - Szolgaltatas tesztek (13 teszt)
  InsertRequestTest.java            - Keres DTO tesztek
  InsertResponseTest.java           - Valasz DTO tesztek
```

## Mukodes

Az `Ac4yLogObjectService.insert()` metodus:
1. Fogadja az `InsertRequest`-et
2. Validalja a kotelezo mezoket (logClass, module, event, threadID, originalTimestamp)
3. Delegalja az `Ac4yLogService`-nek
4. `InsertResponse`-t ad vissza eredmenykoddal (1 = sikeres, -1 = hiba)

## Fuggosegek

- ac4y-log-basic (Ac4yLog, Ac4yLogService)
- ac4y-service-domain (Ac4yServiceRequest, Ac4yServiceResponse)
- Teszt: JUnit 4, Mockito

## Eredet

Az `IJAc4yLogModule/ObjectService` modulbol kinyerve.
