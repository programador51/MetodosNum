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

		/*AQUI SE DETERMINAN LOS VALORES DE A0,A1,A2 Y SE LES REDONDEA A 8 DECIMALES*/

		//DETERMINANTE
		double d = ((n*sumXCuadrado*sumXCuarta)+(sumX*sumXCubo*sumXCuadrado)+(sumXCuadrado*sumX*sumXCubo))
		-((sumXCuadrado*sumXCuadrado*sumXCuadrado)+(sumXCubo*sumXCubo*n)+(sumXCuarta*sumX*sumX));
		d =  Math.rint(d * 100000000)/100000000;

		//DETERMINANTE A0
		double da0 = ((sumY*sumXCuadrado*sumXCuarta)+(sumX*sumXCubo*sumXCuadY)+(sumXCuadrado*sumXY*sumXCubo))
		-((sumX*sumXY*sumXCuarta)+(sumY*sumXCubo*sumXCubo)+(sumXCuadrado*sumXCuadrado*sumXCuadY));
		da0 =  Math.rint(da0 * 100000000)/100000000;

		//DETERMINANTE A1
		double da1 = ((n*sumXY*sumXCuarta)+(sumX*sumXCuadY*sumXCuadrado)+(sumXCuadrado*sumY*sumXCubo))
		-((sumXCuadrado*sumXY*sumXCuadrado)+(sumXCubo*sumXCuadY*n)+(sumXCuarta*sumY*sumX));
		da1 =  Math.rint(da1 * 100000000)/100000000;

		//DETERMINANTE A2
		double da2 = ((n*sumXCuadrado*sumXCuadY)+(sumX*sumXY*sumXCuadrado)+(sumY*sumX*sumXCubo))
		-((sumY*sumXCuadrado*sumXCuadrado)+(n*sumXY*sumXCubo)+(sumX*sumX*sumXCuadY));
		da2 =  Math.rint(da2 * 100000000)/100000000;


		/*SE CALCULAN LOS VALORES DE LAS A0, ESTAS VARIABLES HACEN OPERACIONES USANDO VARIABLES QUE TRABAJAN 
		CON 8 DECIMALES, SIN EMBARGO SE VOLVERAN A REDONDEAR YA QUE EXSITE LA POSIBILIDAD QUE AGARRE 
		MAS DECIMAS DE LAS QUE SE LES INDICO*/
		double a0 = da0/d;
		a0 =  Math.rint(a0 * 100000000)/100000000;
		double a1 = da1/d;
		a1 =  Math.rint(a1 * 100000000)/100000000;
		double a2 = da2/d;
		a2 =  Math.rint(a2 * 100000000)/100000000;
		System.out.println("\na0 = "+a0
			+"\na1 = "+a1
			+"\na2 = "+a2
			+"\n----------------------------------");

		for(int i=0;i<n;i++){
			double gxAuxiliar = a2*Math.pow(valores[i][0],2);
			gxAuxiliar = Math.rint(gxAuxiliar * 100000000)/100000000;
			double gx = a0 + a1*valores[i][0] + gxAuxiliar;
			gx = Math.rint(gx * 100000000)/100000000;
			System.out.println(a0 + " + " + a1 + "("+valores[i][0]+") + "+ a2 + "("+ Math.rint(Math.pow(valores[i][0],2)*100000000)/100000000+ ") = " + gx);
		}
	}
}
