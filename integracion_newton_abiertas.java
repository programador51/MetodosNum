import java.util.Arrays;

public class integracion_newton_abiertas{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static void main(String[] args){
		//CREAR LA TABLA CON LOS VALORES DE LA CONSTANTE DE NEWTON COTES ABIERTAS
		double n1[] = {1.5,0.0,1.0,1.0,0.0};
		double n2[] = {4.0/3.0,0.0,2.0,-1.0,2.0,0.0};
		double n3[] = {5.0/24.0,0.0,11.0,1.0,1.0,11.0,0.0};
		double n4[] = {6.0/20.0,0.0,11.0,-14.0,26.0,-14.0,11.0,0.0};
		double n5[] = {7.0/1440.0,0.0,611.0,-453.0,562.0,562.0,-453.0,611.0,0.0};
		double n6[] = {8.0/945.0,0.0,460.0,-954.0,2196.0,-2459.0,2196.0,-954.0,460.0,0.0};

		double constantes[][] = {n1,n2,n3,n4,n5,n6};

		System.out.println("\n\t\t\tIntegracion - Newton - Cotes (Abiertas)\n");

		//SE ESCOGE UN PROBLEMA AL AZAR
		int funcion = (int)(Math.random()*3)+1;

		/*SE GENERAN LOS VALORES DE LA INTEGRAL DEFINIDA Y DE "n"*/
		int n = (int)(Math.random()*6)+1;

		/*EL LIMITE SUPERIOR DEBE SER MAYOR AL INFERIOR, POR ESO COMO MINIMO, ESTE DEBE VALER 2*/
		int b = (int)(Math.random()*5)+2;
		int a = (int)(Math.random()*5)+1;

		/*NOS ASEGURAMOS QUE EL LIMITE SUPERIOR SEA MAYOR QUE EL LIMITE INFERIOR*/
		while(a==b||a>b||a==0){
			a = (int)(Math.random()*5);
		}

		double h = ((double)b-(double)a)/(n+2);

		double incremento = (double)a;
		double sum = 0;

		switch(funcion){
			case 1:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[3x"+(char)179+"-10]dx\t n = "+n);
			System.out.println(a);

			for(int i=1;i<(constantes[n-1].length);i++){
				//System.out.println("valor = "+constantes[n-1][i]);
				sum += (constantes[n-1][i])*(3*Math.pow(incremento,3)-10);
				sum = redondear(sum);
				incremento+=h;
			}
			break;

			case 2:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[xln(x)]\t n = "+n);
			System.out.println(a);

			for(int i=1;i<(constantes[n-1].length);i++){
				sum += (constantes[n-1][i])*(incremento*Math.log(incremento));
				sum = redondear(sum);
				incremento+=h;
			}

			break;

			case 3:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[1/x]dx\t n = "+n);
			System.out.println(a);

			for(int i=1;i<<constantes n-1="" class="length"></constantes>;i++){
				sum += (constantes[n-1][i])*(1/incremento);
				sum = redondear(sum);
				incremento+=h;
			}

			break;
			default:
		}
		double l =(redondear(h*constantes[n-1][0]))*sum;
		l = redondear(l);
			
		System.out.println("\nl = "+l);
	}
}
