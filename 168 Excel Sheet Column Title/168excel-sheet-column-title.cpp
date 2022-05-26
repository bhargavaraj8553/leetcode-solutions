class Solution {
public:
    string convertToTitle(int n) {
        
        string result="";
        // int n= columnNumber;
        while(n){
            char c= 'A' + (n-1)%26;
            result = c+ result;
            n=(n-1)/26;
        }
        return result;
    }
};




// class Solution {
//         string c;
//     private: string tit(int columnNumber, string &c){
//         if(columnNumber<26){
//             val(columnNumber,c);
//             return c;
//         }
//         if(columnNumber>26){
//             val(columnNumber%26,c="");
//         columnNumber-=columnNumber%26;
//         }
            
//         while(columnNumber >=26){
//             columnNumber = ((columnNumber)/26);
//             return tit(columnNumber,c);
//             // return c;
//         }
//        return c; 
//     }
//     string val(int col,string &c){
//         // string c;
//         int i=0;
//         while(i<=26){
//         if(col==i){
//             // c= (i-1)+'A';
//             c.push_back((i-1)+'A');
//         }
//             i++;
//         }
        
//         return c;
//     }
// public:
//     string convertToTitle(int columnNumber) {
//         // if(columnNumber<26){
//         //     return val(columnNumber,c);
//         //     // return c;
//         // }
//         tit(columnNumber,c);
//         // if(columnNumber>26){
//         //     val(columnNumber%26,c="");
//         //     columnNumber = ((columnNumber-columnNumber%26)/26);
//         //     val(columnNumber,c);
//         //     reverse(c.begin(),c.end());
//         // }
        
//             reverse(c.begin(),c.end());
//        return c; 
//     }
// };