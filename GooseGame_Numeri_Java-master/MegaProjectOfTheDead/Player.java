import java.util.*;
class Player{
    protected String name; // Nom du Joueur
    protected Piece[] pieces; // Liste des pieces du joueur
    protected Board board;
    protected static Random ran = new Random();


    // Constructeur de Player a une seul piece
    public Player(String name){
        this(name,1);
    }

    //Constructeur de Player à nombre de Piece variable
    public Player(String name, int NbPiece){
        this.name=name;
        pieces = new Piece[NbPiece];
        for(int i=0; i<NbPiece;i++)
          pieces[i]=new Piece();
    }

    public Piece getPiece(){
      return pieces[0];
    }
    // Lancer de dés (renvoie un entier entre 1 et 6 inclus)
    private static int throwDice(){
        return ran.nextInt(6)+1;
    }

    //return true s'il peut joueur, sinon cela signifie que la partie est finie
    /*private boolean playTurn(){
      int nextCase= throwDice()+throwDice();
      if(nextCase);
      Case next = board.getCase(nextCase);
      board.removePiece(piece);
      next.setPiece(piece);
    }*/

    public String toString(){
        String res="joueur :" + name;
        for(int i =0 ;i<pieces.length;i++){
            res+="\n"+pieces[i].toString();
        }
        return res;
    }
    class Piece{
        private int canPlay; // Si canPlay est a 0 le pion peut ête deplacer, sinon non.
        private Case place;
        // Constructeur de Piece
        public Piece(){
            canPlay= 0;
            place=null;
        }
        public void setCase(Case a){
          place=a;
        }
        public String toString(){
            return "joueur : "+name+"  est à la case "+((place!=null)?place.toString():"de départ");
        }

        public void setPlay(int n){//met à -1 si le pièce est dans la prison/puit, met 2 si elle est à l'hotel
            canPlay=n;
        }
        public int getPlay(){
          return canPlay;
        }

    }

}
