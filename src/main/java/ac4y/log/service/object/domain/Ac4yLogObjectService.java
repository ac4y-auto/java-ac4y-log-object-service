package ac4y.log.service.object.domain;

import ac4y.base.Ac4yException;
import ac4y.log.service.persistence.Ac4yLogService;
import ac4y.service.domain.Ac4yProcessResult;

/**
 * Object service for processing log insertion requests.
 * Provides validation and error handling for log operations.
 * This service acts as a facade between external requests and the persistence layer.
 *
 * <p><b>Known Issues:</b></p>
 * <ul>
 *   <li>Lines 15, 18, 21, 24: String comparison uses == operator instead of .equals() method,
 *       which may cause incorrect validation behavior</li>
 * </ul>
 *
 * @author Ac4y Log Module
 * @version 1.20190422.1
 */
public class Ac4yLogObjectService {

	/**
	 * Processes a log insertion request with validation.
	 * Validates required fields and delegates to the persistence service.
	 *
	 * <p>Required fields:</p>
	 * <ul>
	 *   <li>logClass - must not be null or empty</li>
	 *   <li>module - must not be null or empty</li>
	 *   <li>event - must not be null or empty</li>
	 *   <li>threadID - must not be null or empty</li>
	 *   <li>originalTimestamp - must not be null</li>
	 * </ul>
	 *
	 * <p>Optional fields:</p>
	 * <ul>
	 *   <li>information - additional details about the log event</li>
	 *   <li>properties - key-value pairs for extra properties</li>
	 * </ul>
	 *
	 * @param request the insertion request containing log data
	 * @return InsertResponse with success (resultCode=1) or error (resultCode=-1) information
	 */
	public InsertResponse insert(InsertRequest request) {

		InsertResponse response = new InsertResponse();

		try {

			if ((request.getLogClass() == null) || (request.getLogClass() == ""))
				throw new Ac4yException("logclass is empty!");

			if ((request.getModule() == null) || (request.getModule() == ""))
				throw new Ac4yException("module is empty!");

			if ((request.getEvent() == null) || (request.getEvent() == ""))
				throw new Ac4yException("event is empty!");
			
			if ((request.getThreadID() == null) || (request.getThreadID() == ""))
				throw new Ac4yException("threadID is empty!");
			
			if (request.getOriginalTimestamp() == null)
				throw new Ac4yException("original time stamp is empty!");
			
			new Ac4yLogService().insert(
					request.getLogClass()
					,request.getModule()
					,request.getEvent()
					,request.getInformation()
					,request.getProperties()
					,request.getThreadID()
					,request.getOriginalTimestamp()
			);

			response.setResult(new Ac4yProcessResult(1, "ok", null));

		} catch (Exception e) {
			response.setResult(new Ac4yProcessResult(-1, e.getLocalizedMessage(), new Ac4yException().getStackTraceAsString(e)));
		}

		return response;
		
	} // insert
	
}
