public class Main {

    public static void main(String[] args) {
        Bus bus1 = new Bus(51, 100, 0, 30);
        Bus bus2 = new Bus(17, 100, 0, 30);

        bus1.boardingPassengers(2);
        bus1.changeAmountOfFuel(-50);
        bus1.changeCondition();
        bus1.changeAmountOfFuel(10);
        bus1.boardingPassengers(45);
        bus1.boardingPassengers(5);
        bus1.changeAmountOfFuel(-55);

        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();

        Taxi taxi1 = new Taxi(4885, 100, 0, 4);
        Taxi taxi2 = new Taxi(5270, 100, 0, 4);

        taxi1.boardingPassengers(2, "서울역", 2);
        taxi1.changeAmountOfFuel(-80);
        taxi1.paymentOfChange(2);
        taxi1.boardingPassengers(5);
        taxi1.boardingPassengers(3, "구로디지털단지역", 12);
        taxi1.paymentOfChange(12);
        taxi1.changeAmountOfFuel(-20);
    }
}
