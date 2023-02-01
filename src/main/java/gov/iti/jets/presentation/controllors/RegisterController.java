package gov.iti.jets.presentation.controllors;
import gov.iti.jets.dto.UserDto;
import gov.iti.jets.util.Constants;
import gov.iti.jets.util.Validation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;

public class RegisterController implements Initializable {

    FileChooser fileChooser = new FileChooser();
    File file;
    private Stage stage;
    private Scene scene;


    @FXML
    private JFXButton SignUp;

    @FXML
    private TextField bio;

    @FXML
    private TextField confirmPassword;

    @FXML
    private ComboBox<String> country;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField password;

    @FXML
    private TextField phone;

    @FXML
    private JFXRadioButton radioFemal;

    @FXML
    private JFXRadioButton radioMale;
    @FXML
    Circle circle;
    @FXML
    private Label invalidBio;

    @FXML
    private Label invalidConPassword;

    @FXML
    private Label invalidFName;

    @FXML
    private Label invalidLName;

    @FXML
    private Label invalidPassword;

    @FXML
    private Label invalidPhone;
    @FXML
    private Label invalidEmail;
    Validation validate;
    String gender;
    UserDto user;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
<<<<<<< HEAD
        circle.setFill(new ImagePattern(new Image("user.png",200,200,false,true)));
        addCountryChoiceBox();
=======
        circle.setFill(new ImagePattern(new Image("/image/user.png",200,200,false,true)));
        country.getItems().addAll(countries);
        //country.setEditable(true);
        country.setOnAction(e->{
            System.out.println(country.getSelectionModel().getSelectedItem());
        });
>>>>>>> e60f60bab8f7bd8fcde39536039a80ceb87f9569
    }
    @FXML
    public void addProfileImage(MouseEvent event) {
        fileChooser.getExtensionFilters().add(  new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            circle.setFill(new ImagePattern(new Image(file.toURI().toString(),200,200,false,true)));
        }
        if(radioMale.isSelected()){
            gender = "Male";
        }else if(radioFemal.isSelected()){
            gender = "Female";
        }
    }
    @FXML
    void signup(ActionEvent event) {
        System.out.println("Sign up clicked");
        //Validate First Name
        if (firstName.getText().isEmpty()) {
            setErrorMsg(firstName,invalidFName, Constants.FIELD_EMPTY);
        }else if(firstName.getText().length() < 3){
            setErrorMsg(firstName,invalidFName,"Name must contains only characters");
        }else {
            firstName.setStyle(Constants.CORRECT_INPUT);
            invalidFName.setText("");
        }


        //Validate Last Name
        if (lastName.getText().isEmpty()) {
            setErrorMsg(lastName,invalidLName, Constants.FIELD_EMPTY);
        }else if(lastName.getText().length() < 3){
            setErrorMsg(lastName,invalidLName,"Name must contains only characters");
        }else {
            lastName.setStyle(Constants.CORRECT_INPUT);
            invalidLName.setText("");
        }

        //Validate Phone Number
        if (phone.getText().isEmpty()) {
            setErrorMsg(phone,invalidPhone, Constants.FIELD_EMPTY);
        }else if(validate.validateEmail(phone.getText())){
            setErrorMsg(phone,invalidPhone,"Invalid phone");
        }else {
            phone.setStyle(Constants.CORRECT_INPUT);
            invalidPhone.setText("");
        }

        //Validate Email
        if (email.getText().isEmpty()) {
            setErrorMsg(email,invalidEmail, Constants.FIELD_EMPTY);
        }else if(validate.validateEmail(email.getText())){
            setErrorMsg(email,invalidEmail,"Invalid email");
        }else {
            email.setStyle(Constants.CORRECT_INPUT);
            invalidEmail.setText("");
        }
    }
    private void addCountryChoiceBox(){
        ObservableList<String> cities = FXCollections.observableArrayList();
        String[] locales1 = Locale.getISOCountries();
        for (String countrylist : locales1) {
            Locale obj = new Locale("", countrylist);
            String[] city = { obj.getDisplayCountry() };
            for (int x = 0; x < city.length; x++) {
                cities.add(obj.getDisplayCountry());
            }
        }
        country.setItems(cities);
    }
    private void setErrorMsg(TextField tf,Label b, String msg){
        tf.setStyle(Constants.ERROR_BORDER_RED);
         b.setText(msg);
        b.setStyle(Constants.RED_FONT);
    }
}
