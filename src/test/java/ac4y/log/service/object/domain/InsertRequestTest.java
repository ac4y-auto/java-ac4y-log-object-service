package ac4y.log.service.object.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

/**
 * Unit tests for InsertRequest.
 * Tests getters, setters, and XML binding annotations.
 */
public class InsertRequestTest {

    private InsertRequest insertRequest;
    private static final String TEST_LOG_CLASS = "TestClass";
    private static final String TEST_MODULE = "TestModule";
    private static final String TEST_EVENT = "TestEvent";
    private static final String TEST_INFORMATION = "Test information";
    private static final String TEST_PROPERTIES = "property1=value1";
    private static final String TEST_THREAD_ID = "thread-123";
    private Date testOriginalTimestamp;

    @Before
    public void setUp() {
        insertRequest = new InsertRequest();
        testOriginalTimestamp = new Date();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull("Default constructor should create instance", insertRequest);
        assertNull("Ac4yIdentification should be null after default constructor", insertRequest.getAc4yIdentification());
    }

    @Test
    public void testParameterizedConstructor() {
        InsertRequest request = new InsertRequest(
            TEST_LOG_CLASS,
            TEST_MODULE,
            TEST_EVENT,
            TEST_INFORMATION,
            TEST_PROPERTIES,
            TEST_THREAD_ID,
            testOriginalTimestamp
        );

        assertEquals("LogClass should match", TEST_LOG_CLASS, request.getLogClass());
        assertEquals("Module should match", TEST_MODULE, request.getModule());
        assertEquals("Event should match", TEST_EVENT, request.getEvent());
        assertEquals("Information should match", TEST_INFORMATION, request.getInformation());
        assertEquals("Properties should match", TEST_PROPERTIES, request.getProperties());
        assertEquals("ThreadID should match", TEST_THREAD_ID, request.getThreadID());
        assertEquals("OriginalTimestamp should match", testOriginalTimestamp, request.getOriginalTimestamp());
    }

    @Test
    public void testLogClassGetterAndSetter() {
        insertRequest.setLogClass(TEST_LOG_CLASS);
        assertEquals("LogClass should be set correctly", TEST_LOG_CLASS, insertRequest.getLogClass());
    }

    @Test
    public void testModuleGetterAndSetter() {
        insertRequest.setModule(TEST_MODULE);
        assertEquals("Module should be set correctly", TEST_MODULE, insertRequest.getModule());
    }

    @Test
    public void testEventGetterAndSetter() {
        insertRequest.setEvent(TEST_EVENT);
        assertEquals("Event should be set correctly", TEST_EVENT, insertRequest.getEvent());
    }

    @Test
    public void testInformationGetterAndSetter() {
        insertRequest.setInformation(TEST_INFORMATION);
        assertEquals("Information should be set correctly", TEST_INFORMATION, insertRequest.getInformation());
    }

    @Test
    public void testPropertiesGetterAndSetter() {
        insertRequest.setProperties(TEST_PROPERTIES);
        assertEquals("Properties should be set correctly", TEST_PROPERTIES, insertRequest.getProperties());
    }

    @Test
    public void testThreadIDGetterAndSetter() {
        insertRequest.setThreadID(TEST_THREAD_ID);
        assertEquals("ThreadID should be set correctly", TEST_THREAD_ID, insertRequest.getThreadID());
    }

    @Test
    public void testOriginalTimestampGetterAndSetter() {
        insertRequest.setOriginalTimestamp(testOriginalTimestamp);
        assertEquals("OriginalTimestamp should be set correctly", testOriginalTimestamp, insertRequest.getOriginalTimestamp());
    }

    @Test
    public void testIdGetterAndSetter() {
        int testId = 123;
        insertRequest.setId(testId);
        assertEquals("ID should be set correctly", testId, insertRequest.getId());
    }

    @Test
    public void testUploadedGetterAndSetter() {
        Date testUploaded = new Date();
        insertRequest.setUploaded(testUploaded);
        assertEquals("Uploaded should be set correctly", testUploaded, insertRequest.getUploaded());
    }

    @Test
    public void testNullValues() {
        insertRequest.setLogClass(null);
        insertRequest.setModule(null);
        insertRequest.setEvent(null);
        insertRequest.setInformation(null);
        insertRequest.setProperties(null);
        insertRequest.setThreadID(null);
        insertRequest.setOriginalTimestamp(null);

        assertNull("LogClass should be null", insertRequest.getLogClass());
        assertNull("Module should be null", insertRequest.getModule());
        assertNull("Event should be null", insertRequest.getEvent());
        assertNull("Information should be null", insertRequest.getInformation());
        assertNull("Properties should be null", insertRequest.getProperties());
        assertNull("ThreadID should be null", insertRequest.getThreadID());
        assertNull("OriginalTimestamp should be null", insertRequest.getOriginalTimestamp());
    }

    @Test
    public void testEmptyStrings() {
        insertRequest.setLogClass("");
        insertRequest.setModule("");
        insertRequest.setEvent("");
        insertRequest.setInformation("");
        insertRequest.setProperties("");
        insertRequest.setThreadID("");

        assertEquals("LogClass should be empty string", "", insertRequest.getLogClass());
        assertEquals("Module should be empty string", "", insertRequest.getModule());
        assertEquals("Event should be empty string", "", insertRequest.getEvent());
        assertEquals("Information should be empty string", "", insertRequest.getInformation());
        assertEquals("Properties should be empty string", "", insertRequest.getProperties());
        assertEquals("ThreadID should be empty string", "", insertRequest.getThreadID());
    }

    @Test
    public void testXmlRootElementAnnotation() {
        assertTrue("InsertRequest should have XmlRootElement annotation",
            InsertRequest.class.isAnnotationPresent(javax.xml.bind.annotation.XmlRootElement.class));
    }
}
