public class Theater {

    // 여기에 코드를 작성하세요.
    private Seat[][] seats;
    private Seat name ;
    Seat seat = new Seat();

    private int rowCount, colCount;

    public Theater(int rowCount, int colCount){
        this.rowCount = rowCount;
        this.colCount = colCount;
        seats = new Seat[this.rowCount][this.colCount];

        for(int i = 0; i < rowCount; i++){
            for (int j = 0; j < colCount; j++){
                seats[i][j] = name;
            }
        }
    }


    public void printSeatMatrix() {
        System.out.print("  ");
        // 열의 숫자 표현
        for (int i = 1; i <= 9; i++) {
            System.out.print("  " + i);
        }
        System.out.println();
        // [] 만들기
        for (int i = 0; i < rowCount; i++) {
            // 행은 알파벳으로 구분함
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < colCount; j++) {
                Seat s = seats[i][j];
                if (s.isOccupied()) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }
}