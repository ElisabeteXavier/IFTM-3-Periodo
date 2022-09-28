import br.estudante.iftm.elisabete.Quadrado;
import br.estudante.iftm.elisabete.Trapezio;
import br.estudante.iftm.elisabete.Triangulo;

public class main {


    public static void main(String[] args) {

        Quadrado quadrado = new Quadrado();
        Trapezio trapezio = new Trapezio();
        Triangulo triangulo = new Triangulo();


        quadrado.Desenha();
        System.out.println("\n");
        trapezio.Desenha();
        System.out.println("\n");
        triangulo.Desenha();

    }
}
