import java.util.Random;
import java.text.DecimalFormat;

public class minimos_cuadratica{
	public static void main(String[] args){
		System.out.println("\n\t\t\tRecta Cuadratica\n");

		int limite = 5,n,x,y;
		n = (int)(Math.random()*limite)+2;
		System.out.println("n = "+n);
		/////////////////////////////////////////////////
		Random r = new Random();

		double random,
		sumY = 0,
		sumX = 0,
		sumXCuadrado = 0,
		sumXCubo = 0,
		sumXCuarta = 0,
		sumXY = 0,
		sumXCuadY = 0,
		max = 10.0,
		min = 1.0;

		double valores[][] = new double[n][2];
		System.out.println("\t\t\t\tX\tY");
		System.out.println("\t\t\t--------------------------");

		for(x=0;x<n;x++){
			for(y=0;y<1;y++){
				random = min + r.nextDouble() * (max - min);
				random = Math.rint(random * 100000000)/100000000;
				valores[x][y] = random;
			}
			random = min + r.nextDouble() * (max - min);
			random = Math.rint(random * 100000000)/100000000;
			valores[x][y] = random;
			System.out.println("\t\t\t| "+valores[x][y-1]+" | "+valores[x][y]+" |");
			System.out.println("\t\t\t--------------------------");
			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE XY
			sumXY += valores[x][y-1]*valores[x][y];	
			sumXY = Math.rint(sumXY * 100000000)/100000000;

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE (X^2)(Y)
			double sumXCuadYAuxiliar = Math.pow(valores[x][y-1],2);
			sumXCuadYAuxiliar = Math.rint(sumXCuadYAuxiliar*100000000)/100000000;
			sumXCuadY += sumXCuadYAuxiliar * valores[x][y];
			sumXCuadY = Math.rint(sumXCuadY*1000000)/1000000;
		}

		/*SE OBTIENEN LOS DATOS DE LAS SUMATORIAS DEACUERDO AL PROBLEMA GENERADO*/
		for(x=0;x<n;x++){
			//SUMATORIA DE X
			sumX+=valores[x][0];

			//SUMATORIA DE Y
			sumY+=valores[x][1];

			//SUMATORIA DE X^2
			valores[x][0] =  Math.rint(valores[x][0] * 100000000)/100000000;
			double sumXCuadradoAuxiliar = Math.rint(Math.pow(valores[x][0],2) * 100000000)/100000000;
			sumXCuadrado += sumXCuadradoAuxiliar;

			//SUMATORIA DE X^3
			double sumXCuboAuxiliar = Math.rint(Math.pow(valores[x][0],3) * 100000000)/100000000;
			sumXCubo += sumXCuboAuxiliar;

			//SUMATORIA DE X^4
			double sumXCuartaAuxiliar = Math.rint(Math.pow(valores[x][0],4) * 1000000)/1000000;
			sumXCuarta += sumXCuartaAuxiliar;
		}


		sumX =  Math.rint(sumX * 100000000)/100000000;
		sumXCubo =  Math.rint(sumXCubo * 1000000)/1000000;
		sumXCuadrado =  Math.rint(sumXCuadrado * 100000000)/100000000;
		sumXCuarta = Math.rint(sumXCuarta * 1000000)/1000000;
		sumY = Math.rint(sumY * 100000000)/100000000;
		sumXY = Math.rint(sumXY * 100000000)/100000000;
		sumXCuadY = Math.rint(sumXCuadY*1000000)/1000000;
		System.out.println("\nEx = "+sumX
			+"\nEx"+(char)178+" = "+sumXCuadrado
			+"\nEx"+(char)179+" = "+sumXCubo
			+"\nEx^4 = "+sumXCuarta
			+"\nEy = "+sumY
			+"\nExy = "+sumXY
			+"\nEx"+(char)178+"y = "+sumXCuadY);
	}
}