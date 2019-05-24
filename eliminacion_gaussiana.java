import java.util.Random;

public class eliminacion_gaussiana{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static double numeroRandom(){
		Random r = new Random();

		double max = 10.0,
		min = 1.0,
		random = 0;

		random = min + r.nextDouble() * (max - min);
		random = Math.rint(random * 1)/1;
		return random;
	}

	public static void main(String[] args) {
	int i,j,k,n;
	double a[][] = new double [5][6];
	double resultados[] = new double[3];
	double cte,x1,x2,x3;
	double x[] = new double [5];

	n = 3;

	System.out.println("\t\tEliminacion Gaussiana");

	for(i=0;i<n;i++){
		for(j=0;j<=n;j++){
			a[i][j]=numeroRandom();
		}
	}

	for(i=0;i<n;i++){
		for(j=0;j<=n;j++){
			System.out.print(a[i][j]+"\t");
		}
		System.out.print("\n");	
	}

	for(i=0;i<n-1;i++){
		  for(j=i+1;j<=n;j++){
			 cte=(-a[j][i])/(a[i][i]);
		      for(k=i;k<n+1;k++){
			 a[j][k]=((a[i][k])*cte)+a[j][k];
			 }
		   }
	}
	 	x3=a[n-1][n]/a[n-1][n-1];
	 	x3 = redondear(x3);
	 	resultados[0] = x3;

	 	x2=(a[n-2][n]-x3*a[n-2][n-1])/a[n-2][n-2];
	 	x2 = redondear(x2);
	 	resultados[1] = x2;

	 	x1=(a[n-3][n]-x2*a[n-3][n-2]-x3*a[n-3][n-1])/a[n-3][n-3];
	 	x1 = redondear(x1);
	 	resultados[2] = x1;

	 	System.out.println("\nx1= "+resultados[2]+" \nx2= " +resultados[1]+" \nx3= " +resultados[0]);
	}
}
