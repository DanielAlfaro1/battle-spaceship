package ipc1.practica2_201700857;


public class Escudo_201700857 implements Runnable{
    public static Thread t;
    public static Traslacion_201700857 sh;
    
    public Escudo_201700857(){
        t = new Thread(this,"Escudo");
        t.start();
    }

    @Override
    public void run() {
        for(int i =0;i<Espacio_201700857.Escudo.length;i++){
            int y=0;
            int random = (int)(Math.random()*(1500-1000+1)+2500);
            y = (int)(Math.random()*420)+10;
            Espacio_201700857.Escudo[i].setLocation(0,y);
            sh = new Traslacion_201700857(y,i,3);
            try{
                Thread.sleep(random);
            }catch(InterruptedException e){};
            
        }
    }
}
