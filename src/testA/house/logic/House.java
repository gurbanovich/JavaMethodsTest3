package testA.house.logic;

/**
 * Create classes whose specifications are listed below. Determine the structs
 * and methods setType (), getType (), toString (). Define additionally methods
 * in the class that creates the array of objects. Set data selection criteria
 * and output this data to the console. In each class that has information,
 * several designers must be declared. 
 * 1. House: id, Room number, Area, Floor, Number of rooms, Street, Building type, 
 * Lifetime. Create an array of objects.
 * Output: 
 * a) a list of apartments with a given number of rooms; 
 * b) a list of apartments with a predetermined number of rooms and located 
 * on the floor, which is in the given interval; 
 * c) the list of apartments with an area exceeding the specified.
 */

public class House {

	private int id;
	private int flatNumber;
	private double flatSquare;
	private int floor;
	private int rooms;
	private String street;
	private String buildingType;
	private int lifetime;

	public House() {
	}

	public House(int id, int floor, String street) {
		this.id = id;
		this.floor = floor;
		this.street = street;
		this.buildingType = "General";
		this.lifetime = 100;
	}

	public House(int id, int flatNumber, double flatSquare, int floor, int rooms, String street, String buildingType,
			int lifetime) {
		this.id = id;
		this.flatNumber = flatNumber;
		this.flatSquare = flatSquare;
		this.floor = floor;
		this.rooms = rooms;
		this.street = street;
		this.buildingType = buildingType;
		this.lifetime = lifetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public double getFlatSquare() {
		return flatSquare;
	}

	public void setFlatSquare(double flatSquare) {
		this.flatSquare = flatSquare;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public int getLifetime() {
		return lifetime;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}

	public String toString() {
		return "House id: " + id + "\nflat number: " + flatNumber + "\nsquare: = " + flatSquare + "\nfloor: " + floor
				+ "\nrooms: " + rooms + " \nstr, " + street + " \ntype: " + buildingType + " \nlifetime: " + lifetime
				+ " years ";
	}

	public class HouseArray {

		private int size;
		private House[] houses;

		public HouseArray() {
			this.size = 0;
			this.houses = new House[size];
		}

		public HouseArray(int size) {
			this.size = size;
			this.houses = new House[size];
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public House[] getHouses() {
			return houses;
		}

		public void addHouse(House h) {
			int index = houses.length;
			if (getSize() == houses.length)
				growArray();
			houses[index] = h;
			setSize(getSize() + 1);
		}

		private void growArray() {
			House[] newArray = new House[houses.length + 1];
			System.arraycopy(houses, 0, newArray, 0, size);
			houses = newArray;
		}

		public HouseArray getFlatSameRooms(int rooms) {
			HouseArray hr = new HouseArray();
			System.out.println("Flats have " + rooms + " rooms");
			for (House h : getHouses()) {
				if (h.getRooms() == rooms) {
					hr.addHouse(h);
				}
			}
			return hr;
		}

		public HouseArray getFlatSameRoomsFloor(int rooms, int floorFrom, int floorTo) {
			HouseArray hr = new HouseArray();
			System.out.println(
					"Flats have " + rooms + " rooms and situated from " + floorFrom + " to " + floorTo + " floor");
			for (House h : getHouses()) {
				if (h.getRooms() == rooms && h.getFloor() >= floorFrom && h.getFloor() <= floorTo) {
					hr.addHouse(h);
				}
			}
			return hr;
		}

		public HouseArray getFlatUpSquare(double minSquare) {
			HouseArray hr = new HouseArray();
			System.out.println("Flats have square more then " + minSquare + " square metres");
			for (House h : getHouses()) {
				if (h.getFlatSquare() > minSquare)
					hr.addHouse(h);
			}
			return hr;
		}

		public void showHouses() {
			for (House h : getHouses()) {
				if (h != null)
					System.out.println(h.toString());
				System.out.println();
			}

		}
	}

}
