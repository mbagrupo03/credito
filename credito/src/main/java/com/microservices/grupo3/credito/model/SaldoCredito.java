package com.microservices.grupo3.credito.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoCredito {
	
	 private double saldoCredito;


	 	@JsonCreator
	    public SaldoCredito(@JsonProperty("saldo_credito") double saldoCredito) {
		super();
		this.saldoCredito = saldoCredito;
	}

		public double getSaldoCredito() {
	        return saldoCredito;
	    }

	    public void setSaldoCredito(double saldoCredito) {
	        this.saldoCredito = saldoCredito;
	    }

}
