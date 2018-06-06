package testA.house.run;

import testA.house.logic.House;
import testA.house.logic.House.HouseArray;

/**
 * Demo class House
 **/

public class RunHouse {

	public static void main(String[] args) {

		House h = new House();
		House h1 = new House(1, 32, 56, 4, 2, "Koltsov", "Appartament block", 50);
		House h2 = new House(2, 24, 62, 8, 3, "Kalinovscki", "Appartament block", 80);
		House h3 = new House(3, 386, 85, 1, 4, "Bogdanovich", "Appartament block", 80);
		House h4 = new House(4, 5, 38, 7, 1, "Gamarnic", "Appartament block", 70);
		House h5 = new House(5, 12, 46, 12, 2, "Independence av.", "Appartament block", 50);
		House h6 = new House(6, 36, 92, 9, 4, "Bogdanovich", "Appartament block", 50);
		House h7 = new House(7, 88, 55, 3, 3, "Neckrasov", "Appartament block", 70);
		House h8 = new House(8, 114, 72, 4, 2, "Gamarnic", "Appartament block", 50);

		HouseArray myHouses = h.new HouseArray();

		myHouses.addHouse(h1);
		myHouses.addHouse(h2);
		myHouses.addHouse(h3);
		myHouses.addHouse(h4);
		myHouses.addHouse(h5);
		myHouses.addHouse(h6);
		myHouses.addHouse(h7);
		myHouses.addHouse(h8);

		myHouses.showHouses();

		// Output:
		// a) a list of apartments with a given number of rooms:
		HouseArray samerooms = myHouses.getFlatSameRooms(3);
		samerooms.showHouses();

		// b) a list of apartments with a predetermined number of rooms and
		// locate:
		HouseArray sameroomsFloor = myHouses.getFlatSameRoomsFloor(2, 2, 5);
		sameroomsFloor.showHouses();

		// c) the list of apartments with an area exceeding the specified:
		HouseArray squareMore = myHouses.getFlatUpSquare(50);
		squareMore.showHouses();
	}

}
