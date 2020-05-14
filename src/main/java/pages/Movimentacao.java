package pages;

import hooks.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.crypto.Data;

import static org.junit.Assert.assertEquals;

public class Movimentacao extends BaseTest {

    @FindBy (css="#tipo")
    private WebElement txtTipodeMovimentacao;

    @FindBy (css="#data_transacao")
    private WebElement txtDataDaMovimentacao;

    @FindBy (css="#data_pagamento")
    private WebElement txtDataDoPagamento;

    @FindBy (css="#descricao")
    private WebElement txtDescricao;

    @FindBy (css="#interessado")
    private WebElement txtInteressado;

    @FindBy (css="#valor")
    private WebElement txtValor;

    @FindBy (css="#conta")
    private WebElement txtConta;

    @FindBy (css="#status_pendente")
    private WebElement rdoPendente;

    @FindBy (css="#status_pago")
    private WebElement rdoPago;

    @FindBy(css="button[type='submit']")
    private WebElement btnSalvar;

    @FindBy(css="div.alert.alert-success")
    private WebElement msgMovimentacaoAdicionadaComSucesso;

    public void preencheFormulario (String tipoMovimentacao, String dataMovimentacao, String dataPagamento, String descricao, String interessado, String valor, String conta, String situacao ) {
        txtTipodeMovimentacao.sendKeys(tipoMovimentacao);
        txtDataDaMovimentacao.sendKeys(dataMovimentacao);
        txtDataDoPagamento.sendKeys(dataPagamento);
        txtDescricao.sendKeys(descricao);
        txtInteressado.sendKeys(interessado);
        txtValor.sendKeys(valor);
        txtConta.sendKeys(conta);
        if(situacao == "pendente"){
            rdoPendente.click();}
        if (situacao == "pago"){
            rdoPago.click();}
    }

    public void salvaMovimentacao() {
        btnSalvar.click();
    }

    public boolean validaMovimentacao (String valMovimentacao) {
        String txtMovimentacaoAdicionadaComSucesso = msgMovimentacaoAdicionadaComSucesso.getText();
        assertEquals(valMovimentacao, txtMovimentacaoAdicionadaComSucesso);
        return true;
    }
}