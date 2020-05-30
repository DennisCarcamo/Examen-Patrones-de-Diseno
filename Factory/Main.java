import java.util.Scanner; 
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int operation = 0;
        char otherTrans;
        boolean contin = true;
        FabricaInscripcione inscribir = new Inscribir();
        System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*   Welcome to Unitec _*_*_*_*_*_*_*_*_*_*_*_*_*" );
        while (contin) {
            System.out.println("  \n Por favor ingrese\n"
                                +" 1 para inscribir un alumno \n"
                                +" 2 para inscribir un maestro ");
            operation = sc.nextInt();
            if (operation == 1) {
                Inscripciones_Personas alumno = inscribir.inscribir( Inscribir.alumno );
                alumno.guardarInscribir();
            } else if(operation == 2) {
                Inscripciones_Personas maestro = inscribir.inscribir( Inscribir.maestro );
                maestro.guardarInscribir();
            }else{
                System.out.println("#############  Opcion Incorrecta ####################");
            }
            System.out.println("ingrese y/Y para inscribir otra persona o "
                    + "cualquier otra tecla para salir");
            otherTrans = sc.next().charAt(0);
            if (otherTrans == 'Y' || otherTrans == 'y') {
                contin = true;
            } else {
                System.out.println("Gracias por preferir Unitec");
                contin = false;
            }
        }

      
        
    }
}




interface Inscripciones_Personas
{
    public void guardarInscribir();
}


class InscripcionAlumno implements Inscripciones_Personas
{
    public InscripcionAlumno() {
    }
    // -----------------------------
    @Override
     public void guardarInscribir() {
        System.out.println("Se ha Inscrito un alumno\n");
    }
}

class InscripcionMAestro implements Inscripciones_Personas
{
    public InscripcionMAestro() {
    }
    // -----------------------------
    @Override
     public void guardarInscribir() {
        System.out.println("Se ha Inscrito un maestro\n");
    }
}

abstract class FabricaInscripcione
{
    public static final int alumno = 1;
    public static final int maestro = 2;
    // --------------------------------
     public abstract Inscripciones_Personas inscribir(int tipo);
}

class Inscribir extends FabricaInscripcione
{
    public void Inscripciones_Personas() {
    }
    // -------------------------------------------
    @Override
     public Inscripciones_Personas inscribir(int tipo)
    {
        Inscripciones_Personas objeto;
        switch( tipo )
        {
            case alumno:
                objeto = new InscripcionAlumno();
                break;
            case maestro:
                objeto = new InscripcionMAestro();
                break;
            default:
                objeto = null;
        }
        return objeto;
    }
}