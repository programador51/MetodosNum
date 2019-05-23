import java.util.Random;

public class runge_kutta_segundo_orden{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static double calcularY(double k1, double k2, double yn){
		double y = yn + 0.5*(k1+k2);
		return y;
	}

	public static void main(String[] args) {
		/*SE ESCOGE ALEATORIAMENTE LA FUNCION A RESOLVER E IMPRIME EL PROBLEMA PROPUESTO*/
		int i,
		funcion = (int)(Math.random()*3)+1;

		Random r = new Random();

		double max = 3.0,
		min = 1.0,
		yn = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		h = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		tn = 0.0,
		k1 = 0.0,
		k2 = 0.0,
		y = 0.0;

		double resultados[] = new double[2];

		System.out.println("\n\t\tRunge - Kutta de 2do Orden\n");

		switch(funcion){
			case 1:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' + 3y - e^-t = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn);
			
			for(i=0;i<2;i++){
				k1 = h * (redondear(Math.exp(tn))-3*yn);
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h * (redondear(Math.exp(-(tn+h)))-3*(yn+k1));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				y = redondear(calcularY(k1,k2,yn));
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");

				resultados[i] = y;

				yn = y;
				tn = tn + h;
			}
			break;

			case 2:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' - 2ty + 1 = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn);
			for(i=0;i<2;i++){
				k1 = h * ((2*tn*yn)-1);
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h * ((2*(tn+h)*(yn+k1))-1);
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				y = redondear(calcularY(k1,k2,yn));
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");

				resultados[i] = y;

				yn = y;
				tn = tn + h;
			}
			break;

			case 3:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty'/[(y+1)(t+1)cos(t"+(char)178+"+2t)] = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn);
			for (i=0;i<2;i++){
				k1 = h * ((yn+1)*(tn+1)*redondear(Math.cos(redondear(Math.pow(tn,2)+(2*tn)))));
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h * (((yn+k1)+1)*((tn+h)+1)*redondear(Math.cos(redondear(Math.pow((tn+h),2)+(2*(tn+h))))));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				y = redondear(calcularY(k1,k2,yn));
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
