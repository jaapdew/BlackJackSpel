import java.util.*;

public class BlackJack {
	
	public static void main(String[] args) {
		BlackJack blackJack = new BlackJack();
		System.out.println("Welcome bij BlackJack!");
		KaartenDeck eersteDeck = new KaartenDeck();
		Collections.shuffle(eersteDeck.deck);
		for(int i = 0; i<52; i++) {
		System.out.print(eersteDeck.deck.get(i).kleur + eersteDeck.deck.get(i).naam + ", ");
		}
		System.out.println();
		ArrayList<Kaart> handVanDeSpeler = new ArrayList();
		blackJack.eersteTweeKaarten(eersteDeck, handVanDeSpeler);
		int l=2;
		while(blackJack.scoreCount(handVanDeSpeler) <= 21 || blackJack.kaartVragen()== "p" || blackJack.kaartVragen()== "q") {
			blackJack.keuzeTesten(blackJack.kaartVragen(),eersteDeck, handVanDeSpeler);
			System.out.println(handVanDeSpeler.get(l).kleur + handVanDeSpeler.get(l).naam);
			System.out.println("Uw score: " + blackJack.scoreCount(handVanDeSpeler));
			l++;
		}
		if(blackJack.scoreCount(handVanDeSpeler) > 21) {
			System.out.println("U heeft verloren!");
		}
		
		
	}

	public void eersteTweeKaarten(KaartenDeck Deck, ArrayList<Kaart> hand) {
		for(int i = 0; i< 2; i++){
			Kaart spelersKaart = Deck.deck.get(0);
			hand.add(spelersKaart);
			Deck.deck.remove(0);
			System.out.println(hand.get(i).kleur + hand.get(i).naam);
		}
		System.out.println("Uw score: " + scoreCount(hand));
	}
	
	public void keuzeTesten(String keuze, KaartenDeck Deck, ArrayList<Kaart> hand) { //werkt maar bij keuze p en q geeft hij een exception
		if(keuze.equalsIgnoreCase("k")) {
			Kaart spelersKaart = Deck.deck.get(0);
			hand.add(spelersKaart);
			Deck.deck.remove(0);
		}else if (keuze.equalsIgnoreCase("p")) {
			System.out.println("U heeft gepast");
			for(int i=0; i<hand.size();i++) {
				System.out.print(hand.get(i).kleur + hand.get(i).naam);
			}
			int eindScore = scoreCount(hand);
			System.out.println("Uw eind score is: " + eindScore);
			System.exit(0);
		}else 
			System.out.println("Het spel is gestopt");
			System.exit(0);
	}

	public int scoreCount(ArrayList<Kaart> hand) {
		int score = 0;
		for(int i=0; i<hand.size();i++) {
			score = score +hand.get(i).waarde;
		}if(score>21) {
			for(int j=0; j<hand.size();j++) {
				if(hand.get(j).waarde==11 && score >21) {
					score = score - 10;
					}
				}
			}
		return score;
	}
	public String kaartVragen() { 
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Druk k om een kaart te vragen");
		System.out.println("Druk p om te passen");
		System.out.println("Druk q om met het spel te stoppen");
		String keuze = "a";
        try {
            keuze = input.next();
        } catch (InputMismatchException e) {
            System.out.println("You did not choose the right key, try again ");
            keuze = kaartVragen();
        }
        if (!keuze.equalsIgnoreCase("k") && !keuze.equalsIgnoreCase("q") && !keuze.equalsIgnoreCase("p")) {
        	System.out.println("Verkeerde input, kies aub voor 'k','p' of 'q'");
        	keuze = kaartVragen();
        }else 
            System.out.println(" U heeft " + keuze + " gekozen.");
            return keuze;
        	
	}
}