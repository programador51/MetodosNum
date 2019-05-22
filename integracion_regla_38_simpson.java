public class integracion_regla_38_simpson {

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static void main(String[] args) {
		System.out.println("\n\t\t\tIntegracion - Regla de 3/8 Simpson\n");

		//SE ESCOGE UN PROBLEMA AL AZAR
		int funcion = (int)(Math.random()*3)+1;

		/*SE GENERA UNA "n" QUE SEA IMPAR*/
		int n = (int)(Math.random()*10)+1;
		if(n%2==0){
			n -= 1;
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
		double fa=0,fb=0;

		switch(funcion){
			case 1:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[x"+(char)179+"e^x]dx\t n = "+n);
			System.out.println(a);

			fa = redondear(Math.pow(a,3))*redondear(Math.exp(a));
			fa = redondear(fa);

			fb = redondear(Math.pow(b,3))*redondear(Math.exp(b));
			fb = redondear(fb);

			for(int i=0;i<n-1;i++){
				incremento+=h;
				sum += redondear(Math.pow(incremento,3))*redondear(Math.exp(incremento));
				sum = redondear(sum);
			}
			break;

			case 2:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[x"+(char)179+"/(1+x^("+(char)189+"))]dx\t n = "+n);
			System.out.println(a);

			fa = redondear(Math.pow(a,3))/(1+redondear(Math.pow(a,0.5)));
			fa = redondear(fa);

			fb = redondear(Math.pow(b,3))/(1+redondear(Math.pow(b,0.5)));
			fb = redondear(fb);

			for(int i=0;i<n-1;i++){
				incremento+=h;
				sum += redondear(Math.pow(incremento,3))/(1+redondear(Math.pow(incremento,0.5)));
				sum = redondear(sum);
			}
			break;

			case 3:
			/*IMPRIMIR LA FUNCION*/
			System.out.println("\n"+b);
			System.out.println("|[(e^x)ln(x)]dx\t n = "+n);
			System.out.println(a);

			fa = redondear(Math.exp(a))*redondear(Math.log(a));
			fa = redondear(fa);

			fb = redondear(Math.exp(b))*redondear(Math.log(b));
			fb = redondear(fb);

			for(int i=0;i<n-1;i++){
				incremento+=h;
				sum += redondear(Math.exp(incremento))*redondear(Math.log(incremento));
				sum = redondear(sum);
			}
			break;

			default:
		}
		double l = (h*(3.0/8.0))*(fa+3*sum+fb);
		l = redondear(l);
		System.out.println("\nI = "+l);
	}
}