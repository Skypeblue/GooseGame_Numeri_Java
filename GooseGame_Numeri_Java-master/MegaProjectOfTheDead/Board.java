public class Board{
  private Player[] players;
  private Case [] board;


  public void print(){
    for (Player a : players ) {
      System.out.println(a);
    }
  }

  public int length(){
    return board.length;
  }

  public void removePiece(Player.Piece removed){
    for (Case a : board ){
      if(a.getPiece()==removed)a.setPiece(null);
      break;
    }
  }

  public Case getCase(int i){
    return board[i];
  }

  public void initGoose(){
    for(int i=0;i<63;i++{
      if (i==5)board[i]=new CasePont(null,"pont",board[11]);
      else if(i==18)board[i]=new CaseHotel(null,"hotel");
      else if(i==30)board[i]=new CasePrison(null,"prison");
      else if(i==41)board[i]=new CasePont(null,"pont",board[29]);
      else if(i==51)board[i]=new CasePrison(null,"prison");
      else if(i==57)board[i]=new CasePont(null,"pont",board[0]);
      else board[i]=new CaseNormal(null,"normal");
    }
  }

}
