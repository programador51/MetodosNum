import java.util.Arrays;

public class integracion_newton_cerradas{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static void main(String[] args){
		//CREAR LA TABLA CON LOS VALORES DE LA CONSTANTE DE NEWTON COTES ABIERTAS
		double n1[] = {0.5,1,1};
		double n2[] = {1.0/3.0,1.0,4.0,1.0};
		double n3[] = {3.0/8.0,1.0,3.0,3.0,1.0};
		double n4[] = {2.0/45.0,7.0,32.0,12.0,32.0,7.0};
		double n5[] = {5.0/288.0,19.0,75.0,50.0,50.0,75.0,19.0};
		double n6[] = {1.0/140.0,41.0,216.0,27.0,272.0,27.0,216.0,41.0};
		double n7[] = {7.0/17280.0,751.0,3577.0,1323.0,2989.0,2989.0,1323.0,3577.0,751.0};
		double n8[] = {14.0/14175.0,989.0,5888.0,-928.0,10946.0,-4540.0,10946.0,-928.0,5888.0,989.0};
		double n9[] = {9.0/89600.0,2857.0,15741.0,1080.0,19344.0,5788.0,5788.0,19344.0,1080.0,15741.0,2857.0};
		double n10[] = {5.0/299376.0,16067.0,106300.0,-48525.0,272400.0,-260550.0,427368.0,-260550.0,272400.0,-48525.0,106300.0,16067.0};

		double constantes[][] = {n1,n2,n3,n4,n5,n6,n7,n8,n9,n10};

		System.out.println("\n\t\t\tIntegracion - Newton - Cotes (Cerradas)\n");

		//SE ESCOGE UN PROBLEMA AL AZAR
		int funcion = (int)(Math.random()*3)+1;
		/*SE GENERAN LOS VALORES DE LA INTEGRAL DEFINIDA Y DE "n"*/
		int n = (int)(Math.random()*10)+1;

		/*EL LIMITE SUPERIOR DEBE SER MAYOR AL INFERIOR, POR ESO COMO MINIMO, ESTE DEBE VALER 2*/
		int b = (int)(Math.random()*5)+2;
		int a = (int)(Math.random()*5)+1;

		/*NOS ASEGURAMOS QUE EL LIMITE SUPERIOR SEA MAYOR QUE EL LIMITE INFERIOR*/
		while(a==b||a>b||a==0){
			a = (int)(Math.random()*5);
		}

		double h = ((double)b-(double)a)/(n);

		double sum = 0;

		double incremento = (double)a;

		//System.out.println(Arrays.toString(constantes[9]));

		switch(funcion){
			case 1:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[xe^(2x)]dx\t n = "+n);
			System.out.println(a);

			for(int i=1;i<(constantes[n-1].length);i++){
				sum += (constantes[n-1][i])*(incremento*redondear(Math.exp(2*incremento)));
				sum = redondear(sum);
				incremento+=h;
			}
			break;

			case 2:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[2x"+(char)178+"-5]\t n = "+n);
			System.out.println(a);

			for(int i=1;i<(constantes[n-1].length);i++){
				sum += (constantes[n-1][i])*(2*redondear(Math.pow(incremento,2))-5);
				sum = redondear(sum);
				incremento+=h;
			}

			break;

			case 3:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[x"+(char)178+"/(x+5)]dx\t n = "+n);
			System.out.println(a);

			for(int i=1;i<(constantes[n].length)-1;i++){
				sum += (constantes[n-1][i])*(redondear(Math.pow(incremento,2))/redondear((incremento+5)));
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