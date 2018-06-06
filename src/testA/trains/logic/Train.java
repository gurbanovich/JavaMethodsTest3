package testA.trains.logic;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Create classes whose specifications are listed below. Determine the structs
 * and methods setType (), getType (), toString (). Define additionally methods
 * in the class that creates the array of objects. Set data selection criteria
 * and output this data to the console. In each class that has information,
 * several designers must be declared. 
 * 2. Train: Destination, Train number,
 * Departure time, No. of seats (common, coupe, reserved seat, suite). Create an
 * array of objects. 
 * Output: 
 * a) a list of trains to the specified destination;
 * b) A list of trains to the specified destination and departure after a given
 * hour; 
 * c) a list of trains departing to the specified destination and having
 * common places.
 **/

public class Train {

	private String dest;
	private int trainNumber;
	private String arriveTime;
	private int genSeat;
	private int coupeSeat;
	private int resSeat;
	private int luxSeat;

	public Train() {
	}

	public Train(String dest, int trainNumber, String arriveTime, int genSeat) {
		this.dest = dest;
		this.trainNumber = trainNumber;
		this.arriveTime = arriveTime;
		this.genSeat = genSeat;
	}

	public Train(String dest, int trainNumber, String arriveTime, int genSeat, int coupeSeat, int resSeat,
			int luxSeat) {
		this.dest = dest;
		this.trainNumber = trainNumber;
		this.arriveTime = arriveTime;
		this.genSeat = genSeat;
		this.coupeSeat = coupeSeat;
		this.resSeat = resSeat;
		this.luxSeat = luxSeat;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public int getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public int getGenSeat() {
		return genSeat;
	}

	public void setGenSeat(int genSeat) {
		this.genSeat = genSeat;
	}

	public int getCoupeSeat() {
		return coupeSeat;
	}

	public void setCoupeSeat(int coupeSeat) {
		this.coupeSeat = coupeSeat;
	}

	public int getResSeat() {
		return resSeat;
	}

	public void setResSeat(int resSeat) {
		this.resSeat = resSeat;
	}

	public int getLuxSeat() {
		return luxSeat;
	}

	public void setLuxSeat(int luxSeat) {
		this.luxSeat = luxSeat;
	}

	public String toString() {
		return "Train to: " + dest + "\nnumber: " + trainNumber + "\narrival time " + arriveTime + "\ngeneral seats"
				+ genSeat + "\ncoupe seats " + coupeSeat + "\nreserved seats  " + resSeat + "\nluxary seats " + luxSeat;
	}

	public class TrainArray {

		private int size;
		private Train[] trains;

		public TrainArray() {
			this.size = 0;
			this.trains = new Train[size];
		}

		public TrainArray(int size) {
			this.size = size;
			this.trains = new Train[size];
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public Train[] getTrains() {
			return trains;
		}

		public void addTrain(Train t) {
			int index = trains.length;
			if (getSize() == trains.length)
				growArray();
			trains[index] = t;
			setSize(getSize() + 1);
		}

		private void growArray() {
			Train[] newArray = new Train[trains.length + 1];
			System.arraycopy(trains, 0, newArray, 0, size);
			trains = newArray;
		}

		public TrainArray getTrainsSameDestination(String dest) {
			TrainArray trd = new TrainArray();
			System.out.println("Trains destination " + dest);
			for (Train t : getTrains()) {
				if (t.getDest().equals(dest))
					trd.addTrain(t);
			}
			return trd;
		}

		public TrainArray getTrainsSameDestinationTime(String dest, String time) {
			TrainArray trd = new TrainArray();
			LocalTime tb = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
			System.out.println("Trains destination " + dest + " arrive after " + time);
			for (Train t : getTrains()) {
				LocalTime ta = LocalTime.parse(t.getArriveTime(), DateTimeFormatter.ofPattern("HH:mm"));
				if (t.getDest().equals(dest) && (ta.isAfter(tb)))
					trd.addTrain(t);
			}
			return trd;
		}

		public TrainArray getTrainsSameDestinationGenSeat(String dest, int seats) {
			TrainArray trd = new TrainArray();
			System.out.println("Trains destination " + dest + " adn have general seats");
			for (Train t : getTrains()) {
				if (t.getDest().equals(dest) && t.getGenSeat() >= 1)
					trd.addTrain(t);
			}
			return trd;
		}

		public void showTrains() {
			for (Train t : getTrains()) {
				System.out.println(t.toString());
				System.out.println();
			}
		}

	}

}
