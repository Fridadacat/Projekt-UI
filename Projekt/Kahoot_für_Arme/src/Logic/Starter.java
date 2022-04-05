package Logic;

import Data.User;
import GUI.StartScreen;

public class Starter {

	public static void main(String[] args) {
		User user = new User();
		new StartScreen(user);

	}

}
