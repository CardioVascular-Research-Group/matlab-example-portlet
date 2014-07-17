/*
 * Created on July 14, 2014
 *
 * Copyright Stephen J. Granite, CardioVascular Research Grid (http://www.cvrgrid.org)
 *
 * The software below is licensed under Apache License, v 2.0.
 * (http://www.apache.org/licenses/LICENSE-2.0)
 *
 * @author Stephen J. Granite
 */
package edu.jhu.cvrg.matlab.backing;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import edu.jhu.cvrg.matlab.controller.MPSClientExample;

/*
 * This is the backing class that is meant to connect the invoke.xhtml to the 
 * MPSClientExample ManagedProperty.
 *  
 * The tool requires the standard Java IO, Utility, Javax Faces, Liferay and MPS Client libraries to function properly.
 */

@ManagedBean(name = "invokeBacking")
@ViewScoped

public class InvokeBacking implements Serializable {

	private static final long serialVersionUID = 3408760301221150971L;
	@ManagedProperty("#{mPSClientExample}")
	private MPSClientExample mPSClientExample; 

	public String runAddMatrix() {
		
		mPSClientExample.run();
		return "result.xhtml";
		
	}
	
	public String printMatrixA1() {
		
		return mPSClientExample.printMatrixA1();

	}

	public String printMatrixA2() {
		
		return mPSClientExample.printMatrixA2();

	}
	
	public MPSClientExample getmPSClientExample() {
		return this.mPSClientExample;
	}

	public void setmPSClientExample(MPSClientExample mPSClientExample) {
		this.mPSClientExample = mPSClientExample;
	}
	
}
