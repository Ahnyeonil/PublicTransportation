// 요구 사항
// 버스 번호
//      버스 객체 생성시 번호는 고유값으로 생성되어야 합니다.
// 버스 상태 변경
//      버스 객체 생성시 최소 상태는 '운행' 상태가 되며
//      주유량이 떨어지거나, 운행을 종료할 때 '차고지' 상태로 변경 합니다.
// 승객 탑승
//      승객 탑승은 '최대 승객수' 이하까지 가능하며 '운행 중'인 상태의 버스만 가능합니다.
//      탑승시 현재 승객수가 증가되어야 합니다.
// 속도 변경
//      주유 상태를 체크하고 주유량이 10이상이어야 운행할 수 있습니다.
//          경고메시지 System.out.println("주유량을 확인해 주세요.");
public class Bus extends PublicTransportation{

    // 현재 승객수
    int currentPassenger = 0;
    // 요금
    int charge = 1000;
    // 상태 (0 : 차고지 행, 1 : 운행)
    int condition = 0;
    // 현재 속도
    int currentSpeed = 0;

    public Bus(int number, int amountOfFuel, int speed, int maximumPassenger) {
        super(number, amountOfFuel, speed, maximumPassenger);
        confirmNumber(number);
    }

    public void confirmNumber(int num){
        super.confirmNumber(num, " 번 버스");
    }

    // 버스 상태 변경
    public void changeCondition(){
        if(condition == 0) {
            currentPassenger = 0;
            super.changeCondition(getNumber(), "버스", condition);
            condition = 1;
        }
        else {
            super.changeCondition(getNumber(), "버스", condition);
            condition = 0;
        }
    }

    // 승객 탑승
    public void boardingPassengers(int passenger){
        if (currentPassenger + passenger > getMaximumPassenger()) {
            System.out.println("최대 승객 수 초과");
        } else {
            currentPassenger += passenger;
            System.out.println("탑승 승객 수 : " + currentPassenger);
            System.out.println("잔여 승객 수 : " + (getMaximumPassenger() - currentPassenger));
            System.out.println("요금 확인 : " + (passenger * charge));
        }
    }

    // 속도 변경
    public void changeSpeed(){

    }

    public void changeAmountOfFuel(int fuel){
        setAmountOfFuel(getAmountOfFuel() + fuel);

        if(getAmountOfFuel() < 10){
            super.changeCondition(getNumber(), "버스", 0);
        }
        super.changeAmountOfFuel();
    }
}
