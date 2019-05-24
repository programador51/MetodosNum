import java.util.Random;

public class minimos_cuadratica_funcion{

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

	public static void main(String[] args) {
		int n,x,y,i,j,k;
		n = 4;
		Random r = new Random();
		/////////////////////////////////////////////////
		double sumY = 0,
		sumX = 0,
		sumXCuadrado = 0,
		sumXCubo = 0,
		sumYFx = 0,
		sumXFx = 0,
		sumXCuarta = 0,
		sumFxCuadrado = 0,
		sumXCuadradoFx = 0,
		sumXY = 0,
		sumXCuadY = 0,
		sumFx = 0,
		cte,
		resultados[] = new double[4];

		double valores[][] = new double[n][2];

		System.out.println("\n\t\t\tMinimos - Cuadratica con Funcion\n\n\t\t\tX\tY");
		System.out.println("\t\t\t---------------");

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

		for(x=0;x<n;x++){
			for(y=0;y<1;y++){
				valores[x][y] = numeroRandom();
				if(x>0){
					while(valores[x][y]<valores[x-1][0]){
						valores[x][y] = numeroRandom();
					}
				}
			}
			valores[x][y] = numeroRandom();
			if(x>0){
				while(valores[x][y]<valores[x-1][1]){
					valores[x][y] = numeroRandom();
				}
			}
			System.out.println("\t\t\t| "+valores[x][y-1]+" | "+valores[x][y]+" |");
			System.out.println("\t\t\t---------------");
			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE XY
			sumXY += valores[x][y-1]*valores[x][y];
			sumXY = redondear(sumXY);

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE (X^2)(Y)
			double sumXCuadYAuxiliar = Math.pow(valores[x][y-1],2);
			sumXCuadYAuxiliar = redondear(sumXCuadYAuxiliar);
			sumXCuadY += sumXCuadYAuxiliar * valores[x][y];
			sumXCuadY = redondear(sumXCuadY);

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE [Y]*[F(x)]
			sumYFx += (valores[x][1]*evaluarFuncion(funcion,valores[x][0]));
			sumYFx = redondear(sumYFx);

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE [X]*[F(x)]
			sumXFx += (valores[x][0]*evaluarFuncion(funcion,valores[x][0]));
			sumXFx = redondear(sumXFx);

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE [X^2]*[F(x)]
			sumXCuadradoFx += (redondear(Math.pow(valores[x][0],2))*evaluarFuncion(funcion,valores[x][0]));
			sumXCuadradoFx = redondear(sumXCuadradoFx);
		}

		for(x=0;x<n;x++){
			//SUMATORIA DE X
			sumX+=valores[x][0];
			sumX = redondear(sumX);

			//SUMATORIA DE F(X)
			sumFx += evaluarFuncion(funcion,valores[x][0]);
			sumFx = redondear(sumFx);

			//SUMATORIA DE FX(X)^2
			valores[x][0] =  redondear(valores[x][0]);
			double sumFxCuadradoAuxiliar = Math.rint(Math.pow(evaluarFuncion(funcion,valores[x][0]),2) * 100000000)/100000000;
			sumFxCuadrado += sumFxCuadradoAuxiliar;

			//SUMATORIA DE Y
			sumY+=valores[x][1];
			sumY = redondear(sumY);

			//SUMATORIA DE X^2
			double sumXCuadradoAuxiliar = redondear(Math.pow(valores[x][0],2));
			sumXCuadrado += sumXCuadradoAuxiliar;
			sumXCuadrado = redondear(sumXCuadrado);

			//SUMATORIA DE X^3
			double sumXCuboAuxiliar = Math.rint(Math.pow(valores[x][0],3)*1000000)/1000000;
			sumXCubo += sumXCuboAuxiliar;
			sumXCubo = redondear(sumXCubo);

			//SUMATORIA DE X^4
			double sumXCuartaAuxiliar = Math.rint(Math.pow(valores[x][0],4)*1000000)/1000000;
			sumXCuarta += sumXCuartaAuxiliar;
			sumXCuarta = redondear(sumXCuarta);
		}
		System.out.println("\nn = "+n
			+"\nEx = "+sumX
			+"\nEx"+(char)178+" = "+sumXCuadrado
			+"\nEx"+(char)179+" = "+sumXCubo
			+"\nEx^4 = "+sumXCuarta
			+"\nEy = "+sumY
			+"\nExy = "+sumXY
			+"\nEx"+(char)178+"y = "+sumXCuadY
			+"\nE[f(x)] = "+sumFx
			+"\nE[x*f(x)] = "+sumXFx
			+"\nE[x"+(char)178+"f(x)] = "+sumXCuadradoFx
			+"\nE[f(x)"+(char)178+"]" +sumFxCuadrado
			+"\nE[y*f(x)] = "+sumYFx);

		double despeje[] = new double [5];
		double a[][] = new double [5][6];

		a[0][0] = n;
		a[0][1] = sumX;
		a[0][2] = sumXCuadrado;
		a[0][3] = sumFx;
		a[0][4] = sumY;

		a[1][0] = sumX;
		a[1][1] = sumXCuadrado;
		a[1][2] = sumXCubo;
		a[1][3] = sumXFx;
		a[1][4] = sumXY;

		a[2][0] = sumXCuadrado;
		a[2][1] = sumXCubo;
		a[2][2] = sumXCuarta;
		a[2][3] = sumXCuadradoFx;
		a[2][4] = sumXCuadY;

		a[3][0] = sumFx;
		a[3][1] = sumXFx;
		a[3][2] = sumXCuadradoFx;
		a[3][3] = sumFxCuadrado;
		a[3][4] = sumYFx;

		for(i=0;i<n-1;i++){
		  for(j=i+1;j<=n;j++){
			 cte=(-a[j][i])/(a[i][i]);
		      for(k=i;k<n+1;k++){
			 a[j][k]=((a[i][k])*cte)+a[j][k];
			 }
		   }
		}
	 	double a3=a[n-1][n]/a[n-1][n-1];
	 	a3 = redondear(a3);

	 	double a2=(a[n-2][n]-a3*a[n-2][n-1])/a[n-2][n-2];
	 	a2 = redondear(a2);

	 	double a1=(a[n-3][n]-a2*a[n-3][n-2]-a3*a[n-3][n-1])/a[n-3][n-3];
	 	a1 = redondear(a1);

	 	double a0 = (sumY - (a1*valores[0][0] + a2*redondear(Math.pow(valores[0][0],2)) +a3*evaluarFuncion(funcion,valores[0][0])))/n;
	 	a0 = redondear(a0);

	 	System.out.println("----------------------------------");
		System.out.println("a0 = "+a0+"\na1= "+a1+" \na2= " +a2+" \na3= " +a3+"\n----------------------------------");

		for(i=0;i<4;i++){
			resultados[i] = a0*n + a1*valores[i][0] + a2*redondear(Math.pow(valores[i][0],2)) + a3*redondear(evaluarFuncion(funcion,valores[i][0]));
			resultados[i] = redondear(resultados[i]);
			System.out.println(a0+"("+n+") + " + a1+"("+valores[i][0]+") + "+ a2+"("+redondear(Math.pow(valores[i][0],2))+") + " + a3+"("+redondear(evaluarFuncion(funcion,valores[i][0]))+") = "+resultados[i]);
		}
	}
}