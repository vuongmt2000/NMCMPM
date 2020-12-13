package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.FormInfo;
import model.FormTable;
import service.FormInfoService;
import service.service_impl.FormInfoServiceImpl;

public class ManagerController implements Initializable {

    @FXML
    TableView<FormTable> table;

    @FXML
    TableColumn<FormTable, Number> id;

    @FXML
    TableColumn<FormTable, String> name;

    @FXML
    TableColumn<FormTable, String> phone;

    @FXML
    TableColumn<FormTable, String> room;

    @FXML
    TableColumn<FormTable, Number> deposit;

    @FXML
    TableColumn<FormTable, String> reason;

    @FXML
    Button search;

    @FXML
    Button pay;

    @FXML
    TextField name_search;
    
    @FXML
    Button returnButton;

    @FXML
    TextField phone_search;

    @FXML
    Button managerId;

    private FormInfoService service = new FormInfoServiceImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table.setEditable(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        id.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        room.setCellValueFactory(new PropertyValueFactory<>("room"));
        deposit.setCellValueFactory(new PropertyValueFactory<>("deposit"));
        reason.setCellValueFactory(new PropertyValueFactory<>("reason"));

        update();

        search.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String name_text = (String) name_search.getText();
                String phone_text = (String) phone_search.getText();

                if (name_text.equals("") && phone_text.equals("")) {
                    update();
                } else {
                    FormInfo form = new FormInfo();
                    form.setFullname(name_text);
                    form.setPhone(phone_text);

                    List<FormInfo> list_form_filter = service.searchForm(form);
                    List<FormTable> list_after = null;
                    if (list_form_filter != null) {
                        list_after = list_form_filter.stream().map(f -> new FormTable(f)).collect(Collectors.toCollection(ArrayList::new));
                    }
                    if (!list_after.isEmpty()) {
                        table.setItems(FXCollections.observableArrayList(list_after));
                    }
                }
            }
        });

        pay.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Store store = Store.getInstance();
                ObservableList<FormTable> selectedRows = table.getSelectionModel().getSelectedItems();
                List<FormTable> rows = new ArrayList<>(selectedRows);
                rows.forEach(row -> store.setForm(row));
                if (store.getForm() != null) {
                    Redirect();
                }
            }
        });

        managerId.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Stage stage = Store.getInstance().getStage();
                Parent root = null;
                Scene scene = null;
                try {
                    root = FXMLLoader.load(this.getClass().getResource("/layout/statistical.fxml"));
                    scene = new Scene(root);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                stage.setScene(scene);
                stage.show();
            }
        });
    }

    public void update() {
        List<FormInfo> list_form = service.findAll();
        List<FormTable> list = list_form.stream().map(form -> new FormTable(form)).collect(Collectors.toCollection(ArrayList::new));
        if (!list.isEmpty()) {
            this.table.setItems(FXCollections.observableArrayList(list));
        }
    }

    private void Redirect() {
        Stage stage = Store.getInstance().getStage();
        Parent root = null;
        Scene scene = null;
        try {
            root = FXMLLoader.load(this.getClass().getResource("/layout/payLayout.fxml"));
            stage.setTitle("Thanh toán");
            scene = new Scene(root);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }
    
    public void returnHomePage(ActionEvent event) {
        Stage stage = Store.getInstance().getStage();
        Parent root = null;
        Scene scene = null;
        try {
            root = FXMLLoader.load(this.getClass().getResource("/layout/index.fxml"));
            scene = new Scene(root);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }
}
