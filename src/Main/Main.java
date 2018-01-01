package Main;
	public class Main {
		private static String Version = "0.1";
		
		

		public static void main(String[] args) {
			
			Main.getVersion();
			
			new Controller();
			
			new Fenster.Fenster_Front();
			new Fenster.Fenster_Right();
			new Fenster.Fenster_Back();
			new Fenster.Fenster_Left();
			

		}
		
		public static void getVersion() {
			System.out.println(Version);
		}

	}
	
	


