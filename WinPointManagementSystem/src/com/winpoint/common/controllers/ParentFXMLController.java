package com.winpoint.common.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;

public class ParentFXMLController implements Initializable{
	public static Image logoImage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		logoImage = new Image("com/winpoint/resources/images/Logo.jpeg");
	}

}