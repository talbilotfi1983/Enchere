package fr.encheres.bo;

public class Routage {
	public static String getRoute(int body) {
		String route = null;
		switch (body) {
		case 1:

			route = "home_visitor";

			break;

		case 2:
			route = "home_admin_user";
			break;

		case 3:

			route = "login";

			break;
		case 4:

			route = "register";

			break;

		case 5:

			route = "forgot";

			break;

		case 6:

			route = "profil";

			break;
		case 7:
			route = "update";
			break;
		case 8:

			route = "manage_users";

			break;

		case 9:
			route = "manage_category";
			break;

		case 10:
			route = "sell_product";
			break;
		case 11:
			route = "credit";
			break;
			
		case 12:
			route = "showArticle";
			break;
			
		

		}
		return route;
	}
}
