#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<string> result;
    
    void backtrack(string digits, int index, string current,
                   unordered_map<char, string>& mapping) {
        
        // Base case
        if (index == digits.length()) {
            result.push_back(current);
            return;
        }
        
        string letters = mapping[digits[index]];
        
        for (char c : letters) {
            backtrack(digits, index + 1, current + c, mapping);
        }
    }
    
    vector<string> letterCombinations(string digits) {
        if (digits.empty())
            return {};
        
        unordered_map<char, string> mapping = {
            {'2',"abc"}, {'3',"def"}, {'4',"ghi"},
            {'5',"jkl"}, {'6',"mno"},
            {'7',"pqrs"}, {'8',"tuv"}, {'9',"wxyz"}
        };
        
        backtrack(digits, 0, "", mapping);
        return result;
    }
};

int main() {
    Solution sol;
    vector<string> ans = sol.letterCombinations("23");
    
    for (string s : ans)
        cout << s << " ";
}