package View.Pizza.RemocaoPizza;

import Database.DAO.DAOPersistente.DAOPersistentePizza;
import Model.Pizza;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RemoverPizzaController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Text LabelRemoverPizza;

    @FXML
    private JFXButton ButtonRemover;

    @FXML
    private JFXButton ButtonVoltar;

    @FXML
    private JFXComboBox<String> JFXComboBoxPizza;

    @FXML
    private JFXTextField JFXTextFieldSabor;

    @FXML
    private JFXTextField JFXTextFieldPreco;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarComboBox();
    }

    @FXML
    private void acaoBotaoVoltar(ActionEvent event) throws IOException {
        Parent telaInicialParent = FXMLLoader.load(getClass().getResource("/View/TelaInicial/TelaInicial.fxml"));
        Scene telaInicialScene = new Scene(telaInicialParent);
        Stage tela = (Stage) ((Node)event.getSource()).getScene().getWindow();
        tela.setScene(telaInicialScene);
        tela.show();
    }


    @FXML
    private void carregarComboBox(){
        DAOPersistentePizza daoPizza = new DAOPersistentePizza();
        for (Pizza pizza : daoPizza.listarTodos()){
            JFXComboBoxPizza.getItems().addAll(pizza.getSabor());
        }


    }

    @FXML
    private void pegarPizza(){
        DAOPersistentePizza daoPizza = new DAOPersistentePizza();
        Pizza pizza = daoPizza.pegarPeloNome(String.valueOf(JFXComboBoxPizza.getSelectionModel().getSelectedItem()));
        JFXTextFieldSabor.setText(pizza.getSabor());
        JFXTextFieldPreco.setText(String.valueOf(pizza.getPreco()));
    }

    @FXML
    private void acaoBotaoRemoverPizza(){
        DAOPersistentePizza daoPizza = new DAOPersistentePizza();
        daoPizza.removerPeloNome(JFXTextFieldSabor.getText());
        limparCampoRemovido();
    }

    private void limparCampoRemovido(){
        JFXTextFieldSabor.setText("");
        JFXTextFieldPreco.setText("");
    }
}
