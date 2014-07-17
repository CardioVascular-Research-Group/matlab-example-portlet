package edu.jhu.cvrg.matlab.backing;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import edu.jhu.cvrg.matlab.controller.MPSClientExample;

@ManagedBean(name = "resultBacking")
@ViewScoped

public class ResultBacking implements Serializable {

	private static final long serialVersionUID = -4414932892509904180L;
	@ManagedProperty("#{mPSClientExample}")
	private MPSClientExample mPSClientExample; 

	public String startOver() {
		
		mPSClientExample.reset();
		return "invoke.xhtml";
		
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