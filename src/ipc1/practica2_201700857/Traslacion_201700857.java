
package ipc1.practica2_201700857;


public class Traslacion_201700857 implements Runnable{
    Thread t;
    int y,posicion,avance=0,situacion,balita=545;
    int[][] lugarbala = new int[30][2];
    int algo=0;
    int j;
    
    
    public Traslacion_201700857(int y,int pos,int situacion){
        this.y=y;
        this.posicion=pos;
        this.situacion = situacion;
        t = new Thread (this);
        t.start();
    }
    
    public String Impacto(int x,int y){
        int p=0;
        for (j=0;j<Espacio_201700857.Balas.length;j++){
            if(Espacio_201700857.coor[j][0]<(x+50)&&Espacio_201700857.coor[j][0]>(x)&&Espacio_201700857.coor[j][1]>(y-5)&&Espacio_201700857.coor[j][1]<(y+50)){
               p=1;
              Espacio_201700857.Balas[j].setLocation(700, y);
              Espacio_201700857.probamos.balita=-35;
              
                System.out.println("BIEN HECHO"+j);
                return("IMPACTO");
//                 algo++;
            }
            else{
//                System.out.println(x);
//                System.out.println(y);
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
                if(Impacto(avance,y).equals("IMPACTO")){
                    avance=avance-10;
                    System.out.println("IMPACTO");
                    Espacio_201700857.probamos.balita=-35;
                    
                    NaveEnemiga_201700857.impac[posicion]++;
                    System.out.println("LLEVA ESTOS IMPACTOS "+NaveEnemiga_201700857.impac[posicion]);
                    if(NaveEnemiga_201700857.impac[posicion]==3){
                    Espacio_201700857.Enemigos[posicion].setLocation(701, y);
                    avance=701;
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
//            t.stop();
        }catch (InterruptedException e){};
    }
    
}
