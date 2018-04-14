
package ipc1.practica2_201700857;

public class Contador_201700857 implements Runnable{
  public static  Thread t;
    int tiempo = 0;
    public Contador_201700857(){
        t = new Thread(this,"Contador");
        t.start();
    }

    @Override
    public void run() {
     try{
         do{
         Espacio_201700857.Contador.setText(String.valueOf(tiempo));
         System.out.println(tiempo);
         tiempo++;
         Thread.sleep(1000);
         }while(tiempo<61);
//             Espacio_201700857.probamos
            if(tiempo==61){
//            Espacio_201700857.prueba.stop();
            NaveEnemiga_201700857.t.suspend();
            Traslacion_201700857.t.suspend();
         }
         
     }catch(InterruptedException e){};
    }
}
