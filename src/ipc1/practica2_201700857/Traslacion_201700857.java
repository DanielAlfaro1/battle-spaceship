
package ipc1.practica2_201700857;


public class Traslacion_201700857 implements Runnable{
    Thread t;
    int y,posicion,avance=0,situacion,balita=545;
    
    
    public Traslacion_201700857(int y,int pos,int situacion){
        this.y=y;
        this.posicion=pos;
        this.situacion = situacion;
        t = new Thread (this);
        t.start();
    }
    
    
    
    @Override
    public void run() {
        try{
            if(situacion==1){
            do{
                avance = avance+1;
                Espacio_201700857.Enemigos[posicion].setLocation(avance,y);
                Thread.sleep(6);
            }while(avance<=700);
            }else{
                if(situacion==2){
                    do{
                        balita = balita-1;
                        Espacio_201700857.Balas[posicion].setLocation(balita, y);
                        Thread.sleep(6);
                    }while(balita>=-35);
                }
            }
//            t.stop();
        }catch (InterruptedException e){};
    }
    
}
