import java.util.Random;

public class euler_adelante{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static void main(String[] args) {
		int i,
		funcion = (int)(Math.random()*3)+1,
		calcula = (int)(Math.random()*3)+1;

		Random r = new Random();

		double max = 3.0,
		min = 1.0,
		yn = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		h = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		tn = 0.0,
		y = 0;

		double resultados[] = new double[2];

		System.out.println("\n\t\tEuler Hacia Adelante\n");
		switch(funcion){
			case 1:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\t3y' - 5yt + 1 = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");
			for (i=0;i<2;i++){
				y = yn + h*(((5*yn*tn)-1)/3);
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");
				resultados[i] = y;
				yn = y;
				tn = tn + h;
			}
			break;

			case 2:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\t1 + y'e^(3t) = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");
			for (i=0;i<2;i++){
				y = yn + h*(-1/redondear(Math.exp(3*tn)));
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");
				resultados[i] = y;
				yn = y;
				tn = tn + h;
			}
			break;

			case 3:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' - t"+(char)178+" - t"+(char)178+"y"+(char)178+" = 0\ty0 = "+yn+"\th = "+h+"\tt0 = "+tn+"\n");

			for (i=0;i<2;i++){
				y = yn + h*(redondear(Math.pow(tn,2))+redondear(Math.pow(tn,2))*redondear(Math.pow(yn,2)));
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
