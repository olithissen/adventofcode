package net.tonick.adventofcode.day03;

public class Day03 {
	public static void main(String... args) {
		System.out.println(manhattanDistanz(22) == 3 );
		System.out.println(manhattanDistanz(7) == 2 );
		System.out.println(manhattanDistanz(25) == 4 );
		System.out.println(manhattanDistanz(277678));
	}

	public static long maximalwertInRing(long ring) {
		return (long) (4 * Math.pow(ring, 2) - 4 * ring + 1);
	}

	public static long umfang(long ring) {
		return maximalwertInRing(ring) - maximalwertInRing(ring - 1);
	}

	public static long maximaleSchritte(long ring) {
		return (ring - 1) * 2;
	}

	public static long achslaenge(long ring) {
		return (long) Math.sqrt((double) maximalwertInRing(ring));
	}

	public static long inWelchemRingIst(long zahl) {
		for (long i = 1;; i++) {
			if (zahl >= maximalwertInRing(i - 1) && zahl < maximalwertInRing(i)) {
				return i;
			}
		}
	}

	public static long positionImRing(long zahl) {
		long ring = inWelchemRingIst(zahl);
		return zahl - (maximalwertInRing(ring) - umfang(ring));
	}
	
	public static long abstandVonEcke(long zahl) {
		long ring = inWelchemRingIst(zahl);
		long achslaenge = achslaenge(ring);
		long positionImRing = positionImRing(zahl);
		long umfang = umfang(ring);

		long besterAbstand = achslaenge;
		long neuerAbstand;

		for (int i = 0; i < 4; i++) {
			neuerAbstand = positionImRing - (umfang - i * (achslaenge - 1));
			if (Math.abs(neuerAbstand) < Math.abs(besterAbstand)) {
				besterAbstand = neuerAbstand;
			}
		}
		neuerAbstand = positionImRing;
		if (Math.abs(neuerAbstand) < Math.abs(besterAbstand)) {
			besterAbstand = neuerAbstand;
		}

		return Math.abs(besterAbstand);
	}
	
	public static long manhattanDistanz(long zahl) {
		return Math.abs(maximaleSchritte(inWelchemRingIst(zahl)) - abstandVonEcke(zahl));
	}
}
