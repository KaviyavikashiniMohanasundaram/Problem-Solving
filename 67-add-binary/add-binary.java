class Solution {
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int carry = 0;
        Stack<Character> stack = new Stack<>();

        while (i >= 0 && j >= 0) {
            if (arr1[i] == '0' && arr2[j] == '0' && carry == 0) {
                stack.push('0');
                i--;
                j--;
            }
            else if ((arr1[i] == '1' && arr2[j] == '0' && carry == 0)
                    || (arr1[i] == '0' && arr2[j] == '1' && carry == 0)
                    || (arr1[i] == '0' && arr2[j] == '0' && carry == 1)) {
                stack.push('1');
                i--;
                j--;
                carry = 0;
            }
            else if ((arr1[i] == '1' && arr2[j] == '1' && carry == 0)
                    || (arr1[i] == '0' && arr2[j] == '1' && carry == 1)
                    || (arr1[i] == '1' && arr2[j] == '0' && carry == 1)) {
                stack.push('0');
                i--;
                j--;
                carry = 1;
            }
            else {
                stack.push('1');
                i--;
                j--;
            }
        }

        while (i >= 0) {
            if (carry == 0)
                stack.push(arr1[i--]);
            else {
                if (arr1[i] == '0') {
                    stack.push('1');
                    i--;
                    carry = 0;
                }
                else {
                    stack.push('0');
                    i--;
                }
            }
        }

        while (j >= 0) {
            if (carry == 0)
                stack.push(arr2[j--]);
            else {
                if (arr2[j] == '0') {
                    stack.push('1');
                    j--;
                    carry = 0;
                }
                else {
                    stack.push('0');
                    j--;
                }
            }
        }

        if (carry == 1)
            stack.push('1');

        char[] res_char = new char[stack.size()];
        int length = stack.size();
        for (int k = 0; k < length; k++)
            res_char[k] = stack.pop();

        return new String(res_char);
    }
}