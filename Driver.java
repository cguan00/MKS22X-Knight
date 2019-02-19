public class Driver{
  public static void main(String[] args) {
    KnightBoard board1 = new KnightBoard(5,5);
    KnightBoard board2 = new KnightBoard(8,8);

    try{
      KnightBoard board3 = new KnightBoard(-4,3);
    } catch (IllegalArgumentException e){
      System.out.println("cannot have negative numbers as constructor parameters");
    }

    try{
      KnightBoard board3 = new KnightBoard(3, -4);
    } catch (IllegalArgumentException e){
      System.out.println("cannot have negative numbers as constructor parameters");
    }

    System.out.println(board1);
    System.out.println(board1.isEmpty());//should be true
    System.out.println("");
    System.out.println(board2);
    board1.solve(0, 0);
    System.out.println(board1);
  }
}
