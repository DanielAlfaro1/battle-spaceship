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
JPanel Espacio;
JLabel Tiempo,fondo,nave,naveEscudo;
JButton Arriba, Abajo;
NaveEnemiga_201700857 n;
public static JLabel[] Enemigos = new JLabel[50];
public static JLabel[] Balas = new JLabel[30];
NaveEnemiga_201700857 n1;
ArrayList componentes;
int up=0,down=0,left=0,right=0,b=0,a=0,posi=0;
int x= 550;
int y = 200;
public static int[][] coor= new int[30][2];
public static int pruebay;
public static Traslacion_201700857 probamos;

//public void Ship(){
//    for(int i=0;i<Enemigos.length;i++){
//       Enemigos[i] = new JLabel();
//       Enemigos[i].setIcon(new ImageIcon("img/phantom.png"));
//        Enemigos[i].setBounds(800,0,60,50);
//        fondo.add(Enemigos[i]);
//    }
//}

public void Arriba(NaveEnemiga_201700857 n){
    Espacio.add(n.enemigo);
}

public void añadir(int n){
    Enemigos[n].setBounds(0,0,60,50);
    fondo.add(Enemigos[n]);
}

public void CrearPanel(){
    //Paneles
    Espacio = new JPanel();
    Espacio.setLayout(null);
        
    //Labels
    fondo = new JLabel();
    fondo.setIcon(new ImageIcon("img/Espacio.png"));
    fondo.setBounds(0,0,700,500);
    //Nave
    nave = new JLabel();
    nave.setBounds(x,y,100,75);
    nave.setIcon(new ImageIcon("img/fragata.png"));
    
    naveEscudo = new JLabel();
    naveEscudo.setBounds(x,y,100,75);
    naveEscudo.setIcon(new ImageIcon("img/fragataShield2.png"));
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
//   Espacio.add(Arriba);
//   Espacio.add(Abajo);
//   Espacio.add(nave);
//   fondo.add(Arriba);
//   fondo.add(Abajo);
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
    V1.setBounds(150,150,700,500);
    V1.add(Espacio);
    V1.setVisible(true);
    V1.setDefaultCloseOperation(V1.EXIT_ON_CLOSE);
    V1.addKeyListener(teclado);
}
public Espacio_201700857(){
//    Ship();
    CrearPanel();
    CrearVentana();
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
                nave.setVisible(false);
                naveEscudo.setVisible(true);
                
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
            nave.setVisible(true);
                naveEscudo.setVisible(false);
        }
        if(e.getKeyCode()==KeyEvent.VK_P){
            NaveEnemiga_201700857 prueba = new NaveEnemiga_201700857("prueba");
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            if(posi==Balas.length){
                System.out.println("SE AGOTÓ LA MUNICIÓN");
                
                posi=0;
            }
            Balas[posi].setLocation(x,y+23);
            probamos = new Traslacion_201700857(y+23,posi,2);
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
        añadir(1);
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
