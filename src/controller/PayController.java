package controller;

import dao.IDeviceDAO;
import dao.impl.DeviceDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Device;
import model.FormInfo;
import model.FormTable;
import model.PayDevice;
import service.FormInfoService;
import service.service_impl.FormInfoServiceImpl;
import utils.Format;

public class PayController implements Initializable {

    @FXML
    Label name;

    @FXML
    Label phone;

    @FXML
    Label room;

    @FXML
    Label paymoney;

    @FXML
    Label deposit;

    @FXML
    TextArea reason;

    @FXML
    TableView<PayDevice> table;

    @FXML
    TableColumn<PayDevice, Number> id;

    @FXML
    TableColumn<PayDevice, String> device;

    @FXML
    TableColumn<PayDevice, Number> quantity;

    @FXML
    TableColumn<PayDevice, String> price;

    @FXML
    Button pay;

    @FXML
    Button close;

    @FXML
    Button goBack;

    private Map<String, Long> priceDevice;
    private List<PayDevice> listData;
    private FormTable form;
    private FormInfo formInfo;

    private FormInfoService formService = new FormInfoServiceImpl();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        setTable();
        setPrice();
        form = Store.getInstance().getForm();
        if (form != null) {
            name.setText(form.getName());
            phone.setText(form.getPhone());
            room.setText(form.getRoom());
            deposit.setText(form.getDeposit() + "");
            reason.setText(form.getReason());

            listData = new ArrayList<>();
            formInfo = formService.findOne(form.getID());
            List<String> list = Store.getInstance().getListDevice();
            for (int i = 0; i < list.size(); i++) {
                PayDevice pd = new PayDevice();
                pd.setDevice(list.get(i));
                pd.setQuantity(formInfo.getQuantity(i));
                pd.setPrice(priceDevice.get(list.get(i)) * pd.getQuantity());

                listData.add(pd);
            }

            table.setItems(FXCollections.observableArrayList(listData));

            Long payMoney = form.getSumPrice() - form.getDeposit();
            paymoney.setText(Format.formatMoney(payMoney / 1000));

        }

        pay.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                formInfo.setStatus(0);
                formService.updateRoom(formInfo);
                Redirect();

            }
        });

        close.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                Redirect();
            }
        });
//
//        pay.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent arg0) {
//                Stage stage = Store.getInstance().getStage();
//                Parent root = null;
//                Scene scene = null;
//                try {
//                    root = FXMLLoader.load(this.getClass().getResource("/layout/manager-layout.fxml"));
//                    scene = new Scene(root);
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//                stage.setScene(scene);
//                stage.show();
//            }
//        });
    }

    private void Redirect() {
        Stage stage = Store.getInstance().getStage();
        Parent root = null;
        Scene scene = null;
        try {
            root = FXMLLoader.load(this.getClass().getResource("/layout/manager-layout.fxml"));
            scene = new Scene(root);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }

    private void setPrice() {
        priceDevice = new HashMap<>();

        IDeviceDAO deviceDAO = new DeviceDAO();
        List<Device> listDevice = deviceDAO.findAll();
        for (Device device : listDevice) {
            priceDevice.put(device.getName(), device.getPrice());
        }
    }

    private void setTable() {
        id.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue()) + 1));
        device.setCellValueFactory(new PropertyValueFactory<>("device"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

    }
}
