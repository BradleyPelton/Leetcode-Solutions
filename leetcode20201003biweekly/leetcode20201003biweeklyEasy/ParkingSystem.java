package leetcode20201003biweeklyEasy;

// Accepted after 41 mintues...
// I took way to long to play around with the java Syntax
// I forgot I had to declare big medium and small before I could use (this.big = big)
// Pretty frustrating that Intellij didnt correct that issue, but I guess it probably can't.
// I dont know why I figured it was something Intellij could figure out.

class ParkingSystem {
    int currentNumOfBig = 0;
    int currentNumOfMedium = 0;
    int currentNumOfSmall = 0;

    int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
//        outputArr.add(null);
        this.currentNumOfBig = 0;
        this.currentNumOfMedium = 0;
        this.currentNumOfSmall = 0;

        this.big = big;
        this.medium = medium;
        this.small = small;

    }

    public boolean addCar(int carType) {
        if(carType==1){
            if(this.currentNumOfBig < this.big){
                this.currentNumOfBig++;
                return true;
            }
            else {
                return false;
            }
        } else if(carType==2){
            if(this.currentNumOfMedium < this.medium){
                this.currentNumOfMedium++;
                return true;
            }
            else {
                return false;
            }
        }else if(carType==3) {
            if (this.currentNumOfSmall < this.small) {
                this.currentNumOfSmall++;
                return true;
            } else {
                return false;
            }
        } else{
            return false;
        }
    }
}

class Tests {
    public static void main(String[] args) {
//        String[] methods = {"ParkingSystem", "addCar", "addCar", "addCar", "addCar"};
//        int[][] vals = {{1,1,0},{1},{2},{3},{1}};
//
//        ParkingSystem ps = new ParkingSystem(1,1,0);
//        System.out.println(ps.addCar(1));
//        System.out.println(ps.addCar(2));
//        System.out.println(ps.addCar(3));
//        System.out.println(ps.addCar(1));



        String[] methods = {"ParkingSystem", "addCar", "addCar", "addCar", "addCar"};
        int[][] vals = {{1,1,0},{1},{2},{3},{1}};

        ParkingSystem ps = new ParkingSystem(1,1,0);
        System.out.println(ps.addCar(1));
        System.out.println(ps.addCar(2));
        System.out.println(ps.addCar(3));
        System.out.println(ps.addCar(1));

    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */