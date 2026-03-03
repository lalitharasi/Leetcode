#include <iostream>
#include <string>
#include <climits>

using namespace std;

class Solution {
public:
    int myAtoi(string s) {
        int i = 0;
        int n = s.length();
        
        // Skip leading whitespace
        while (i < n && s[i] == ' ')
            i++;
        
        //  Handle sign
        int sign = 1;
        if (i < n && (s[i] == '+' || s[i] == '-')) {
            if (s[i] == '-')
                sign = -1;
            i++;
        }
        
        //  Convert digits
        long result = 0;  // use long to detect overflow
        
        while (i < n && isdigit(s[i])) {
            int digit = s[i] - '0';
            
            //  Check overflow BEFORE multiplying
            if (result > INT_MAX / 10 ||
                (result == INT_MAX / 10 && digit > 7)) {
                
                return sign == 1 ? INT_MAX : INT_MIN;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return sign * result;
    }
};

int main() {
    Solution sol;
    cout << sol.myAtoi("42") << endl;           // 42
    cout << sol.myAtoi("   -042") << endl;     // -42
    cout << sol.myAtoi("1337c0d3") << endl;    // 1337
    cout << sol.myAtoi("0-1") << endl;         // 0
    cout << sol.myAtoi("words and 987") << endl; // 0
}