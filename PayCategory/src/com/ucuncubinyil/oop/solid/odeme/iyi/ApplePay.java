package com.ucuncubinyil.oop.solid.odeme.iyi;

public class ApplePay implements IOdemeTipi{

	@Override
	public String Ode(double tutar) {
		return "Apple Pay ile : " + tutar+ " Tl ödeme yapıldı";
	}

}
