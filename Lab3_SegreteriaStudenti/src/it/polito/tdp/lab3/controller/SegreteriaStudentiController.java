package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab3.db.CorsoDAO;
import it.polito.tdp.lab3.model.SegreteriaStudentiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

	public class SegreteriaStudentiController {

		private List<String> corsi = new LinkedList<String>();
		private CorsoDAO dao = new CorsoDAO();
		private SegreteriaStudentiModel model;
		
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<String> cmbCorso;

	    @FXML
	    private TextField txtfMatricola;

	    @FXML
	    private Button btnCerca;

	    @FXML
	    private Button btnIscrivi;

	    @FXML
	    private TextArea txtOutput;

	    @FXML
	    private Button btnReset;

	    @FXML
	    void doCerca(ActionEvent event) {

	    }

	    @FXML
	    void doClick(MouseEvent event) {

	    }

	    @FXML
	    void doIscrivi(ActionEvent event) {

	    }

	    @FXML
	    void doReset(ActionEvent event) {

	    }

	    @FXML
	    void initialize() {
	        assert cmbCorso != null : "fx:id=\"cmbCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert txtfMatricola != null : "fx:id=\"txtfMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        
	        corsi.addAll(dao.elencoCorsi());
	        cmbCorso.getItems().addAll(corsi);
	    }

		public void setModel(SegreteriaStudentiModel model) {
			this.model = model;
			
		}
	    
}

