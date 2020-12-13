package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.stage.Stage;
import model.FormTable;

public class Store {
	private static Store instance;
	private FormTable form;
	protected List<String> listDevice;
	private Stage stage;

	private Store() {
		setListDevice();
	}
	
	public static Store getInstance() {
		if(instance == null) {
			instance = new Store();
		}
		return instance;
	}

	public FormTable getForm() {
		return form;
	}

	public void setForm(FormTable form) {
		this.form = form;
	}

	public List<String> getListDevice() {
		return listDevice;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setListDevice() {
		listDevice = new ArrayList<>();
		listDevice.add("Bàn");
		listDevice.add("Ghế");
		listDevice.add("Loa");
		listDevice.add("Đài");
		listDevice.add("Máy chiếu");
	}
}

