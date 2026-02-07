package ac4y.log.service.object.domain;

import javax.xml.bind.annotation.XmlRootElement;

import ac4y.service.domain.Ac4yServiceResponse;

/**
 * Response object for log insertion operations.
 * Contains the result of the insertion request including success/error status.
 * Supports XML serialization through JAXB annotations.
 *
 * <p>The response includes an Ac4yProcessResult with:</p>
 * <ul>
 *   <li>resultCode: 1 for success, -1 for error</li>
 *   <li>resultMessage: "ok" for success, error message for failure</li>
 *   <li>exception: stack trace string if an error occurred</li>
 * </ul>
 *
 * @author Ac4y Log Module
 * @version 1.20190422.1
 */
@XmlRootElement
public class InsertResponse extends Ac4yServiceResponse {

	/**
	 * Default constructor for XML binding.
	 * Initializes the response with a GUID template.
	 */
	public InsertResponse() {
		getAc4yIdentification().getTemplate().setGUID("InsertResponse");
		setAc4yIdentification(null);
	}

}
