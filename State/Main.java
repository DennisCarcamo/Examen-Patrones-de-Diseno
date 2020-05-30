/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Thread.sleep;

/**
 *
 * @author dejoc
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException
    {   
        Clima objClima = new Clima();
        System.out.println();
        System.out.println("                  Bienvenido a COPECO");
        System.out.println("Esta es una simulacion de dias con diferentes temperaturas\n");
        sleep(4000);
        objClima.setEstado(new EstadoNormal(objClima));
        objClima.mostrarTemperaturaAviso();
        sleep(4000);
        objClima.setEstado( new EstadoFrio(objClima) );
        objClima.mostrarTemperaturaAviso();
        sleep(4000);
        objClima.setEstado( new EstadoNormal(objClima) );
        objClima.mostrarTemperaturaAviso();
        sleep(4000);
        objClima.setEstado( new EstadoNormal(objClima) );
        objClima.mostrarTemperaturaAviso();
        sleep(4000);
        objClima.setEstado( new EstadoCaliente(objClima) );
        objClima.mostrarTemperaturaAviso();
        System.out.print("********************** Simulacion Terminada ***************************");
    }
}

class Clima
{
    private EstadoClima objEstadoClima;
    // -------------------------------------------
    public Clima() {
         this.objEstadoClima = new EstadoCaliente(this);
    }
    // -------------------------------------------
    public void setEstado( EstadoClima objEstadoClima ) {
        this.objEstadoClima = objEstadoClima;
    }
    // -------------------------------------------
    public void mostrarTemperaturaAviso() {
        this.objEstadoClima.mostrarTemperatura();
    }
}

class EstadoCaliente extends EstadoClima {

    public EstadoCaliente(Clima objClima) {
        this.objClima = objClima;
    }

    // -------------------------------------------

    @Override
    public void mostrarTemperatura() {
        System.out.println("Temperatura actual: 24 o mas  grados C.");
        Recomendacion rec =  new Recomendacion(1);
        System.out.println(rec.toString());
    }
}


abstract class EstadoClima
{
     protected Clima objClima;
    // Método que deberán crear las clases que hereden de ésta
    public abstract void mostrarTemperatura();
}

class Recomendacion {
    String mensaje = "";
    public Recomendacion(int a) {
        if (a == 1) {
            mensaje = "Calor, Mucha Calor, deberias comprar un helado";
        } else if(a==2){
            mensaje = "No hay Problema Con el Clima, Disfrute su dia!";
        }else{
            mensaje = "Si puedes quedate en casita abrigadito";
        }
    }

    @Override
    public String toString() {
        return "Recomendacion: "+ mensaje +"\n";
    }
}



class EstadoNormal extends EstadoClima
{
     public EstadoNormal( Clima objClima ) {
         this.objClima = objClima;
    }
    // -------------------------------------------
    @Override
     public void mostrarTemperatura() {
        System.out.println("Temperatura actual: 18 - 23  grados C.");
        Recomendacion rec =  new Recomendacion(2);
        System.out.println(rec.toString());
    }
}

class EstadoFrio extends EstadoClima {

    public EstadoFrio(Clima objClima) {
        this.objClima = objClima;
    }

    // -------------------------------------------

    @Override
    public void mostrarTemperatura() {
        System.out.println("Temperatura actual: 17 o menos grados C.");
        Recomendacion rec =  new Recomendacion(3);
        System.out.println(rec.toString());
    }
}


