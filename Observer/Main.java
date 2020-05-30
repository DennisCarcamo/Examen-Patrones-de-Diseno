import java.util.ArrayList;
import java.util.Scanner;



public class Main
{
    public static void main(String[] args) 
    {
        
        String countrie = "";
        UnObservado objObservado = new UnObservado();
        String otherTrans;
        int operation = 0;
        boolean contin = true;
        System.out.println("\n                            Welcome to the European Union\n");
        
        while (contin) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter 1 to Join the European Union\n"
                                           +"2 to remove a Countrie from the European union"); 
            operation = sc.nextInt();
            sc = new Scanner(System.in);
            if(operation == 1){
                System.out.println("        Please enter the name of the Coutrie that will Join the European Union");
                System.out.println("************** All member countries of the European Union will be notified **************");
                countrie = sc.nextLine();
                UnObservador objObservadorCountrie = new UnObservador(countrie);
                objObservado.agregarObservador(objObservadorCountrie);


            }else if(operation == 2){
                System.out.println("        We are now removing the last countrie that joined the European Union");
                objObservado.eliminarObservador();
            }else{
                System.out.println("       Please enter a valid option");

            }
            
            System.out.println("Please enter y/Y if more countries will Join the European Union"
                    + " or other key to exit");
            otherTrans = sc.nextLine();
            if (otherTrans.equals("Y") || otherTrans.equals("y")) {
                contin = true;
                System.out.println("");
            } else {
                System.out.println("********************************** EU ***************************************************");
                contin = false;
            }
        }
    }
}



abstract class Observado
{
    private ArrayList<IObservador> observadores = new ArrayList<IObservador>();
    // ---------------------------------
    public Observado() {
    }
    // ---------------------------------
     public void agregarObservador(IObservador o)
    {
        observadores.add(o);
        System.out.println("\n*_*_*_*_*_*_*_* NOTYFYING COUNTRIES MEMBER OF THE EU *_*_*_*_*_*_*_*\n" ); 
        notificarObservadores();
    }
    // ---------------------------------
     public void eliminarObservador() {
        observadores.remove(observadores.size()-1);
        System.out.println("\n*_*_*_*_*_*_*_* NOTYFYING COUNTRIES MEMBER OF THE EU *_*_*_*_*_*_*_*\n" ); 
        notificarObservadores();
    }
    // ---------------------------------
     public void notificarObservadores()
    {
         for (IObservador obj : observadores) {
             obj.observadoActualizado();
        }
    }
}




class UnObservado extends Observado
{
    public UnObservado() {
    }
}



interface IObservador
{
     public void observadoActualizado();
}




class UnObservador implements IObservador
{
    private String countrie;
    // ---------------------------------
    public UnObservador(String countrie) {
        this.setcountrie(countrie);
        
        System.out.println(this.countrie + " Is now part of the European Union");
        
    }
    // ---------------------------------
    public String getcountrie() {
        return this.countrie;
    }
    // ---------------------------------
    public void setcountrie(String countrie) {
        this.countrie = countrie;
    }
    // ---------------------------------
    @Override
     public void observadoActualizado() {
       System.out.println( this.getcountrie() + " has been notified");
    }
}


