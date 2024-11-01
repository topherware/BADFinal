package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProductPage extends Application{
	Scene scene;
	
	// Container
	VBox mainLayout = new VBox();
	VBox titleBox = new VBox();
	VBox flowerDetail = new VBox();
	HBox bodyBox = new HBox();
	HBox flowerNameBox = new HBox();
	HBox flowerTypeBox = new HBox();
	HBox flowerPriceBox = new HBox();
	
	// Table view
	TableView<Flower> productTable = new TableView<Flower>();
	
	// Observable List
	ObservableList<Flower> flowerList = FXCollections.observableArrayList();
	
	// Bikin column table
	TableColumn<Flower, String> flowerNameCol = new TableColumn<Flower, String>("Name");	
	TableColumn<Flower, String> flowerTypeCol = new TableColumn<Flower, String>("Type");	
	TableColumn<Flower, Integer> flowerPriceCol = new TableColumn<Flower, Integer>("Price");	
	
	// Texts
	Text titleText = new Text("Product List");
	Text welcomeText = new Text("Welcome, Customer"); // nanti diganti ama column customer name di db
	Text flowerDetailText = new Text("Flower Detail");
	Text flowerNameText = new Text("Flower Name: ");
	Text flowerTypeText = new Text("Flower Type: ");
	Text flowerPriceText = new Text("Flower Price: ");
	Text selectedFlowerName = new Text();
    Text selectedFlowerType = new Text();
    Text selectedFlowerPrice = new Text();

	
	// Button
	Button addToCart = new Button("Add to Cart");
	
	public void addFakeData() {
		Flower flower1 = new Flower("Rose", "Perennial", 1000);
		flowerList.add(flower1);
		
		Flower flower2 = new Flower("Tulip", "Bulb", 1500);
		flowerList.add(flower2);
		
		Flower flower3 = new Flower("Lily", "Perennial", 1200);
		flowerList.add(flower3);
		
		Flower flower4 = new Flower("Daffodil", "Bulb", 1100);
		flowerList.add(flower4);
		
		Flower flower5 = new Flower("Sunflower", "Annual", 1300);
		flowerList.add(flower5);
	}
	
	public void setPositionComponents() {
		titleBox.getChildren().addAll(titleText, welcomeText);
		flowerNameBox.getChildren().addAll(flowerNameText, selectedFlowerName); // tambahin 1 component untuk disebelahnya --> nama flower yang lagi dipencet
		flowerTypeBox.getChildren().addAll(flowerTypeText, selectedFlowerType); // tambahin 1 component untuk disebelahnya --> type flower yang lagi dipencet
		flowerPriceBox.getChildren().addAll(flowerPriceText, selectedFlowerPrice); // tambahin 1 component untuk disebelahnya --> harga flower yang lagi dipencet
		flowerDetail.getChildren().addAll(flowerDetailText, flowerNameBox, flowerTypeBox, flowerPriceBox, addToCart);
		bodyBox.getChildren().addAll(productTable, flowerDetail);
		mainLayout.getChildren().addAll(titleBox, bodyBox);
		
		scene = new Scene(mainLayout);
	}
	
	public static void main (String[]args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		addFakeData();
		setPositionComponents();
		
		productTable.setItems(flowerList);
		
		productTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedFlowerName.setText(newValue.getFlower_name());
                selectedFlowerType.setText(newValue.getType());
                selectedFlowerPrice.setText(String.valueOf(newValue.getPrice()));
            }
        });
		
		//  Declare value2 dari table2nya
		flowerNameCol.setCellValueFactory(new PropertyValueFactory("flower_name"));
		flowerTypeCol.setCellValueFactory(new PropertyValueFactory("type"));
		flowerPriceCol.setCellValueFactory(new PropertyValueFactory("price"));
		
		// Masukkin column2 yang sudah dibuat ke dalam tablenya
		productTable.getColumns().addAll(flowerNameCol, flowerTypeCol, flowerPriceCol);
		
		stage.setScene(scene);
		stage.show();
	}

}
