import java.util.Random;
import java.text.DecimalFormat;

public class minimos_lineal_funcion{

		public static double evaluarFuncion(int funcion, double valores){
			double evaluacion = 0;
			switch(funcion){
				case 1:
				evaluacion = Math.exp(valores);
				evaluacion = Math.rint(evaluacion * 100000000)/100000000;
				break;

				case 2:
				evaluacion = Math.sin(valores);
				evaluacion = Math.rint(evaluacion * 100000000)/100000000;
				break;

				case 3:
				evaluacion = Math.cos(valores);
				evaluacion = Math.rint(evaluacion * 100000000)/100000000;
				break;

				case 4:
				evaluacion = Math.tan(valores);
				evaluacion = Math.rint(evaluacion * 100000000)/100000000;
				break;

				case 5:
				evaluacion = Math.log(valores);
				evaluacion = Math.rint(evaluacion * 100000000)/100000000;
				break;
				default:
			}
			return evaluacion;
		}

	public static void main(String[] args){
		System.out.println("\n\t\t\tLineal con funcion\n");

		int n=4,x,y;

		Random r = new Random();

		double
		sumFx = 0,
		sumXFx = 0,
		sumYFx = 0,
		sumFxCuadrado = 0,
		random,
		sumY = 0,
		sumX = 0,
		sumXCuadrado = 0,
		sumXY = 0,
		max = 10.0,
		min = 1.0;

		/*IMPRIME FUNCION ALEATORIA*/
		int funcion = (int)(Math.random()*5)+1;
		switch(funcion){
			case 1:
			System.out.println("f(x) = e^x");
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

		/*SE CREA LA TABLA DE X,Y DE MANERA ALEATORIA*/

		resultados[] = new double[4];
		double valores[][] = new double[n][2];
		System.out.println("\t\t\tX\tY");
		System.out.println("\t\t\t---------------");

		for(x=0;x<n;x++){
			for(y=0;y<1;y++){
				random = min + r.nextDouble() * (max - min);
				random = Math.rint(random * 100)/100;
				valores[x][y] = random;
			}
			random = min + r.nextDouble() * (max - min);
			random = Math.rint(random * 100)/100;
			valores[x][y] = random;
			System.out.println("\t\t\t| "+valores[x][y-1]+" | "+valores[x][y]+" |");
			System.out.println("\t\t\t---------------");

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE XY
			sumXY += valores[x][y-1]*valores[x][y];	
			sumXY = Math.rint(sumXY * 100000000)/100000000;

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE [X]*[F(x)]
			sumXFx += valores[x][y-1]*evaluarFuncion(funcion,valores[x][y]);	
			sumXFx = Math.rint(sumXFx * 100000000)/100000000;

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE [Y]*[F(x)]
			sumYFx += (valores[x][1]*evaluarFuncion(funcion,valores[x][0]));
			sumYFx = Math.rint(sumYFx * 100000000)/100000000;
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

			//SUMATORIA DE FX(X)
			sumFx += evaluarFuncion(funcion,valores[x][0]);
			sumFx = Math.rint(sumFx * 100000000)/100000000;

			//SUMATORIA DE FX(X)^2
			valores[x][0] =  Math.rint(valores[x][0] * 100000000)/100000000;
			double sumFxCuadradoAuxiliar = Math.rint(Math.pow(evaluarFuncion(funcion,valores[x][0]),2) * 100000000)/100000000;
			sumFxCuadrado += sumFxCuadradoAuxiliar;
		}	

		sumX =  Math.rint(sumX * 100000000)/100000000;
		sumXCuadrado =  Math.rint(sumXCuadrado * 100000000)/100000000;
		sumY = Math.rint(sumY * 100000000)/100000000;
		sumXY = Math.rint(sumXY * 100000000)/100000000;
		sumXFx = Math.rint(sumXFx * 100000000)/100000000;
		sumFxCuadrado = Math.rint(sumFxCuadrado * 100000000)/100000000;
		sumYFx = Math.rint(sumYFx * 100000000)/100000000;

		System.out.println("\nEx = "+sumX
			+"\nEx"+(char)178+" = "+sumXCuadrado
			+"\nEy = "+sumY
			+"\nExy = "+sumXY
			+"\nEf(x) = "+sumFx
			+"\nE[x*f(x)] = "+sumXFx
			+"\nEf(x)"+(char)178 + " = " + sumFxCuadrado
			+"\nE[y*f(x) = " + sumYFx);

		/*AQUI SE DETERMINAN LOS VALORES DE A0,A1,A2 Y SE LES REDONDEA A 8 DECIMALES*/

		//DETERMINANTE
		double d = ((n*sumXCuadrado*sumFxCuadrado)+(sumX*sumXFx*sumFx)+(sumFx*sumX*sumXFx))
		-((sumFx*sumXCuadrado*sumFx)+(sumXFx*sumXFx*n)+(sumFxCuadrado*sumX*sumX));
		d =  Math.rint(d * 100000000)/100000000;

		//DETERMINANTE A0
		double da0 = ((sumY*sumXCuadrado*sumFxCuadrado)+(sumX*sumXFx*sumYFx)+(sumFx*sumXY*sumXFx))
		-((sumX*sumXY*sumFxCuadrado)+(sumY*sumXFx*sumXFx)+(sumFx*sumXCuadrado*sumYFx));
		da0 =  Math.rint(da0 * 100000000)/100000000;

		//DETERMINANTE A1
		double da1 = ((n*sumXY*sumFxCuadrado)+(sumX*sumYFx*sumFx)+(sumFx*sumY*sumXFx))
		-((sumFx*sumXY*sumFx)+(sumXFx*sumYFx*n)+(sumFxCuadrado*sumY*sumX));
		da1 =  Math.rint(da1 * 100000000)/100000000;

		//DETERMINANTE A2
		double da2 = ((n*sumXCuadrado*sumYFx)+(sumX*sumXY*sumFx)+(sumY*sumX*sumXFx))
		-((sumX*sumX*sumYFx)+(n*sumXY*sumXFx)+(sumY*sumXCuadrado*sumFx));
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
			double gxAuxiliar = a2*evaluarFuncion(funcion,valores[i][0]);
			gxAuxiliar = Math.rint(gxAuxiliar * 100000000)/100000000;
			double gx = a0 + a1*valores[i][0] + gxAuxiliar;
			gx = Math.rint(gx * 100000000)/100000000;
			resultados[i] = gx;
			System.out.println(a0 + " + " + a1 + "("+valores[i][0]+") + "+ a2 + "("+ Math.rint(evaluarFuncion(funcion,valores[i][0])*100000000)/100000000+ ") = " + gx);
		}
	}
}
