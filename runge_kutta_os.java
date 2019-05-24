import java.util.Random;

public class runge_kutta_os{

	public static double redondear(double valor){
		double redondear = 0;
		redondear = Math.rint(valor * 100000000)/100000000;
		return redondear; 
	}

	public static void main(String[] args) {
		int i,
		funcion = (int)(Math.random()*3)+1;

		Random r = new Random();

		double max = 3.0,
		min = 1.0,

		yn = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		ynPrima = Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,

		h =  Math.rint((min + r.nextDouble() * (max - min))*10000)/10000,
		tn = 0.0,
		y = 0.0,

		k1 = 0.0,
		k2 = 0.0,

		m1 = 0.0,
		m2 = 0.0,

		vn = ynPrima,
		un = yn,
		qn = tn;

		double resultados[] = new double[4];

		funcion = 2;

		System.out.println("\n\t\tRunge - Kutta de Orden Superior\n");
		switch(funcion){
			case 1:
			System.out.println("Calcula y1, y1', y2 & y2' con los siguientes datos\n\t3y'' - 4ysen(t) + 2y'cos(t) = 0\ty0 = "+yn+"\ty'0 = "+ynPrima+"\th = "+h+"\tt0 = "+tn+"\n");
			for(i=0;i<2;i++){
				k1 = h*vn;
				k1 = redondear(k1);

				m1 = h*(((4*un*redondear((Math.sin(qn))))-2*vn*redondear((Math.cos(qn))))/3.0);
				m1 = redondear(m1);

				k2 = h*(vn+m1);
				k2 = redondear(k2);

				m2 = h*(((4*(un+k1)*redondear(Math.sin(qn+h)))-2*(vn+m1)*redondear(Math.cos(qn+h)))/3.0);
				m2 = redondear(m2);

				y = yn + 0.5*(k1+k2);
				y = redondear(y);

				ynPrima = ynPrima + 0.5*(m1+m2);
				ynPrima = redondear(ynPrima);

				System.out.println("\n----------------------"
					+"\nk1 = "+k1
					+"\nm1 = "+m1
					+"\nk2 = "+k2
					+"\nm2 = "+m2);

				/*SE GUARDA EN UN ARREGLO
				[0] - Y1
				[1] - Y1'
				[2] - Y2
				[3] - Y2'*/
				if(i==0){
					resultados[i] = y;
					resultados[i+1] = ynPrima;
					System.out.println(
					"y1 "+resultados[i] +"\n"
					+"y1' "+resultados[i+1]);
				}
				if(i==1){
					resultados[i+1] = y;
					resultados[i+2] = ynPrima;
					System.out.println(
					"y2 "+resultados[i+1] +"\n"
					+"y2' "+resultados[i+2]);
				}

				tn = tn + h;
				vn = ynPrima;
				un = yn;
				qn = tn;
			}
			break;

			case 2:
			System.out.println("Calcula y1, y1', y2 & y2' con los siguientes datos\n\t2y'' - y'tg(t) + y = 0\ty0 = "+yn+"\ty'0 = "+ynPrima+"\th = "+h+"\tt0 = "+tn+"\n");
			
			for(i=0;i<2;i++){
				k1 = h*vn;
				k1 = redondear(k1);

				m1 = h*((vn*redondear(Math.tan(qn))-(un))/2.0);
				m1 = redondear(m1);

				k2 = h*(vn+m1);
				k2 = redondear(k2);

				m2 = h*(((vn+m1)*redondear(Math.tan(qn+h))-(un+k1))/2.0);
				m2 = redondear(m2);

				y = yn + 0.5*(k1+k2);
				y = redondear(y);

				ynPrima = ynPrima + 0.5*(m1+m2);
				ynPrima = redondear(ynPrima);

				System.out.println("\n----------------------"
					+"\nk1 = "+k1
					+"\nm1 = "+m1
					+"\nk2 = "+k2
					+"\nm2 = "+m2);

				/*SE GUARDA EN UN ARREGLO
				[0] - Y1
				[1] - Y1'
				[2] - Y2
				[3] - Y2'*/
				if(i==0){
					resultados[i] = y;
					resultados[i+1] = ynPrima;
					System.out.println(
					"y1 "+resultados[i] +"\n"
					+"y1' "+resultados[i+1]);
				}
				if(i==1){
					resultados[i+1] = y;
					resultados[i+2] = ynPrima;
					System.out.println(
					"y2 "+resultados[i+1] +"\n"
					+"y2' "+resultados[i+2]);
				}

				tn = tn + h;
				vn = ynPrima;
				un = yn;
				qn = tn;
			}
			break;

			case 3:
			System.out.println("Calcula y1, y1', y2 & y2' con los siguientes datos\n\ty''+ y' - y - t = 0\ty0 = "+yn+"\ty'0 = "+ynPrima+"\th = "+h+"\tt0 = "+tn+"\n");
			for(i=0;i<2;i++){
				k1 = h*vn;
				k1 = redondear(k1);

				m1 = h * (-vn+un+qn);
				m1 = redondear(m1);

				k2 = h*(vn+m1);
				k2 = redondear(k2);

				m2 = h * (-(vn+m1)+(un+k1)-(qn+h));
				m2 = redondear(m2);

				y = yn + 0.5*(k1+k2);
				y = redondear(y);

				ynPrima = ynPrima + 0.5*(m1+m2);
				ynPrima = redondear(ynPrima);

				System.out.println("\n----------------------"
					+"\nk1 = "+k1
					+"\nm1 = "+m1
					+"\nk2 = "+k2
					+"\nm2 = "+m2);

				/*SE GUARDA EN UN ARREGLO
				[0] - Y1
				[1] - Y1'
				[2] - Y2
				[3] - Y2'*/
				if(i==0){
					resultados[i] = y;
					resultados[i+1] = ynPrima;
					System.out.println(
					"y1 "+resultados[i] +"\n"
					+"y1' "+resultados[i+1]);
				}
				if(i==1){
					resultados[i+1] = y;
					resultados[i+2] = ynPrima;
					System.out.println(
					"y2 "+resultados[i+1] +"\n"
					+"y2' "+resultados[i+2]);
				}
				
				tn = tn + h;
				vn = ynPrima;
				un = yn;
				qn = tn;
			}
			break;
			default:
		}
	}
}