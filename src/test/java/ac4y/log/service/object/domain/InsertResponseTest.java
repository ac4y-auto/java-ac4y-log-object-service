package ac4y.log.service.object.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for InsertResponse.
 * Tests constructor and XML binding annotations.
 */
public class InsertResponseTest {

    private InsertResponse insertResponse;

    @Before
    public void setUp() {
        insertResponse = new InsertResponse();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull("Default constructor should create instance", insertResponse);
        assertNull("Ac4yIdentification should be null after default constructor", insertResponse.getAc4yIdentification());
    }

    @Test
    public void testXmlRootElementAnnotation() {
        assertTrue("InsertResponse should have XmlRootElement annotation",
            InsertResponse.class.isAnnotationPresent(javax.xml.bind.annotation.XmlRootElement.class));
    }

    @Test
    public void testInheritsFromAc4yServiceResponse() {
        assertTrue("InsertResponse should extend Ac4yServiceResponse",
            ac4y.service.domain.Ac4yServiceResponse.class.isAssignableFrom(InsertResponse.class));
    }
}
