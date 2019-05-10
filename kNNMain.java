import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

   
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


	double percentTotal = 0;
	int ctr = 0;
	for (int j = 0; j < 1000; j ++)
	{
		Iris1 = DataSet.readDataSet(Path_To_Data);
		List<DataPoint> Insurance = DataSet.getTestSet(Iris1, 0.3);
		List<DataPoint> Train = DataSet.getTrainingSet(Iris1, 0.7);
		
		ctr = 0;
		for (int i = 0; i < Insurance.size(); i ++)
		{
			String predictedThingy = thingToFind.predict( Train, Insurance.get(i));
			if(predictedThingy .equals (Insurance.get(i).getLabel()))
			{
				ctr++; 
			}
			//System.out.println( predictedThingy);
		}
		double percentage = (double)(ctr)/(double)(Insurance.size()) * 100;
		percentTotal = percentTotal + percentage;
		
	}
	double finalPercent = percentTotal/1000.0;
	System.out.println(finalPercent);
  }

}
