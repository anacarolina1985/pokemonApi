package br.com.ana.alves.araujo.pokemon.response;

public class ResponseBase {

	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public ResponseBase(String data){
		this.data = data;
	}
}
