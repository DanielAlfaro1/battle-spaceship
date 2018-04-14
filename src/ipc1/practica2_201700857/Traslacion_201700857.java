
package ipc1.practica2_201700857;

import java.awt.Color;

public class Traslacion_201700857 implements Runnable{
    public static Thread t;
    int y,posicion,avance=0,situacion,balita=545;
    int[][] lugarbala = new int[30][2];
    int algo=0,golpe=0;
    public static int  hits =0;
    int j;
    
    public void NoEscudo(){
    if(hits>4){
        Espacio_201700857.naveEscudo.setVisible(false);
        Espacio_201700857.nave.setVisible(true);
        Espacio_201700857.v=0;
        hits=0;
    }
}
    
    public Traslacion_201700857(int y,int pos,int situacion){
        this.y=y;
        this.posicion=pos;
        this.situacion = situacion;
        t = new Thread (this);
        t.start();
    }
    
    public void detener(){
        t.suspend();
    }
    
    public String choque(int x, int y){
        int p=0;
        if( (Espacio_201700857.x+6)<(x+50)&&(Espacio_201700857.x+100)>x&&(((Espacio_201700857.y+20)<y)||(Espacio_201700857.y+10)<y+50 )&&(Espacio_201700857.y+45)>y ){
            if (Espacio_201700857.v==1) {
              golpe=2;
            }else{
                System.out.println("hit1");
//            return("HIT");
                golpe=1;
            }
        }else{
        if((Espacio_201700857.x+55)<(x+50)&&(Espacio_201700857.x+83)>x&&((Espacio_201700857.y+45)<y)&&(Espacio_201700857.y+65)>y ){
            if(Espacio_201700857.v==1){
                golpe=2;
            }else{
                System.out.println("hit2");
//            return("HIT");
                golpe=1;
            
            }
        }
        }
        if(golpe==1){
            
            golpe=0;
            return("HIT");
            
        }else{if(golpe==2){
            hits++;
            golpe=0;
            
           
            return("LERO");
        }else{
            
        return("NOPE");
        }
    }
       
    }
    
    public String Impacto(int x,int y){
        int p=0;
        for (j=0;j<Espacio_201700857.Balas.length;j++){
            if(Espacio_201700857.coor[j][0]<(x+50)&&Espacio_201700857.coor[j][0]>(x)&&Espacio_201700857.coor[j][1]>(y-12)&&Espacio_201700857.coor[j][1]<(y+50)){
               p=1;
              Espacio_201700857.Balas[j].setLocation(700, y);
              Espacio_201700857.probamos[j].balita=-35;
                System.out.println("BIEN HECHO"+j);
                return("IMPACTO");
            }
            else{
                p=0;
            }
        }
        if(p==1){
            return("IMPACTO");
        }else{
            return("NOPE");
        }
    }
    
    @Override
    public void run() {
        try{
            if(situacion==1){
            do{
                avance = avance+1;
                Espacio_201700857.Enemigos[posicion].setLocation(avance,y);
                Impacto(avance,y);
                if(choque(avance,y).equals("HIT")){
                    Espacio_201700857.Enemigos[posicion].setLocation(avance-10,y);
                    Espacio_201700857.Enemigos[posicion].setLocation(701, y);
                    avance=701;
                    Espacio_201700857.vida=Espacio_201700857.vida-10;
                    Espacio_201700857.PorcLife.setText(String.valueOf(Espacio_201700857.vida)+"%");
                    Espacio_201700857.punch=Espacio_201700857.punch-10;
                    Espacio_201700857.ContPuntos.setText(String.valueOf(Espacio_201700857.punch));
                    if(Espacio_201700857.vida<=50){
                        Espacio_201700857.PorcLife.setForeground(Color.orange);
                    }
                    if(Espacio_201700857.vida==0){
                        Espacio_201700857.PorcLife.setForeground(Color.red);
                    Espacio_201700857.x=800;
                    Espacio_201700857.nave.setLocation(500,500);
                    }
//                    System.out.println(choque(avance,y));
                }
                if(choque(avance,y).equals("LERO")){
                    Espacio_201700857.Enemigos[posicion].setLocation(avance-10,y);
                    Espacio_201700857.Enemigos[posicion].setLocation(701, y);
                    avance=701;
                    Espacio_201700857.punch=Espacio_201700857.punch+25;
                    Espacio_201700857.ContPuntos.setText(String.valueOf(Espacio_201700857.punch));
                    Espacio_201700857.destroy++;
                    Espacio_201700857.ContDest.setText(String.valueOf(Espacio_201700857.destroy));
                    NoEscudo();
                }
                if(Impacto(avance,y).equals("IMPACTO")){
                    avance=avance-10;
                    System.out.println("IMPACTO");
                    Espacio_201700857.probamos[j].balita=-35;
                    NaveEnemiga_201700857.impac[posicion]++;
                    System.out.println("LLEVA ESTOS IMPACTOS "+NaveEnemiga_201700857.impac[posicion]);
                    if(NaveEnemiga_201700857.impac[posicion]>=3){
                    Espacio_201700857.Enemigos[posicion].setLocation(701, y);
                    avance=701;
                    Espacio_201700857.destroy++;
                    Espacio_201700857.punch=Espacio_201700857.punch+25;
                    Espacio_201700857.ContDest.setText(String.valueOf(Espacio_201700857.destroy));
                    Espacio_201700857.ContPuntos.setText(String.valueOf(Espacio_201700857.punch));
                    }
                }
                Thread.sleep(6);
            }while(avance<=700);
            }else{
                if(situacion==2){
                    do{
                        if (balita==-35){
                            Espacio_201700857.Balas[posicion].setLocation(-36, y);
                        }
                        balita = balita-1;
                        Espacio_201700857.Balas[posicion].setLocation(balita, y);
                        Espacio_201700857.coor[posicion][0]=balita;
                        Espacio_201700857.coor[posicion][1]=y;
                        Thread.sleep(6);
                    }while(balita>=-35);
                }
            }
        }catch (InterruptedException e){};
    }
    
}
