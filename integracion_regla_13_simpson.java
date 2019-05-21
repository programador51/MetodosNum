public class integracion_regla_13_simpson{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static void main(String[] args){
		System.out.println("\n\t\t\tIntegracion - Regla de 1/3 Simpson\n");

		//SE ESCOGE UN PROBLEMA AL AZAR
		int funcion = (int)(Math.random()*3)+1;
		/*SE GENERA UNA "n" QUE SEA PAR*/
		int n = (int)(Math.random()*10)+1;
		if(n%2==1){
			n += 1;
		}
		/*EL LIMITE SUPERIOR DEBE SER MAYOR AL INFERIOR, POR ESO COMO MINIMO, ESTE DEBE VALER 2*/
		int b = (int)(Math.random()*5)+2;
		int a = (int)(Math.random()*5)+1;

		while(a==b||a>b||a==0){
			a = (int)(Math.random()*5);
		}

		double h = ((double)b-(double)a)/(n);

		double sum = 0;

		double incremento = (double)a;
		double fa=0,fb=0,multiplicador = 4.0;

		funcion = 3;

		switch(funcion){
			case 1:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[5x^4-6x"+(char)178+"+3]dx\t n = "+n);
			System.out.println(a);

			fa = (5*redondear(Math.pow(a,4)))-(6*redondear(Math.pow(a,2)))+3;
			fa = redondear(fa);

			fb = (5*redondear(Math.pow(b,4)))-(6*redondear(Math.pow(b,2)))+3;
			fb = redondear(fb);

			for(int i=0;i<n-1;i++){
				incremento+=h;
				sum += multiplicador*((5*(redondear(Math.pow(incremento,4))))-(6*(redondear(Math.pow(incremento,2))))+3);
				sum = redondear(sum);
				if(multiplicador == 4.0){
					multiplicador = 2.0;
				} else{
					multiplicador = 4.0;
				}
			}
			break;

			case 2:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[x"+(char)178+"ln(x)]dx\t n = "+n);
			System.out.println(a);

			fa = (redondear(Math.pow(a,2)))*(redondear(Math.log(a)));
			fa = redondear(fa);

			fb = (redondear(Math.pow(b,2)))*(redondear(Math.log(b)));
			fb = redondear(fb);

			for(int i=0;i<n-1;i++){
				incremento+=h;
				sum += multiplicador*((redondear(Math.pow(incremento,2)))*(redondear(Math.log(incremento))));
				sum = redondear(sum);
				if(multiplicador == 4.0){
					multiplicador = 2.0;
				} else{
					multiplicador = 4.0;
				}
			}

			break;

			case 3:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[(4^x - 2^x)/3^x]dx\t n = "+n);
			System.out.println(a);

			fa = (redondear(Math.pow(4,a))-redondear(Math.pow(2,a)))/redondear(Math.pow(3,a));
			fa = redondear(fa);

			fb = (redondear(Math.pow(4,b))-redondear(Math.pow(2,b)))/redondear(Math.pow(3,b));
			fb = redondear(fb);

			for(int i=0;i<n-1;i++){
				incremento+=h;
				sum += multiplicador*((redondear(Math.pow(4,incremento))-redondear(Math.pow(2,incremento)))/redondear(Math.pow(3,incremento)));
				sum = redondear(sum);
				if(multiplicador == 4.0){
					multiplicador = 2.0;
				} else{
					multiplicador = 4.0;
				}
			}

			break;
			default:
		}
		double l = (h/3)*(fa+sum+fb);
		l = redondear(l);
		System.out.println("\nI = "+l);
	}
}