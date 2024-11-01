package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
	
	// Object
	Scene scene, sceneOnBoarding, sceneRegister;
	BorderPane loginCtr, onBoardingCtr, registerCtr;
	GridPane userNameCtr, passwordCtr, buttonCtr, emailCtr, registUserNameCtr,
	registPasswordCtr, confirmPasswordCtr, addressCtr, phoneNumberCtr, checkBoxCtr,
	registBtnCtr;
	VBox formCtr, registFormCtr;
	Label loginLabel, userNameLabel, passwordLabel, registerLabel, 
	emailLabel, registUserNameLabel, registPasswordLabel, confirmPasswordLabel,
	addressLabel, phoneNumberLabel, checkBoxLabel;
	TextField userNameFld, emailFld, registUserNameFld, phoneNumberFld;
	PasswordField passwordFld, registPasswordFld, confirmPasswordFld;
	TextArea addressFld;
	CheckBox terms;
	Button loginBtn, registerBtn;
	MenuBar menu, menuLogin, menuRegister;
	Menu page;
	MenuItem login, register;
	
	// Initialize Object
	public void init() {
		// On Boarding
		onBoardingCtr = new BorderPane();
		menu = new MenuBar();
		page = new Menu("Pagessss");
		login = new MenuItem("Sign In page");
		register = new MenuItem("Sign Up page");
		
		// Register
		registerCtr = new BorderPane();
		
		emailCtr = new GridPane();
		registUserNameCtr = new GridPane();
		registPasswordCtr = new GridPane();
		confirmPasswordCtr = new GridPane();
		addressCtr = new GridPane();
		phoneNumberCtr = new GridPane();
		checkBoxCtr = new GridPane();
		registBtnCtr = new GridPane();
		
		registerLabel = new Label("Register");
		emailLabel = new Label("Email:");
		registUserNameLabel = new Label("Username:");
		registPasswordLabel = new Label("Password:");
		confirmPasswordLabel = new Label("Confirm Password:");
		addressLabel = new Label("Address:");
		phoneNumberLabel = new Label("Phone Number:");
		
		emailFld = new TextField();
		registUserNameFld = new TextField();
		registPasswordFld = new PasswordField();
		confirmPasswordFld = new PasswordField();
		addressFld = new TextArea();
		phoneNumberFld = new TextField();
		
		terms = new CheckBox();
		checkBoxLabel = new Label("I agree to create an account");
		
		registerBtn = new Button("Register");
		
		menuRegister = new MenuBar();
		
		// Login
		loginCtr = new BorderPane();
		userNameCtr = new GridPane();
		passwordCtr = new GridPane();
		buttonCtr = new GridPane();
		loginLabel = new Label("Login");
		userNameLabel = new Label("User Name");
		passwordLabel = new Label("Password");
		userNameFld = new TextField();
		passwordFld = new PasswordField();
		loginBtn = new Button("Sign In");
		menuLogin = new MenuBar();
	}
	
	// Make
	public void makeMenu() {
		page.getItems().addAll(login, register);
		menu.getMenus().add(page);
		menuLogin.getMenus().add(page);
		menuRegister.getMenus().add(page);
	}
	
	public void makeFormRegister() {
		emailCtr.add(emailLabel, 0, 0);
		emailCtr.add(emailFld, 1, 0);
		
		registUserNameCtr.add(registUserNameLabel, 0, 0);
		registUserNameCtr.add(registUserNameFld, 1, 0);
		
		registPasswordCtr.add(registPasswordLabel, 0, 0);
		registPasswordCtr.add(registPasswordFld, 1, 0);
		
		confirmPasswordCtr.add(confirmPasswordLabel, 0, 0);
		confirmPasswordCtr.add(confirmPasswordFld, 1, 0);
		
		addressCtr.add(addressLabel, 0, 0);
		addressCtr.add(addressFld, 1, 0);
		
		phoneNumberCtr.add(phoneNumberLabel, 0, 0);
		phoneNumberCtr.add(phoneNumberFld, 1, 0);
		
		checkBoxCtr.add(terms, 0, 0);
		checkBoxCtr.add(checkBoxLabel, 1, 0);
		
		registBtnCtr.add(registerBtn, 0, 0);
		
		registFormCtr = new VBox(10, registerLabel, emailCtr, registUserNameCtr, registPasswordCtr,
				confirmPasswordCtr, addressCtr, phoneNumberCtr, checkBoxCtr, registBtnCtr);
	}
	
	public void makeFormLogin() {
		userNameCtr.add(userNameLabel, 0, 0);
		userNameCtr.add(userNameFld, 0, 1);
		
		passwordCtr.add(passwordLabel, 0, 0);
		passwordCtr.add(passwordFld, 0, 1);
		
		buttonCtr.add(loginBtn, 0, 0);
		
		formCtr = new VBox(10, loginLabel, userNameCtr, passwordCtr, buttonCtr);
	}
	
	// Add Component
	public void addComponentOnBoarding() {
		onBoardingCtr.setTop(menu);
		sceneOnBoarding = new Scene(onBoardingCtr,600,500);
	}
	
	public void addComponentRegister() {
		registerCtr.setTop(menuRegister);
		registerCtr.setCenter(registFormCtr);
		sceneRegister = new Scene(registerCtr, 600, 500);
	}
	
	public void addComponentLogin() {
		loginCtr.setTop(menuLogin);
		loginCtr.setCenter(formCtr);	
		scene = new Scene(loginCtr, 600, 500);
	}
	
	// Arrange Component
	public void arrangeComponentRegister() {
		registerLabel.setFont(new Font("Times New Roman", 30));
		registFormCtr.setMargin(registerLabel, new Insets(40,0,0,260));
		registFormCtr.setMargin(emailCtr, new Insets(10,0,0,165));
		emailCtr.setMargin(emailFld, new Insets(0,0,0,80));
		registFormCtr.setMargin(registUserNameCtr, new Insets(0,0,0,165));
		registUserNameCtr.setMargin(registUserNameFld, new Insets(0,0,0,55));
		registFormCtr.setMargin(registPasswordCtr, new Insets(0,0,0,165));
		registPasswordCtr.setMargin(registPasswordFld, new Insets(0,0,0,59));
		registFormCtr.setMargin(confirmPasswordCtr, new Insets(0,0,0,165));
		confirmPasswordCtr.setMargin(confirmPasswordFld, new Insets(0,0,0,13));
		addressFld.setMaxWidth(148);
		addressFld.setMaxHeight(60);
		registFormCtr.setMargin(addressCtr, new Insets(0,0,0,165));
		addressCtr.setMargin(addressFld, new Insets(0,0,0,67));
		registFormCtr.setMargin(phoneNumberCtr, new Insets(0,0,0,165));
		phoneNumberCtr.setMargin(phoneNumberFld, new Insets(0,0,0,30));
		registFormCtr.setMargin(checkBoxCtr, new Insets(0,0,0,165));
		checkBoxCtr.setMargin(checkBoxLabel, new Insets(0,0,0,10));
		registerBtn.setPrefWidth(265);
		registFormCtr.setMargin(registBtnCtr, new Insets(0,0,0,165));
	}
	
	public void arrangeComponentLogin() {
		loginLabel.setFont(new Font("Times New Roman", 30));
		formCtr.setMargin(passwordCtr, new Insets(5));
		userNameCtr.setMargin(userNameLabel, new Insets(0,10,10,0));
		passwordCtr.setMargin(passwordLabel, new Insets(0,20,10,0));
		formCtr.setMargin(loginLabel, new Insets(110,0,0,260));
		formCtr.setMargin(userNameCtr, new Insets(0,0,0,220));
		formCtr.setMargin(passwordCtr, new Insets(0,0,0,220));
		formCtr.setMargin(buttonCtr, new Insets(0,0,0,220));
		loginBtn.setPrefWidth(150);
	}
	
	
	// Start Code
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// Call Methods
		init();
		makeMenu();
		makeFormRegister();
		makeFormLogin();
		addComponentOnBoarding();
		addComponentRegister();
		addComponentLogin();
		arrangeComponentRegister();
		arrangeComponentLogin();
		
		// Start Scene
		stage.setTitle("On Boarding Page anjingggggg");
		stage.setResizable(false);
		stage.setScene(sceneOnBoarding);
		stage.show();
		
		// Select Login
		login.setOnAction(e -> {stage.setScene(scene);
		stage.setTitle("Login");
		});
		
		// Select Register
		register.setOnAction(e -> {stage.setScene(sceneRegister);
		stage.setTitle("Register");
		});
	}

}
