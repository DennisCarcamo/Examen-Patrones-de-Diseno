/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;


import java.util.ArrayList;
/**
 *
 * @author dejoc
 */
public class Main
{
    public static void main(String[] args)
    {
        // Crear el objeto Cocinero
        Cocinero objCocoBaleadas = new Cocinero();
        Scanner sc = new Scanner(System.in);
        int operation = 0;
        char otherTrans;
        boolean contin = true;
        System.out.println("Bienvenido a Coco Baleadas");

        while (contin) {
            System.out.println("Porfavor ingrese:\n1 para solicitar una baleada Sencilla\n"
                                                + "2 para solicitar una baleada Suprema\n"
                                                + "3 para solicitar una baleada Extrema");
            operation = sc.nextInt();

            if (operation == 1) {
                BuilderBaleada balSencilla  = new constructorBaleadaSencilla();
                objCocoBaleadas.cocinarBaleada( balSencilla );
                Baleada baleadaSencilla = balSencilla.getBaleada();
                mostrarCaracteristica( baleadaSencilla );

            } else if (operation == 2){
                BuilderBaleada balSuprema = new constructorBaleadaSuprema();
                objCocoBaleadas.cocinarBaleada( balSuprema );
                Baleada baleadaSuprema = balSuprema.getBaleada();
                mostrarCaracteristica( baleadaSuprema );

            }else if (operation == 3){
                BuilderBaleada balExtrema  = new constructorBaleadaExtrema();
                objCocoBaleadas.cocinarBaleada( balExtrema );
                Baleada baleadaExtrema = balExtrema.getBaleada();
                mostrarCaracteristica( baleadaExtrema );
            }else{
                System.out.println("Opcion no valida");
            }

            System.out.println("Por Favor ingrese  y/Y para solicitar mas baleadas o culaquier otra tecla para salir");
            otherTrans = sc.next().charAt(0);
            if (otherTrans == 'Y' || otherTrans == 'y') {
                contin = true;
            } else {
                System.out.println("Gracias por elegir COCO Baleadas");
                contin = false; 
            }
        }
    }
    // --------------------------------
    public static void mostrarCaracteristica (Baleada baleada )
    {
        System.out.println("====================== Detalles de la Baleada ======================");
        System.out.println( " Tortilla de Harina: " + baleada.gettortillaDeHarina() );
        System.out.println( "           Frijoles: " + baleada.getfrijoles() );
        System.out.println( "Queso y Mantequilla: " + baleada.getquesoYmantequilla() );
        System.out.println( "              Huevo: " + baleada.getHuevo() );
        System.out.println( "              Carne: " + baleada.getcarne() );
        System.out.println( "           Aguacate: " + baleada.getaguacate() );
        System.out.println("=====================================================================\n");
    }
}
//__________________________________________________________________________________________________________________________________________________________________________

abstract class BuilderBaleada
{
     protected Baleada baleada;
    // ------------------------------
    public Baleada getBaleada() {
        return this.baleada;
    }
    // ------------------------------
     public void crearNuevoBaleada() {
        this.baleada= new Baleada();
    }
    // ------------------------------------
    // Métodos que deberán ser construídos por las clases que hereden de ésta
     public abstract void cocinartortillaDeHarina();
     public abstract void cocinarFrijoles();
     public abstract void cocinarquesoYmantequilla();
     public abstract void cocinarHuevo();
     public abstract void cocinarCarne();
     public abstract void cocinarAguacate();
     
}

//__________________________________________________________________________________________________________________________________________________________________________
 class Baleada
{
    private boolean tortillaDeHarina = false;
    private boolean frijoles = false;
    private Boolean quesoYmantequilla = false;
    private Boolean huevo = false;
    private Boolean carne = false;
    private Boolean aguacate = false;
    
    // -------------------------------------------
    public Baleada() {
    }
    // -------------------------------------------
    public Boolean gettortillaDeHarina() {
        return this.tortillaDeHarina;
    }
    // -------------------------------------------
    public void settortillaDeHarina(Boolean tortillaDeHarina) {
        this.tortillaDeHarina = tortillaDeHarina;
    }
    // -------------------------------------------
    public Boolean getfrijoles() {
        return this.frijoles;
    }
    // -------------------------------------------
    public void setfrijoles(Boolean frijoles) {
        this.frijoles = frijoles;
    }
    // -------------------------------------------
    public Boolean getquesoYmantequilla() {
        return this.quesoYmantequilla;
    }
    // -------------------------------------------
    public void setquesoYmantequilla(Boolean quesoYmantequilla) {
        this.quesoYmantequilla = quesoYmantequilla;
    }
    // -------------------------------------------
    public Boolean getHuevo() {
        return this.huevo;
    }
    // -------------------------------------------
    public void setHuevo(boolean huevo) {
       this.huevo = huevo;
    }
    // -------------------------------------------
    public Boolean getcarne() {
        return this.carne;
    }

    //---------------------------------------------
    public void setcarne(boolean carne) {
        this.carne = carne;
    }

    //-------------------------------------------

     public void setaguacate(Boolean aguacate) {
       this.aguacate = aguacate;
    }

    //-------------------------------------------
    public Boolean getaguacate() {
        return this.aguacate;
    }
}
//__________________________________________________________________________________________________________________________________________________________________________
class constructorBaleadaSencilla extends BuilderBaleada
{
    public constructorBaleadaSencilla() {
    }
    // ------------------------------
    @Override
     public void cocinartortillaDeHarina() {
        this.baleada.settortillaDeHarina(true);
    }
    // ------------------------------
    @Override
     public void cocinarFrijoles() {
        this.baleada.setfrijoles(true);
    }
    // ------------------------------
    @Override
     public void cocinarquesoYmantequilla() {
        this.baleada.setquesoYmantequilla(true);
    }
    // ------------------------------
    @Override
     public void cocinarHuevo() {
        this.baleada.setHuevo(false);
    }
    @Override
     public void cocinarCarne() {
        this.baleada.setcarne(false);
    }
    @Override
    public void cocinarAguacate() {
        this.baleada.setaguacate(false);
    }
}
//__________________________________________________________________________________________________________________________________________________________________________
class constructorBaleadaExtrema extends BuilderBaleada {

    public constructorBaleadaExtrema() {
    }

    // ------------------------------

    @Override
    public void cocinartortillaDeHarina() {
       this.baleada.settortillaDeHarina(true);
   }
   // ------------------------------
   @Override
    public void cocinarFrijoles() {
       this.baleada.setfrijoles(true);
   }
   // ------------------------------
   @Override
    public void cocinarquesoYmantequilla() {
       this.baleada.setquesoYmantequilla(true);
   }
   // ------------------------------
   @Override
    public void cocinarHuevo() {
       this.baleada.setHuevo(true);
   }
   @Override
    public void cocinarCarne() {
       this.baleada.setcarne(true);
   }
   @Override
   public void cocinarAguacate() {
       this.baleada.setaguacate(true);
   }
}
//__________________________________________________________________________________________________________________________________________________________________________
class constructorBaleadaSuprema extends BuilderBaleada
{
    public constructorBaleadaSuprema() {
    }

    @Override
    public void cocinartortillaDeHarina() {
       this.baleada.settortillaDeHarina(true);
   }
   // ------------------------------
   @Override
    public void cocinarFrijoles() {
       this.baleada.setfrijoles(true);
   }
   // ------------------------------
   @Override
    public void cocinarquesoYmantequilla() {
       this.baleada.setquesoYmantequilla(true);
   }
   // ------------------------------
   @Override
    public void cocinarHuevo() {
       this.baleada.setHuevo(true);
   }
   @Override
    public void cocinarCarne() {
       this.baleada.setcarne(false);
   }
   @Override
   public void cocinarAguacate() {
       this.baleada.setaguacate(false);
   }
}

//__________________________________________________________________________________________________________________________________________________________________________
 class Cocinero
{
    public Cocinero() {
    }
    // --------------------------
     public void cocinarBaleada( BuilderBaleada builder )
    {
        builder.crearNuevoBaleada();
        builder.cocinartortillaDeHarina();
        builder.cocinarFrijoles();
        builder.cocinarquesoYmantequilla();
        builder.cocinarHuevo();
        builder.cocinarCarne();
        builder.cocinarAguacate();
    }
}