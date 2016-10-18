package comp;

public class Tester {
	
	public static void main(String[] args) { ;
		
		/* Network Setup
		 * Define input layer, number of hidden layers and output layer
		 */
		Layer in = new Layer(42, 2);
		Layer hidden = new Layer(22);
		Layer out = new Layer(3);
		Mind test1 = new Mind(in, hidden, out, true);
		

		/*
		 * Training Data Set
		 */
		String a = ".####.\n"+
				   "#....#\n"+
				   "#....#\n"+
				   "######\n"+
				   "#....#\n"+
				   "#....#\n"+
				   "#....#\n";
		
		String b = "#####.\n"+
				   "#....#\n"+
				   "#....#\n"+
				   "#####.\n"+
				   "#....#\n"+
				   "#....#\n"+
				   "######\n";
		
		String c = "######\n"+
				   "#.....\n"+
				   "#.....\n"+
				   "#.....\n"+
				   "#.....\n"+
				   "#.....\n"+
				   "######\n";
		
		/*
		 * Testing Data Set
		 */
		String aish = ".####.\n"+
				   	  "#....#\n"+
				      "#.K..#\n"+
				      "######\n"+
				      "#.~..#\n"+
				      "#....#\n"+
				      "#..}.#\n";
		
		String bish = "#####.\n"+
				      "#....#\n"+
				      "#./..#\n"+
				      "#####.\n"+
				      "#....#\n"+
				      "#.-..#\n"+
				      "##w###\n";
		
		String cish = "######\n"+
				   	  "#..v..\n"+
				      "#.....\n"+
				      "##....\n"+
				      "#..a..\n"+
				      "#.....\n"+
				      "######\n";
		
		double[][] result;
		result = test1.predict(new double[][]{symbolsToInput(aish),symbolsToInput(bish),symbolsToInput(cish)});


		//Print Results of an untrained network on training data
		System.out.println("Results:-");
		for(int i = 0; i < result.length; i++) {
			System.out.println("Set "+(i+1)+":- ");
			for(int j = 0; j < result[i].length; j++) {
				System.out.println("	Output "+(j+1)+": "+result[i][j]);
			}
		}
		
		//Train Network with training data and desired output
		test1.learn(new double[][]{symbolsToInput(a),symbolsToInput(b),symbolsToInput(c)}, new double[][]{{1,0,0},{0,1,0},{0,0,1}});
		
		result = test1.predict(new double[][]{symbolsToInput(a),symbolsToInput(b),symbolsToInput(c)});
		
		//Print Results of a trained network on training data
		System.out.println("Results on Training Data:-");
		for(int i = 0; i < result.length; i++) {
			System.out.println("Set "+(i+1)+":- ");
			for(int j = 0; j < result[i].length; j++) {
				System.out.println("	Output "+(j+1)+": "+result[i][j]);
			}
		}
		
		result = test1.predict(new double[][]{symbolsToInput(aish),symbolsToInput(bish),symbolsToInput(cish)});
		
		//Print Results of a trained network on testing data
		System.out.println("Results on Testing Data:-");
		for(int i = 0; i < result.length; i++) {
			System.out.println("Set "+(i+1)+":- ");
			for(int j = 0; j < result[i].length; j++) {
				System.out.println("	Output "+(j+1)+": "+result[i][j]);
			}
		}
		
	}
	
	//Converts symbols to a valid input type, in this case numeric
	public static double[] symbolsToInput(String ch) {
		double input[] = new double[42];
		
		for(int i = 0; i < input.length; i++) {
				double cNum = ch.charAt(i);
				input[i] = input[i] + cNum;
		}
		return input;
	}
}
