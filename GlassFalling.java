import java.util.Arrays;

/**
 * Glass Falling
 */
public class GlassFalling {
  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) {
    // Fill in here and change the return
	  int minimumDrops = Integer.MAX_VALUE;
	  int results;
	  if(floors == 1 || floors == 0) {
		  return floors;
	  }//if theres only one floor, we check one and if there's zero floors then we do zero
	  if(sheets == 1) {
		  return floors;
	  }
	  //if we only have one sheet then we use the worst case 
	  	//Starting from the first floor to the nth floor
	  for(int i = 1; i<= floors; i++) {
		  results = Math.max(glassFallingRecur(i - 1, sheets - 1), glassFallingRecur(floors - i, sheets));
		  minimumDrops = Math.min(results, minimumDrops);
		//find the max value of the two recursive calls and then we compare it to the current minimumDrops var
	  }
	  
	  return minimumDrops + 1;
	  
  }

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized(int floors, int sheets) {
	 int[][] memo = new int[floors + 1][sheets +1];
	 int minimumDrops = Integer.MAX_VALUE;
	  int results;
	  if(floors == 1 || floors == 0) {
		  return floors;
	  }//if theres only one floor, we check one and if there's zero floors then we do zero
	  if(sheets == 1) {
		  return floors;
	  }
	  //if we only have one sheet then we use the worst case 
	  	//Starting from the first floor to the nth floor
	  if(memo[floors][sheets] >= 0) { 
		  return memo[floors][sheets];
	  }
	  
	  for(int i = 1; i<= floors; i++) {
		  System.out.println("hi");
		  results = Math.max(glassFallingRecur(i - 1, sheets - 1), glassFallingRecur(floors - i, sheets));
		  minimumDrops = Math.min(results, minimumDrops);
		 
		//find the max value of the 2 recursive calls and then compare it to the current minimumDrops variable 
	  }
	  System.out.println("bye");
	  memo[floors][sheets] = minimumDrops+1;
	  
	  return minimumDrops+1;

  }


  // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
    // Fill in here and change the return
	  int sheetFloorDrop[][] = new int [floors+1][sheets+1];
	  int results;
	  for(int i = 1; i <= sheets; i++) {
		  sheetFloorDrop[i][1] = 1;
		  sheetFloorDrop[i][0] = 0;
		  //store 0 for when floor is 0 and 1 when floor is 1
	  }
	  
	  for(int j = 1;j <= floors; j++) {
		  sheetFloorDrop[j][1] = j;
		  //stores the highest floor when we only have 1 sheet because thats the worst case
	  }
	  
	  for(int i = 2; i<= sheets; i++) {
		  for(int j = 2; j <= floors; j++) {
			  sheetFloorDrop[j][i] = Integer.MAX_VALUE;
			  for(int h = 2; h <= j; h++) {
				  results = 1 + Math.max(sheetFloorDrop[h-1][i-1], sheetFloorDrop[j-h][i]);
				  //iterate through each array index using the previous computed indexes to calculate the current floor and sheet count
				  if(results < sheetFloorDrop[j][i]) {
					  sheetFloorDrop[j][i] = results;
				  }
			  }
		  }
	  }
    return sheetFloorDrop[floors][sheets];
  }


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Memo = gf.glassFallingMemoized(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Memo + " " + minTrials2Bottom);
  
      
  }
}
