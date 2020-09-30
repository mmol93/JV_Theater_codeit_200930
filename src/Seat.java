public class Seat {
    private String name;

    public Seat(){
    }

    public String getName(){
        // 예약자 이름 반환
        return name;
    }

    public void reserve(String name){

    }

    public void cancel(){
        // 예약자 이름 취소
    }

    public boolean isOccupied(){
        // 이미 예약된 자리인지 확인
        return false;
    }

//    public boolean match(String checkName){
//        // checkName으로 예약된 자리인지 확인하고 불린값 반환
//
//    }
}
