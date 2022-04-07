package com.microservices.grupo3.credito.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.grupo3.credito.model.Credito;
import com.microservices.grupo3.credito.model.SaldoCredito;
import com.microservices.grupo3.credito.services.CreditoService;

@RestController
@RequestMapping("/credito")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping(path = "/status_aplicacao")
    public String checarStatusAplicacao(){
        return "Aplicação credito online";
    }

    @PostMapping
    public Credito criarCredito(@RequestBody Credito credito){
        return creditoService.criarCredito(credito);
    }

    //GET PARA CONSULTAR TODAS AS TRANSACOES POR TIPO CONTA
    @GetMapping(path = "/contas")
    public List<Credito> consultaTransacoesPorTipo(@RequestParam(value = "tipoConta", required = true) String tipoConta) {
        return creditoService.consultaTransacoesTipoConta(tipoConta);
    }

    //GET PARA CONSULTAR TODAS AS TRANSACOES DAS CONTAS
    @GetMapping(path = "/listar/contas")
    public List<Credito> listarContas() {
        return creditoService.listarContas();
    }

    //GET PARA CONSULTAR TRANSACOES DE CREDITO POR CONTA CORRENTE
    @GetMapping(path = "/extrato/contacorrente/{contaId}")
	public List<Credito> consultaExtratoContaCorrente(@PathVariable("contaId") Integer contaId) {
		return  creditoService.consultaContaIdContaCorrente(contaId);
	}

    //GET PARA CONSULTAR TRANSACOES DE CREDITO POR CONTA INVESTIMENTO
    @GetMapping(path = "/extrato/investimento/{contaId}") 
    public List<Credito> consultaExtratoContaInvestimento(@PathVariable("contaId") Integer contaId) {
        return creditoService.consultaContaIdInvestimento(contaId);
    }

    //GET PARA CONSOLIDAR OS VALORES DE CREDITO EM UMA CONTA CORRENTE
    @GetMapping(path = "/saldo/contacorrente/{contaId}")
	public SaldoCredito consultaSaldoConsolidadoContaCorrente(@PathVariable("contaId") Integer contaId) {
    	SaldoCredito saldoCreditoResponse =
                new SaldoCredito(creditoService.consultaSaldoContaIdContaCorrente(contaId));
        return  saldoCreditoResponse;
	}

    //GET PARA CONSOLIDAR OS VALORES DE CREDITO EM UMA CONTA INVESTIMENTO
    @GetMapping(path = "/saldo/investimento/{contaId}")
    public SaldoCredito consultaSaldoConsolidadoContaInvestimento(@PathVariable("contaId") Integer contaId) {
    	SaldoCredito saldoCreditoResponse =
                new SaldoCredito(creditoService.consultaSaldoContaIdContaInvestimento(contaId));
        return saldoCreditoResponse;
    }
}
