package com.microservices.grupo3.credito.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "credito")
public class Credito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id_transacao")
    private Integer idTransacao;
   
    @Column(name = "conta_id")
    private Integer contaId;

    @Column(name = "valor_credito")
    private double valorCredito;

    @Column(name = "cliente_id")
    private Integer clienteId;

    @Column(name = "tipo_conta")
    private String tipoConta;

    
    public Credito() {
        super();
    }

           

	public Credito(Integer idTransacao, Integer contaId, double valorCredito, Integer clienteId, String tipoConta) {
		super();
		this.idTransacao = idTransacao;
		this.contaId = contaId;
		this.valorCredito = valorCredito;
		this.clienteId = clienteId;
		this.tipoConta = tipoConta;
	}


	public Integer getIdTransacao() {
        return this.idTransacao;
    }

    public void setIdTransacao(Integer idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Integer getContaId() {
        return this.contaId;
    }

    public void setContaId(Integer contaId) {
        this.contaId = contaId;
    }

    public double getValorCredito() {
        return this.valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public Integer getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }



	public String getTipoConta() {
		return tipoConta;
	}


	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}


}
