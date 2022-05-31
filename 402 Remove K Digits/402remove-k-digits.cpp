// class Solution {
// public:
//     string removeKdigits(string num, int k) {
//         int n = num.size();
//         stack<char> mystack;
//         //Store the final string in stack
//         for(char c: num)
//         {
//             while(!mystack.empty() && k>0 && mystack.top()>c)
//             {   mystack.pop();      k-=1;   }
            
//             if(!mystack.empty() || c!='0')
//                 mystack.push(c);
//         }
        
//         //Now remove the largest values from the top of the stack
//         while(!mystack.empty() && k--)
//             mystack.pop();
//         if(mystack.empty())
//             return "0";
        
//         //Now retrieve the number from stack into a string (reusing num)
//         while(!mystack.empty())
//         {
//             num[n-1] = mystack.top();
//             mystack.pop();
//             n-=1;
//         }
//         return num.substr(n);
//     }
// };

class Solution {
public:
    string removeKdigits(string num, int k) {
        
        // int count=0,i=0;
        stack<char> st;
        int n=num.size();
        for(char it: num){
            // if(it>st.top){
            // st.push(it);00
            // }
            while (k>0 && !st.empty() && st.top()>it) {
                st.pop();
                k--;
                // if(count==k) break;
            }
            // if(!st.empty()
               // || it!='0')
            if(it!='0' || !st.empty()) st.push(it);

            // if(count==k){
            //     break;
            // }
        }   
        
        while(!st.empty() && k>0){
            st.pop();
            k--;
            // if(st.empty())
            // return "0";
        // for(auto it: st){
        //     val[i++]=it;
        // }
        // stri
        }
        
        // ng val;
        if(st.empty()){
            return "0";
        }
        while(!st.empty()){
            num[n-1]=(st.top());
            st.pop();
            n--;
        }
        return num.substr(n);
    }
};



// // class Solution {
// // public:
// //     string removeKdigits(string num, int k) {
        
// //         int maxi=num[0],count=0,n=num.size();
// //         // string final;
// //         for(int i=0;i<k;i++){
// //             for(int j=i+1;j<i+k+1;j++){
// //                 if(num[j]>num[i]){
// //                     swap(num[j],num[i]);
// //                     count++;
// //                     break;
// //                 }
// //                 }
// //                 if(count>=k){
// //                     break;
// //             }  
// //         }
// //         string final(num.begin()+k,num.end()) ;
// //         if (final=="") final='0';
// //         int f= stoi(final);
// //         string value= to_string(f);
// //         return value;
// //     }
// // };