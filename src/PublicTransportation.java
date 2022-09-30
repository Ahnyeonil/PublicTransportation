public class PublicTransportation {

    // 번호
    private int number;
    // 주유량
    private int amountOfFuel = 100;
    // 속도
    private  int speed = 0;
    // 최대 승객 수
    private int maximumPassenger;

    public PublicTransportation(int number, int amountOfFuel, int speed, int maximumPassenger) {
        this.number = number;
        this.amountOfFuel = amountOfFuel;
        this.speed = speed;
        this.maximumPassenger = maximumPassenger;
    }

    // 운행
    public int startService(){
        return 0;
    }

    // 속도 변경
    public void changeSpeed(){

    }

    public void confirmNumber(int num, String kind){
        System.out.println(num + "번 " + kind);
    }
    // 상태 변경
    public void changeCondition(int num, String kind, int condition){
        if(kind.equals("버스")) {
            if (condition == 1) {
                System.out.println("상태 : " + num + kind + " 운행중");
            } else {
                System.out.println(num + kind + " 차고지 행");
            }
        } else {
            if (condition == 0) {
                System.out.println("상태 : " + num + kind + " 운행중");
            } else if(condition == 1) {
                System.out.println(num + kind + " 일반");
            }
            else {
                System.out.println("상태 : 운행불가");
            }
        }
    }

    public void changeAmountOfFuel(){
        System.out.println("주유량 : " + amountOfFuel);
        if (amountOfFuel < 10) {
            System.out.println("주유 필요");
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAmountOfFuel() {
        return amountOfFuel;
    }

    public void setAmountOfFuel(int amountOfFuel) {
        this.amountOfFuel = amountOfFuel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaximumPassenger() {
        return maximumPassenger;
    }

    public void setMaximumPassenger(int maximumPassenger) {
        this.maximumPassenger = maximumPassenger;
    }
}
