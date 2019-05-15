import java.util.Random;
import java.text.DecimalFormat;

public class minimos_linea_recta{
	public static void main(String[] args){
		System.out.println("\n\t\tEjercicio de Linea recta\n");
		
		/*AQUI SE GENERAN DE MANERA ALEATORIA LOS VALORES DE X & Y PARA EL PROBLEMA A RESOLVER*/
		//n.- ES EL NUMERO DE VALORES DADOS A "X"
		int limite = 5,n,x,y;
		n = (int)(Math.random()*limite)+2;
		System.out.println("n = "+n);
		/////////////////////////////////////////////////
		Random r = new Random();

		DecimalFormat round = new DecimalFormat ("0.00000000");

		double random,
		randomx,
		randomy,
		sumY = 0,
		sumX = 0,
		sumXCuadrado = 0,
		sumXY = 0,
		max = 10.0,
		min = 1.0; 

		double valores[][] = new double[n][2];

		for(x=0;x<n;x++){
			for(y=0;y<1;y++){
				random = min + r.nextDouble() * (max - min);
				valores[x][y] = Double.parseDouble(round.format(random));
			}
			random = min + r.nextDouble() * (max - min);
			valores[x][y] = Double.parseDouble(round.format(random));
			System.out.println("["+x+"]["+(y-1)+"]= "+valores[x][y-1]+"\t["+x+"]["+y+"]= "+valores[x][y]);
			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE XY
			sumXY += valores[x][y-1]*valores[x][y];
			sumXY = Double.parseDouble(round.format(sumXY));
		}

		/*SE OBTIENEN LOS DATOS DE LAS SUMATORIAS DEACUERDO AL PROBLEMA GENERADO*/
		for(x=0;x<n;x++){
			//SUMATORIA DE X
			sumX+=valores[x][0];
			sumX = Double.parseDouble(round.format(sumX));
			//SUMATORIA DE Y
			sumY+=valores[x][1];
			sumY = Double.parseDouble(round.format(sumY));
			//SUMATORIA DE X^2
			valores[x][0] = Double.parseDouble(round.format(valores[x][0]));
			double sumXCuadradoAuxiliar = Double.parseDouble(round.format(Math.pow(valores[x][0],2)));
			sumXCuadrado += sumXCuadradoAuxiliar;
		}
		System.out.println("\nSumatoria X="+sumX
			+"\nSumatoria X^2="+sumXCuadrado
			+"\nSumatoria Y="+sumY
			+"\nSumatoria XY="+sumXY);

		/*SE RESUELVE EL SISTEMA DE ECUACIONES CON DETERMINANTES
		ALMENOS ESTE TIPO DE PROBLEMA SIEMPRE SERA 2X2*/
		System.out.println("\n\t\tEcuaciones\n\n"
			+"1)\t"+n+"a0\t"+sumX+"a1\t=\t"+sumY
			+"\n2)\t"+sumX+"a0\t"+sumXCuadrado+"a1\t=\t"+sumXY);
		double det=(n*sumXCuadrado)-(sumX*sumX);
		det = Double.parseDouble(round.format(det));

		double a0 = ((sumY*sumXCuadrado)-(sumX*sumXY))/det;
		a0 = Double.parseDouble(round.format(a0));

        double a1 = ((n*sumXY)-(sumY*sumX))/det;
        a1 = Double.parseDouble(round.format(a1));

        System.out.println("\n"
        	+"a0="+a0
        	+"\na1="+a1+"\n\n");

        for(int i=0;i<n;i++){
        	double gx = a0 + a1*valores[i][0];
        	gx = Double.parseDouble(round.format(gx));
        	System.out.println(a0+" + "+a1+"("+valores[i][0]+") = "+gx);
        }
	}
}
