package contests.contests2021.lc0807biweekly.mediumone;

import java.util.ArrayList;

class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {


        char oppositeColor = (color == 'W') ? 'B' : 'W';
        char sameColor = color;


        // Up Line
        ArrayList<Character> directlyAboveChars = new ArrayList<>();

        for (int vertCoordinate = rMove - 1; vertCoordinate >= 0; vertCoordinate--) {
            char nextChar = board[vertCoordinate][cMove];

            if (nextChar == '.') {
//                System.out.println("breaking on empty");
                break;
            } else if (nextChar == sameColor) {
//                System.out.println("breaking same color");
                directlyAboveChars.add(nextChar);
                break;
            } else {
                directlyAboveChars.add(nextChar);
            }
        }

//        System.out.println("place");



        // Down Line
        ArrayList<Character> directlyDownChars = new ArrayList<>();

        for (int vertCoordinate = rMove + 1; vertCoordinate < board.length; vertCoordinate++) {
            char nextChar = board[vertCoordinate][cMove];

            if (nextChar == '.') {
//                System.out.println("breaking on empty");
                break;
            } else if (nextChar == sameColor) {
//                System.out.println("breaking same color");
                directlyDownChars.add(nextChar);
                break;
            } else {
                directlyDownChars.add(nextChar);
            }
        }

//        System.out.println("placeholder");
        // Right Line
        ArrayList<Character> directlyRightChars = new ArrayList<>();

        for (int horizontalCoordinate = cMove + 1; horizontalCoordinate < board[0].length; horizontalCoordinate++) {
            char nextChar = board[rMove][horizontalCoordinate];

            if (nextChar == '.') {
//                System.out.println("breaking on empty");
                break;
            } else if (nextChar == sameColor) {
//                System.out.println("breaking same color");
                directlyRightChars.add(nextChar);
                break;
            } else {
                directlyRightChars.add(nextChar);
            }
        }

//        System.out.println("placehol;der");
        // Left Line
        ArrayList<Character> directlyLeftChars = new ArrayList<>();

        for (int horizontalCoordinate = cMove - 1; horizontalCoordinate >= 0; horizontalCoordinate--) {
            char nextChar = board[rMove][horizontalCoordinate];

            if (nextChar == '.') {
//                System.out.println("breaking on empty");
                break;
            } else if (nextChar == sameColor) {
//                System.out.println("breaking same color");
                directlyLeftChars.add(nextChar);
                break;
            } else {
                directlyLeftChars.add(nextChar);
            }
        }
//        System.out.println("placehol;der");


        // diag -upLeft
        ArrayList<Character> directlyDiagUpLeftChars = new ArrayList<>();

        int vertCoord = rMove - 1;
        int horiCoord = cMove - 1;
        for (horiCoord = cMove -1,vertCoord = rMove - 1; horiCoord >= 0 && vertCoord >= 0; vertCoord--,horiCoord--) {
            char nextChar = board[vertCoord][horiCoord];

            if (nextChar == '.') {
//                System.out.println("breaking on empty");
                break;
            } else if (nextChar == sameColor) {
//                System.out.println("breaking same color");
                directlyDiagUpLeftChars.add(nextChar);
                break;
            } else {
                directlyDiagUpLeftChars.add(nextChar);
            }
        }
//        System.out.println("placehol;der");

        // diag -upRight
        ArrayList<Character> directlyDiagUpRightChars = new ArrayList<>();

        for (horiCoord = cMove + 1,vertCoord = rMove - 1; horiCoord >= 0 && vertCoord >= 0; vertCoord--,horiCoord--) {
            char nextChar = board[vertCoord][horiCoord];

            if (nextChar == '.') {
//                System.out.println("breaking on empty");
                break;
            } else if (nextChar == sameColor) {
//                System.out.println("breaking same color");
                directlyDiagUpRightChars.add(nextChar);
                break;
            } else {
                directlyDiagUpRightChars.add(nextChar);
            }
        }
//        System.out.println("placehol;der");

        // diag - downright
        ArrayList<Character> directlyDiagDownRightChars = new ArrayList<>();

        vertCoord = rMove;
        horiCoord = cMove;
        for (horiCoord = cMove + 1, vertCoord = rMove + 1; horiCoord < board[0].length && vertCoord < board.length; vertCoord++,horiCoord++) {
            char nextChar = board[vertCoord][horiCoord];

            if (nextChar == '.') {
//                System.out.println("breaking on empty");
                break;
            } else if (nextChar == sameColor) {
//                System.out.println("breaking same color");
                directlyDiagDownRightChars.add(nextChar);
                break;
            } else {
                directlyDiagDownRightChars.add(nextChar);
            }
        }
//        System.out.println("placehol;der");

        // diag - downright
        ArrayList<Character> directlyDiagDownLeftChars = new ArrayList<>();

        for (horiCoord = cMove - 1, vertCoord = rMove + 1; horiCoord >= 0 && vertCoord < board.length; vertCoord++,horiCoord++) {
            char nextChar = board[vertCoord][horiCoord];

            if (nextChar == '.') {
//                System.out.println("breaking on empty");
                break;
            } else if (nextChar == sameColor) {
//                System.out.println("breaking same color");
                directlyDiagDownLeftChars.add(nextChar);
                break;
            } else {
                directlyDiagDownLeftChars.add(nextChar);
            }
        }
//        System.out.println("placehol;der");

//        boolean colorTest = isGoodLine(new ArrayList<Character>(Arrays.asList('B','W','W')),'W','B');
//        boolean colorTest2 = isGoodLine(new ArrayList<Character>(Arrays.asList('B','W','W')),'B','W');
//        boolean colorTest3 = isGoodLine(new ArrayList<Character>(Arrays.asList('W','B','B')),'W','B');
//        boolean colorTest4 = isGoodLine(new ArrayList<Character>(Arrays.asList('W','B','B')),'B','W');
//        boolean colorTest5 = isGoodLine(new ArrayList<Character>(Arrays.asList('B','W','W')),'W','B');



        boolean leftBool = isGoodLine(directlyLeftChars, oppositeColor, sameColor);
        boolean rightBool = isGoodLine(directlyRightChars, oppositeColor, sameColor);
        boolean downBool = isGoodLine(directlyDownChars, oppositeColor, sameColor);
        boolean upBool = isGoodLine(directlyAboveChars, oppositeColor, sameColor);
        boolean diagDownLeftBool = isGoodLine(directlyDiagDownLeftChars, oppositeColor, sameColor);
        boolean diagDownRightBool  = isGoodLine(directlyDiagDownRightChars, oppositeColor, sameColor);
        boolean diagUpRightBool = isGoodLine(directlyDiagUpRightChars, oppositeColor, sameColor);
        boolean diagUpLeftBool = isGoodLine(directlyDiagUpLeftChars, oppositeColor, sameColor);


        System.out.println("leftBool equals " + leftBool);
        System.out.println("rightBool equals " + rightBool);
        System.out.println("downBool equals " + downBool);
        System.out.println("upBool equals " + upBool);
        System.out.println("diagDownLeftBool equals " + diagDownLeftBool);
        System.out.println("diagDownRightBool equals " + diagDownRightBool);
        System.out.println("diagUpRightBool equals " + diagUpRightBool);
        System.out.println("diagUpLeftBool equals " + diagUpLeftBool);

        boolean ansBool = leftBool || rightBool || downBool || upBool || diagDownLeftBool || diagDownRightBool || diagUpRightBool || diagUpLeftBool;
        System.out.println("final ans " + ansBool);

        return ansBool;

    }

    public boolean isGoodLine(ArrayList<Character> line, char oppositeColor, char sameColor) {
        if (line.size() < 2) {
//            System.out.println("not big enough");
            return false;
        }

        ArrayList<Character> trimmedArr = new ArrayList<>();
        for (int i =0; i < line.size(); i++) {
            char nextColor = line.get(i);

            if (nextColor == oppositeColor) {
                trimmedArr.add(nextColor);
            } else if (nextColor == '.') {
                break;
            } else if (nextColor == sameColor) {
                trimmedArr.add(nextColor);
                break;
            }
        }

//        System.out.println("trimmed");

        trimmedArr.add(0, sameColor);

//        System.out.println("trimmed");

        if (trimmedArr.size() < 3) {
//            System.out.println("trimmed array not big enough");
            return false;
        } else {
            if (trimmedArr.get(0) != sameColor) {
//                System.out.println("color wrong at end of trimmed");
            } else if (trimmedArr.get(trimmedArr.size() - 1) != sameColor) {
//                System.out.println("color wrong and same side???");
                return false;
            } else {
                for (int j = 1; j < trimmedArr.size() - 2; j++) {
                    char nextTrimColor = trimmedArr.get(j);
                    if (nextTrimColor != oppositeColor) {
//                        System.out.println("middle not homogeneous");
                        return false;
                    }
                }
            }
        }

//        System.out.println("good line, made it through!");
        return true;
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] firstBoard = {{'.','.','.','B','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'W','B','B','.','W','W','W','B'},{'.','.','.','B','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','W','.','.','.','.'}};
        char[][] secondBoard = {{'.','.','.','.','.','.','.','.'},{'.','B','.','.','W','.','.','.'},{'.','.','W','.','.','.','.','.'},{'.','.','.','W','B','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','B','W','.','.'},{'.','.','.','.','.','.','W','.'},{'.','.','.','.','.','.','.','B'}};

//        sol.checkMove(firstBoard, 4,3,'B');
//        sol.checkMove(secondBoard, 4,4,'W');
//        sol.checkMove(secondBoard, 4,4,'B');  //GREAT TEST FOR DIAG


        char[][] thirdBoard= {{'.','.','.','.','W','B','B','B'},{'.','.','.','.','.','.','.','B'},{'W','.','.','W','.','.','W','.'},{'B','.','B','B','B','.','.','W'},{'W','.','.','B','W','B','B','.'},{'W','B','.','.','W','B','B','.'},{'.','W','B','B','W','B','.','W'},{'B','.','W','B','W','.','W','.'}};
        sol.checkMove(thirdBoard,0,0,'B'); //Expected True
    }
}