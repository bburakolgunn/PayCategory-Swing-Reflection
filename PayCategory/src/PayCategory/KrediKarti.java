package PayCategory;

public class KrediKarti implements IOdemeTipi{

	@Override
	public String Ode(double tutar) {
	
		return "Kredi Kartı ile : " + tutar+ " Tl ödeme yapıldı";
	}

}
