package edu.jhu.cvrg.matlab.controller;


import java.net.URL;
import java.io.IOException;
import com.mathworks.mps.client.MWClient;
import com.mathworks.mps.client.MWHttpClient;
import com.mathworks.mps.client.MATLABException;

public interface MATLABAddMatrix {
	double[][] addmatrix(double[][] a1, double[][] a2)
			throws MATLABException, IOException;
}
