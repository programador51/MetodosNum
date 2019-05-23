import java.util.Random;

public class runge_kutta_38_simpson{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static double calcularY(double k1, double k2, double k3, double k4,double yn){
		double y = yn + (1.0/8.0)*(k1+3*k2+3*k3+k4);
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

		System.out.println("\n\t\tRunge - Kutta de 4to Orden (3/8 de Simpson)\n");

		funcion = 3;

		switch(funcion){
			case 1:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty'(y"+(char)178+" + t) + y = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");

			for (i=0;i<2;i++){
				k1 = h*(-yn/(redondear(Math.pow(yn,2))+tn));
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h*(-(yn+k1/3.0)/(redondear(Math.pow(yn+k1/3.0,2))+(tn+h/3.0)));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				k3 = h*(-(yn+(k1/3.0)+(k2/3.0))/(redondear(Math.pow((yn+(k1/3.0)+(k2/3.0)),2))+(tn+(2.0/3.0)*h)));
				k3 = redondear(k3);
				System.out.println("k3 = " +k3);

				k4 = h*(-(yn+k1-k2+k3)/(redondear(Math.pow((yn+k1-k2+k3),2))+(tn+h)));
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
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' + 20y - 7e^(-0.5t) = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");

			for (i=0;i<2;i++){
				k1 = h*((-20)*yn+(7*redondear(Math.exp(-0.5*tn))));
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h*((-20)*(yn+k1/3.0)+(7*redondear(Math.exp(-0.5*(tn+h/3.0)))));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				k3 = h*((-20)*(yn+(k1/3.0)+(k2/3.0))+(7*redondear(Math.exp(-0.5*(tn+(2.0/3.0)*h)))));
				k3 = redondear(k3);
				System.out.println("k3 = " +k3);

				k4 = h*((-20)*(yn+k1-k2+k3)+(7*redondear(Math.exp(-0.5*(tn+h)))));
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
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' + 3y - t"+(char)178+"= 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");

			for (i=0;i<2;i++){
				k1 = h*(redondear(Math.pow(tn,2))-(3*yn));
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h*(redondear(Math.pow((tn+h/3.0),2))-(3*(yn+k1/3.0)));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				k3 = h*(redondear(Math.pow((tn+(2.0/3.0)*h),2))-(3*(yn+(k1/3.0)+(k2/3.0))));
				k3 = redondear(k3);
				System.out.println("k3 = " +k3);

				k4 = h*(redondear(Math.pow((tn+h),2))-(3*(yn+k1-k2+k3)));
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