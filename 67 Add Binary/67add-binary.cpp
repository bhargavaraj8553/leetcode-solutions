class Solution {
public:
    string addBinary(string a, string b) {
        
        int i=a.length()-1,j=b.length()-1,carry=0;
        string ans;
        
        while( i>=0 || j>= 0 || carry){
        if(i>=0){
        carry += (a[i--]-'0') ;
             }
        if(j>=0){
        carry+= (b[j--]-'0');
        }
        // ans+= carry;
        ans+= carry%2 + '0';
        carry = carry/2;
        
        // sum.push_back(ans+'0');    
    }
        // if(carry){
        //     sum.push_back(carry+'0');
        // }
     reverse(ans.begin(),ans.end());
        return ans;
    }
};


// \

// class Solution {
// public:
//     string addBinary(string a, string b) {
//         int x= stoi(a);
//         cout<<x<<" x "<<endl;
//         int y= stoi(b);
//         cout<<y<<" y "<<endl;
//         int carry =0,val=0;
//         string s3;
//         while(x>0 && y>0){
//         val= x%10 + y%10 +carry;
//             cout<<val<<" vvvv "<<endl;
//         if(val==1 || val==0){ s3.push_back(char((val)+'0'));}
//         else {
//             s3.push_back(char((val-2)+'0'));
//             carry=1;
//     }
//             x=x/10;
//             y=y/10;
//             cout<<carry<<" cccaaarrryyyyy "<<endl;
//             cout<<val<<" vvvv "<<endl;
//             cout<<s3<<" stringggg "<<endl;
//         }
//          cout<<s3<<" stringggg "<<endl;
//         // carry=0;
        
//         while(x>0){
//             val=x%10 +carry;
//             cout<<val<<" vvvv "<<endl;
//             if(val==1 || val==0){ s3.push_back(char((val)+'0'));}
//             else if (val==2){
//                 s3.push_back(char((val-2)+'0'));
//                 carry=1;
//                             }
//             x=x/10;
//             cout<<val<<" vvvv "<<endl;
//             cout<<s3<<" stringggg "<<endl;
// }
        
//         while(y>0){
//             val=y%10 +carry;
//             cout<<val<<" vvvv "<<endl;
//             if(val==1 || val==0){ s3.push_back(char((val)+'0'));}
//             else if (val==2){
//                 s3.push_back(char((val-2)+'0'));
//                 carry=1;
//                             }
//             y=y/10;
//             cout<<val<<" vvvv "<<endl;
//             cout<<s3<<" stringggg "<<endl;
// }
//         s3.push_back(char(carry+'0'));
//         reverse(s3.begin(),s3.end());
//         return s3;
//         }
// };