import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class MenuT extends JFrame {
  private JPanel help,main;
  private Pan goose,numeri;
  private CardLayout pile;
  public MenuT(){
    setTitle("Game");
    setSize(400,400);
    Container content = getContentPane();
    pile = new CardLayout(30,10);
    content.setLayout(pile);
    help = new JPanel();
    main = new JPanel();
    //main.setBackground(Color.blue);
    main.setOpaque(false);
    main.setLayout(new BoxLayout(main,BoxLayout.PAGE_AXIS));
    JButton[] buttons = new JButton[4];
    buttons[0] = new JButton("goose");
    buttons[0].addActionListener(e->{
      pile.show(content,"goose");
    });
    buttons[1] = new JButton("numeri");
    buttons[1].addActionListener(e->{
      pile.show(content,"numeri");
    });
    buttons[2] = new JButton("help");
    buttons[3] = new JButton("quit");
    buttons[3].addActionListener(e->{
      this.dispose();
    });
    for ( JButton a : buttons ) {
      a.setFont(new Font("Monospaced",Font.PLAIN,12));
      a.setContentAreaFilled(false);
      a.setForeground(Color.WHITE);
      main.add(Box.createVerticalGlue());
      a.setAlignmentX(Component.CENTER_ALIGNMENT);
      main.add(a);
    }
    content.setBackground(Color.BLACK);
    goose = new Pan(6,content);
    numeri = new Pan(6,content);
    content.add(main,"main");
    content.add(help,"help");
    content.add(goose,"goose");
    content.add(numeri,"numeri");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
    public static void main(String[] args) {
      EventQueue.invokeLater(()->{
        MenuT a = new MenuT();
        a.setVisible(true);
        a.pack();
      });
    }
   class Pan extends JPanel{
     private int nbButtons;
     private JButton[] variant;
     private JButton prev,next,back;
     private CardLayout stack;
     private JPanel panVar,panBut;
     public Pan(int nbButtons,Container menu){
       setBackground(Color.BLUE);
       panVar = new JPanel();
       panBut = new JPanel();
       panVar.setOpaque(false);
       panBut.setOpaque(false);
       this.nbButtons=nbButtons;
       JButton[] variant= new JButton[nbButtons];
       stack = new CardLayout(30,10);
       panVar.setLayout(stack);
       for (int i=0; i< nbButtons;i++) {
         variant[i]=new JButton("Variante n°"+i);
         variant[i].setFont(new Font("LucidaSansRegular.ttf",Font.PLAIN,12));
         variant[i].setForeground(Color.white);
         variant[i].setContentAreaFilled(false);
         panVar.add(variant[i],"Variante "+Integer.toString(i));
       }
       prev = new JButton("previous");panBut.add(prev);
       prev.addActionListener(e->{
         stack.previous(panVar);
       });
       next = new JButton("next");panBut.add(next);
       next.addActionListener(e->{
         stack.next(panVar);
       });
       back=new JButton("back");panBut.add(back);
       back.addActionListener(e->{
        CardLayout a = (CardLayout) menu.getLayout();
         a.show(menu,"main");
       });
       this.add(panVar);
       this.add(panBut);
     }
   }
}
