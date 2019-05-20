import java.util.Random;

public class integracion_regla_trapezoidal{
	public static void main(String[] args){
		System.out.println("\n\t\t\tIntegracion - Regla Trapezoidal\n");
		
		/*SE ESCOGE ALEATORIAMENTE LA FUNCION A RESOLVER E IMPRIME EL PROBLEMA PROPUESTO*/
		int i, //PARA LOS CICLOS FOR
		funcion = (int)(Math.random()*3)+1;

		double h = 0,
		sum = 0,
		auxiliar = 0,
		fa =  0,
		fb = 0,
		l;

		/*SE GENERAN LOS VALORES DE LA INTEGRAL DEFINIDA Y DE "n"*/
		int n = (int)(Math.random()*5)+2;

		/*EL LIMITE SUPERIOR DEBE SER MAYOR AL INFERIOR, POR ESO COMO MINIMO, ESTE DEBE VALER 2*/
		int b = (int)(Math.random()*5)+2;
		int a = (int)(Math.random()*5)+1;

		/*NOS ASEGURAMOS QUE EL LIMITE SUPERIOR SEA MAYOR QUE EL LIMITE INFERIOR*/
		while(a==b||a>b){
			a = (int)(Math.random()*5)+1;
		}

		h = ((double)b-(double)a)/(double)n;

		switch(funcion){
			case 1:
		
			/*IMPRIMIR LA FUNCION*/
			System.out.println(b);
			System.out.println("|[1/(1+x"+(char)178+")]dx\t n = "+n);
			System.out.println(a);

			fa = 1/(1+Math.pow(a,2));
			fa = Math.rint(fa * 100000000)/100000000;

			fb = 1/(1+Math.pow(b,2));
			fb = Math.rint(fb * 100000000)/100000000;

			auxiliar = (double)a;

			for(i=0;i<(n-1);i++){
				auxiliar += h;
				sum += (1/(1+Math.pow(auxiliar,2)));
				sum = Math.rint(sum * 100000000)/100000000;
			}
			break;

			case 2:
			/*IMPRIMIR LA FUNCION*/
			System.out.println(b);
			System.out.println("|[sen(2x) + x"+(char)179+"]dx\t n = "+n);
			System.out.println(a);

			fa = Math.sin(2*a) + Math.pow(a,3);
			fa = Math.rint(fa * 100000000)/100000000;

			fb = Math.sin(2*b) + Math.pow(b,3);
			fb = Math.rint(fb * 100000000)/100000000;

			auxiliar = (double)a;

			for(i=0;i<(n-1);i++){
				auxiliar += h;
				sum += Math.sin(2*auxiliar) + Math.pow(auxiliar,3);
				sum = Math.rint(sum * 100000000)/100000000;
			}
			break;

			case 3:
			/*IMPRIMIR LA FUNCION*/
			System.out.println(b);
			System.out.println("|[cos(x) + x"+(char)178+"]dx");
			System.out.println(a);

			fa = Math.cos(a) + Math.pow(a,2);
			fa = Math.rint(fa * 100000000)/100000000;

			fb = Math.cos(b) + Math.pow(b,2);
			fb = Math.rint(fb * 100000000)/100000000;

			auxiliar = (double)a;

			for(i=0;i<(n-1);i++){
				auxiliar += h;
				sum += Math.cos(auxiliar) + Math.pow(auxiliar,2);
				sum = Math.rint(sum * 100000000)/100000000;
			}
			break;
			default:
		}

		l = (h/2)*(fa+(2*sum)+fb);
		l = Math.rint(l * 100000000)/100000000;
		System.out.println("\nI = "+l);

	}
}
