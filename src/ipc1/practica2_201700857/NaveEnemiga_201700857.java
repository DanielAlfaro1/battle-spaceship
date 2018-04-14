
package ipc1.practica2_201700857;

import javax.swing.*;

public class NaveEnemiga_201700857 implements Runnable {
    public static Thread t;
    String nave;
    JLabel[] Enemys;
    JLabel enemigo = new JLabel();
    public static Traslacion_201700857 tr;
    public static int[] impac = new int[50];
    
    public NaveEnemiga_201700857(){
//        t = new Thread(this,"Nave");
//        t.start();
//    enemigo = new JLabel();
    enemigo.setBounds(0,0,60,50);
    enemigo.setIcon(new ImageIcon("img/phantom"));
    enemigo.setVisible(true);
    t = new Thread(this,"enemigo");
    t.start();
    }
    
    public NaveEnemiga_201700857(String nave){
        this.nave = nave;
                t = new Thread (this,"nave");
                t.start();
    }
    
    public void stop(){
        t.suspend();
    }
//    public NaveEnemiga_201700857(JLabel[] ship){
////        
//    }
    public void run(){
        try{
            for(int i=0;i<Espacio_201700857.Enemigos.length;i++){
                int y = 0;
                int ran = (int)(Math.random()*(3000-2500+1)+2500);
                y = (int)(Math.random()*420)+10;
                Espacio_201700857.Enemigos[i].setLocation(0, y);
                System.out.println(nave+" - valor: "+i);
                NaveEnemiga_201700857.impac[i]=0;
//                System.out.println(ran);
                tr = new Traslacion_201700857(y,i,1);
            Thread.sleep(ran);
            }
//            enemigo.setBounds(0,0,60,50);
//            enemigo.setIcon(new ImageIcon("img/phantom"));
//            enemigo.setVisible(true);
        }catch (InterruptedException e){};
    }
}
