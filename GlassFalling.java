

public class GlassFalling {
  // Do not change the parameters!
	int counter = 0;
  public int glassFallingRecur(int floors, int sheets) {
    // Fill in here and change the return
	  int minimum = Integer.MAX_VALUE;
	  int results;
	  if(floors == 1 || floors == 0) {
		  return floors;
	  }
	  if(sheets == 1) {
		  return floors;
	  }
	  
	  for(int i = 1; i<= floors; i++) {
		  results = Math.max(glassFallingRecur(i - 1, sheets - 1), glassFallingRecur(floors - i, sheets));
		  minimum = Math.min(results, minimum);
	  }
	  
	  return minimum + 1;
	  
  }

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized() {
    // Fill in here and change the return
    return 0;
  }

  // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
    // Filling in here and returning a changed return
	  int sheetFloor[][] = new int [floors+1][sheets+1];
	  int results;
	  for(int i = 1; i <= sheets; i++) {
		  sheetFloor[i][1] = 1;
		  sheetFloor[i][0] = 0;
	  }
	  
	  for(int j = 1;j <= floors; j++) {
		  sheetFloor[j][1] = j;
	  }
	  
	  for(int i = 2; i<= sheets; i++) {
		  for(int j = 2; j <= floors; j++) {
			  sheetFloor[j][i] = Integer.MAX_VALUE;
			  for(int h = 2; h <= j; h++) {
				  results = 1 + Math.max(sheetFloor[h-1][i-1], sheetFloor[j-h][i]);
				  if(results < sheetFloor[j][i]) {
					  sheetFloor[j][i] = results;
				  }
			  }
		  }
	  }
    return sheetFloor[floors][sheets];
  }


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Recur = gf.glassFallingRecur(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);
      
  }
}
