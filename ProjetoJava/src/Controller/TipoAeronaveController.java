package Controller;

import java.util.ArrayList;
import java.util.Vector;

import Model.TipoAeronave;

public class TipoAeronaveController {

	public boolean cadastrarTipoAeronave(String descricao) throws Exception {
		if (descricao != null && descricao.length() > 0) {
			TipoAeronave desc = new TipoAeronave(descricao);
			desc.cadastrarTipoAeronave(desc);
			return true;
		}
		return false;
	}

	public ArrayList<TipoAeronave> listaTipoAeronave(String nome) throws Exception {
		return new TipoAeronave().listaTipoAeronave(nome);
	}

	public boolean alterarTipoAeronave(Integer idTipoAeronave, String descricao) throws Exception {
		if (idTipoAeronave != null && idTipoAeronave > 0 && descricao != null && descricao.length() > 0) {
			TipoAeronave tpAeronave = new TipoAeronave(idTipoAeronave, descricao);
			tpAeronave.setIdTipoAeronave(idTipoAeronave);
			tpAeronave.alterarTipoAeronave(tpAeronave);
			return true;
		}
		return false;
	}

	public boolean apagarTipoAeronave(Integer idTipoAeronave) throws Exception {
		if (idTipoAeronave == 0) {
			return false;
		} else {
			TipoAeronave tpAeronave = new TipoAeronave();
			tpAeronave.setIdTipoAeronave(idTipoAeronave);
			tpAeronave.apagarTipoAeronave(tpAeronave);
			return true;
		}
	}

}

