/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dejoc
 */
import java.util.Scanner; 

import java.util.Scanner; 
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Adaptador conversor = new Adaptador();
       Scanner sc = new Scanner(System.in);
       int operation = 0;
       double ammount = 0.0;
       char otherTrans; 
       boolean contin = true; 
       System.out.println("Welcome to your Bank");
       while(contin){
           System.out.println("Please enter 1 to make a deposit or 2 to make a Withdrawal of money");
           operation = sc.nextInt();
           System.out.println("");
           double temp;
           if (operation == 1) {
               temp = conversor.getSaldo();
               System.out.println("Please enter the ammount of Pesetas do you want to save in Euros");
               ammount = sc.nextInt();
               System.out.println("Total Euros before Deposit:                          "+ temp);
               System.out.println("Deposit in Pesetas:                                  "+ ammount);
               conversor.ingresarPesetas(ammount);
               System.out.println("Total Euros after deposit:                           "+ conversor.getSaldo());
           }else if (operation == 2){
               temp = conversor.getSaldo();
               System.out.println("Please enter the ammount of Pesetas do you want to withdrawals in Euros");
               ammount = sc.nextInt();
               System.out.println("Total Euros before withdrawals:                      "+ temp);
               System.out.println("withdrawals in Pesetas:                              "+ ammount);
               conversor.sacarPesetas(ammount);
               System.out.println("Total Euros after withdrawals:                       "+ conversor.getSaldo());
           }
           System.out.println("");
           System.out.println("Please enter y/Y to make another transaction or any other key to exit");
           otherTrans = sc.next().charAt(0);
           System.out.println("");
           if (otherTrans == 'Y' || otherTrans == 'y'){
               contin = true;
           }else{
               System.out.println("Thank You for prefering us!");
               contin = false; 
           }
       }
    }
    
}

interface IAdaptador{
    public abstract void sacarPesetas( double pesetas );
    public abstract void ingresarPesetas( double pesetas );
}

class CajaEuros
{
    private double euros = 0;
    // -----------------
    public CajaEuros() {
    }
    // -----------------
    public double getTotalEuros()
    {
        return this.euros;
    }
    // -----------------
     public void sacarEuros( double euros )
    {
        this.euros -= euros;
    }
    // -----------------
     public void ingresarEuros( double euros )
    {
        this.euros += euros;
    }
}

class Adaptador implements IAdaptador
{
     CajaEuros cajaEuros = new CajaEuros();
    // ------------------
    public Adaptador() {
    }
    // ------------------
    public double getSaldo()
    {
         return this.cajaEuros.getTotalEuros();
    }
    // ------------------
    @Override
     public void sacarPesetas( double pesetas )
    {
        double euros = pesetas / 166.386;
         cajaEuros.sacarEuros( euros );
    }
    // ------------------
    @Override
     public void ingresarPesetas( double pesetas )
    {
        double euros = pesetas / 166.386;
         cajaEuros.ingresarEuros( euros );
    }
}
