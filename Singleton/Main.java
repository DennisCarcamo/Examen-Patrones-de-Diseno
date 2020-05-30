/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author dejoc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean continuar = true;
        Scanner input = new Scanner(System.in);
        char respuesta;
        while (continuar){
            System.out.println("Por favor precione y/Y para crear la identidad de la persona");
         respuesta = input.charAt(0);
        }
        for(int num=1; num <= 5; num++){
            Identidad.getInstancia();
        }
    }
    
}


class Identidad
{
     private static Identidad instancia;
    // ----------------------------------------
    private Identidad() {
    }
    // ----------------------------------------
     public static Identidad getInstancia()
    {
         if (instancia == null) {
             instancia = new Identidad();
            System.out.println("Se ha creado Una Identidad para esta persona");
        }
        else {
            System.out.println("No se puede crear la Identidad porque ya se ha creado anteriormente");
        }
         return instancia;
    }
}