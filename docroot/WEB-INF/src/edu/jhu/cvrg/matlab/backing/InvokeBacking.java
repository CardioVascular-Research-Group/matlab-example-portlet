package edu.jhu.cvrg.matlab.backing;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import edu.jhu.cvrg.matlab.controller.MPSClientExample;

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
