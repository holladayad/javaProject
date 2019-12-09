
package javaProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.pool.*;




public class GroupProjectGUI extends Application {
    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults;
    
   Employee Jacob = new Employee("jake","Hi1","jacob");
   //Guest Susan = new Guest ("Susan1","Hi1","suzy");
   //Guest Jay = new Guest ("Jason","Hi1","Jay");
   
   //Room one = new Room(3, 2, 1, 1, 1);
   //Room two = new Room(2, 1, 2, 2, 2);
   //Room three = new Room(1, 1, 2, 1, 3);
   
   //Booking first = new Booking(Susan, one, 2019, 5, 10);
   //Booking second = new Booking(Jay, two, 2019, 8, 16);


Alert a = new Alert(AlertType.ERROR);






// Controls for start 
        Label lblFirst = new Label("Username");
        Label lblSecond = new Label ("Password");
        Button btnLogin = new Button ("Login-->"); 
        ComboBox<String> comboUser = new ComboBox<>();
        TextField txtFirst = new TextField();
        TextField txtSecond = new TextField();
        
        // Controls for the Employee menu below 1-7
        // Controls for tab 1
        final ToggleGroup group = new ToggleGroup();
        Label choice = new Label("Enter Choice: ");
        Label title = new Label("Booking Report");
        Button btnEnter = new Button("Enter");
        Button btnBack1 = new Button("Go Back");
        Button clearReport = new Button("Clear Text Box");
        RadioButton rb1 = new RadioButton("All Rooms");
        
        RadioButton rb2 = new RadioButton("Single Rooms");
        TextField singleRoom = new TextField();
        ComboBox <String> allOrOne = new ComboBox();
        TextArea report = new TextArea();
        
        // Controls for tab 2
        
        Label guestOut = new Label("Guest Check Out");
        Label roomNum = new Label("Enter room number please: ");
        Button btnGuest = new Button("Enter");
        TextField txtRoomNum = new TextField();
        Button btnBack2 = new Button("Go Back");
        TextArea TAResponse = new TextArea();
        
        
        //controls for tab 3
        
        Label guestInfo = new Label("Please Entere Guest Information Below");
        Label guestName = new Label("Enter Guest Name");
        Label guestUser = new Label("Enter Guest Username");
        Label guestPass = new Label("Enter Guest Password");
        Label confirmGuestPass = new Label("Confirm Guest Password");
        Label valueGuest = new Label("Would you like to be a valued guest");
        TextField gName = new TextField();
        TextField gUser = new TextField();
        TextField gPass = new TextField();
        TextField confirmGPass = new TextField();  
        Button btnBack3 = new Button("Go Back");
        Button btnCreateGuest = new Button("Create Account");
        ComboBox<String> yesOrNo = new ComboBox();
        
        // controls tab 4
        
        Label infoToEdit = new Label("Choose information you would like to edit");
        Button btnBack4 = new Button("Go Back");
        Button continue1 = new Button("Continue");
        ComboBox<String> editInfo = new ComboBox();
        
        //tab 4 subpane
        Label guestEditName = new Label("Please enter guest username you'd like to edit");
        Label guestEditPass = new Label("Please enter guest new password");
        Label guestEditConfirm = new Label("Please confirm the password");
        TextField txtEditName = new TextField();
        TextField txtEditPass = new TextField();
        TextField txtConfirmEdit = new TextField();
        Button btnChangePass = new Button("Change Password");
        Button btnBackToChoice = new Button("Back");
        
        
        // controls tab 5
        
        Label empCreate = new Label("Create Employee Account");
        Label empName = new Label("Name");
        Label empUser = new Label("Username");
        Label empPass = new Label("Password");
        Label confirmEmpPass = new Label("Confirm Password");
        TextField txtEmpName = new TextField();
        TextField txtEmpUser = new TextField();
        TextField txtEmpPass = new TextField();
        TextField txtEmpConfirm = new TextField();
        Button btnBack5 = new Button("Go Back");
        Button btnEmpCreate = new Button("Create Account");
        TextArea TAEmp = new TextArea();
        
        // controls tab 6
        
        Label empInfo = new Label("Choose Information to Edit");
        Button btnBack6 = new Button("Go Back");
        Button btnContinue2 = new Button ("Continue");
        ComboBox<String> empEditInfo = new ComboBox();
        TextArea TAEditEmp = new TextArea();
        
        // tab 6 subpane controls
        Label empUsername = new Label("Enter Employee Username");
        Label empPassword = new Label("Enter Employee New Password");
        Label empNewPass = new Label("Confirm Employee New Password");
        TextField txtEmpUsername = new TextField();
        TextField txtEmpPassword = new TextField();
        TextField txtEmpNewPass = new TextField();
        Button btnChangeEmpPass = new Button("Change Password");
        Button btnGoBack = new Button("Back");


        
        // controls tab 7
        
        Label roomOption = new Label("Please Select an Option");
        Label roomTitle = new Label ("Show Options");
        ComboBox<String> roomOpt = new ComboBox();
        Button btnBack7 = new Button("Go Back");
        Button btnContinue3 = new Button("Continue");
        
        // tab 7 creaitng room controls
        Label bed = new Label("Select Bed Option");
        Label kitchen = new Label("Select Kitchen Option");
        Label coffee = new Label("Select Coffee Option");
        Label accessibility = new Label("Select Accessibility Option");
        Label newRoomNum = new Label("Enter a room number");
        TextField roomNumbers = new TextField();
        ComboBox<String> bedOpt = new ComboBox();
        ComboBox<String> kitchenOpt = new ComboBox();
        ComboBox<String> coffeeOpt = new ComboBox();
        ComboBox<String> accessibilityOpt = new ComboBox();
        Button creatingRoom = new Button("Create Room");
        Button backToOpt = new Button ("Go back to options");
        TextArea creatingTA = new TextArea();
        
        // tab 7 editing controls
        Label whichRoom = new Label("Please enter a room number for the room to edit");
        Label anotherChoice = new Label("Which would you like to edit");
        TextField number = new TextField();
        Button roomContinue = new Button("Continue");
        Button backToOptions1 = new Button("Go back to options");
        ComboBox<String> whichOpt = new ComboBox();
        
        //tab 7 activate
        Label activeRoom = new Label("Enter Room Number to activate");
        TextField activeNum = new TextField();
        Button activateRoom = new Button("Make Active");
        Button backMain = new Button("Back to Menu");
        
        //tab7 deactive
        Label deactiveRoom = new Label("Enter the Room to deactivate");
        TextField deactiveNum = new TextField();
        Button deactivateRoom = new Button("Make Deactive");
        Button backToMain = new Button("Back to menu");
        
        //tab 8 log out control
        Label empLog = new Label("Would you like to log out?");
        Button empLogOut = new Button("Log out");
        
        //controls for guest tab 1
        
        Label roomChoice = new Label("Which room would you like to book?");
        Label roomNumber = new Label("Please enter a room number");
        Label year = new Label("Check in Year");
        Label outDay = new Label("Check out Day");
        Label inDay = new Label("Check in Day");
        Button bookRoomNum = new Button("Book Room");
        Button guestBack1 = new Button("Go back");
        Button showAvail = new Button("Show Rooms");
        TextField roomEnter = new TextField();
        TextField txtYear = new TextField();
        TextField txtInDay = new TextField();
        TextField txtOutDay = new TextField();
        TextArea bookingTA = new TextArea();
        
        // Controls for guest tab 2
        TextArea iBook = new TextArea();
        Label guestBookings = new Label("Below are all the rooms you have booked");
        Button showMy = new Button("Show my rooms");
        
        // Controls for tab 3
        
        Label edit = new Label("What would you like to edit");
        ComboBox<String> choice2 = new ComboBox();
        Button continue3 = new Button("Continue");
        
        // controls tab 3 subPane
        
        Label newPasswordGuest = new Label("Please enter your new name");
        Label confirmNewGuestPass = new Label("Confirm name");
        TextField txtNewPasswordGuest = new TextField();
        TextField txtConfirmNewGuestPass = new TextField();
        Button changeGuestPass = new Button("Change Name");
        Button backToGuestMenu = new Button("Back to Guest Menu");
        TextArea TAEditPass = new TextArea();
        
        // guest taba 4
        Label question = new Label("Would you like to log out?");
        Button yes = new Button ("Log Out");
        
                
        
        
        
        
        // Pane Creation
        
        // Login Screen
        StackPane whole = new StackPane();
        GridPane primaryPane = new GridPane();
        
        //Employee login
        GridPane empLogin = new GridPane();
        
        // create account pane
        GridPane createEmpAcc = new GridPane();
        
        //Guest Menu Panes
        
        TabPane guestRoot = new TabPane();
        GridPane bookRoomGuest = new GridPane();
        GridPane iBooked = new GridPane();
        GridPane editPersonal = new GridPane();
        GridPane personalPass = new GridPane();
        GridPane logOut = new GridPane();
        
        // Employee Menu Panes
        
        TabPane root = new TabPane();
        GridPane empBooking = new GridPane();
        GridPane empCheckOut = new GridPane();
        GridPane empCreateGuest = new GridPane();
        GridPane empEditGuest = new GridPane();
        GridPane empCreateEmp = new GridPane();
        GridPane empEditEmp = new GridPane();
        GridPane roomOp = new GridPane();
        GridPane empLogOut1 = new GridPane();
       
        //tab 4 pane
        GridPane empEditGuestPane = new GridPane();
        GridPane empEditEmpPane = new GridPane();
        
        GridPane createRoom = new GridPane(); // tab 7 sub panes
        GridPane editRoom = new GridPane(); // tab 7 subpanes
        GridPane inactive = new GridPane(); // tab 7 subpane
        GridPane active = new GridPane(); // tab 7 subpane
        
        // Employee Tab Creation
        
        Tab empTab1 = new Tab("Booking Report");
        Tab empTab2 = new Tab("Guest Checkout");
        Tab empTab3 = new Tab("Create Guest Account");
        Tab empTab4 = new Tab("Edit Guest Info");
        Tab empTab5 = new Tab("Creat Employee Account");
        Tab empTab6 = new Tab("Edit Employee Account");
        Tab empTab7 = new Tab("Room Options");
        Tab empTab8 = new Tab("Log Out");
        
        //Guest Tabs
        
        Tab guestTab1 = new Tab("Book a Room");
        Tab guestTab2 = new Tab ("See Which Rooms you have booked");
        Tab guestTab3 = new Tab ("Edit Personal Information");
        Tab guestTab4 = new Tab("Log Out");
        
        
        
        //Scenes
        
        Scene primaryScene = new Scene(whole,500,300);
        Scene empLoginScene = new Scene(empLogin,700,400);
        Scene createEmpScene = new Scene(createEmpAcc,900,600);
        Scene empMenuChoiceScene = new Scene(root,1100,700);
        
        Scene empEditGuestPass = new Scene(empEditGuestPane,800,800);
        Scene empEditEmpPass = new Scene(empEditEmpPane,800,800);
        
        Scene creating = new Scene(createRoom,800,800);
        Scene editing = new Scene(editRoom, 800,500);
        Scene inactivate = new Scene(inactive,800,500);
        Scene activate = new Scene(active, 800,500);
        
        // guest scenes
        
        Scene bookRoom = new Scene(guestRoot,1000,700);
        Scene editPersonalScene = new Scene(personalPass,800,600);
    
    
    
    
  
    
    
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //loadDataFromDB();
        showAllEmployee();
        showAllGuest();
        whole.getChildren().add(primaryPane);
        
        //Login page

        comboUser.getItems().addAll("Employee","Guest");
        comboUser.setValue("Employee");
        empLogin.setAlignment(Pos.CENTER);
    
    

        empLogin.add(lblFirst,0,1);
        empLogin.add(lblSecond,0,2);
        empLogin.add(txtFirst,1,1);
        empLogin.add(txtSecond,1,2);
        empLogin.add(comboUser,1,3);
        empLogin.add(btnLogin,1,4);
        
        empLogin.setVgap(12);
        empLogin.setHgap(20);

        String name = txtFirst.toString();
        String password = txtSecond.toString();
        
        //!!!!!!!!!!!!!!!!!!Employee Menu!!!!!!!!!!!!!!!!!!!!!!!!!!!1
        
        
        root.getTabs().add(empTab1);
        allOrOne.getItems().addAll("Single Room", "All Rooms");
        allOrOne.setValue("");
        empBooking.setAlignment(Pos.CENTER);
        empTab1.setContent(empBooking);
        empBooking.setVgap(20);
        empBooking.setHgap(20);
        
        empBooking.add(title,1,0,2,1);
        empBooking.add(choice,0,1);
        empBooking.add(btnEnter,2,2);
        empBooking.add(btnBack1,1,2);
        empBooking.add(clearReport,3,2);
        empBooking.add(rb1,1,1);
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        empBooking.add(rb2,2,1);
        empBooking.add(report,1,4,2,1);
        empBooking.add(singleRoom,3,1);
        report.setEditable(false);
        report.setMaxSize(500,500);
        singleRoom.setVisible(false);
        rb1.setSelected(true);
        
        //empBooking.add(allOrOne,1,1);
        
        
        //Tab 2 edit
        empCheckOut.setAlignment(Pos.CENTER);
        empTab2.setContent(empCheckOut);
        
        root.getTabs().add(empTab2);
        empCheckOut.add(guestOut,0,0);
        empCheckOut.add(roomNum,0,1);
        empCheckOut.add(txtRoomNum,1,1);
        empCheckOut.add(btnGuest,2,2);
        empCheckOut.add(btnBack2,1,2);
        empCheckOut.add(TAResponse,1,3,2,1);
        TAResponse.setEditable(false);
        
        
        // tab 3 edits
        
        root.getTabs().add(empTab3);
        empTab3.setContent(empCreateGuest);
        yesOrNo.getItems().addAll("Yes", "No");
        
        empCreateGuest.setAlignment(Pos.CENTER);
        empCreateGuest.add(guestInfo,1,0);
        empCreateGuest.add(guestName,1,1);
        empCreateGuest.add(guestUser,1,2);
        empCreateGuest.add(guestPass,1,3);
        empCreateGuest.add(confirmGuestPass,1,4);
        empCreateGuest.add(gName,2,1);
        empCreateGuest.add(gUser,2,2);
        empCreateGuest.add(gPass,2,3);
        empCreateGuest.add(confirmGPass,2,4);
        empCreateGuest.add(btnBack3,1,7);
        empCreateGuest.add(btnCreateGuest,1,6);
        empCreateGuest.add(valueGuest,1,5);
        empCreateGuest.add(yesOrNo,2,5);
        
        //tab 4 edit
        root.getTabs().add(empTab4);
        editInfo.getItems().addAll( "Change Guest Password");
        empEditGuest.setAlignment(Pos.CENTER);
        empTab4.setContent(empEditGuest);
        empEditGuest.add(infoToEdit,1,0,2,1);
        empEditGuest.add(editInfo,1,1,2,1);
        empEditGuest.add(continue1,2,3);
        empEditGuest.add(btnBack4,1,3);
        
        //tab 4 edit subPane
        empEditGuestPane.setAlignment(Pos.CENTER);
        empEditGuestPane.add(guestEditName,0,0);
        empEditGuestPane.add(guestEditPass,0,1);
        empEditGuestPane.add(guestEditConfirm,0,2);
        empEditGuestPane.add(txtEditName,1,0);
        empEditGuestPane.add(txtEditPass,1,1);
        empEditGuestPane.add(txtConfirmEdit,1,2);
        empEditGuestPane.add(btnChangePass,1,3);
        empEditGuestPane.add(btnBackToChoice,0,3);
        
        //tab 5 edit
        root.getTabs().add(empTab5);
        TAEmp.setMaxSize(500,200);
        empCreateEmp.setAlignment(Pos.CENTER);
        empTab5.setContent(empCreateEmp);
        empCreateEmp.add(empCreate,1,0);
        empCreateEmp.add(empName,0,1);
        empCreateEmp.add(empUser,0,2);
        empCreateEmp.add(empPass,0,3);
        empCreateEmp.add(confirmEmpPass,0,4);
        empCreateEmp.add(txtEmpName,1,1,2,1);
        empCreateEmp.add(txtEmpUser,1,2,2,1);
        empCreateEmp.add(txtEmpPass,1,3,2,1);
        empCreateEmp.add(txtEmpConfirm,1,4,2,1);
        empCreateEmp.add(btnBack5,1,6);
        empCreateEmp.add(btnEmpCreate,2,6);
        empCreateEmp.add(TAEmp,1,7,2,1);
        TAEmp.setEditable(false);
        
        //tab 6 edits
        root.getTabs().add(empTab6);
        empEditInfo.getItems().addAll("Change Employee Password");
        empEditEmp.setAlignment(Pos.CENTER);
        empTab6.setContent(empEditEmp);
        empEditEmp.add(empInfo,1,0,2,1);
        empEditEmp.add(empEditInfo,1,2,2,1);
        empEditEmp.add(btnBack6,1,3);
        empEditEmp.add(btnContinue2,2,3);
        empEditEmp.add(TAEditEmp,1,4,2,1);
        
        TAEditEmp.setMaxSize(500,250);
        TAEditEmp.setEditable(false);
        
        // tab 6 subpane edits
        empEditEmpPane.setAlignment(Pos.CENTER);
        empEditEmpPane.add(empUsername,0,1,2,1);
        empEditEmpPane.add(empPassword,0,2,2,1);
        empEditEmpPane.add(empNewPass,0,3,2,1);
        empEditEmpPane.add(txtEmpUsername,2,1,2,1);
        empEditEmpPane.add(txtEmpPassword,2,2,2,1);
        empEditEmpPane.add(txtEmpNewPass,2,3,2,1);
        empEditEmpPane.add(btnChangeEmpPass,2,4);
        empEditEmpPane.add(btnGoBack,1,4);
        

                
        // tab 7 edit
        root.getTabs().add(empTab7);
        roomOp.setAlignment(Pos.CENTER);
        empTab7.setContent(roomOp);
        roomOpt.getItems().addAll("Create Room","Edit Room", "Activate Room" ,"Deactivate Room");
        roomOpt.setValue("");
        
        roomOp.add(roomTitle,0,0);
        roomOp.add(roomOption,0,1);
        roomOp.add(roomOpt,1,1,2,1);
        roomOp.add(btnBack7,1,2);
        roomOp.add(btnContinue3,2,2);
        
        // tab 7 subtab 1 (create)!!
        createRoom.setAlignment(Pos.CENTER);
        createRoom.add(bed,0,0);
        createRoom.add(kitchen,0,1);
        createRoom.add(coffee,0,2);
        createRoom.add(accessibility,0,3);
        createRoom.add(bedOpt,1,0);
        createRoom.add(kitchenOpt,1,1);
        createRoom.add(coffeeOpt,1,2);
        createRoom.add(accessibilityOpt,1,3);
        createRoom.add(newRoomNum,0,4);
        createRoom.add(roomNumbers,1,4);
        createRoom.add(creatingTA,1,8,3,1);
        creatingTA.setEditable(false);
        creatingTA.setMaxSize(500,250);
        createRoom.add(creatingRoom,3,3);
        createRoom.add(backToOpt,3,5);
        
        bedOpt.getItems().addAll("1 Queen Bed", "2 Queen Beds", "1 King Bed");
        kitchenOpt.getItems().addAll("Microwave", "Fridge and Microwave");
        coffeeOpt.getItems().addAll("1 Cup Standard Coffee Machine", "Keurig Hot K200 Machine");
        accessibilityOpt.getItems().addAll("Standard Room", "Enhanced Accessibility Room");
        
        // tab 7 subtab (edit) ---- need functionality
        
        editRoom.setAlignment(Pos.CENTER);
        editRoom.add(whichRoom,0,0);
        editRoom.add(number,2,0);
        editRoom.add(whichOpt,2,1);
        editRoom.add(backToOptions1,0,5);
        editRoom.add(roomContinue,2,5);
        editRoom.add(anotherChoice,0,1);
        whichOpt.getItems().addAll("Bed Option" , "Kitchen Option" , "Coffee Option" , "Accessibility Option");
        
        
        // tab 7 -- activeate controls
        
        active.setAlignment(Pos.CENTER);
        active.add(activeRoom, 0, 0);
        active.add(activeNum,2,0);
        active.add(activateRoom,1,1);
        active.add(backMain,1,2);
        
        //tab 7 deactive
        
        inactive.setAlignment(Pos.CENTER);
        inactive.add(deactiveRoom, 0, 0);
        inactive.add(deactiveNum,2,0);
        inactive.add(deactivateRoom,1,1);
        inactive.add(backToMain,1,2);
        

        // tab 8 log
        root.getTabs().add(empTab8);
        empTab8.setContent(empLogOut1);
        empLogOut1.setAlignment(Pos.CENTER);
        empLogOut1.add(empLogOut, 1, 3);
        empLogOut1.add(empLog,0,0);
        
        
        //!!!!!!!Guest Menu!!!!!!!
        
        //guest tabs
        guestRoot.getTabs().addAll(guestTab1, guestTab2, guestTab3,guestTab4);
        
        // tab 1 edits
        
       bookRoomGuest.setAlignment(Pos.CENTER);
       guestTab1.setContent(bookRoomGuest);
       bookRoomGuest.add(roomChoice,1,1,2,1);
       bookRoomGuest.add(roomNumber,1,2);
       bookRoomGuest.add(year,1,3);
       bookRoomGuest.add(inDay,1,4);
       bookRoomGuest.add(outDay,1,5);
       bookRoomGuest.add(txtYear,2,3);
       bookRoomGuest.add(txtInDay,2,4);
       bookRoomGuest.add(txtOutDay,2,5);
       bookRoomGuest.add(roomEnter,2,2);
       bookRoomGuest.add(showAvail,4,5);
       bookRoomGuest.add(bookRoomNum, 4, 6);
       bookRoomGuest.add(bookingTA,1,6,2,1);
       
       bookingTA.setEditable(false);
       bookingTA.setMaxSize(500,500);
       
       // tab 2 edit 
       
       guestTab2.setContent(iBooked);
       iBooked.setAlignment(Pos.CENTER);
       iBooked.add(guestBookings,1,1);
       iBooked.add(iBook, 1, 2,2,1);
       iBooked.add(showMy,2,3);
       iBook.setEditable(false);
       iBook.setMaxSize(1000,1000);
       
       //tab 3 edits
       guestTab3.setContent(editPersonal);
       editPersonal.setAlignment(Pos.CENTER);
       editPersonal.add(edit,0,0);
       editPersonal.add(choice2,2,0);
       editPersonal.add(continue3,1,2);
       choice2.getItems().addAll("Edit My Name");
       
       // tab 3 subpane edits
       
       personalPass.setAlignment(Pos.CENTER);
       personalPass.add(newPasswordGuest,0,0);
       personalPass.add(confirmNewGuestPass,0,1);
       personalPass.add(txtNewPasswordGuest,1,0);
       personalPass.add(txtConfirmNewGuestPass,1,1);
       personalPass.add(changeGuestPass,2,2);
       personalPass.add(backToGuestMenu,2,4);
       personalPass.add(TAEditPass, 1,5,2,1);
       TAEditPass.setEditable(false);
       TAEditPass.setMaxSize(400,250 );
       
       
       guestTab4.setContent(logOut);
       logOut.setAlignment(Pos.CENTER);
       logOut.add(question, 0, 0);
       logOut.add(yes,1,3);
       

                
        primaryStage.setScene(empLoginScene);
        primaryStage.setTitle("Hotel Madison App");
        
        Alert errorAlert = new Alert(AlertType.ERROR);

        btnLogin.setOnAction(e -> {
            if (comboUser.getValue() == "Employee")
            {
                Employee foundEmployee = null;
                for (int i = 0; i < Employee.employees.size(); i++)
                {
                    
                    Employee current = Employee.employees.get(i);
                    boolean isPerson = current.checkCredentials(txtFirst.getText(), txtSecond.getText());

                    if (isPerson) {
                        foundEmployee = current;
                        
                        
                       primaryStage.setScene(empMenuChoiceScene);

                        break;
                    }
                    else
                    {
                         a.setTitle("Invalid Login");
                         a.setHeaderText("Login information is incorrect");
                         a.setContentText("Either you username or password is incorrect, please try again");
                         a.show();
                    }

                }
            }
            else if (comboUser.getValue() == "Guest")
                {
                    Guest foundGuest = null;
                    for (int i = 0; i < Guest.guestAccounts.size(); i++)
                    {
                        Guest current = Guest.guestAccounts.get(i);
                        boolean isPerson = current.checkCredentials(txtFirst.getText(), txtSecond.getText());
                        
                        if (isPerson)
                        {
                            foundGuest = current;
                            primaryStage.setScene(bookRoom);
                            break;

                        }
                        else
                        {
                             a.setTitle("Invalid Login");
                             a.setHeaderText("Login information is incorrect");
                             a.setContentText("Either you username or password is incorrect, please try again");
                             a.show();
                        }
                    }
                }
            
        });
     //!!!!! Employee Tab 1 Functionality   
       rb2.setOnAction(e -> {
           singleRoom.setVisible(true);
       });
       
        btnEnter.setOnAction(e -> {
            //int roomNum = Integer.parseInt(singleRoom.toString());
            if (rb1.isSelected() == true)
            {
                for (int i = 0; i < Room.rooms.size(); i++)
                {
                    report.appendText(Room.rooms.get(i).roomAnalytics().toString() +"\n");
                }
                        
            }
            else if(rb2.isSelected() == true)
            {
               Room roomFound = null;
               for (int i = 0; i < Room.rooms.size(); i++)
               {
                   int roomNum = Integer.parseInt(singleRoom.getText());
                   Room current = Room.rooms.get(i);
                   if (roomNum == current.getRoomNumber())
                   {
                       roomFound = current;
                       report.appendText(current.roomAnalytics().toString());
                   }
                  
               }
    
               singleRoom.clear();
            }
         
 
         
           
        });
        
        btnBack1.setOnAction(e -> {
            primaryStage.setScene(empLoginScene);
        });
        clearReport.setOnAction(e -> {
           report.clear(); 
        });
        
        // Employee Tab 2 Functionality
        btnGuest.setOnAction(e -> {
            
        
        boolean found = false;
        int foundRoom = Integer.parseInt(txtRoomNum.getText());
        for (int i = 0; i < Booking.booked.size(); i++)
        {
            Booking current = Booking.booked.get(i);
            int currentRoomBooked = current.bookedRoom.getRoomNumber();
            if (foundRoom == currentRoomBooked)
            {
                current.endBooking();
                found = true;
                
            }
        }           
            TAResponse.appendText(" Successfully Checked Out");
        });
        
        
        // Employee tab 3 Functionality
       
        btnCreateGuest.setOnAction(e -> {
            
            String guestName = gName.getText();
            String guestUser = gUser.getText();
            String guestPass = gPass.getText();
            String guestConfirm = confirmGPass.getText();
            
            if (yesOrNo.getValue() == "Yes")
            {
                ValueGuest newGuest = new ValueGuest(guestUser, guestPass, guestName);
                Guest regGuest = new Guest(guestUser, guestPass, guestName);
            }
            else
            {
                Guest regGuest = new Guest(guestUser, guestPass, guestName);
            }
            
        });
        
        
        //Employee tab 4 Functionality
        continue1.setOnAction(e -> {
            if (editInfo.getSelectionModel().getSelectedIndex() == 0)
            {
                primaryStage.setScene(empEditGuestPass);
            }
        });
        
        
        btnChangePass.setOnAction(e -> {
            String guestUsername = txtEditName.getText();
            int guestNum = 0;
            for (int i = 0; i < Guest.guestAccounts.size(); i++)
            {
                if(guestUsername.equalsIgnoreCase(Guest.guestAccounts.get(i).getUserName()))
                {
                    guestNum = i;
                }
            }
            String password1 = txtEditPass.getText();
            String newPass = txtConfirmEdit.getText();
            if (password1.equals(newPass))
            {
                Guest.guestAccounts.get(guestNum).setPassword(Guest.guestAccounts.get(guestNum).getPassword(), password1);
            }
        });
        btnBackToChoice.setOnAction(e -> {
            primaryStage.setScene(empMenuChoiceScene);
        });
        
        //Employee tab 5 Functionality
        
        btnEmpCreate.setOnAction(e -> {
           String nameEmp = txtEmpName.getText();
           String userEmp = txtEmpUser.getText();
           String passEmp = txtEmpPass.getText();
           String confirmEmp = txtEmpConfirm.getText();
           
           Employee newEmp = new Employee(userEmp,passEmp,nameEmp);
           TAEmp.appendText(nameEmp + " was successfully created!");
           
        });
        
        //Employee tab 6 functionality
        
        btnContinue2.setOnAction(e -> {
            primaryStage.setScene(empEditEmpPass);
        });
        
        //Emplotee tab 6 subpane 
        btnChangePass.setOnAction(e -> {
            String empUsername = txtEmpUsername.getText();
            int empNum = -1;
            for (int i = 0; i < Employee.employees.size(); i++)
            {
                if(empUsername.equalsIgnoreCase(Employee.employees.get(i).getUsername()))
                {
                    empNum = i;
                }
            }
            String empPassword1 = txtEmpPass.getText();
            String empPassNew = txtEmpNewPass.getText();
            
            if(empPassword1.equals(empPassNew))
            {
                Employee.employees.get(empNum).setPassword(Employee.employees.get(empNum).getPassword(), empPassword1);
            }
        });
        
        btnGoBack.setOnAction(e -> {
            primaryStage.setScene(empMenuChoiceScene);
        });
        
        backToOptions1.setOnAction(e -> {
           primaryStage.setScene(empMenuChoiceScene); 
        });
        
                // Employee tab 7
        btnContinue3.setOnAction(e -> {
            if (roomOpt.getSelectionModel().getSelectedIndex() == 0)
            {
                     primaryStage.setScene(creating);
            }
            else if (roomOpt.getSelectionModel().getSelectedIndex() == 1)
            {
                primaryStage.setScene(editing);
            }
            else if (roomOpt.getSelectionModel().getSelectedIndex() == 2)
            {
                primaryStage.setScene(activate);
            }
            else
                primaryStage.setScene(inactivate);
        });
        
        
        backToOpt.setOnAction(e -> {
            primaryStage.setScene(empMenuChoiceScene);
        });
        // employee tab 8
        empLogOut.setOnAction(e -> {
            primaryStage.setScene(empLoginScene);
            txtFirst.clear();
            txtSecond.clear();
        });
        
        creatingRoom.setOnAction(e -> {
            if (roomOpt.getSelectionModel().getSelectedIndex() == 0)
            {
       
            int bedChoice1 = bedOpt.getSelectionModel().getSelectedIndex();
            int kitchenChoice1 = kitchenOpt.getSelectionModel().getSelectedIndex();
            int coffeeChoice1 = coffeeOpt.getSelectionModel().getSelectedIndex();
            int accessibilityChoice1 = accessibilityOpt.getSelectionModel().getSelectedIndex();
    

           int foundRoomNum = Integer.parseInt(roomNumbers.getText());
           
           Room rooms = new Room(bedChoice1,kitchenChoice1,coffeeChoice1,accessibilityChoice1,foundRoomNum);
           creatingTA.appendText(rooms.roomDescription() + "\n" +"Room " + foundRoomNum + " was successfully created");
            }
        });
        
         activateRoom.setOnAction(e -> {
            int activeTheNum = Integer.parseInt(activeNum.getText());
            boolean not_Found = true;
            for (int i = 0; i < Room.rooms.size(); i++)
            {
                Room current = Room.rooms.get(i);
                if (current.getRoomNumber() == activeTheNum)
                {
                    not_Found = false;
                    current.makeActive();
                }
//                else
//                {
//                    
//                    
//                         a.setTitle("Invalid Room");
//                         a.setHeaderText("Room not found");
//                         a.setContentText("The room you're trying to find has not yet been created please enter a room that has been created");
//                         a.show();
//                    
//                }
            }
        });
         
         deactivateRoom.setOnAction(e -> {
             int makeRoomDeactive = Integer.parseInt(deactiveNum.getText());
             boolean notFound = true;
             for (int i = 0; i < Room.rooms.size(); i++)
             {
                 Room current = Room.rooms.get(i);
                 if (current.getRoomNumber() == makeRoomDeactive)
                 {
                     notFound = false;
                     current.makeInactive();
                 }
//                 else
//                 {
//                     if (notFound = true)
//                     {
//                         a.setTitle("Invalid Room");
//                         a.setHeaderText("Room not found");
//                         a.setContentText("The room you're trying to find has not yet been created please enter a room that has been created");
//                         a.show();
//                     }
//                 }
             }
         });
         
         backToMain.setOnAction(e -> {
            primaryStage.setScene(empMenuChoiceScene); 
         });
        backMain.setOnAction(e -> {
           primaryStage.setScene(empMenuChoiceScene); 
        });
        
        
        // Guest tab 1 edits

        showAvail.setOnAction(e -> {
        boolean didNotFindRoom = true;

        
        for (int i = 0; i < Room.rooms.size(); i++)
        {
            if (!Room.rooms.get(i).isBooked() && Room.rooms.get(i).isActive())
            {
                bookingTA.appendText(Room.rooms.get(i).roomDescription());
                didNotFindRoom = false;
            }

        }
        });
        
        bookRoomNum.setOnAction(e -> {

        bookingTA.clear();

       Guest Guests = Guest.guestAccounts.get(0);
        for (int i = 0; i < Guest.guestAccounts.size(); i++)
        {
            if (Guest.guestAccounts.get(i).getUserName().equals(guestUser.getText()))
            {
                Guests = Guest.guestAccounts.get(i);
            }
        }

        for (int i = 0; i < Room.rooms.size(); i++)
        {
             Room current = Room.rooms.get(i);
             int roomBeingBook = Integer.parseInt(roomEnter.getText());
             int yearOfBooking = Integer.parseInt(txtYear.getText());
             int dayInOfBooking = Integer.parseInt(txtInDay.getText());     
             int dayOutOfBooking = Integer.parseInt(txtOutDay.getText());
             
            if(current.getRoomNumber() == roomBeingBook && Room.rooms.get(i).isActive() && !current.isBooked())
            {
                Booking anotherBook = new Booking(Guests,current,yearOfBooking,dayInOfBooking,dayOutOfBooking);
            }
        }
        
       });
                
         showMy.setOnAction(e -> {
        boolean noRoomsBooked = true;

        for (int i = 0; i < Booking.booked.size(); i++)
        {
            if(Booking.booked.get(i).bookingGuest.getUserName().equalsIgnoreCase(txtFirst.getText()))
            {
                iBook.appendText(Booking.booked.get(i).bookedRoom.roomAnalytics()+"\n");
                 
            }

        }
        });
         
         continue3.setOnAction(e -> {
            if (choice2.getSelectionModel().getSelectedIndex() == 0)
                primaryStage.setScene(editPersonalScene);
         });
         
         changeGuestPass.setOnAction(e -> {
             String newName = txtNewPasswordGuest.toString();
             String confirmName = txtConfirmNewGuestPass.toString();
             Guest newGuest = null;
             for (int i = 0; i < Guest.guestAccounts.size(); i++)
                 {
                     if (guestUser.equals(Guest.guestAccounts.get(i).getUserName()))
                         newGuest = Guest.guestAccounts.get(i);
                 }
             if (newGuest != null)
                 {
                     newGuest.setGuestName(newName);
                 }
         });
         
         backToGuestMenu.setOnAction(e -> {
            primaryStage.setScene(bookRoom); 
         });
         
         
         yes.setOnAction(e -> {
             primaryStage.setScene(empLoginScene);
                 });
                 
         
        primaryStage.show();

    }
    
    @Override
    public void stop()
    {
        insertEmployee();
        insertGuest();
        insertRoom();
    }
    
    public void insertEmployee(){
        for (int i = 0; i < Employee.employees.size(); i++)
        {
            String sqlQuery = "";
            sqlQuery += "INSERT INTO SYSTEM.EMPLOYEE (EMPLOYEEID, USERNAME, PASSWORD, EMPLOYEENAME) VALUES ";
            sqlQuery += "(" + Employee.employees.get(i).getEmployeeID() + ", ";
            sqlQuery += "\'" + Employee.employees.get(i).getUsername() + "\', ";
            sqlQuery += "\'" + Employee.employees.get(i).getPassword() + "\', ";
            sqlQuery += "\'" + Employee.employees.get(i).getEmployeeName() + "\')";
            
            sendDBCommand(sqlQuery);
        }
     
    }
    public void insertGuest(){
        for (int i = 0; i < Guest.guestAccounts.size(); i++)
        {
            String sqlQuery = "";
            sqlQuery += "INSERT INTO SYSTEM.GUEST (GUESTID, USERNAME, PASSWORD, GUESTNAME) VALUES ";
            sqlQuery += "(" + Guest.guestAccounts.get(i).getGuestID() + ", ";
            sqlQuery += "\'" + Guest.guestAccounts.get(i).getUserName() + "\', ";
            sqlQuery += "\'" + Guest.guestAccounts.get(i).getPassword() + "\', ";
            sqlQuery += "\'" + Guest.guestAccounts.get(i).getGuestName() +"\')";
            
            sendDBCommand(sqlQuery);

        }
    }
    
    public void insertRoom() {
        for (int i = 0; i < Room.rooms.size(); i++)
        {
            String sqlQuery = "";
            sqlQuery += "INSERT INTO SYSTEM.ROOM (ROOMID, BEDOPTION, KITCHENOPTION, COFFEEOPTION, ACCESSIBILITYOPTION, ROOMNUMBER, ISROOMBOOKED, ROOMCOSTPERNIGHT, ROOMREV) VALUES ";
            sqlQuery += "(" + Room.rooms.get(i).getRoomID() + ", ";
            sqlQuery += Room.rooms.get(i).bedOption + ", ";
            sqlQuery += Room.rooms.get(i).kitchenOption + ", ";
            sqlQuery += Room.rooms.get(i).coffeeOption + ", ";
            sqlQuery += Room.rooms.get(i).accessibleOption +", ";
            sqlQuery += Room.rooms.get(i).getRoomNumber() + ", ";
            sqlQuery += "\'" + Room.rooms.get(i).isRoomBooked() + ", ";
            sqlQuery += Room.rooms.get(i).roomCostPerNight + ", ";
            sqlQuery += Room.rooms.get(i).getRoomRev() + ")";
            
            sendDBCommand(sqlQuery);
        }
    }
    
    public void insertRoomService(RoomService services){
        String sqlQuery ="";
        sqlQuery += "INSERT INTO SYSTEM.ROOMSERVICE (ROOMSERVICEID, ROOMSERVICEDESCRIPTION, PRICE) VALUES ";
        sqlQuery += "(" + services.getRoomServiceID() + ", ";
        sqlQuery += "\'" + services.getDescription() + "\', ";
        sqlQuery += "\'" + services.getPrice() + "\')";
        
        sendDBCommand(sqlQuery);
    }
    
    public void insertOrderItems()
    {
        for (int i = 0; i < Booking.booked.size(); i++)
        {
           String sqlQuery = "";
           sqlQuery += Booking.booked.get(i).bookingID + ", ";

        }
    }
    public void showAllEmployee()
    {
        String sqlQuery = "SELECT * FROM EMPLOYEE";
        sendDBCommand(sqlQuery);
        String username ="";
        String password ="";
        String name = "";
        String ID ="";
        try
        {
            while (dbResults.next())
            {
                ID += dbResults.getString(1);
                name += dbResults.getString(2);
                username += dbResults.getString(3);
                password += dbResults.getString(4);
                Employee emp = new Employee(username, password, name);
            }
            dbConn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        
    }
    
    public void showAllGuest(){
        String sqlQuery = "SELECT * FROM GUEST";
        sendDBCommand(sqlQuery);
        String gName = "";
        String gUser ="";
        String gPass = "";
        String gID = "";
        String value = "";
        ValueGuest vGuest = null;
        Guest newGuest = null;
        
        try
        {
            while(dbResults.next())
            {
                gID += dbResults.getString(1);
                gName += dbResults.getString(2);
                gUser += dbResults.getString(3);
                gPass += dbResults.getString(4);
                value += dbResults.getString(5);
                
                if(value.equals("Yes"))
                {
                    vGuest = new ValueGuest(gUser, gPass, gName);
                }
                else
                {
                  newGuest = new Guest(gUser, gPass, gName);
                }
            }
            dbConn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        
    }

            

    
    public static void main(String[] args) {
        launch(args);
        
    } 
    public void sendDBCommand(String sqlQuery)
    {
        // Set up your connection strings
        // IF YOU ARE IN CIS330 NOW: use YOUR Oracle Username/Password
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String userID = "system"; // Change to YOUR Oracle username
        String userPASS = "heyyou90"; // Change to YOUR Oracle password
        OracleDataSource ds;
        
        // Clear Box Testing - Print each query to check SQL syntax
        //  sent to this method.
        // You can comment this line out when your program is finished
        System.out.println(sqlQuery);
        
        // Lets try to connect
        try
        {
            // instantiate a new data source object
            ds = new OracleDataSource();
            // Where is the database located? Web? Local?
            ds.setURL(URL);
            // Send the user/pass and get an open connection.
            dbConn = ds.getConnection(userID,userPASS);
            // When we get results
            //  -TYPE_SCROLL_SENSITIVE means if the database data changes we
            //   will see our resultset update in real time.
            //  -CONCUR_READ_ONLY means that we cannot accidentally change the
            //   data in our database by using the .update____() methods of
            //   the ResultSet class - TableView controls are impacted by
            //   this setting as well.
            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // We send the query to the DB. A ResultSet object is instantiated
            //  and we are returned a reference to it, that we point to from
            // dbResults.
            // Because we declared dbResults at the datafield level
            // we can see the results from anywhere in our Class.
            dbResults = commStmt.executeQuery(sqlQuery); // Sends the Query to the DB
            // The results are stored in a ResultSet structure object
            // pointed to by the reference variable dbResults
            // Because we declared this variable globally above, we can use
            // the results in any method in the class.
        }
        catch (SQLException e)
        {
            System.out.println(e.toString());
        }
    }


    
    
    
    
    
    
}
