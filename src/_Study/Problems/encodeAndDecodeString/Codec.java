package _Study.Problems.encodeAndDecodeString;

import java.util.ArrayList;
import java.util.List;


/**
 * 271. Encode and Decode Strings
 * https://leetcode.com/problems/encode-and-decode-strings/description/
 *
 * Boring problem. Edge cases around passing empty strings.
 */
public class Codec {
    char customDelimiter = '¿';
    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s).append(customDelimiter);
        }
        sb.deleteCharAt(sb.length() - 1); // delete last delimiter;
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == customDelimiter) {
                ans.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(s.charAt(i));
            }
        }
        ans.add(sb.toString());
        return ans;
    }
}

class test {
    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.decode(codec.encode(List.of("Hello","World")));
        codec.decode(codec.encode(List.of("")));
        codec.decode(codec.encode(List.of("", "")));
    }
}
