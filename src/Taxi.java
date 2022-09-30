// 요구 사항
// 운행 시작
//      운행 시작전 주유상태를 체크 하고 주유량이 10 이상이어야 운행 가능
// 승객 탑승
//      승객 탑승은 택시 상태가 '일반'일 때만 가능합니다.
//      그 외 택시는 '탁습 불가' 처리를 해주세요.
//      '일반' 상태의 택시가 승객을 태우면 '운행 중' 상태로 변경해 주세요.
//  속도 변경
//      변경할 속도를 입력 받아 현재 속도에 추가 하거나 뺄 수 있어야 합니다.
//  거리당 요금 추가
//      기본 거리보다 먼 곳은 추가 요금이 붙습니다.
//      기본 거리와 추가 요금은 자유롭게 산정해 주세요.
//  요금 결제
//      최종 요금을 출력하는 것으로 합니다.

public class Taxi extends PublicTransportation{

    // 현재 승객수
    int currentPassenger = 0;
    // 현재 속도
    int currentSpeed = 0;
    // 목적지
    int destination;
    // 기본거리
    int basicDistance = 1;
    // 목적기까지 거리
    int destinationDistancec;
    // 기본 요금
    int basicCharge = 3000;
    // 거리당 요금
    int distanceCharge = 1000;
    // 상태 (0 : 운행 중, 1 : 일반, 2 : 운행 불가)
    int condition = 1;

    // 누적 요금
    int totalCharge = 0;

    public Taxi(int number, int amountOfFuel, int speed, int maximumPassenger) {
        super(number, amountOfFuel, speed, maximumPassenger);
        confirmNumber(number);
    }

    public void confirmNumber(int num){
        super.confirmNumber(num, "택시");
        super.changeAmountOfFuel();
        if(condition == 0) {
            super.changeCondition(num, "택시", condition);
            condition = 1;
        } else if(condition == 1){
            super.changeCondition(num, "택시", condition);
            condition = 0;
        }
    }

    // 운행 시작
    public void busCondition(int speed){
        currentSpeed += speed;
    }

    public void boardingPassengers(int passenger){
        currentPassenger = 0;
        System.out.println("최대 승객 수 초과");
    }
    // 승객 탑승
    public void boardingPassengers(int passenger, String destination, int distance){
        currentPassenger += passenger;
        System.out.println("탑승 승객 수 : " + currentPassenger);
        System.out.println("잔여 승객 수 : " + (getMaximumPassenger() - currentPassenger));
        /*super.boardingPassengers(currentPassenger);*/
        System.out.println("기본 요금 확인 : " + basicCharge);
        System.out.println("목적지 : " + destination);
        System.out.println("목적지까지의 거리 : " + distance);
        System.out.println("지불할 요금 : " + additionalChargePerDistance(distance));
        paymentOfChage(distance);
        condition = 0;
        super.changeCondition(getNumber(), "택시", condition);
    }

    // 속도 변경
    public void changeSpeed(){
        System.out.println("속도 변경");
    }

    // 거리당 요금 추가
    public int additionalChargePerDistance(int distance) {
        return (basicCharge + (distance - basicDistance) * distanceCharge);
    }

    // 요금 결제
    public void paymentOfChage(int distance){
        condition = 1;
        totalCharge += basicCharge + (distance - basicDistance) * distanceCharge;
    }

    public void changeAmountOfFuel(int fuel){
        setAmountOfFuel(getAmountOfFuel() + fuel);

        super.changeAmountOfFuel();

        if(getAmountOfFuel() < 10){
            condition = 2;
            super.changeCondition(getNumber(), "택시", condition);
        }
        System.out.println("누적 요금 : " + totalCharge);
    }
}
