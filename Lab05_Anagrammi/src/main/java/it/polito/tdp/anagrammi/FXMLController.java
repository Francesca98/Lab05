package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    private static final int LinkedList = 0;
    Model model ;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserisciParola;

    @FXML
    private Button btnCalcoloAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErratti;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErratti.clear();
    	this.txtInserisciParola.clear();

    }

    @FXML
    void hadleCalcoloAnagrammi(ActionEvent event) {
    	String string = txtInserisciParola.getText().toLowerCase();
    	if(!string.matches("[a-zA-Z]*"))
    	{
    		this.txtAnagrammiCorretti.appendText("Formato stringa non valido!");
    		return;
    	}
    	List<Character> list = new ArrayList<>();
    	for(int i=0 ; i<string.length();i++)
    	{
    		list.add(string.charAt(i));
    		//System.out.println(string.charAt(i));
    	}
    	
    	List <String> anagrammi =this.model.anagrammi(list);
    	for(String s : anagrammi)
    	{
    	
    		if(this.model.isCorret(s))
    		{	txtAnagrammiCorretti.appendText(s+"\n");}
    		else
    			txtAnagrammiErratti.appendText(s+"\n");
    	}
    	

    }
   
    @FXML
    void initialize() {
        assert txtInserisciParola != null : "fx:id=\"txtInserisciParola\" was not injected: check your FXML file 'Anagramma.fxml'.";
        assert btnCalcoloAnagrammi != null : "fx:id=\"btnCalcoloAnagrammi\" was not injected: check your FXML file 'Anagramma.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Anagramma.fxml'.";
        assert txtAnagrammiErratti != null : "fx:id=\"txtAnagrammiErratti\" was not injected: check your FXML file 'Anagramma.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagramma.fxml'.";

    }

	

	public void setModel(Model model2) {
		this.model=model2;
		
	}

}
