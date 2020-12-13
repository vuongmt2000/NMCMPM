package controller;

import java.io.IOException;
import model.*;
import service.FormInfoService;
import service.service_impl.DeviceServiceImpl;
import service.service_impl.FormInfoServiceImpl;
import service.service_impl.RoomDeviceServiceImpl;
import service.service_impl.RoomServiceImpl;
import utils.Constants;
import utils.Format;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterFormController implements Initializable {

    @FXML
    private TextField mainName;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private TextField creditCard;

    @FXML
    private DatePicker dateOfLocation;

    @FXML
    private TextField addressOfLocation;

    @FXML
    private TextField nation;

    @FXML
    private TextField religion;

    @FXML
    private TextField phone;

    @FXML
    private TextField pernamentAddress;

    @FXML
    private TextArea reason;

    @FXML
    private ComboBox comboBoxFloor;

    @FXML
    private ComboBox comboBoxDevice;

    @FXML
    private TextField quantity;

    @FXML
    private Button btnAdd;

    @FXML
    private TextArea contentRent;

    @FXML
    private Button btnSearch;

    @FXML
    private Label roomId;

    @FXML
    private Label deviceId;

    @FXML
    private Label areaId;

    @FXML
    private Label noteId;

    @FXML
    private Button back;

    private Long totalPriceFinal;

    private NumberDeviceRegister numberDeviceRegister = new NumberDeviceRegister();

    private StringBuilder sentenceContent = new StringBuilder();

    private RoomServiceImpl roomService = new RoomServiceImpl();

    private DeviceServiceImpl deviceService = new DeviceServiceImpl();

    private RoomDeviceServiceImpl roomDeviceService = new RoomDeviceServiceImpl();

    private Map<String, Room> roomMap = new HashMap<>();

    private Map<String, Device> deviceMap = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // fill data of device and room to map
        roomService.findAll().forEach(item -> {
            roomMap.put(Constants.ROOM.TYPE + item.getFloor() + Constants.ROOM.DOT + item.getNumber_floor(), item);
        });

        deviceService.getAll().forEach(item -> {
            deviceMap.put(item.getName(), item);
        });

        //hide all id off field
        roomId.setVisible(false);
        deviceId.setVisible(false);

        // get list room and device to combobox
        List<Room> roomList = roomService.getListRoom();
        List<Device> deviceList = deviceService.getAllDevice();

        ObservableList<String> rooms = FXCollections.observableArrayList();
        ObservableList<String> devices = FXCollections.observableArrayList();

        roomList.forEach(item -> {
            rooms.add(Constants.ROOM.TYPE + item.getFloor().toString() + Constants.ROOM.DOT + item.getNumber_floor().toString());
        });
        deviceList.forEach(item -> {
            devices.add(item.getName());
        });

        comboBoxFloor.setItems(rooms);
        comboBoxDevice.setItems(devices);
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Redirect("index");
            }
        });
    }

    private void Redirect(String file) {
        Stage stage = Store.getInstance().getStage();
        Parent root = null;
        Scene scene = null;
        try {
            root = FXMLLoader.load(this.getClass().getResource("/layout/" + file + ".fxml"));
            scene = new Scene(root);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        stage.setScene(scene);
        stage.show();
    }

    public void keyupMainName(ActionEvent actionEvent) {

    }

    public void chooseDevice(ActionEvent actionEvent) {
        String comboBoxDeviceValue = comboBoxDevice.getValue().toString();
        Device device = deviceService.findByName(comboBoxDeviceValue, Constants.STATUS.ACTIVATED);
        if (device != null) {
            deviceId.setText(device.getId().toString());
            deviceId.setVisible(false);
        }
    }

    public void chooseRoom(ActionEvent actionEvent) {

        // set numberDeviceRegister return original value
        numberDeviceRegister = new NumberDeviceRegister();

        // fill area to note to user
        String comboBoxRoomValue = comboBoxFloor.getValue().toString();
        String[] room = comboBoxRoomValue.replace(Constants.ROOM.TYPE, "").trim().split("\\.");
        Integer numberRoom = Integer.parseInt(room[1]);
        Integer floor = Integer.parseInt(room[0]);

        Room roomModel = roomService.findByFloorAndNumberFloor(floor, numberRoom, Constants.STATUS.ACTIVATED);
        if (roomModel != null) {
            roomId.setText(roomModel.getId().toString());
            roomId.setVisible(false);
            areaId.setText(roomModel.getArea().toString() + Constants.ROOM.AREA);

            // print detail information
            StringBuilder positionSentence = new StringBuilder();
            positionSentence.append(Constants.SENTENCES.POSITION);
            positionSentence.append(comboBoxRoomValue + " (");
            positionSentence.append(roomModel.getArea() + Constants.ROOM.AREA + ") - ");

            // format currency VND
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            String price = currencyVN.format(roomModel.getPrice() * 1000);
            positionSentence.append(Constants.ROOM.PRICE + price);

            contentRent.setText(positionSentence.toString());
            sentenceContent = new StringBuilder();
            sentenceContent.append(positionSentence.toString());
        }

    }

    public void addDevice(ActionEvent event) {
        long totalPrice = 0;
        totalPrice += roomMap.get(comboBoxFloor.getValue()).getPrice() * 1000;
        if (deviceId.getText() != "" && roomId.getText() != "") {
            Long idOfDevice = Long.parseLong(deviceId.getText());
            Long idOfRoom = Long.parseLong(roomId.getText());
            Room_Device roomDevice = roomDeviceService.findByRoomIdAndDeviceId(idOfRoom, idOfDevice);
            Device device = deviceMap.get(comboBoxDevice.getValue());
            if (roomDevice != null) {

                if (!quantity.getText().equals("")) {
                    Integer total = Integer.parseInt(quantity.getText());
                    int i = idOfDevice.intValue();
                    if (total > roomDevice.getQuantity()) {
                        noteId.setText(comboBoxFloor.getValue() + " chỉ còn " + roomDevice.getQuantity() + " " + comboBoxDevice.getValue());
                        noteId.setTextFill(Color.web("red"));
                    } else {
                        switch (i) {
                            case 1:
                                if (numberDeviceRegister.isHasTable()) {
                                    if (total + numberDeviceRegister.getNumberTable() > roomDevice.getQuantity()) {
                                        noteId.setText(comboBoxFloor.getValue() + " chỉ còn " + (roomDevice.getQuantity() - numberDeviceRegister.getNumberTable()) + " " + comboBoxDevice.getValue());
                                        noteId.setTextFill(Color.web("red"));
                                    } else {
                                        numberDeviceRegister.setNumberTable(total + numberDeviceRegister.getNumberTable());
                                        noteId.setText(null);
                                    }
                                } else {
                                    numberDeviceRegister.setHasTable(true);
                                    numberDeviceRegister.setNumberTable(total);
                                    noteId.setText(null);
                                }
                                break;
                            case 2:
                                if (numberDeviceRegister.isHasChair()) {
                                    if (total + numberDeviceRegister.getNumberChair() > roomDevice.getQuantity()) {
                                        noteId.setText(comboBoxFloor.getValue() + " chỉ còn " + (roomDevice.getQuantity() - numberDeviceRegister.getNumberChair()) + " " + comboBoxDevice.getValue());
                                        noteId.setTextFill(Color.web("red"));
                                    } else {
                                        numberDeviceRegister.setNumberChair(total + numberDeviceRegister.getNumberChair());
                                        noteId.setText(null);
                                    }
                                } else {
                                    numberDeviceRegister.setHasChair(true);
                                    numberDeviceRegister.setNumberChair(total);
                                    noteId.setText(null);
                                }
                                break;
                            case 3:
                                if (numberDeviceRegister.isHasSpeaker()) {
                                    if (total + numberDeviceRegister.getNumberSpeaker() > roomDevice.getQuantity()) {
                                        noteId.setText(comboBoxFloor.getValue() + " chỉ còn " + (roomDevice.getQuantity() - numberDeviceRegister.getNumberSpeaker()) + " " + comboBoxDevice.getValue());
                                        noteId.setTextFill(Color.web("red"));
                                    } else {
                                        numberDeviceRegister.setNumberSpeaker(total + numberDeviceRegister.getNumberSpeaker());
                                        noteId.setText(null);
                                    }
                                } else {
                                    numberDeviceRegister.setHasSpeaker(true);
                                    numberDeviceRegister.setNumberSpeaker(total);
                                    noteId.setText(null);
                                }
                                break;
                            case 4:
                                if (numberDeviceRegister.isHasRadio()) {
                                    if (total + numberDeviceRegister.getNumberRadio() > roomDevice.getQuantity()) {
                                        noteId.setText(comboBoxFloor.getValue() + " chỉ còn " + (roomDevice.getQuantity() - numberDeviceRegister.getNumberRadio()) + " " + comboBoxDevice.getValue());
                                        noteId.setTextFill(Color.web("red"));
                                    } else {
                                        numberDeviceRegister.setNumberRadio(total + numberDeviceRegister.getNumberRadio());
                                        noteId.setText(null);
                                    }
                                } else {
                                    numberDeviceRegister.setHasRadio(true);
                                    numberDeviceRegister.setNumberRadio(total);
                                    noteId.setText(null);
                                }
                                break;
                            case 5:
                                if (numberDeviceRegister.isHasProjector()) {
                                    if (total + numberDeviceRegister.getNumberProjector() > roomDevice.getQuantity()) {
                                        noteId.setText(comboBoxFloor.getValue() + " chỉ còn " + (roomDevice.getQuantity() - numberDeviceRegister.getNumberProjector()) + " " + comboBoxDevice.getValue());
                                        noteId.setTextFill(Color.web("red"));
                                    } else {
                                        numberDeviceRegister.setNumberProjector(total + numberDeviceRegister.getNumberProjector());
                                        noteId.setText(null);
                                    }
                                } else {
                                    numberDeviceRegister.setHasProjector(true);
                                    numberDeviceRegister.setNumberProjector(total);
                                    noteId.setText(null);
                                }
                                break;
                        }
                    }
                } else {
                    noteId.setText("Bạn chưa nhập số lượng " + comboBoxDevice.getValue());
                    noteId.setTextFill(Color.web("red"));
                }

                // print infor user rent device
                StringBuilder contentInfo = new StringBuilder();
                contentInfo.append(sentenceContent.toString());
                if (numberDeviceRegister.isHasTable()) {
                    Long tablePrice = numberDeviceRegister.getNumberTable() * deviceMap.get(Constants.DEVICE.TABLE).getPrice();
                    totalPrice += tablePrice * 1000;
                    contentInfo.append("\nSố lượng bàn: " + numberDeviceRegister.getNumberTable() + " cái - giá " + Format.formatMoney(tablePrice));
                }
                if (numberDeviceRegister.isHasChair()) {
                    Long chairPrice = numberDeviceRegister.getNumberChair() * deviceMap.get(Constants.DEVICE.CHAIR).getPrice();
                    totalPrice += chairPrice * 1000;
                    contentInfo.append("\nSố lượng ghế: " + numberDeviceRegister.getNumberChair() + " cái - giá " + Format.formatMoney(chairPrice));
                }
                if (numberDeviceRegister.isHasSpeaker()) {
                    Long speakerPrice = numberDeviceRegister.getNumberSpeaker() * deviceMap.get(Constants.DEVICE.SPEAKER).getPrice();
                    totalPrice += speakerPrice * 1000;
                    contentInfo.append("\nSố lượng loa: " + numberDeviceRegister.getNumberSpeaker() + " cái - giá " + Format.formatMoney(speakerPrice));
                }
                if (numberDeviceRegister.isHasRadio()) {
                    Long radioPrice = numberDeviceRegister.getNumberRadio() * deviceMap.get(Constants.DEVICE.RADIO).getPrice();
                    totalPrice += radioPrice * 1000;
                    contentInfo.append("\nSố lượng đài: " + numberDeviceRegister.getNumberRadio() + " cái - giá " + Format.formatMoney(radioPrice));
                }
                if (numberDeviceRegister.isHasProjector()) {
                    Long projectorPrice = numberDeviceRegister.getNumberProjector() * deviceMap.get(Constants.DEVICE.PROJECTOR).getPrice();
                    totalPrice += projectorPrice * 1000;
                    contentInfo.append("\nSố lượng máy chiếu: " + numberDeviceRegister.getNumberProjector() + " cái - giá " + Format.formatMoney(projectorPrice));
                }

                contentInfo.append("\n----------------------------------------\n");
                contentInfo.append("Tổng tiền: " + Format.formatMoney(totalPrice/1000));
                this.totalPriceFinal = totalPrice;

                contentRent.setText(contentInfo.toString());
            }

        }
    }

    public void saveForm(ActionEvent actionEvent) {
        FormInfo form = new FormInfo();
        FormInfoService infoService = new FormInfoServiceImpl();
        form.setFullname(mainName.getText());
        ZoneId defaultZoneId = ZoneId.systemDefault();

        // format datepicker to date
        LocalDate localBirthDay = dateOfBirth.getValue();
        LocalDate localDateLocation = dateOfLocation.getValue();
        Date birthDay = Date.from(localBirthDay.atStartOfDay(defaultZoneId).toInstant());
        Date dateLocaiotn = Date.from(localDateLocation.atStartOfDay(defaultZoneId).toInstant());

        form.setBirthday(birthDay);
        form.setDate_of_allocation(dateLocaiotn);
        form.setCredit_card(creditCard.getText());
        form.setAddress_of_allocation(addressOfLocation.getText());
        form.setNation(nation.getText());
        form.setReligion(religion.getText());
        form.setPhone(phone.getText());
        form.setPermanent_address(pernamentAddress.getText());
        form.setReason(reason.getText());
        form.setStatus(Constants.STATUS.ACTIVATED);
        form.setSum_price(totalPriceFinal);
        form.setTable(this.numberDeviceRegister.getNumberTable());
        form.setChair(this.numberDeviceRegister.getNumberChair());
        form.setSpeaker(this.numberDeviceRegister.getNumberSpeaker());
        form.setRadio(this.numberDeviceRegister.getNumberRadio());
        form.setProjector(this.numberDeviceRegister.getNumberProjector());
        form.setRoom(comboBoxFloor.getValue().toString());

       Long status =  infoService.save(form);
       Redirect("require");
    }

}
