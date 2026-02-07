package ac4y.log.service.object.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import ac4y.service.domain.Ac4yServiceRequest;

/**
 * Request object for log insertion operations.
 * Contains all the data required to create a new log entry.
 * Supports XML serialization through JAXB annotations.
 *
 * @author Ac4y Log Module
 * @version 1.20190422.1
 */
@XmlRootElement
public class InsertRequest extends Ac4yServiceRequest {

	/**
	 * Default constructor for XML binding.
	 * Initializes the request with a GUID template.
	 */
	public InsertRequest() {
		getAc4yIdentification().getTemplate().setGUID("InsertRequest");
		setAc4yIdentification(null);
	}

	/**
	 * Constructs an InsertRequest with all log data.
	 *
	 * @param aLogClass the classification or category of the log entry
	 * @param aModule the module or component that generated the log
	 * @param aEvent the event type or action being logged
	 * @param aInformation detailed information about the log event
	 * @param aProperties additional properties as key-value pairs
	 * @param aThreadID the thread identifier where the log was generated
	 * @param aOriginalTimestamp the original timestamp when the event occurred
	 */
	public InsertRequest(
			String aLogClass
			,String aModule
			,String aEvent
			,String aInformation
			,String aProperties
			,String aThreadID
			,Date aOriginalTimestamp) {
		
		setLogClass(aLogClass);
		setModule(aModule);
		setEvent(aEvent);
		setInformation(aInformation);
		setProperties(aProperties);
		setThreadID(aThreadID);
		setOriginalTimestamp(aOriginalTimestamp);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogClass() {
		return logClass;
	}
	public void setLogClass(String logClass) {
		this.logClass = logClass;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public String getThreadID() {
		return threadID;
	}
	public void setThreadID(String threadID) {
		this.threadID = threadID;
	}
	public Date getUploaded() {
		return uploaded;
	}
	public void setUploaded(Date uploaded) {
		this.uploaded = uploaded;
	}
	public Date getOriginalTimestamp() {
		return originalTimestamp;
	}
	public void setOriginalTimestamp(Date originalTimestamp) {
		this.originalTimestamp = originalTimestamp;
	}
	protected int id;
	protected String logClass;
	protected String module;
	protected String event;
	protected String information;
	protected String properties;
	protected String threadID;
	protected Date uploaded;
	protected Date originalTimestamp;
	
}
