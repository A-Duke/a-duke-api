package org.eva4j.api;

public interface IOperation {

	/**
	 * 
	 * @return id which is used to fetch object state
	 * 
	 */
	Object getObjectId();
	
	/**
	 * Apply operation to the state fetched using {@link #getObjectId()}
	 * @param state
	 * @return
	 */
	Object apply(Object state);
	/**
	 * Compensate previously applied operation
	 * @param state
	 * @return New state
	 */
	Object compensate(Object state);
}
