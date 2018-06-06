package testA.trains.run;

import testA.trains.logic.Train;
import testA.trains.logic.Train.TrainArray;

/**
 * Demo class Train
 **/

public class RunTrain {

	public static void main(String[] args) {

		Train t = new Train();
		Train t1 = new Train("Baranovichi", 221, "12:31", 321);
		Train t2 = new Train("Minsk", 222, "11:26", 225, 125, 60, 120);
		Train t3 = new Train("Mogilev", 223, "05:01", 120, 60, 150, 100);
		Train t4 = new Train("Brest", 224, "18:12", 350);
		Train t5 = new Train("Minsk", 225, "20:22", 200, 140, 150, 60);
		Train t6 = new Train("Grodno", 226, "07:08", 125, 60, 230, 60);
		Train t7 = new Train("Grodno", 227, "01:51", 50, 150, 150, 100);
		Train t8 = new Train("Minsk", 228, "13:12", 340);

		TrainArray myTrains = t.new TrainArray();

		myTrains.addTrain(t1);
		myTrains.addTrain(t2);
		myTrains.addTrain(t3);
		myTrains.addTrain(t4);
		myTrains.addTrain(t5);
		myTrains.addTrain(t6);
		myTrains.addTrain(t7);
		myTrains.addTrain(t8);

		myTrains.showTrains();

		// Output:
		// a) a list of trains to the specified destination:
		TrainArray tDest = myTrains.getTrainsSameDestination("Grodno");
		tDest.showTrains();

		// b) A list of trains to the specified destination and departure after
		// a given hour:
		TrainArray tDestTime = myTrains.getTrainsSameDestinationTime("Minsk", "16:00");
		tDestTime.showTrains();

		// c) a list of trains departing to the specified destination
		// and having common places:
		TrainArray tDestSeat = myTrains.getTrainsSameDestinationGenSeat("Minsk", 1);
		tDestSeat.showTrains();
	}

}
