import java.util.Random;

public class runge_kutta_tercer_orden{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static double calcularY(double k1, double k2, double k3,double yn){
		double y = yn + (1.0/6.0)*(k1+(4*k2)+k3);
		return y;
	}

	public static void main(String[] args) {
		/*SE ESCOGE ALEATORIAMENTE LA FUNCION A RESOLVER E IMPRIME EL PROBLEMA PROPUESTO*/
		int i,
		funcion = (int)(Math.random()*1)+1,
		calcula = (int)(Math.random()*3)+1;

		Random r = new Random();

		double max = 3.0,
		min = 1.0,
		yn = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		h = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		tn = 0.0,
		k1 = 0.0,
		k2 = 0.0,
		k3 = 0.0,
		y = 0.0;

		yn = 1.0;
		h = 0.25;

		System.out.println("\n\t\tRunge - Kutta de 3er Orden\n");

		switch(funcion){
			case 1:
			System.out.println("Calcula y"+calcula+" con los siguientes datos\n\ty'y - 2yt - 1 = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");
			
			for(i=0;i<calcula;i++){
				k1 = h * (redondear((2*yn*tn)+1)/redondear(Math.pow(yn,2)));
				k1 = redondear(k1);
				System.out.println("k1 = " +k1);

				k2 = h * (redondear((2*(yn+(k1/2.0))*(tn+h/2.0)))+1)/(redondear(Math.pow(yn+(k1/2.0),2)));
				k2 = redondear(k2);
				System.out.println("k2 = " +k2);

				k3 = h * (redondear((2*(yn-k1+2*k2)*(tn+h)+1)))/redondear(Math.pow(yn-k1+2*k2,2));
				k3 = redondear(k3);
				System.out.println("k3 = " +k3);

				y = calcularY(k1,k2,k3,yn);
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");

				yn = y;
				tn = tn + h;
			}
			break;

			case 2:
			break;

			case 3:
			break;
			default:
		}
	}
}