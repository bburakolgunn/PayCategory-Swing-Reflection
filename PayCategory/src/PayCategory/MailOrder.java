package PayCategory;

public class MailOrder implements IOdemeTipi{

	@Override
	public String Ode(double tutar) {
		return "Mail Order ile : " + tutar+ " Tl ödeme yapıldı";
	}

}
