import java.util.Random;
import java.text.DecimalFormat;

public class minimos_cuadratica{

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
		System.out.println("\n\t\t\tRecta Cuadratica\n");

		int n,x,y;
		n = 4;
		/////////////////////////////////////////////////
		double sumY = 0,
		sumX = 0,
		sumXCuadrado = 0,
		sumXCubo = 0,
		sumXCuarta = 0,
		sumXY = 0,
		sumXCuadY = 0,
		resultados[] = new double[4];

		double valores[][] = new double[n][2];
		System.out.println("\t\t\tX\tY");
		System.out.println("\t\t\t--------------");

		for(x=0;x<n;x++){
			for(y=0;y<1;y++){
				valores[x][y] = numeroRandom();
			}
			valores[x][y] = numeroRandom();
			System.out.println("\t\t\t| "+valores[x][y-1]+" | "+valores[x][y]+" |");
			System.out.println("\t\t\t--------------");
			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE XY
			sumXY += valores[x][y-1]*valores[x][y];	
			sumXY = redondear(sumXY);

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE (X^2)(Y)
			double sumXCuadYAuxiliar = Math.pow(valores[x][y-1],2);
			sumXCuadYAuxiliar = redondear(sumXCuadYAuxiliar);
			sumXCuadY += sumXCuadYAuxiliar * valores[x][y];
			sumXCuadY = redondear(sumXCuadY);
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
			double sumXCuadradoAuxiliar = redondear(Math.pow(valores[x][0],2));
			sumXCuadrado += sumXCuadradoAuxiliar;
			sumXCuadrado = redondear(sumXCuadrado);

			//SUMATORIA DE X^3
			double sumXCuboAuxiliar = redondear(Math.pow(valores[x][0],3));
			sumXCubo += sumXCuboAuxiliar;
			sumXCubo = redondear(sumXCubo);

			//SUMATORIA DE X^4
			double sumXCuartaAuxiliar = redondear(Math.pow(valores[x][0],4));
			sumXCuarta += sumXCuartaAuxiliar;
			sumXCuarta = redondear(sumXCuarta);
		}

		System.out.println("\nEx = "+sumX
			+"\nEx"+(char)178+" = "+sumXCuadrado
			+"\nEx"+(char)179+" = "+sumXCubo
			+"\nEx^4 = "+sumXCuarta
			+"\nEy = "+sumY
			+"\nExy = "+sumXY
			+"\nEx"+(char)178+"y = "+sumXCuadY);

		/*AQUI SE DETERMINAN LOS VALORES DE A0,A1,A2 Y SE LES REDONDEA A 8 DECIMALES*/

		//DETERMINANTE
		double d = ((n*sumXCuadrado*sumXCuarta)+(sumX*sumXCubo*sumXCuadrado)+(sumXCuadrado*sumX*sumXCubo))
		-((sumXCuadrado*sumXCuadrado*sumXCuadrado)+(sumXCubo*sumXCubo*n)+(sumXCuarta*sumX*sumX));
		d =  redondear(d);

		//DETERMINANTE A0
		double da0 = ((sumY*sumXCuadrado*sumXCuarta)+(sumX*sumXCubo*sumXCuadY)+(sumXCuadrado*sumXY*sumXCubo))
		-((sumX*sumXY*sumXCuarta)+(sumY*sumXCubo*sumXCubo)+(sumXCuadrado*sumXCuadrado*sumXCuadY));
		da0 =  redondear(da0);

		//DETERMINANTE A1
		double da1 = ((n*sumXY*sumXCuarta)+(sumX*sumXCuadY*sumXCuadrado)+(sumXCuadrado*sumY*sumXCubo))
		-((sumXCuadrado*sumXY*sumXCuadrado)+(sumXCubo*sumXCuadY*n)+(sumXCuarta*sumY*sumX));
		da1 =  redondear(da1);

		//DETERMINANTE A2
		double da2 = ((n*sumXCuadrado*sumXCuadY)+(sumX*sumXY*sumXCuadrado)+(sumY*sumX*sumXCubo))
		-((sumY*sumXCuadrado*sumXCuadrado)+(n*sumXY*sumXCubo)+(sumX*sumX*sumXCuadY));
		da2 =  redondear(da2);


		/*SE CALCULAN LOS VALORES DE LAS A0, ESTAS VARIABLES HACEN OPERACIONES USANDO VARIABLES QUE TRABAJAN 
		CON 8 DECIMALES, SIN EMBARGO SE VOLVERAN A REDONDEAR YA QUE EXSITE LA POSIBILIDAD QUE AGARRE 
		MAS DECIMAS DE LAS QUE SE LES INDICO*/
		double a0 = da0/d;
		a0 =  redondear(a0);

		double a1 = da1/d;
		a1 =  redondear(a1);

		double a2 = da2/d;
		a2 =  redondear(a2);

		System.out.println("\na0 = "+a0
			+"\na1 = "+a1
			+"\na2 = "+a2
			+"\n----------------------------------");

		for(int i=0;i<n;i++){
			double gxAuxiliar = redondear(a2*Math.pow(valores[i][0],2));
			double gx = a0 + a1*valores[i][0] + gxAuxiliar;

			gx = redondear(gx);

			resultados[i] = gx;

			System.out.println(a0 + " + " + a1 + "("+valores[i][0]+") + "+ a2 + "("+ redondear(Math.pow(valores[i][0],2))+ ") = " + gx);
		}
	}
}
