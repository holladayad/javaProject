package javaProject;

import java.util.*;

public class HoApp {
	public static void main(String[] args) {

		Employee jacob = new Employee("bell2jh", "Godukes1", "jacob");
		Employee sarah = new Employee("smith", "Hi1", "sarah");

		Guest susan = new Guest("susan1", "Hi1", "susan");
		Guest jay = new Guest("jay1", "Hi1", "jay");

		Room one = new Room(3, 2, 1, 1, 1);
		Room two = new Room(2, 1, 2, 2, 2);
		Room three = new Room(1, 1, 2, 1, 3);

		Booking first = new Booking(susan, one, 2019, 5, 10);
		Booking second = new Booking(jay, two, 2019, 8, 16);

		ValueGuest robin = new ValueGuest("robin1", "hi", "robin");
		ValueGuest zach = new ValueGuest("zach1", "hi", "zach");

		Scanner in = new Scanner(System.in);
		int begin = 0;
		System.out.println("Welcome to Hotel Madison");
		System.out.println("-------------------------");
		do {
			System.out.println("1)Login as existing Employee\n" + "2)Login as an exisiting Guest\n" + "3)Exit system");
			System.out.print("Choice: ");
			begin = in.nextInt();
			beginningChoice(begin);

		} while (begin != 3);

	}

	public static int beginningChoice(int begin) {
		Scanner in = new Scanner(System.in);
		switch (begin) {

		case 1:
			if (begin == 1) {
				String EmployeeUsername;
				String EmployeePassword;
				// Employee jacob = new Employee("bell2jh", "godukes", "jacob");
				Employee foundEmployee = null;

				System.out.print("Enter Employee Username: ");
				EmployeeUsername = in.next();

				System.out.print("Enter Employee Password: ");
				EmployeePassword = in.next();

				for (int i = 0; i < Employee.employees.size(); i++) {
					Employee current = Employee.employees.get(i);
					boolean isPerson = current.checkCredentials(EmployeeUsername, EmployeePassword);

					if (isPerson) {
						foundEmployee = current;
						break;
					}
				}
				if (foundEmployee == null) {
					System.out.println("Employee Account not found");
					break;
				}
				System.out.println("Welcome, " + foundEmployee.getEmployeeName());
				int answer = 0;
				do {
					System.out.println("-----------------------------");
					System.out.println("Which action would you like to choose?");
					System.out.println("1) Run a Booking report\n" + "2) Check a Guest out\n"
							+ "3) Create a Guest account\n" + "4) Edit Guest Account\n" 
                                                        + "5) Create a new Employee Information\n"
                                                        + "6) Edit Employee Information\n"
							+ "7) Create, edit, and make a Room inactive\n"
                                                        + "8)Log out");
					answer = in.nextInt();

					EmployeeMenu(answer);

				} while (answer != 8);

			}
			break;
		case 2:

			Guest foundGuest = null;
			System.out.print("Enter Guest username: ");
			String usernameGuest = in.next();
			System.out.print("Enter Guest password: ");
			String passwordGuest = in.next();

			for (int i = 0; i < Guest.guestAccounts.size(); i++) {
				Guest current = Guest.guestAccounts.get(i);
				boolean isPerson = current.checkCredentials(usernameGuest, passwordGuest);
				if (isPerson) {
					foundGuest = current;
					break;
				}
//				} else
//					System.out.println("invalid login");
			}
			if (foundGuest == null) {
				System.out.println("Guest Account not found");
				break;
			}
			System.out.println("Welcome, " + foundGuest.getGuestName());
			int GuestAnswer = 0;
			// String usernameGuest = "";
			do {
				System.out.println("Which action would you like to choose?\n" + "1)Book a Room\n"
						+ "2)See which Rooms have been booked by you\n" + "3)Edit personal information\n" + "4)Logout");
				GuestAnswer = in.nextInt();
				GuestMenu(GuestAnswer, usernameGuest);

			} while (GuestAnswer != 4);

			break;
		case 3:
			System.out.println("Exiting System....");
			break;

		}
		return begin;
	}

	public static void EmployeeMenu(int answer) {
		Scanner in = new Scanner(System.in);
                int guestNum = 0;
		String reply = "";
		switch (answer) {
		case 1:
			while (!reply.equalsIgnoreCase("all") && !reply.equalsIgnoreCase("one")) {
				System.out.println("For all Rooms or one Room? [All/One] ");
				reply = in.next();

			}

			if (reply.equalsIgnoreCase("all")) {
				for (int i = 0; i < Room.rooms.size(); i++) {
					System.out.println(Room.rooms.get(i).roomAnalytics());
				}
			} else {
				System.out.println("Enter Room number: ");
				int RoomNumber = in.nextInt();
				Room RoomFound = null;
				for (int i = 0; i < Room.rooms.size(); i++) {
					Room current = Room.rooms.get(i);
					if (RoomNumber == current.getRoomNumber()) {
						RoomFound = current;
						System.out.println(current.roomAnalytics());
						break;
					}
				}
				if (RoomFound == null) {
					System.out.println("Room not found");
					break;
				}
			}
			break;
		case 2: // free this Room
			System.out.println("What is the Guest's Room number? ");
			int RoomNumber = in.nextInt();
			boolean found = false;
			for (int i = 0; i < Booking.booked.size(); i++) {
				Booking current = Booking.booked.get(i);
				int currentRoomNum = current.bookedRoom.getRoomNumber();
				if (RoomNumber == currentRoomNum) {
					current.endBooking();
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Booking Not Found");
			}
			System.out.println("Guest sucessfully checked out");
			break;
		case 3:
			System.out.print("Enter the Guest name: ");
			String GuestName = in.next();
			System.out.print("Enter a username: ");
			String GuestUser = in.next();
			System.out.print("Enter Password: ");
			String GuestPassword = in.next();
			Guest newGuest = new Guest(GuestUser, GuestPassword, GuestName);

			String wantsValuedAccount = "";
			while (!wantsValuedAccount.equalsIgnoreCase("y") && !wantsValuedAccount.equalsIgnoreCase("n")) {
				System.out.println("Do you want to make a Valued Guest Account?[y/n]");
				wantsValuedAccount = in.next();

			}
			if (wantsValuedAccount.equalsIgnoreCase("n")) {
				newGuest = new Guest(GuestUser, GuestPassword, GuestName);
			} else {
				newGuest = new ValueGuest(GuestUser, GuestPassword, GuestName);
			}

			break;
                case 4:
                        int gustNum = 0;
                        System.out.println("Please enter the Guest you would like to edit: ");
                        String guestUsername = in.next();
                        gustNum = -1;
                        for (int i = 0; i < Guest.guestAccounts.size(); i++)
                        {
                            if (guestUsername.equalsIgnoreCase(Guest.guestAccounts.get(i).getUserName()))
                                guestNum = i;
                        }
                        System.out.println("Enter the new guest password: ");
                        String passwordNew = in.next();
                        System.out.println("Please confirm the password: ");
                        String passwordNew2 = in.next();
                        if (passwordNew.equals(passwordNew2))
                        {
                            Guest.guestAccounts.get(guestNum).setPassword(passwordNew);
                            System.out.println("Password change successful");
                        }
                        break;
                case 5:
			System.out.print("Enter your name: ");
			String newEmployeeName = in.next();
			System.out.print("Enter a username: ");
			String EmployeeUsername = in.next();
			System.out.print("Enter Password: ");
			String EmployeePassword = in.next();
			Employee newEmployee = new Employee(EmployeeUsername, EmployeePassword, newEmployeeName);
			break;
                case 6:
                        System.out.println("Enter username of the employee you want to edit: ");
                        String employUser = in.next();
                        int employeeNum = -1;
                        for (int i = 0; i < Employee.employees.size(); i++)
                        {
                            if (employUser.equalsIgnoreCase(Employee.employees.get(i).getUsername()))
                            employeeNum = i;    
                            
                        }
                        System.out.println("Please enter the new password for the employee: ");
                        String password = in.next();
                        System.out.println("Please confirm the password: ");
                        String password2 = in.next();
                        if (password.equals(password2))
                        {
                            Employee.employees.get(employeeNum).setPassword(password);
                            System.out.println("Password change successful");
                        }
   
                        break;
		case 7:
			int choice = 0;
			do {
				System.out.println("-----------------");
				System.out.println("1. Create New Room");
				System.out.println("2. Edit Existing Room");
				System.out.println("3. Make Room Inactive");
				System.out.println("4. Make Room Active");
				System.out.println("5. Quit");
				choice = in.nextInt();
				RoomChoices(choice);
			} while (choice != 5);
			break;
		case 8:
			System.out.println("Logging out...");
			break;
		}
	}

	public static void GuestMenu(int GuestAnswer, String usernameGuest) {
		Scanner in = new Scanner(System.in);
		Guest Guests = Guest.guestAccounts.get(0);
		for (int i = 0; i < Guest.guestAccounts.size(); i++) {
			if (Guest.guestAccounts.get(i).getUserName().equals(usernameGuest)) {
				Guests = Guest.guestAccounts.get(i);
			}
		}
		switch (GuestAnswer) {
		case 1:
			boolean didNotFindRoom = true;
			for (int i = 0; i < Room.rooms.size(); i++) {
				if (!Room.rooms.get(i).isBooked() && Room.rooms.get(i).isActive()) {
					System.out.println(Room.rooms.get(i).roomDescription());
					didNotFindRoom = false;
				}
			}
			if (didNotFindRoom) {
				System.out.println("We are sorry, but no rooms are available");
				break;
			}
			System.out.println("Which Room would you like to book (enter Room number): ");
			int RoomBeingBooked = in.nextInt();
			for (int i = 0; i < Room.rooms.size(); i++) {
				Room current = Room.rooms.get(i);
				if (current.getRoomNumber() == RoomBeingBooked && current.isActive() && !current.isBooked()) {
					//current.bookRoom();
					Booking books = new Booking(Guests, current, 2019, 5, 10);
					System.out.println("Booking successful!");
				}
			}

			break;
		case 2:
			boolean noRoomsBooked = true;
			for (int i = 0; i < Booking.booked.size(); i++) {
				if (Booking.booked.get(i).bookingGuest.getUserName().equalsIgnoreCase(usernameGuest)) {
					System.out.println(Booking.booked.get(i).bookedRoom.roomAnalytics() + "\n");
					noRoomsBooked = false;
				}
			}
			if (noRoomsBooked) {
				System.out.println("You have not rooms booked");
			}

			break;
		case 3:
			int GuestNum = 0;
			for (int i = 0; i < Guest.guestAccounts.size(); i++) {
				if (usernameGuest.equalsIgnoreCase(Guest.guestAccounts.get(i).getUserName()))
					GuestNum = (i);
			}
			System.out.println("Enter new Guest name: ");
			String name = in.next();
			Guest.guestAccounts.get(GuestNum).setGuestName(name);
			break;

		}
	}

	public static void RoomChoices(int choice) {
		Scanner in = new Scanner(System.in);

		switch (choice) {
		case 1:
			int bedOption = 0;
			while (bedOption != 1 && bedOption != 2 && bedOption != 3) {
				System.out.println("Enter Bed Option:\n1)1 Queen Bed\n" + "2)2 Queen Beds\n" + "3)1 King Bed");
				System.out.print("Choice: ");
				bedOption = in.nextInt();
			}
			int kitchenOption = 0;
			while (kitchenOption != 1 && kitchenOption != 2) {
				System.out.println("Enter Kitchen Option:\n" + "1)Microwave\n" + "2)Fridge and Microwave");
				System.out.print("Choice: ");

				kitchenOption = in.nextInt();
			}
			int coffeeOption = 0;
			while (coffeeOption != 1 && coffeeOption != 2) {
				System.out.println(
						"Enter Coffee Option:\n" + "1)1 Cup Std Coffee Machine\n" + "2)Keurig Hot K200 Machine");
				System.out.print("Choice: ");

				coffeeOption = in.nextInt();
			}
			int aOption = 0;
			while(aOption != 1 && aOption != 2) {
			System.out
					.println("Enter Accessibility Options:\n" + "1)Standard Room\n" + "2)Enhanced Accessibility Room");
			System.out.print("Choice: ");

			aOption = in.nextInt();
			}
			//Could be a problem if you have 2 rooms with the same number
			boolean numberIsUsed = true;
			int RoomNumber = 0;
			while(numberIsUsed) { 
				System.out.println("Enter an unused the Room Number");
				RoomNumber = in.nextInt();
				numberIsUsed = false;
				for (int i = 0; i < Room.rooms.size(); i++) {
					if (Room.rooms.get(i).getRoomNumber() == RoomNumber) {
						numberIsUsed = true;
					}
				}
			}
			Room RoomName = new Room(bedOption, kitchenOption, coffeeOption, aOption, RoomNumber);
			break;

		case 2:
			System.out.println("Please enter a Room number to be edited: ");
			int RoomToEdit = in.nextInt();
			Room RoomEdit = null;
			for (int i = 0; i < Room.rooms.size(); i++) {
				if (Room.rooms.get(i).roomNumber == RoomToEdit) {
					RoomEdit = Room.rooms.get(i);
				}
			}
			if (RoomEdit == null) {
				System.out.println("Room number not found");
				break;
			}
			int option = 0;
			do {
				System.out.print("What would you like to edit: \n 1: (bed option)\n" + " 2: (kitchen options)\n" + " 3: (coffee options)\n"
						+ " 4: (accessibility options) to edit: \n" + " 5: Quit \n");
				option = in.nextInt();

				switch (option) {
				case 1:
					System.out.println("Bed Options: " + "\n 1) 1 Queen Bed \n 2) 2 Queen Beds \n 3) 1 King Bed");
					System.out.println("Enterr bed option: ");
					int bedChoice = in.nextInt();
					for (int i = 0; i < Room.rooms.size(); i++) {
						if (Room.rooms.get(i).roomNumber == RoomToEdit) {
							Room.rooms.get(i).bedOption = bedChoice;
						}
					}
					break;
				case 2:
					System.out.println("Kitchen Options: \n 1) Microwave \n 2) Fridge + Microwave ");
					System.out.println("Enter Kitchen Option: ");
					int kitchenChoice = in.nextInt();
					for (int i = 0; i < Room.rooms.size(); i++) {
						if (Room.rooms.get(i).roomNumber == RoomToEdit) {
							Room.rooms.get(i).kitchenOption = kitchenChoice;
						}
					}
					break;
				case 3:
					System.out.println("Coffee Option:  \n 1) 1-Cup Std. Coffee Machine  \n 2) Keurig Hot K200 Machine");
					System.out.println("Enter Coffee Option: ");
					int coffeeChoice = in.nextInt();
					for (int i = 0; i < Room.rooms.size(); i++) {
						if (Room.rooms.get(i).roomNumber == RoomToEdit) {
							Room.rooms.get(i).coffeeOption = coffeeChoice;
						}
					}
					break;
				case 4:
					System.out.println("Accessibility Option: \n 1) Standard Room \n 2) Enhanced Accessibility Room");
					System.out.println("Enter Accessibility Option: ");
					int accessibilityChoice = in.nextInt();
					for (int i = 0; i < Room.rooms.size(); i++) {
						if (Room.rooms.get(i).roomNumber == RoomToEdit) {
							Room.rooms.get(i).accessibleOption = accessibilityChoice;
						}
					}
					break;
				}
			} while (option != 5);

			break;

		case 3:
			// Making a room inactive sounds different than booking it
			// Instead maybe add a flag to room that says active or not active

			System.out.println("Enter Room number to deactivate:");
			int roomNum = in.nextInt();
			boolean notFound = true;
			for (int i = 0; i < Room.rooms.size(); i++) {
				Room current = Room.rooms.get(i);
				if (current.getRoomNumber() == roomNum) {
					notFound = false;
					current.makeInactive();
				}
			}
			if (notFound) {
				System.out.println("Room not found");
				break;
			}
			break;


		case 4:
			// Making a room inactive sounds different than booking it
			// Instead maybe add a flag to room that says active or not active

			System.out.println("Enter Room Number to activate:");
			int room_num = in.nextInt();
			boolean not_found = true;
			for (int i = 0; i < Room.rooms.size(); i++) {
				Room current = Room.rooms.get(i);
				if (current.getRoomNumber() == room_num) {
					not_found = false;
					current.makeActive();
				}
			}
			if (not_found) {
				System.out.println("Room not found");
				break;
			}
			break;



		}

	}

}
