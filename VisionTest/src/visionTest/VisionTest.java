package visionTest;

import java.util.Arrays;
import java.util.Scanner;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;


public class VisionTest {
	public static void main(String[] args){
		System.out.println("Starting...");
		Pipeline pipeline = new Pipeline();
	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Mat mat = new Mat();
	    VideoCapture cap = new VideoCapture(0);
	    if(!cap.isOpened()){
	    	System.out.println("Damnit. The camera isn't opened.");
	    	System.exit(1);
	    }
	    double[] positions;
	    double[] scores;
	    double[] ratios;
	    MatOfPoint[] contours;
	    Rect rect;
	    Mat frame = new Mat();
	    boolean cont = true;
	    Scanner scanner = new Scanner(System.in);
	    
	    while(cont) {
	    	cap.read(frame);
	    	pipeline.process(frame);
	    
	    	positions = new double[20];
	    	scores = new double[20];
	    	ratios = new double[20];
	    	contours = new MatOfPoint[20];
	    	rect = new Rect();
	    
	    	if(!pipeline.filterContoursOutput().isEmpty()){
	    		System.out.println("Was non-empty");
	    		rect = Imgproc.boundingRect(pipeline.findBestContourOutput());
	    		pipeline.filterContoursOutput().toArray(contours);
	    		for(int i=0; i <= pipeline.filterContoursOutput().size()-1; i++){
	    			positions[i] = Imgproc.boundingRect(contours[i]).x + Imgproc.boundingRect(contours[i]).width/2;
	    		}
	    		scores = pipeline.scoreContoursOutput();
	    		ratios = pipeline.ratioContoursOutput();
	    		System.out.println("Target Position: " + (rect.x + (rect.width/2.0)));
	    		System.out.println("All filtered contours' positions: " + (Arrays.toString(positions)));
	    		System.out.println("All filtered contours' scores: " + (Arrays.toString(scores)));
	    		System.out.println("All filtered contours' ratios: " + Arrays.toString(ratios));
	    	} else {
	    		System.out.println("Was empty");
	    		System.out.println("Target Position: " + -1.0);
	    	}

	    	System.out.println("Number of found contours: " + (pipeline.findContoursOutput().size()));
	    	System.out.println("Number of filtered contours: " + (pipeline.filterContoursOutput().size()));
	    	//System.out.println("Best contour: " + pipeline.findBestContourOutput().dump());
	    	
	    	System.out.println("Continue? (0/1)");
	    	cont = intToBool(scanner.nextInt());
	    }
	    System.out.println("Done.");
	}
	
	private static boolean intToBool(int in){
		if(in == 0) {
			return false;
		} else {
			return true;
		}
	}
}
