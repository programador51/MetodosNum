import java.util.Random;

public class euler_modificado{

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
		yn1 = yn, 
		h = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		tn = 0.0,
		tn1 = 0.0,
		y = 0;

		tn1 = tn + h;

		double resultados[] = new double[2];

		System.out.println("\n\t\tEuler Modificado\n");
		switch(funcion){
			case 1:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\t2y' + 3yt + y = 0\ty0 = "+yn+"\ty1 = "+yn1+"\th = "+h+"\tt0 = "+tn+"\n");
			for (i=0;i<2;i++){
				y = yn + (h/2.0)*(((-3*yn*tn-yn)/2.0)+((-3*yn1*tn1-yn1)/2.0));
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");
				resultados[i] = y;
				tn = tn + h;
				tn1 = tn + h;
				yn1 = y;
			}
			break;

			case 2:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' + y/2 - sen(t) = 0\ty0 = "+yn+"\ty1 = "+yn1+"\th = "+h+"\tt0 = "+tn+"\n");
			for (i=0;i<2;i++){
				y = yn + (h/2)*((redondear(Math.sin(tn))-(yn/2.0))+(redondear(Math.sin(tn1))-(yn1/2.0)));
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");
				resultados[i] = y;
				tn = tn + h;
				tn1 = tn + h;
				yn1 = y;		
			}
			break;

			case 3:
			System.out.println("Calcula y1 & y2 con los siguientes datos\n\ty' - 14t - 8y = 0\ty0 = "+yn+"\ty1 = "+yn1+"\th = "+h+"\tt0 = "+tn+"\n");
			for (i=0;i<2;i++){
				y = yn + (h/2)*(((14*tn)+(8*yn))+((14*tn1)+(8*yn1)));
				y = redondear(y);
				System.out.println("y"+(i+1)+" = "+y+"\n--------------------");
				resultados[i] = y;
				tn = tn + h;
				tn1 = tn + h;
				yn1 = y;		
			}

			break;
			default:
		}	
	}
}