package Main;
	public class Main {
		private static String Version = "0.5 Alpha";
	
		public static void main(String[] args) {
			
			Main.getVersion();
			
			new Controller();
			
			windows();

		}
		
		public static void windows() {
			System.out.println("Front");
			new Fenster.Fenster_Front();
			System.out.println("Right");
			new Fenster.Fenster_Right();
			System.out.println("Back");
			new Fenster.Fenster_Back();
			System.out.println("Left");
			new Fenster.Fenster_Left();
		
		}
		
		
		public static void getVersion() {
			
			System.out.println("Applicationversion: " + Version);
		}

	}
	
	


