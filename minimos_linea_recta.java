import java.util.Random;

public class minimos_linea_recta{
	public static void main(String[] args){
		System.out.println("\n\t\tEjercicio de Linea recta\n");
		
		/*AQUI SE GENERAN DE MANERA ALEATORIA LOS VALORES DE X & Y PARA EL PROBLEMA A RESOLVER*/
		//n.- ES EL NUMERO DE VALORES DADOS A "X"
		int limite = 6,n,x,y;
		n = (int)(Math.random()*limite)+1;
		System.out.println("n = "+n);
		/////////////////////////////////////////////////

		Random rx = new Random();
		Random ry = new Random();
		Random r = new Random();

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
				valores[x][y] = random = min + r.nextDouble() * (max - min);
			}
			valores[x][y] = random = min + r.nextDouble() * (max - min);
			System.out.println("["+x+"]["+(y-1)+"]= "+valores[x][y-1]+"\t["+x+"]["+y+"]= "+valores[x][y]);
			//SE OBTIENE LA SUMATORIA DE LA MULTIPLICACION DE XY
			sumXY += valores[x][y-1]*valores[x][y];
		}

		/*SE OBTIENEN LOS DATOS DE LAS SUMATORIAS DEACUERDO AL PROBLEMA GENERADO*/
		for(x=0;x<n;x++){
			//SUMATORIA DE X
			sumX+=valores[x][0];
			//SUMATORIA DE Y
			sumY+=valores[x][1];
		}
		//SUMATORIA DE X^2
		sumXCuadrado = sumX*sumX;
		System.out.println("\nSumatoria X="+sumX
			+"\nSumatoria X^2="+sumXCuadrado
			+"\nSumatoria Y="+sumY
			+"\nSumatoria XY="+sumXY);
	}
}