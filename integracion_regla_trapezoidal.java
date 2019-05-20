import java.util.Random;

public class integracion_regla_trapezoidal{
	public static void main(String[] args){
		System.out.println("\n\t\t\tIntegracion - Regla Trapezoidal\n");
		
		/*SE ESCOGE ALEATORIAMENTE LA FUNCION A RESOLVER E IMPRIME EL PROBLEMA PROPUESTO*/
		int i,
		funcion = (int)(Math.random()*1)+1;

		double h = 0,
		sum = 0,
		l;

		switch(funcion){
			case 1:
			/*SE GENERAN LOS VALORES DE LA INTEGRAL DEFINIDA Y DE "n"*/
			int n = (int)(Math.random()*5)+1;

			/*EL LIMITE SUPERIOR DEBE SER MAYOR AL INFERIOR, POR ESO COMO MINIMO, ESTE DEBE VALER 2*/
			int b = (int)(Math.random()*5)+2;
			int a = (int)(Math.random()*5)+1;

			/*NOS ASEGURAMOS QUE EL LIMITE SUPERIOR SEA MAYOR QUE EL LIMITE INFERIOR*/
			while(a==b||a>b){
				a = (int)(Math.random()*5)+1;
			}

			h = ((double)b-(double)a)/(double)n;

			/*IMPRIMIR LA FUNCION*/
			System.out.println(b);
			System.out.println("|[1/(1+x"+(char)178+")]dx\t n = "+n);
			System.out.println(a);

			double fa = 1/(1+Math.pow(a,2));
			double fb = 1/(1+Math.pow(b,2));
			for(i=0;i<n;i++){
				sum += (1/(1+Math.pow(h,2)));
			}
			l = (h/2)*(fa+(2*sum)+fb);
			System.out.println("I = "+i);
			break;

			case 2:
			System.out.println("f(x) = sen(x)");
			break;

			case 3:
			System.out.println("f(x) = cos(x)");
			break;

			case 4:
			System.out.println("f(x) = tg(x)");
			break;

			case 5:
			System.out.println("f(x) = Ln(x)");
			break;
			default:
		}
	}
}