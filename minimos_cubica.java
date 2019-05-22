import java.util.Random;

public class minimos_cubica{

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

	public static void main(String[] args) {
		int n,x,y,i,j,k;
		n = 4;
		/////////////////////////////////////////////////
		double sumY = 0,
		sumX = 0,
		sumXCuadrado = 0,
		sumXCubo = 0,
		sumXCuarta = 0,
		sumXQuinta = 0,
		sumXSexta = 0, 
		sumXY = 0,
		sumXCuadY = 0,
		sumXCuboY = 0,
		cte,
		resultados[] = new double[4];
	
		/*SE CREA LA TABLA CON LOS VALORES X & Y*/

		double valores[][] = new double[n][2];
		System.out.println("\n\t\t\tMinimos - Cubica\n\n\t\t\tX\tY");
		System.out.println("\t\t\t---------------");

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

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE (X^2)(Y)
			double sumXCuadYAuxiliar = Math.pow(valores[x][y-1],2);
			sumXCuadYAuxiliar = redondear(sumXCuadYAuxiliar);
			sumXCuadY += sumXCuadYAuxiliar * valores[x][y];
			sumXCuadY = redondear(sumXCuadY);

			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE (X^3)(Y)
			double sumXCuboYAuxiliar = Math.pow(valores[x][y-1],3);
			sumXCuboYAuxiliar = Math.rint(sumXCuboYAuxiliar*1000000)/1000000;
			sumXCuboY += sumXCuboYAuxiliar * valores[x][y];
			sumXCuboY = Math.rint(sumXCuboY*1000000)/1000000;

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
			double sumXCuboAuxiliar = Math.rint(Math.pow(valores[x][0],3)*1000000)/1000000;
			sumXCubo += sumXCuboAuxiliar;
			sumXCubo = Math.rint(sumXCubo*1000000)/1000000;

			//SUMATORIA DE X^4
			double sumXCuartaAuxiliar = Math.rint(Math.pow(valores[x][0],4)*1000000)/1000000;
			sumXCuarta += sumXCuartaAuxiliar;
			sumXCuarta = Math.rint(sumXCuarta*1000000)/1000000;

			//SUMATORIA DE X^5
			double sumXQuintaAuxiliar = Math.rint(Math.pow(valores[x][0],5)*1000000)/1000000;
			sumXQuinta += sumXQuintaAuxiliar;
			sumXQuinta = Math.rint(sumXQuinta*1000000)/1000000;

			//SUMATORIA DE X^6
			double sumXSextaAuxiliar = Math.rint(Math.pow(valores[x][0],6)*1000000)/1000000;
			sumXSexta += sumXSextaAuxiliar;
			sumXSexta = Math.rint(sumXSexta*1000000)/1000000;
		}
		System.out.println("\nEx = "+sumX
			+"\nEx"+(char)178+" = "+sumXCuadrado
			+"\nEx"+(char)179+" = "+sumXCubo
			+"\nEx^4 = "+sumXCuarta
			+"\nEx^5 = "+sumXQuinta
			+"\nEx^6 = "+sumXSexta
			+"\nEy = "+sumY
			+"\nExy = "+sumXY
			+"\nEx"+(char)178+"y = "+sumXCuadY
			+"\nEx"+(char)179+"y = "+sumXCuboY);

		double despeje[] = new double [5];
		double a[][] = new double [5][6];

		a[0][0] = n;
		a[0][1] = sumX;
		a[0][2] = sumXCuadrado;
		a[0][3] = sumXCubo;
		a[0][4] = sumY;

		a[1][0] = sumX;
		a[1][1] = sumXCuadrado;
		a[1][2] = sumXCubo;
		a[1][3] = sumXCuarta;
		a[1][4] = sumXY;

		a[2][0] = sumXCuadrado;
		a[2][1] = sumXCubo;
		a[2][2] = sumXCuarta;
		a[2][3] = sumXQuinta;
		a[2][4] = sumXCuadY;

		a[3][0] = sumXCubo;
		a[3][1] = sumXCuarta;
		a[3][2] = sumXQuinta;
		a[3][3] = sumXSexta;
		a[3][4] = sumXCuboY;

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

	 	double a0 = (sumY-((sumX*a1)+(sumXCuadrado*a2)+(sumXCubo*a3)))/n;
	 	a0 = redondear(a0);

	 	System.out.println("----------------------------------");
		System.out.println("a0 = "+a0+"\na1= "+a1+" \na2= " +a2+" \na3= " +a3+"\n----------------------------------");

		for(i=0;i<4;i++){
			resultados[i] = a0*n + a1*valores[i][0] + a2*redondear(Math.pow(valores[i][0],2)) + a3*redondear(Math.pow(valores[i][0],3));
			resultados[i] = redondear(resultados[i]);
			System.out.println(a0+"("+n+") + " + a1+"("+valores[i][0]+") + "+ a2+"("+redondear(Math.pow(valores[i][0],2))+") + " + a3+"("+redondear(Math.pow(valores[i][0],3))+") = "+resultados[i]);
		}

	}
}
