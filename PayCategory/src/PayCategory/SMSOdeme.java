package PayCategory;

public class SMSOdeme implements IOdemeTipi{

	@Override
	public String Ode(double tutar) {
		return "SMS ile : " + tutar+ " Tl ödeme yapıldı";
	}

}
