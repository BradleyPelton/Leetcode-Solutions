package contests.contests2021.lc1113biweekly.mediumone;

// First attempt time limit exceeded. Single steps was too slow

class Robot {

    int[] currPos;
    int[][] grid;

    String currDirection;

    int totalPerimeter;


    public Robot(int width, int height) {
        currPos = new int[]{0,0};
        grid = new int[height][width];
        currDirection = "East";
        totalPerimeter = 2*(grid[0].length) + 2*(grid.length) - 4;

    }

    public void move(int num) {

        int numberOfStepsLeft = num;
        while (numberOfStepsLeft > 0) {
            if (currDirection.equals("East")) {
                if (currPos[0] + numberOfStepsLeft > grid[0].length - 1) {
                    int possibleSteps = grid[0].length - 1 - currPos[0];
                    currPos[0] += possibleSteps;
                    changeDir();
                    numberOfStepsLeft -= possibleSteps;
                    numberOfStepsLeft = trimLoops(numberOfStepsLeft);
                    continue;
                } else {
                    currPos[0] += numberOfStepsLeft;
                    break;
                }
            }
            else if (currDirection.equals("North")) {
                if (currPos[1] + numberOfStepsLeft > grid.length - 1) {
                    int possibleSteps = grid.length - 1 - currPos[1];
                    currPos[1] += possibleSteps;
                    changeDir();
                    numberOfStepsLeft -= possibleSteps;
                    numberOfStepsLeft = trimLoops(numberOfStepsLeft);
                    continue;
                } else {
                    currPos[1] += numberOfStepsLeft;
                    break;
                }
            }
            else if (currDirection.equals("West")) {
                if (currPos[0] - numberOfStepsLeft < 0) {
                    int possibleSteps =  currPos[0];
                    currPos[0] = 0;
                    changeDir();
                    numberOfStepsLeft -= possibleSteps;
                    numberOfStepsLeft = trimLoops(numberOfStepsLeft);
                    continue;
                } else {
                    currPos[0] -= numberOfStepsLeft;
                    break;
                }
            }
            else if (currDirection.equals("South")) {
                if (currPos[1] - numberOfStepsLeft < 0) {
                    int possibleSteps = currPos[1];
                    currPos[1] = 0;
                    changeDir();
                    numberOfStepsLeft -= possibleSteps;
                    numberOfStepsLeft = trimLoops(numberOfStepsLeft);
                    continue;
                } else {
                    currPos[1] -= numberOfStepsLeft;
                    break;
                }
            }

            numberOfStepsLeft--;
//            System.out.println("curr pos = " + Arrays.toString(currPos));

        }

    }

    public int[] getPos() {
        return currPos;
    }

    public String getDir() {
        return currDirection;
    }

    private void changeDir() {
        if (currDirection.equals("East")) {
            currDirection = "North";
        }
        else if (currDirection.equals("North")) {
            currDirection = "West";
        }
        else if (currDirection.equals("West")) {
            currDirection = "South";
        }
        else if (currDirection.equals("South")) {
            currDirection = "East";
        }
    }

    private int trimLoops(int numMovesLeft) {
        if (numMovesLeft > totalPerimeter) {
//            System.out.println("VALUE BEFORE TRIM = " + numMovesLeft);
//            System.out.println("TRIMMING");
//            System.out.println("VALUE AFTER TRIM = " + numMovesLeft % totalPerimeter);
            if ((currPos[0] == 0 && currPos[1] == 0)
                    ||(currPos[0] == 0 && currPos[1] == grid.length - 1)
                    ||(currPos[0] == grid[0].length - 1 && currPos[1] == 0)
                    ||(currPos[0] == grid[0].length - 1 && currPos[1] == grid.length - 1)) {
                changeDir();
                changeDir();
                changeDir();
            }
            return (numMovesLeft % totalPerimeter);
        } else {
            return numMovesLeft;
        }
    }
}

class Tests {
    public static void main(String[] args) {
//        ["Robot", "move", "move", "getPos", "getDir", "move", "move", "move", "getPos", "getDir"]
//        [[6, 3], [2], [2], [], [], [2], [1], [4], [], []]

//        Robot robot = new Robot(6, 3);
//        robot.move(2);
//        robot.move(2);
//        System.out.println(Arrays.toString(robot.getPos()));
//        System.out.println(robot.getDir());
//        robot.move(2);
//        robot.move(1);
//        robot.move(4);
//        System.out.println(Arrays.toString(robot.getPos()));
//        System.out.println(robot.getDir());

//        ["Robot","move","move","move","getPos","getDir","move","getPos","getDir","move","move","move","getPos","getDir","move","move","move","getPos","getDir","move","move","move","move","move","getPos","getDir","move","move","move","move","move","getPos","getDir","move","move","getPos","getDir","move","move","getPos","getDir","move","move","getPos","getDir","move","move"]
//        [[20,14],[32],[18],[18],[],[],[18],[],[],[45],[37],[39],[],[],[8],[11],[18],[],[],[3],[39],[7],[31],[42],[],[],[35],[11],[36],[29],[10],[],[],[49],[31],[],[],[31],[47],[],[],[29],[1],[],[],[5],[44]]

//        Robot robot = new Robot(20, 14);
//        robot.move(32);
//        robot.move(18);
//        robot.move(18);
//        System.out.println(Arrays.toString(robot.getPos()));
//        System.out.println(robot.getDir());


//        ["Robot","move","getPos","getDir","move","getPos","getDir","move","move","getPos","getDir","move","move","move","move","move","getPos","getDir","move","move","move","move","move","getPos","getDir","move","move","move","move","move","getPos","getDir","move","move","move","move","getPos","getDir","move","move","move"]
//[[8,11],[18],[],[],[24],[],[],[44],[36],[],[],[17],[42],[47],[31],[11],[],[],[50],[39],[25],[1],[45],[],[],[43],[25],[2],[4],[2],[],[],[9],[29],[18],[5],[],[],[14],[21],[10]]

//        Robot robot = new Robot(8, 11);
//        robot.move(18);
//        System.out.println(Arrays.toString(robot.getPos()));
//        System.out.println(robot.getDir());
//        robot.move(24);
//        System.out.println(Arrays.toString(robot.getPos()));
//        System.out.println(robot.getDir());
//        robot.move(44);
//        robot.move(36);
//        System.out.println(Arrays.toString(robot.getPos()));
//        System.out.println(robot.getDir());
//        robot.move(17);
//        robot.move(42);
//        robot.move(47);
//        robot.move(31);
//        robot.move(11);
//        System.out.println(Arrays.toString(robot.getPos()));
//        System.out.println(robot.getDir());
//        robot.move(11);
//        robot.move(50);
//        robot.move(39);
//        robot.move(25);
//        robot.move(1);
//        robot.move(45);
//        robot.move(44);



//["Robot","move","move","move","move","move","getPos","getDir","move","move","getPos","getDir","move","move","move","move","move","getPos","getDir","move","move","move","getPos","getDir","move","move","move","getPos","getDir","move","move","move","move","getPos","getDir","move","move","getPos","getDir","move","move","move","move","getPos","getDir","move","move","move"]
//[[3,3],[26],[34],[30],[45],[25],[],[],[35],[33],[],[],[34],[31],[42],[8],[33],[],[],[23],[17],[4],[],[],[36],[14],[46],[],[],[21],[9],[13],[16],[],[],[33],[31],[],[],[17],[30],[45],[28],[],[],[35],[12],[33]]
//        Robot robot = new Robot(3, 3);
//        robot.move(26);
//        robot.move(34);
//        robot.move(30);
//        robot.move(45);
//        robot.move(25);
//        System.out.println(Arrays.toString(robot.getPos()));
//        System.out.println(robot.getDir());
//        robot.move(35);
//        robot.move(33);
//        System.out.println(Arrays.toString(robot.getPos()));
//        System.out.println(robot.getDir());
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.move(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */