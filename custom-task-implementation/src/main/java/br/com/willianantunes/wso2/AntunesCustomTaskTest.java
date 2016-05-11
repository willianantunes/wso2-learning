package br.com.willianantunes.wso2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.ManagedLifecycle;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.task.Task;

/**
 * Custom task implementation. 
 * @author Willian Antunes
 * @see <a href="https://docs.wso2.com/display/ESB490/Adding+and+Scheduling+Tasks">Adding and Scheduling Tasks</a>
 * @see <a href="https://docs.wso2.com/display/ESB490/Writing+Tasks">Writing Tasks</a>
 * @see <a href="https://docs.wso2.com/display/ESB490/Writing+Tasks+Sample">Writing Tasks Sample</a>
 */
public class AntunesCustomTaskTest implements Task, ManagedLifecycle
{
	private Log log = LogFactory.getLog(AntunesCustomTaskTest.class);
	private String helloWorld;
	private String propertyDiscovered;
	private SynapseEnvironment synapseEnvironment;

	@Override
	public void init(SynapseEnvironment synapseEnvironment) {
		this.synapseEnvironment = synapseEnvironment;
	}

	@Override
	public void destroy() { }
	
	
	@Override
	public void execute() {
		log.debug("First custom task Hello World!");

		
		if(synapseEnvironment == null){
			log.error("Synapse Environment not set. Please use ESB Dashboard and set it!");
			return;    
		}
		
		if(helloWorld == null || propertyDiscovered == null){
			log.error("HelloWorld or propertyDiscovered not set. Please use ESB Dashboard and set them!");
			return;
		}
		
		System.out.println(String.format("Everything worked as expected! Look out the values passed by ESB:\r\n"
				+ "helloWorld: %s\r\n"
				+ "propertyDiscovered: %s\r\n"
				+ "currentTimeMillis: %s", helloWorld, propertyDiscovered, System.currentTimeMillis()));
	}

	public String getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
	}

	public String getPropertyDiscovered() {
		return propertyDiscovered;
	}

	public void setPropertyDiscovered(String propertyDiscovered) {
		this.propertyDiscovered = propertyDiscovered;
	}

	public SynapseEnvironment getSynapseEnvironment() {
		return synapseEnvironment;
	}

	public void setSynapseEnvironment(SynapseEnvironment synapseEnvironment) {
		this.synapseEnvironment = synapseEnvironment;
	}
}
