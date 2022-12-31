package Controller;

import java.util.ArrayList;

import Model.Aeronave;
import Model.TipoAeronave;


public class AeronaveController {

	public boolean cadastrarAeronave( String fabricante, String modelo, String codigoAeronave, String tipoaeronave)
			throws Exception {
		if (fabricante != null && fabricante.length() > 0 && modelo != null && modelo.length() > 0
				&& codigoAeronave != null && codigoAeronave.length() > 0  && tipoaeronave != null && tipoaeronave.length() > 0) {
			Aeronave aeronave = new Aeronave(fabricante, modelo, codigoAeronave, tipoaeronave);
			aeronave.cadastrarAeronave(aeronave);
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Aeronave> listaAeronaves(String nome) throws Exception {
		return new Aeronave().listaAeronaves(nome);
	}

	public boolean alterarAeronave(int idAeronave, String fabricante, String modelo, String codigoAeronave,String tipoaeronave) throws Exception {
		if (fabricante != null && fabricante.length() > 0 && modelo != null && modelo.length() > 0
				&& codigoAeronave != null && codigoAeronave.length() > 0) {
			Aeronave aeronave = new Aeronave( fabricante, modelo, codigoAeronave, tipoaeronave);
			aeronave.setIdAeronave(idAeronave);
			aeronave.alterarAeronave(aeronave);
			return true;
		}
		return false;
	}

	public boolean apagarAeronave(Integer idAeronave) throws Exception {
		if (idAeronave == 0) {
			return false;
		} else {
			Aeronave aeronave = new Aeronave();
			aeronave.setIdAeronave(idAeronave);
			aeronave.apagarAeronave(aeronave);
			return true;
		}
	}
}

