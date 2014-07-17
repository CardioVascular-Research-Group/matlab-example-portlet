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
package edu.jhu.cvrg.matlab.controller;


import java.net.URL;
import java.io.IOException;
import com.mathworks.mps.client.MWClient;
import com.mathworks.mps.client.MWHttpClient;
import com.mathworks.mps.client.MATLABException;

/*
 * This is the interface controller class used to connect to the Matlab Production Server (MPS) and
 * invoke a specific Matlab function.
 * This code is a part of a portlet implementation of the MPS Example that can be found here:
 * http://www.mathworks.com/help/mps/qs/create-a-java-application-that-calls-the-deployed-function.html
 * 
 * The tool requires the standard Java IO, Utility, Javax Faces, Liferay and MPS Client libraries to function properly.
 */


public interface MATLABAddMatrix {
	double[][] addmatrix(double[][] a1, double[][] a2)
			throws MATLABException, IOException;
}
