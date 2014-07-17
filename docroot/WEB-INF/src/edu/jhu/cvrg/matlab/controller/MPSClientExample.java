package edu.jhu.cvrg.matlab.controller;

import java.net.URL;
import java.util.Arrays;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.jhu.cvrg.matlab.controller.MATLABAddMatrix;

import com.liferay.portal.kernel.util.PropsUtil;
import com.mathworks.mps.client.MWClient;
import com.mathworks.mps.client.MWHttpClient;
import com.mathworks.mps.client.MATLABException;

@ManagedBean(name="mPSClientExample")
@SessionScoped

public class MPSClientExample implements Serializable {

	private static final long serialVersionUID = 3611366336484620041L;
	private double[][] a1, a2;
	private String matrix00, matrix01, matrix02, matrix10, matrix11, matrix12;
	private StringBuffer sb;
	private String sbToString;
	private MWClient client;
	
	public MPSClientExample() {
		
		double[][] matrix1 = {{1,2,3},{3,2,1}};
		double[][] matrix2 = {{4,5,6},{6,5,4}};
		setA1(matrix1);	
		setA2(matrix2);

	}

	public void run(){

		setClient(new MWHttpClient());
		setSb(new StringBuffer());
		setSbToString(new String());
		double[][] matrix1 = {{1,2,3},{3,2,1}};
		double[][] matrix2 = {{4,5,6},{6,5,4}};
		matrix1[0][0] = Double.parseDouble(matrix00);
		matrix1[0][1] = Double.parseDouble(matrix01);
		matrix1[0][2] = Double.parseDouble(matrix02);
		matrix1[1][0] = Double.parseDouble(matrix10);
		matrix1[1][1] = Double.parseDouble(matrix11);
		matrix1[1][2] = Double.parseDouble(matrix12);
		setA1(matrix1);	
		setA2(matrix2);
		
		try {
//			MATLABAddMatrix m = getClient().createProxy(new URL("http://10.162.38.221:9910/addmatrix"),
//					MATLABAddMatrix.class);
			MATLABAddMatrix m = getClient().createProxy(new URL(PropsUtil.get("mps_server") + "addmatrix"),
					MATLABAddMatrix.class);
			double[][] result = m.addmatrix(a1,a2);

			// Print the magic square

			setSb(printResult(result));
			setSbToString(getSb().toString());

		} catch(MATLABException ex) {

			// This exception represents errors in MATLAB 
			setSb(printException(ex));
			setSbToString(getSb().toString());
			
		} catch(IOException ex) {

			// This exception represents network issues. 
			setSb(printException(ex));
			setSbToString(getSb().toString());
			
		} finally {

			getClient().close();        
	
		}

	}

	public void reset() {

		setClient(null);
		setSb(null);
		setSbToString("");
		setMatrix00("");
		setMatrix01("");
		setMatrix02("");
		setMatrix10("");
		setMatrix11("");
		setMatrix12("");

	}
	
	public StringBuffer printResult(double[][] result){
		StringBuffer sbPR = getSb();
		for(double[] row : result){
			for(double element : row){
				sbPR.append(element + " ");
			}
			sbPR.append("\n");
		}
		return sbPR;
	}

	public StringBuffer printException(Exception ex){
		StringBuffer sbEX = getSb();
		sbEX.append(ex + "\n");
		return sbEX;
	}


	private StringBuffer getSb() {
		return this.sb;
	}

	private void setSb(StringBuffer sb) {
		this.sb = sb;
	}

	public String getSbToString() {
		return this.sbToString;
	}

	private void setSbToString(String sbToString) {
		this.sbToString = sbToString;
	}

	private MWClient getClient() {
		return this.client;
	}

	private void setClient(MWClient client) {
		this.client = client;
	}

	public double[][] getA1() {
		return this.a1;
	}

	public void setA1(double[][] a1) {
		this.a1 = a1;
	}

	public double[][] getA2() {
		return this.a2;
	}

	public void setA2(double[][] a2) {
		this.a2 = a2;
	}
	
	private String printMatrix(double[][] matrix) {
		return Arrays.deepToString(matrix);
	}

	public String printMatrixA1() {
		return printMatrix(getA1());
	}

	public String printMatrixA2() {
		return printMatrix(getA2());
	}

	public String getMatrix00() {
		return this.matrix00;
	}

	public void setMatrix00(String matrix00) {
		this.matrix00 = matrix00;
	}

	public String getMatrix01() {
		return this.matrix01;
	}

	public void setMatrix01(String matrix01) {
		this.matrix01 = matrix01;
	}

	public String getMatrix02() {
		return this.matrix02;
	}

	public void setMatrix02(String matrix02) {
		this.matrix02 = matrix02;
	}

	public String getMatrix10() {
		return this.matrix10;
	}

	public void setMatrix10(String matrix10) {
		this.matrix10 = matrix10;
	}

	public String getMatrix11() {
		return this.matrix11;
	}

	public void setMatrix11(String matrix11) {
		this.matrix11 = matrix11;
	}

	public String getMatrix12() {
		return this.matrix12;
	}

	public void setMatrix12(String matrix12) {
		this.matrix12 = matrix12;
	}
	
}
