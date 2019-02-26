public class KnightBoard{
  private int[][] board;
  //2D array to represent the board

  private int rows;
  //store the number of rows in the board

  private int cols;
  //store the number of cols in the board

  private int[][] moves;
  //keep track of the different moves the knight can make

  private int[][] outgoing;
  //keeps track of number of possible outgoing moves from each square

  // @throws IllegalArgumentException when either parameter is <= 0.
  // Initialize the board to the correct size and make them all 0's
  public KnightBoard(int startingRows,int startingCols){
    if(startingRows < 0 || startingCols < 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
    moves = new int[][] {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
    outgoing = new int[startingRows][startingCols];
  }

  public void fillOutGoingMoves(){
    for(int i = 0; i < outgoing.length; i++){
      for(int j = 0; j < outgoing[i].length; j++){
        if(i > 1 && i < outgoing.length - 2 && j > 1 && j < outgoing[i].length - 2){
          outgoing[i][j] = 8;//more than two sqares in all directions, so all moves are possible
        } else{
          int count = 0;
          for(int k = 0; k < moves.length; k++){
            int row = i + moves[k][0];//store the row value of that possible move from the square i, j
            int col = j + moves[k][1];//store the col value of that possible move from the square i, j
            if(!(row < 0 || col < 0 || row >= board.length || col >= board[i].length)){//if you dont go out of bounds
              count++;//a possible move, so you add one to counter variable
            }
          }
          outgoing[i][j] = count;//set this square to hold the number of possible moves
        }
      }
    }
  }

  public int[][] myMoves(int r, int c){
    int[][] myMoves = new int[outgoing[r][c]][];
    for(int i = 0; i < myMoves.length; i++){
    }
    return myMoves;
  }

  public String movesToStringDebug() {
    String output = "";
    for(int row = 0; row < outgoing.length; row++){
      for(int col = 0; col < outgoing[row].length; col++){
        output += outgoing[row][col] + " ";
      }
      output += "\n";
    }
    return output;
  }

  public String toString() {
    String output = "";
    for(int row = 0; row < board.length; row++){
      for(int col = 0; col < board[row].length; col++){
        if(rows * cols >= 10 && board[row][col] < 10){
          output += " ";
        }
        if(board[row][col] == 0){
          output += "_";
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

  public boolean move(int row, int col, int level){
    if(row < 0 || col < 0 || row >= board.length || col >= board[row].length){
      return false;//out of bounds, return false
    }
    if(board[row][col] != 0){
      return false;//cannot visit the same square twice
    }
    board[row][col] = level;//move knight here
    return true;
  }


  public void clear(){
    for(int row = 0; row < board.length; row++){
      for(int col = 0; col < board[row].length; col++){
        board[row][col] = 0;
      }
    }
  }


  // Modifies the board by labeling the moves from 1 (at startingRow,startingCol) up to the area of the board in proper knight move steps.
  // @throws IllegalStateException when the board contains non-zero values.
  // @throws IllegalArgumentException when either parameter is negative
  //  or out of bounds.
  // @returns true when the board is solvable from the specified starting position
  /**
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative or out of bounds.
  */
  public boolean solve(int startingRow, int startingCol){
    if(!isEmpty()){
      throw new IllegalStateException();
    }
    if(startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[startingRow].length){
      throw new IllegalArgumentException();
    }
    return solveHelper(startingRow, startingCol, 1);//call helper method. start counting levels at 1
  }

  //helper method for solve
  private boolean solveHelper(int row, int col, int level){
    if(level > (board.length * board[0].length)){
      return true;//filled up board (visited all squares), return true
    }
    for (int i = 0; i < moves.length; i++){//loop through possible moves
      if(move(row, col, level)){//if successfully moved knight
        if(solveHelper(row + moves[i][0], col + moves[i][1], level + 1)){
          return true;//recursive call
        }
        board[row][col] = 0;//try different position
      }
    }
    return false;
  }


  // @throws IllegalStateException when the board contains non-zero values.
  // @throws IllegalArgumentException when either parameter is negative
  //  or out of bounds.
  // @returns the number of solutions from the starting position specified
  public int countSolutions(int startingRow, int startingCol){
    clear();
    if(!isEmpty()){
      throw new IllegalStateException();
    }
    if(startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[startingRow].length){
      throw new IllegalArgumentException();
    }
    return countHelper(startingRow, startingCol, 1);
  }

  public int countHelper(int row, int col, int level){
    if(level > (board.length * board[0].length)){
      return 1;//filled board, so it's a solution. add one to count
    }
    int count = 0;
    for(int i = 0; i < moves.length; i++){//loop through moves
      if(move(row, col, level)){
        count += countHelper(row + moves[i][0], col + moves[i][1], level + 1);//adds to count
        board[row][col] = 0;//removes knight
      }
    }
    return count;
  }



}
