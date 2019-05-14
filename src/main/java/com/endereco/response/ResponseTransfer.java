package com.endereco.response;

public class ResponseTransfer {
	private String status;
	private String mensagem;
	public ResponseTransfer() {
		
	}
	
	public ResponseTransfer(String status) {
		this.status = status;
	}
	public ResponseTransfer(String status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}
	
	
	public String getstatus() {
		return status;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setstatus(String status) {
		this.status =  status;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
