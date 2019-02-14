public class KnightBoard{
  private int[][] board;
  //2D array to represent the board

  private int rows;
  //store the number of rows in the board

  private int cols;
  //store the number of cols in the board


  // @throws IllegalArgumentException when either parameter is <= 0.
  // Initialize the board to the correct size and make them all 0's
  public KnightBoard(int startingRows,int startingCols){
    if(startingRows < 0 || startingCols < 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
  }


  // blank boards display 0's as underscores
  // you get a blank board if you never called solve or
  // when there is no solution

  // Single spaces between numbers, but leading spaces on single digit numbers:
  //  1  2  5
  //  3  4  6
  //  7  8  9
  //
  // Which is equivalant to: " 1  2  5\n 3  4  6\n 7  8  9\n"
  //
  // When there are two digit numbers (rows*cols >= 10) Put a leading space in front of single digit numbers:
  // (spaces replaced with _ to show the difference)
  // _1 _2 15 _6
  // _3 _4 _7 11
  // _8 _9 10 12
  // 13 14 _5 16
  //
  // So it looks like this:
  //  1  2 15  6
  //  3  4  7 11
  //  8  9 10 12
  // 13 14  5 16
  public String toString() {
    String output = "";
    for(int row = 0; row < board.length; row++){
      for(int col = 0; col < board[row].length; col++){
        if(rows * cols >= 10 && board[row][col] < 10){
          output += " ";
        }
        if(board[row][col] == 0){
          // output += "_";
          output += board[row][col];//easier to debug if you see the number
        }else{
          output += board[row][col];
        }
        output += " ";
      }
      output += "\n";
    }
    return output;
  }

  public boolean isEmpty(){
    for(int row = 0; row < board.length; row++){
      for(int col = 0; col < board[row].length; col++){
        if(board[row][col] != 0){
          return false;
        }
      }
    }
    return true;
  }

  public boolean addKnight(int row, int col, int numMoves){
    if(row < 0 || col < 0){
      return false;//row or col cannot be negative
    }
    if(row > board.length || col > board[row].length){
      return false;//cannot be out of bounds of the dimensions of the board
    }
    if(board[row][col] == 0){
      board[row][col] = numMoves;//keep track of what move number you are on
      return true;
    }
    return false;//can't add knight to square where you previously visited
  }

  public boolean removeKnight(int row, int col){
    board[row][col] = 0;//removing Knight makes the square empty, so you set it to 0
    return true;
  }

  // Modifies the board by labeling the moves from 1 (at startingRow,startingCol) up to the area of the board in proper knight move steps.
  // @throws IllegalStateException when the board contains non-zero values.
  // @throws IllegalArgumentException when either parameter is negative
  //  or out of bounds.
  // @returns true when the board is solvable from the specified starting position
  public boolean solve(int startingRow, int startingCol){
    if(!isEmpty()){
      throw new IllegalStateException();
    }
    if(startingRow < 0 || startingCol < 0){
      throw new IllegalArgumentException();
    }
    return solveHelper(0,0,0);
  }

  public boolean solveHelper(int row, int col, int numMoves){
    int[][] possibleMoves = new int[8][2];
    return true;
  }

  // @throws IllegalStateException when the board contains non-zero values.
  // @throws IllegalArgumentException when either parameter is negative
  //  or out of bounds.
  // @returns the number of solutions from the starting position specified
  public int countSolutions(int startingRow, int startingCol){
    return 0;
  }

  // Suggestion:
  // private boolean solveH(int row ,int col, int level)
  // level is the # of the knight

}
