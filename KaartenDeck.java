import java.util.ArrayList;

class KaartenDeck {
	ArrayList<Kaart> deck = new ArrayList();
	
	KaartenDeck(){
		String[] kleur = {"Ruiten ","Harten ","Schoppen ","Klaveren "};
		String[] naam = {"2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10 ","Boer ","Vrouw ","Heer ","Aas "};
		int[] waarde = {2,3,4,5,6,7,8,9,10,10,10,10,11};
		int a = 0;
		for(int i = 0; i < kleur.length;i++){
			for(int j=0;j < naam.length;j++){
				Kaart kaart = new Kaart();
			    kaart.kleur = kleur[i];
				kaart.naam = naam[j];
				kaart.waarde = waarde[j];	
				deck.add(kaart);
				a++;
			}
		}
	}
}
