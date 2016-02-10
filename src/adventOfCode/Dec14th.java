package adventOfCode;

public class Dec14th {
	
	public void race(int speed, int flySecs, int restSecs) {
		
		boolean running = true;
		int sum = 0;
		for(int i = 1; i <= 2503;) {
			if(running) {
				for(int j = 0; j < flySecs; j++) {
					sum += speed;
					i++;
					if(i > 2503) {
						break;
					}
				}
			} else {			//resting
				for(int k = 0; k < restSecs; k++) {
					i++;
					if(i > 2503) {
						break;
					}
				}
			}
			running = !running;
		}
		System.out.println(sum);
	}
	/*
	 * Pseudo
	 * Starta med 2503 sek och räkna ner
	 * Kör en boolean, true för kör, false för stanna
	 * För rudolph, kör 8 sek och vila 165 sek. 
	 */
	
	
	
	/*
	 *	Rudolph can fly 22 km/s for 8 seconds, but then must rest for 165 seconds. 2640
		Cupid can fly 8 km/s for 17 seconds, but then must rest for 114 seconds.
		Prancer can fly 18 km/s for 6 seconds, but then must rest for 103 seconds.
		Donner can fly 25 km/s for 6 seconds, but then must rest for 145 seconds.
		Dasher can fly 11 km/s for 12 seconds, but then must rest for 125 seconds.
		Comet can fly 21 km/s for 6 seconds, but then must rest for 121 seconds.
		Blitzen can fly 18 km/s for 3 seconds, but then must rest for 50 seconds.
		Vixen can fly 20 km/s for 4 seconds, but then must rest for 75 seconds.
		Dancer can fly 7 km/s for 20 seconds, but then must rest for 119 seconds. 
	 * 
	 */
	
	public static void main(String[] args) {
		Dec14th dc = new Dec14th();
		dc.race(22, 8, 165);
		dc.race(8, 17, 114);
		dc.race(18, 6, 103);
		dc.race(25, 6, 145);
		dc.race(11, 12, 125);
		dc.race(21, 6, 121);
		dc.race(18, 3, 50);
		dc.race(20, 4, 75);
		dc.race(7, 20, 119);
	}

}
