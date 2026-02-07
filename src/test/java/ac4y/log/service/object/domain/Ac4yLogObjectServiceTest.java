package ac4y.log.service.object.domain;

import ac4y.service.domain.Ac4yProcessResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Unit tests for Ac4yLogObjectService.
 * Tests validation logic and request/response handling.
 */
public class Ac4yLogObjectServiceTest {

    private Ac4yLogObjectService service;
    private InsertRequest validRequest;

    @Before
    public void setUp() {
        service = new Ac4yLogObjectService();
        validRequest = new InsertRequest(
            "TestClass",
            "TestModule",
            "TestEvent",
            "Test information",
            "properties",
            "thread-123",
            new Date()
        );
    }

    @Test
    public void testInsertWithValidRequest() {
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be 1 for success", 1, response.getResult().getResultCode());
        assertEquals("Result message should be 'ok'", "ok", response.getResult().getResultMessage());
    }

    @Test
    public void testInsertWithNullLogClass() {
        validRequest.setLogClass(null);
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be -1 for error", -1, response.getResult().getResultCode());
        assertTrue("Error message should mention logclass",
            response.getResult().getResultMessage().toLowerCase().contains("logclass"));
    }

    @Test
    public void testInsertWithEmptyLogClass() {
        validRequest.setLogClass("");
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be -1 for error", -1, response.getResult().getResultCode());
        assertTrue("Error message should mention logclass",
            response.getResult().getResultMessage().toLowerCase().contains("logclass"));
    }

    @Test
    public void testInsertWithNullModule() {
        validRequest.setModule(null);
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be -1 for error", -1, response.getResult().getResultCode());
        assertTrue("Error message should mention module",
            response.getResult().getResultMessage().toLowerCase().contains("module"));
    }

    @Test
    public void testInsertWithEmptyModule() {
        validRequest.setModule("");
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be -1 for error", -1, response.getResult().getResultCode());
        assertTrue("Error message should mention module",
            response.getResult().getResultMessage().toLowerCase().contains("module"));
    }

    @Test
    public void testInsertWithNullEvent() {
        validRequest.setEvent(null);
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be -1 for error", -1, response.getResult().getResultCode());
        assertTrue("Error message should mention event",
            response.getResult().getResultMessage().toLowerCase().contains("event"));
    }

    @Test
    public void testInsertWithEmptyEvent() {
        validRequest.setEvent("");
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be -1 for error", -1, response.getResult().getResultCode());
        assertTrue("Error message should mention event",
            response.getResult().getResultMessage().toLowerCase().contains("event"));
    }

    @Test
    public void testInsertWithNullThreadID() {
        validRequest.setThreadID(null);
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be -1 for error", -1, response.getResult().getResultCode());
        assertTrue("Error message should mention threadID",
            response.getResult().getResultMessage().toLowerCase().contains("threadid"));
    }

    @Test
    public void testInsertWithEmptyThreadID() {
        validRequest.setThreadID("");
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be -1 for error", -1, response.getResult().getResultCode());
        assertTrue("Error message should mention threadID",
            response.getResult().getResultMessage().toLowerCase().contains("threadid"));
    }

    @Test
    public void testInsertWithNullOriginalTimestamp() {
        validRequest.setOriginalTimestamp(null);
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be -1 for error", -1, response.getResult().getResultCode());
        assertTrue("Error message should mention timestamp",
            response.getResult().getResultMessage().toLowerCase().contains("time"));
    }

    @Test
    public void testInsertWithNullInformation() {
        validRequest.setInformation(null);
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be 1 for success (information is optional)",
            1, response.getResult().getResultCode());
    }

    @Test
    public void testInsertWithNullProperties() {
        validRequest.setProperties(null);
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Result should not be null", response.getResult());
        assertEquals("Result code should be 1 for success (properties is optional)",
            1, response.getResult().getResultCode());
    }

    @Test
    public void testInsertResponseContainsStackTraceOnError() {
        validRequest.setLogClass(null);
        InsertResponse response = service.insert(validRequest);

        assertNotNull("Response should not be null", response);
        assertNotNull("Stack trace should be present on error", response.getResult().getException());
    }

    @Test
    public void testServiceInstantiation() {
        assertNotNull("Service should be instantiable", service);
    }
}
