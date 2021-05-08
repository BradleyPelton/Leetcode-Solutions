package contests2020q4.leetcode20201114;

import java.util.ArrayList;
import java.util.List;

// Accepted after second Attempt
// Accepted after 1 hour and 14 minutes (10:44pm EST)

// So frustrating... I misread the problem(poorly worded problem).
// I assumed we were finding a sequence of LEXOGRAPHICALLY INCREASING STRINGS
// but instead if was just a sequence of strings.

// I spent an hour debugging a solution that was right. I learned some stuff about the debugger so that was nice.
// First time using comparison as well. I miss python and a simple "<" operator would lexographically compare strings.


class OrderedStream {
    int length;
    int ptr;
    String[] stringArr;

    public OrderedStream(int n) {
        this.length = n;
        this.ptr = 1;
        this.stringArr = new String[n];

    }

    public List<String> insert(int id, String value) {
        this.stringArr[id-1] = value;

        ArrayList<String> outputArr = new ArrayList<String>();


        if(id == this.ptr){
//            System.out.println("insert was called when id is equal to ptr is equal to " + id);
            // then find the longest contiguous incrementing sequence of ids
            outputArr.add(value);

            for(int i=1; i<this.length; i++){

                if(id+i > this.length){
                    break;
                }

                String curr = this.stringArr[id+i-2];
                String next = this.stringArr[id+i-1];

                if(next == null || next.length() == 0){
                    break;
                } else {
                    outputArr.add(next);
                }

//                int comparisonVal = next.compareTo(curr);

//                if(comparisonVal == 0 || comparisonVal < 0){
//                    break;
//                } else if(comparisonVal > 0){
//                    outputArr.add(next);
//                }
            }

            this.ptr += outputArr.size();
//            System.out.println("updating PTR to " + this.ptr);

        } else{
//            System.out.println("insert was called when id was not equal to ptr. id is  " + id);

        }

//        System.out.println("returning array when id insert is equal to " + id);
//        System.out.println(Arrays.toString(outputArr.toArray()));

        return outputArr;

    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */

class Tests{
    public static void main(String[] args) {
//        OrderedStream os = new OrderedStream(5);
//        os.insert(3, "ccccc");
//        os.insert(1, "aaaaa");
//        os.insert(2, "bbbbb");
//        os.insert(5, "eeeee");
//        os.insert(4, "ddddd");




        OrderedStream os = new OrderedStream(9);
        os.insert(9, "nghbm");
        os.insert(7, "hgeob");
        os.insert(6, "mwlrz");
        os.insert(4, "oalee");
        os.insert(2, "bouhq");
        os.insert(1, "mnknb");
        os.insert(5, "qkxbj");
        os.insert(8, "iydkk");
        os.insert(3, "oqdnf");





//[[9],[9,"nghbm"],[7,"hgeob"],[6,"mwlrz"],[4,"oalee"],[2,"bouhq"],[1,"mnknb"],[5,"qkxbj"],[8,"iydkk"],[3,"oqdnf"]]



    // EXPECTED
//    [null,[],[],[],[],[],["mnknb","bouhq"],[],[],["oqdnf","oalee","qkxbj","mwlrz","hgeob","iydkk","nghbm"]]

    }
}