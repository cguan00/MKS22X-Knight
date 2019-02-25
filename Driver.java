public class Driver{
  public static void main(String[] args) {
    KnightBoard board1 = new KnightBoard(5,5);
    KnightBoard board2 = new KnightBoard(3,4);
    KnightBoard board3 = new KnightBoard(5,2);
    KnightBoard board4 = new KnightBoard(6,6);
    KnightBoard board5 = new KnightBoard(2,2);
    KnightBoard board6 = new KnightBoard(1,1);
    KnightBoard board7 = new KnightBoard(7,7);

    try{
      KnightBoard boardA = new KnightBoard(-4,3);
    } catch (IllegalArgumentException e){
      System.out.println("cannot have negative numbers as constructor parameters");
    }

    System.out.println(board1);
    board1.fillOutGoingMoves();
    System.out.println(board1.movesToStringDebug());
    // System.out.println(board2);
    // System.out.println(board3);
    // System.out.println(board4);
    // System.out.println(board5);
    // System.out.println(board6);
    // System.out.println(board7);
    //
    // System.out.println(board1.isEmpty());//should be true
    // System.out.println(board2.isEmpty());//should be true
    // System.out.println(board3.isEmpty());//should be true
    // System.out.println(board4.isEmpty());//should be true
    // System.out.println(board5.isEmpty());//should be true
    // System.out.println(board6.isEmpty());//should be true
    // System.out.println(board7.isEmpty());//should be true
    // System.out.println("");
    //
    // System.out.println(board1.solve(0, 0));
    // System.out.println(board1);
    // System.out.println(board2.solve(0, 0));
    // System.out.println(board2);
    // System.out.println(board3.solve(0, 0));//should be false
    // System.out.println(board3);
    // System.out.println(board4.solve(0, 0));
    // System.out.println(board4);
    // System.out.println(board5.solve(0, 0));//should be false
    // System.out.println(board5);
    // System.out.println(board6.solve(0, 0));//should be false
    // System.out.println(board6);
    // System.out.println(board7.solve(0, 0));
    // System.out.println(board7);
    //
    // System.out.println(board1.countSolutions(0, 0));
    // System.out.println(board2.countSolutions(0, 0));
    // System.out.println(board3.countSolutions(0, 0));
    // // System.out.println(board4.countSolutions(0, 0));
    // System.out.println(board5.countSolutions(0, 0));
    // // System.out.println(board7.countSolutions(0, 0));


  }
}
