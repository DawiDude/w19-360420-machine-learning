import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	String Path_To_Data = args[0];
	DataSet Iris = new DataSet();
	List<DataPoint> Iris1 = DataSet.readDataSet(Path_To_Data);
	
	DataPoint a = Iris1.get(5);
	String Label = a.getLabel();
	double [] values = a.getX();
	
	/*System.out.println( Label);
	
	for(int i=0; i< values.length; i ++)
	{
		System.out.println( + values[i]);
	}*/
	

    // TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	List<DataPoint> Insurance = DataSet.getTestSet(Iris1, 0.2);
	List<DataPoint> Train = DataSet.getTrainingSet(Iris1, 0.8);
    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)

	//REMOVED

    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)



    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	
	
	KNNClassifier thingToFind = new KNNClassifier (5);
	
	
	
	
	/*DataPoint IrisA = Iris1.get(0);
	double [] valuesA = IrisA.getX();
	for(int i=1; i< values.length; i ++)
	{
		System.out.println( + valuesA[i]);
	}
	DataPoint IrisB = Iris1.get(40);
	double [] valuesB = IrisB.getX();
	for(int i=1; i< values.length; i ++)
	{
		System.out.println( + valuesB[i]);
	}
	double distance = DataSet.distanceEuclid(IrisA,IrisB);
	System.out.println(distance);*/

    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
	int ctr = 0;
	for (int i = 0; i < Insurance.size(); i ++)
	{
		String predictedThingy = thingToFind.predict( Train, Insurance.get(i));
		if(predictedThingy .equals (Insurance.get(i).getLabel()))
		{
			ctr++; 
		}
		System.out.println( predictedThingy);
	}
	double persentage = (double)(ctr)/(double)(Insurance.size()) * 100;
	System.out.println(persentage);
  }

}
