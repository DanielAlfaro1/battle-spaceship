package ipc1.practica2_201700857;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Espacio_201700857 {
JFrame V1;
JPanel Espacio,Stats;
public static JLabel Tiempo,fondo,nave,naveEscudo,Contador,Puntos,letra,ContPuntos,Segundos,Life,PorcLife,dest,ContDest;
JButton Arriba, Abajo;
Contador_201700857 timer;
NaveEnemiga_201700857 n;
public static JLabel[] Enemigos = new JLabel[50];
public static JLabel[] Balas = new JLabel[30];
public static NaveEnemiga_201700857 prueba;
NaveEnemiga_201700857 n1;
ArrayList componentes;
int up=0,down=0,left=0,right=0,b=0,a=0,posi=0;
public static int v=0;
public static int x= 550;
public static int y = 200;
public static int[][] coor= new int[50][2];
public static int pruebay,destroy=0,vida=100,punch=0;
public static Traslacion_201700857[] probamos = new Traslacion_201700857[30];

//public void Ship(){
//    for(int i=0;i<Enemigos.length;i++){
//       Enemigos[i] = new JLabel();
//       Enemigos[i].setIcon(new ImageIcon("img/phantom.png"));
//        Enemigos[i].setBounds(800,0,60,50);
//        fondo.add(Enemigos[i]);
//    }
//}
public void Escudo(int visi){
    
    if (visi>=3){
        nave.setVisible(false);
        naveEscudo.setVisible(true);
        v=1;
        visi=0;
    }
    
}
public void NoEscudo(){
    if(Traslacion_201700857.hits>=3){
        naveEscudo.setVisible(false);
        nave.setVisible(true);
        v=0;
        Traslacion_201700857.hits=0;
    }
}

public void choque(){
    nave.setVisible(false);
    naveEscudo.setVisible(true);
}

public void CrearPanel(){
    //Paneles
    Espacio = new JPanel();
    Espacio.setLayout(null);
    Stats = new JPanel();
    Stats.setLayout(null);
    Stats.setBounds(700,0,150,500);
        
    //Labels
    fondo = new JLabel();
    fondo.setIcon(new ImageIcon("img/Espacio.png"));
    fondo.setBounds(0,0,700,500);
    Contador = new JLabel("00");
    Contador.setBounds(50,15,75,50);
    Segundos = new JLabel("SEGUNDOS");
    Segundos.setBounds(50,65,75,25);
    Puntos = new JLabel("PUNTOS");
    Puntos.setBounds(50,200,75,20);
    letra = new JLabel("s");
    letra.setBounds(130,15,20,20);
    ContPuntos = new JLabel("00");
    ContPuntos.setBounds(50,140,75,50);
    Life = new JLabel("PORCENTAJE DE VIDA");
    Life.setBounds(50,320,75,20);
    PorcLife = new JLabel("100%");
    PorcLife.setBounds(50,240,75,50);
    dest  = new JLabel("NAVES DESTRUIDAS");
    dest.setBounds(50,395,75,50);
    ContDest = new JLabel();
    ContDest.setBounds(50,315,75,50);
    Tiempo = new JLabel("00");
    Tiempo.setBounds(50,450,75,50);
    //Nave
    nave = new JLabel();
    nave.setBounds(x,y,100,75);
    nave.setIcon(new ImageIcon("img/fragata.png"));
    
    naveEscudo = new JLabel();
    naveEscudo.setBounds(x,y,100,75);
    naveEscudo.setIcon(new ImageIcon("img/fragataescudo.png"));
    naveEscudo.setVisible(false);
   // Boton
   Arriba = new JButton("ARRIBA");
   Arriba.setBounds(0,130,100,50);
   Arriba.addMouseListener(accion);
   Abajo = new JButton("ABAJO");
   Abajo.setBounds(0,200,100,50);
   Abajo.addMouseListener(accion);
   //Agegar objetos
   Espacio.add(fondo);
   Espacio.add(Stats);
//   Stats.add(Tiempo);
   Stats.add(Contador);
   Stats.add(letra);
   Stats.add(Segundos);
   Stats.add(Puntos);
   Stats.add(ContPuntos);
   Stats.add(Life);
   Stats.add(PorcLife);
   Stats.add(dest);
   Stats.add(ContDest);
   fondo.add(nave);
   fondo.add(naveEscudo);
   Espacio.addKeyListener(teclado);
   Espacio.setFocusable(true);
  Espacio.setVisible(true); 
  
  //Prueba
  for(int i=0;i<Enemigos.length;i++){
       Enemigos[i] = new JLabel();
       Enemigos[i].setIcon(new ImageIcon("img/phantom.png"));
        Enemigos[i].setBounds(800,0,60,50);
        fondo.add(Enemigos[i]);
    }
  for (int i=0;i<Balas.length;i++){
      Balas[i]=new JLabel();
      Balas[i].setIcon(new ImageIcon("img/proyectil.png"));
      Balas[i].setBounds(800,100,30,20);
      fondo.add(Balas[i]);
  }
    
}
public void CrearVentana(){
    V1 = new JFrame("MINI-GALAGA");
    V1.setBounds(150,150,850,500);
    V1.add(Espacio);
    V1.setVisible(true);
    V1.setDefaultCloseOperation(V1.EXIT_ON_CLOSE);
    V1.addKeyListener(teclado);
    
}
public Espacio_201700857(){
//    Ship();
    
    CrearPanel();
    CrearVentana();
    timer = new Contador_201700857();
}

KeyListener teclado = new KeyListener(){
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_W){
        if(y>=25){
              y=y-25;
              nave.setLocation(x, y);
              naveEscudo.setLocation(x,y);
            }
    }
    
    if(e.getKeyCode()==KeyEvent.VK_S){
        if(y<=375){
                y=y+25;
                nave.setLocation(x, y);
                naveEscudo.setLocation(x,y);
            }
        }
        
        if(e.getKeyCode()==KeyEvent.VK_UP){
            up++;
            System.out.println(up);
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            down++;
            System.out.println(down);
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            left++;
            System.out.println(left);
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            right++;
            System.out.println(right);
        }
        if(e.getKeyCode()==KeyEvent.VK_B){
            b++;
            System.out.println(b);
        }
        if(e.getKeyCode()==KeyEvent.VK_A){
            a++;
            System.out.println(a);
            if(up==2&&down==2&&left==2&&right==2&&b==1&&a==1){
                up=0;
                down=0;
                left=0;
                right=0;
                b=0;
                a=0;
                int m=3;
                Escudo(m);
//                nave.setVisible(false);
//                naveEscudo.setVisible(true);
                
            }else{
                up=0;
                down=0;
                left=0;
                right=0;
                b=0;
                a=0;
            }        
    }
        
        
        if(e.getKeyCode()==KeyEvent.VK_R){
//            nave.setVisible(true);
//                naveEscudo.setVisible(false);
            int aqui =3;
                NoEscudo();
        }
        if(e.getKeyCode()==KeyEvent.VK_P){
            prueba = new NaveEnemiga_201700857("prueba");
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            if(posi==Balas.length){
                System.out.println("SE AGOTÓ LA MUNICIÓN");
                
                posi=0;
            }
            Balas[posi].setLocation(x,y+23);
            probamos[posi] = new Traslacion_201700857(y+23,posi,2);
            posi++;
            
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
};


MouseListener accion = new MouseListener(){
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==Arriba){
//            if(y>=25){
//              y=y-25;
//              nave.setLocation(x, y);
//            }
//            nave.setVisible(true);
//            naveEscudo.setVisible(false);
//        añadir(1);
        }
        if (e.getSource()==Abajo){
            if(y<=375){
                y=y+25;
                nave.setLocation(x, y);
            }
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
};
}
