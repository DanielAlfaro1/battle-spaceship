package ipc1.practica2_201700857;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.applet.AudioClip;
import java.applet.Applet;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Espacio_201700857 {
JFrame V1;
JPanel Espacio,Stats;
public static JLabel Tiempo,fondo,nave,naveEscudo,Contador,Puntos,letra,ContPuntos,Segundos,Life,PorcLife,dest,ContDest,status;
JButton Arriba, Abajo;
Contador_201700857 timer;
NaveEnemiga_201700857 n;
public static JLabel[] Escudo = new JLabel[3];
public static JLabel[] Enemigos = new JLabel[50];
public static JLabel[] Balas = new JLabel[30];
public static NaveEnemiga_201700857 prueba;
NaveEnemiga_201700857 n1;
//ArrayList componentes;
 AudioClip sonido;
int up=0,down=0,left=0,right=0,b=0,a=0,posi=0;
public static int v=0;
public static int x= 550;
public static int y = 200;
public static int[][] coor= new int[50][2];
public static int pruebay,destroy=0,vida=100,punch=0,escudito=0;
public static Traslacion_201700857[] probamos = new Traslacion_201700857[30];

public static void Escudo(int visi){
    if (visi==1){
        Espacio_201700857.status.setIcon(new ImageIcon("img/shield1.png"));
    }else{
        if(visi==2){
            Espacio_201700857.status.setIcon(new ImageIcon("img/shield2.png"));
        }else{
            if (visi>=3){
        nave.setVisible(false);
        naveEscudo.setVisible(true);
        v=1;
        Espacio_201700857.status.setIcon(new ImageIcon("img/shield3.png"));
        visi=0;
    }
        }
    }
    
    
}
public void NoEscudo(){
    
        naveEscudo.setVisible(false);
        nave.setVisible(true);
        v=0;
        Traslacion_201700857.hits=0;
        status.setIcon(new ImageIcon("img/shield0.png"));
}

public void choque(){
    nave.setVisible(false);
    naveEscudo.setVisible(true);
}

public void CrearPanel(){
    Font font = new Font("Arial Black",Font.BOLD,12);
    
    try{
        FileInputStream fis;
        Player player;
        fis = new FileInputStream("C:\\Users\\Bminas\\Documents\\NetBeansProjects\\[IPC1]Practica2_201700857\\img");
        BufferedInputStream bis = new BufferedInputStream(fis);
        
        player = new Player(bis);
        player.play();
    }catch(JavaLayerException e){
        e.printStackTrace();
    }
    
    
    //Paneles
    Espacio = new JPanel();
    Espacio.setLayout(null);
    Stats = new JPanel();
    Stats.setLayout(null);
    Stats.setBounds(700,0,150,500);
        
    //Labels
   
    sonido = java.applet.Applet.newAudioClip(getClass().getResource("ipc1practica2_201700857/Halo2.wav"));
    sonido.play();
    fondo = new JLabel();
    fondo.setIcon(new ImageIcon("img/Espacio.png"));
    fondo.setBounds(0,0,700,500);
    Contador = new JLabel("00");
    Contador.setBounds(55,15,75,25);
    Contador.setFont(font);
    Segundos = new JLabel("SEGUNDOS");
    Segundos.setBounds(25,30,125,25);
    Segundos.setFont(font);
    Puntos = new JLabel("PUNTOS");
    Puntos.setBounds(30,65,75,20);
    Puntos.setFont(font);
    ContPuntos = new JLabel("00");
    ContPuntos.setBounds(50,50,75,25);
    ContPuntos.setFont(font);
    Life = new JLabel("VIDA");
    Life.setBounds(50,320,75,20);
    Life.setFont(font);
    PorcLife = new JLabel("100%");
    PorcLife.setBounds(50,240,75,50);
    PorcLife.setFont(font);
    dest  = new JLabel("NAVES DESTRUIDAS");
    dest.setBounds(0,100,200,25);
    dest.setFont(font);
    ContDest = new JLabel("0");
    ContDest.setBounds(55,85,75,20);
    ContDest.setFont(font);
    Tiempo = new JLabel("00");
    Tiempo.setBounds(50,450,75,50);
    Tiempo.setFont(font);
    status = new JLabel();
    status.setIcon(new ImageIcon("img/shield0.png"));
    status.setBounds(43,140,50,50);
    //Nave
    nave = new JLabel();
    nave.setBounds(x,y,100,75);
    nave.setIcon(new ImageIcon("img/fragata.png"));
    
    naveEscudo = new JLabel();
    naveEscudo.setBounds(x,y,100,75);
    naveEscudo.setIcon(new ImageIcon("img/fragataescudo.png"));
    naveEscudo.setVisible(false);
   //Agegar objetos
   Espacio.add(fondo);
   Espacio.add(Stats);
//   Stats.add(Tiempo);
   Stats.add(Contador);
//   Stats.add(letra);
   Stats.add(Segundos);
   Stats.add(Puntos);
   Stats.add(ContPuntos);
   Stats.add(Life);
   Stats.add(PorcLife);
   Stats.add(dest);
   Stats.add(ContDest);
   Stats.add(status);
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
  for(int i=0;i<Escudo.length;i++){
      Escudo[i] = new JLabel();
      Escudo[i].setIcon(new ImageIcon("img/shield3.png"));
      Escudo[i].setBounds(900,50,50,50);
      Escudo[i].setVisible(true);
      fondo.add(Escudo[i]);
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
    prueba = new NaveEnemiga_201700857("prueba");
    
}

KeyListener teclado = new KeyListener(){
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_W){
            
            System.out.println(up);
    }
    
    if(e.getKeyCode()==KeyEvent.VK_S){
        
            System.out.println(down);
        
        }
        
        if(e.getKeyCode()==KeyEvent.VK_UP){
            up++;
            if(y>=25){
              y=y-25;
              nave.setLocation(x, y);
              naveEscudo.setLocation(x,y);
            }
        
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            down++;
            
            if(y<=375){
                y=y+25;
                nave.setLocation(x, y);
                naveEscudo.setLocation(x,y);
            }
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
//            Escudo_201700857 esc = new Escudo_201700857();
//            System.out.println(b);
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
                Escudo(3);
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
        if (e.getKeyCode()==KeyEvent.VK_R){
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

}
