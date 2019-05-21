import java.util.Random;
import java.text.DecimalFormat;

public class minimos_linea_recta{

	public static double numeroRandom(){
		Random r = new Random();

		double max = 10.0,
		min = 1.0,
		random = 0;

		random = min + r.nextDouble() * (max - min);
		random = Math.rint(random * 100)/100;
		return random;
	}

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static void main(String[] args){
		System.out.println("\n\t\tEjercicio de Linea recta\n");
		
		/*AQUI SE GENERAN DE MANERA ALEATORIA LOS VALORES DE X & Y PARA EL PROBLEMA A RESOLVER*/
		//n.- ES EL NUMERO DE VALORES DADOS A "X"
		int n,x,y;
		n = 4;
		/////////////////////////////////////////////////
		double sumY = 0,
		sumX = 0,
		sumXCuadrado = 0,
		sumXY = 0,
		resultados[] = new double[4];
	
		/*SE CREA LA TABLA CON LOS VALORES X & Y*/

		double valores[][] = new double[n][2];

		for(x=0;x<n;x++){
			for(y=0;y<1;y++){
				valores[x][y] = numeroRandom();
			}
			valores[x][y] = numeroRandom();
			System.out.println("\t\t\t| "+valores[x][y-1]+" | "+valores[x][y]+" |");
			System.out.println("\t\t\t---------------");
			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE XY
			sumXY += valores[x][y-1]*valores[x][y];
			sumXY = redondear(sumXY);
		}

		/*SE OBTIENEN LOS DATOS DE LAS SUMATORIAS DEACUERDO AL PROBLEMA GENERADO*/
		for(x=0;x<n;x++){
			//SUMATORIA DE X
			sumX+=valores[x][0];
			sumX = redondear(sumX);
			//SUMATORIA DE Y
			sumY+=valores[x][1];
			sumY = redondear(sumY);
			//SUMATORIA DE X^2
			valores[x][0] = redondear(valores[x][0]);
			double sumXCuadradoAuxiliar = redondear(Math.pow(valores[x][0],2));
			sumXCuadrado += sumXCuadradoAuxiliar;
			sumXCuadrado = redondear(sumXCuadrado);
		}
		System.out.println("\nEx = "+sumX
			+"\nEx"+(char)178+" = "+sumXCuadrado
			+"\nEy = "+sumY
			+"\nE(xy) = "+sumXY);

		/*SE RESUELVE EL SISTEMA DE ECUACIONES CON DETERMINANTES
		ALMENOS ESTE TIPO DE PROBLEMA SIEMPRE SERA 2X2*/
		double det=(n*sumXCuadrado)-(sumX*sumX);
		det = redondear(det);

		double a0 = ((sumY*sumXCuadrado)-(sumX*sumXY))/det;
		a0 = redondear(a0);

        double a1 = ((n*sumXY)-(sumY*sumX))/det;
        a1 = redondear(a1);

        System.out.println("\n"
        	+"a0 = "+a0
        	+"\na1 = "+a1+"\n\n");

        for(int i=0;i<n;i++){
        	double gx = a0 + a1*valores[i][0];
        	gx = redondear(gx);
        	resultados[i] = gx;
        	System.out.println(a0+" + "+a1+"("+valores[i][0]+") = "+gx);
        }
	}
}
