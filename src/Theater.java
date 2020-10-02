public class Theater {
    private Seat[][] seats;

    private int rowCount, colCount;
    private int seat_row;

    public Theater(int rowCount, int colCount) {
        if (rowCount > 26) {
            rowCount = 26; // number of alphabets
        }
        seats = new Seat[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                seats[i][j] = new Seat();
            }
        }

        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    public boolean reserve(String name, char rowChar, int col, int numSeat) {
        // 여기에 코드를 작성하세요
        // rowChar는 알파벳이므로 이를 숫자로 변환(예 : A = 0)
        for (int i = 0; i < rowCount; i++){
            if(rowChar == 'A'+i){
                // seat_row는 이제 알파벳 대신 숫자로 표현된다(예 : A = 0)
                seat_row = i;
            }
        }

        // 예약전 해당 자리에 예약이 되있는지 확인 - ok
        for (int i = 0; i < numSeat; i++){
//            System.out.println(seats[seat_row][col].getName());
//            System.out.println(seats[seat_row][col].isOccupied());
            // isOccupied 참 : 사람 있음 / isOccupied 거짓 : 사람 없음
            if((seats[seat_row][col].isOccupied())){
                return false;
            }
        }

        // col+numset이 전체 column을 넘는지 확인 - ok
        if(colCount < col + numSeat - 1){
            return false;
        }

        // 자리 예약
            // 한번에 에약하려는 자리수가 1이상일 강우
        if(numSeat >= 1 ){
            for (int j = 0; j < numSeat; j++){
                seats[seat_row][col +j-1].reserve(name);
            }
            return true;
            }
        // 밑에 이거 안써주면 에러 발생함...
        return true;
    }

    public int cancel(String name) {
        int counter = 0;
        // 여기에 코드를 작성하세요
        // 모든 좌석의 이름을 name과 비교
        for (int i = 0; i < rowCount; i++){
            for (int j= 0; j < colCount; j++){
                // 해당 시트의 이름이 비어있을경우 무시하고 진행
                if (seats[i][j].getName() == null){
                    continue;
                }
                // 해당 이름(name)과 같은 자리라면 캔슬
                if (seats[i][j].match(name)){
                    seats[i][j].cancel();
                    counter++;
                }
            }
        }
        return counter;
    }

    public int cancel(char rowChar, int col, int numSeat) {
        int counter = 0;
        // rowChar는 알파벳이므로 이를 숫자로 변환(예 : A = 0)
        for (int i = 0; i < rowCount; i++){
            if(rowChar == 'A'+i){
                // seat_row는 이제 알파벳 대신 숫자로 표현된다(예 : A = 0)
                seat_row = i;
            }
        }
        // 해당 자리를 모두 캔슬
        for (int j = 0; j < numSeat; j++){
            if (seats[seat_row][col + j -1].isOccupied()){
                seats[seat_row][col + j -1].cancel();
//                System.out.print(seat_row);
//                System.out.println(col + j -1);
                counter++;
            }
        }
        return counter;
    }


    public int getNumberOfReservedSeat() {
        // 여기에 코드를 작성하세요
        int counter = 0;
        for (int i = 0; i < rowCount; i++){
            for(int j =0; j < colCount; j++){
                if (seats[i][j].isOccupied()){
                    counter++;
                }
            }
        }
        return counter;
    }

    public void printSeatMatrix() {
        System.out.print("  ");
        for (int i = 1; i <= 9; i++) {
            System.out.print("  " + i);
        }
        System.out.println();

        for (int i = 0; i < rowCount; i++) {
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < colCount; j++) {
                Seat s = seats[i][j];
                if (s.isOccupied()) {
                    System.out.print("[O]");
//                    System.out.println(i);
//                    System.out.println(j);
//                    System.out.println(seats[i][j].getName());
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    private int getRowIndex(char uppercaseChar) {
        return uppercaseChar - 'A';
    }
}