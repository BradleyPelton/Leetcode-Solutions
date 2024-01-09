package contests.contests2023.lc0318biweekly.easy;



// Disgustingly bad
// 2 incorrect answer
// 20 minutes on an easy

// In my defense, a lot of people struggled with this easy
// deceptively simple, lots of edge cases.
// 1300 accepted before me. 10000 incorrect answers



class Solution {
    public int distMoney(int money, int children) {

        int ans = 0;



        if (money < children) {
            System.out.println("too few, returing -1");
            return -1;
        } else {
            money -= children; // give every child 1 dollar
        }

        while (money > 6 && children > 0) {
            ans += 1;
            money -= 7;
            children -= 1;
        }

        // ALL CHILDREN HAVE 8
        if (children == 0 && money > 0) {
            // give remaining money to one child
            if (money == 3) {
                ans -= 1;
                System.out.println("four case, return ans -=1");
                return ans;
            } else {
                ans -= 1;
                return ans;
            }
        }

        // ELSE ALL CHILDREN DON't HAVE 8
        else if (money > 0 && children > 0) {
            if (children > 1) {
                System.out.println("we can evenly distribute remaining withour 4s");
                return ans;
            } else {
                if (money == 3) {
                    System.out.println("one 8 and a remaining 3");
                    ans  -= 1;
                    return ans;
                } else {
                    System.out.println("remaining even");
                    return ans;
                }
            }
        } else {
            System.out.println("Perfect");
            return ans;
        }
    }
}

class Tests {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.distMoney(20, 3)); // expected 1
        System.out.println(sol.distMoney(16, 2)); // expected 2
        System.out.println(sol.distMoney(10, 2)); // expected 1
        System.out.println(sol.distMoney(19, 2)); // expected 1
    }
}
