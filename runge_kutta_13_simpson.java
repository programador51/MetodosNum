import java.util.Random;

public class runge_kutta_13_simpson{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static double calcularY(double k1, double k2, double k3, double k4,double yn){
		double y = yn + (1.0/6.0)*(k1+2*k2+2*k3+k4);
		return y;
	}

	public static void main(String[] args) {
		/*SE ESCOGE ALEATORIAMENTE LA FUNCION A RESOLVER E IMPRIME EL PROBLEMA PROPUESTO*/
		int i,
		funcion = (int)(Math.random()*1)+1;

		Random r = new Random();

		double max = 3.0,
		min = 1.0,
		yn = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		h = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		tn = 0.0,
		k1 = 0.0,
		k2 = 0.0,
		k3 = 0.0,
		k4 = 0.0,
		y = 0.0;

		double resultados[] = new double[2];

		System.out.println("\n\t\tRunge - Kutta de 4to Orden (1/3 de Simpson)\n");

		funcion = 3;
		h = 0.1;
		yn = 1.0;

		switch(funcion){
			case 1:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' - y'y - (y + t)"+(char)178+" = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");
			
			for(i=0;i<2;i++){
				k1 = h * (redondear(Math.pow((yn+tn),2))/(1-yn));
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h * (redondear(Math.pow(((yn+k1/2.0)+(tn+h/2.0)),2))/(1-(yn+k1/2.0)));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				k3 = h * (redondear(Math.pow(((yn+k2/2.0)+(tn+h/2.0)),2))/(1-(yn+k2/2.0)));
				k3 = redondear(k3);
				System.out.println("k3 = " +k3);

				k4 = h * (redondear(Math.pow(((yn+k3)+(tn+h)),2))/(1-(yn+k3)));
				k4 = redondear(k4);
				System.out.println("k4 = " +k4);

				y = calcularY(k1,k2,k3,k4,yn);
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");

				resultados[i] = y;

				yn = y;
				tn = tn + h;
			}
			break;

			case 2:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' + y - t - 1 = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");

			for (i=0;i<2;i++){
				k1 = h * (tn+1-yn);
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h * ((tn+h/2.0)+1-(yn+k1/2.0));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				k3 = h * ((tn+h/2.0)+1-(yn+k2/2.0));
				k3 = redondear(k3);
				System.out.println("k3 = " +k3);

				k4 = h * ((tn+h)+1-(yn+k3));
				k4 = redondear(k4);
				System.out.println("k4 = " +k4);

				y = calcularY(k1,k2,k3,k4,yn);
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");

				resultados[i] = y;

				yn = y;
				tn = tn + h;
			}
			break;

			case 3:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' - 1 + t - 4y = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");

			for (i=0;i<2;i++){
				k1 = h * (1-tn+4*yn);
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h * (1-(tn+h/2.0)+4*(yn+k1/2.0));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				k3 = h * (1-(tn+h/2.0)+4*(yn+k2/2.0));
				k3 = redondear(k3);
				System.out.println("k3 = " +k3);

				k4 = h * (1-(tn+h)+4*(yn+k3));
				k4 = redondear(k4);
				System.out.println("k4 = " +k4);

				y = calcularY(k1,k2,k3,k4,yn);
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");

				resultados[i] = y;

				yn = y;
				tn = tn + h;
			}

			break;
			default:
		}
	}
}