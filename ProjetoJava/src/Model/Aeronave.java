package Model;

import java.util.ArrayList;

import Dao.AeronaveDAO;
import br.com.voeairlines.model.TipoAeronave;


public class Aeronave {
	
	private int idAeronave;
	private String fabricante;
	private String modelo;
	private String codigoAeronave;
	private String tipoaeronave;


	public Aeronave() {
		
	}


	public Aeronave(String fabricante, String modelo, String codigoAeronave, String tipoaeronave) {
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.codigoAeronave = codigoAeronave;
		this. tipoaeronave =  tipoaeronave;
	}

	public Aeronave(Integer idAeronave, String fabricante, String modelo, String codigoAeronave, String tipoaeronave) {
		this.idAeronave = idAeronave;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.codigoAeronave = codigoAeronave;
		this. tipoaeronave =  tipoaeronave;
	}


	public int getIdAeronave() {
		return idAeronave;
	}

	public void setIdAeronave(int idAeronave) {
		this.idAeronave = idAeronave;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCodigoAeronave() {
		return codigoAeronave;
	}

	public void setCodigoAeronave(String codigoAeronave) {
		this.codigoAeronave = codigoAeronave;
	}	
	
	public String getTipoaeronave() {
		return tipoaeronave;
	}

	public void setTipoaeronave(String tipoaeronave) {
		this.tipoaeronave = tipoaeronave;
	}

	public void cadastrarAeronave(Aeronave aeronave) throws Exception {
		new AeronaveDAO().cadastrarAeronave(aeronave);
	}

	public ArrayList<Aeronave> listaAeronaves(String nome) throws Exception {
		return new AeronaveDAO().listaAeronaves(nome);
	}

	public void alterarAeronave(Aeronave aeronave) throws Exception {
		new AeronaveDAO().alterarAeronave(aeronave);
	}

	public void apagarAeronave(Aeronave aeronave) throws Exception {
		new AeronaveDAO().apagarAeronave(aeronave);
	}



}


