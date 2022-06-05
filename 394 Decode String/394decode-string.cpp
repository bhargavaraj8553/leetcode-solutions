class Solution {
public:
    string decodeString(string s) {
        
        stack<char> st;
        for(auto it=s.begin();it!=s.end();it++){
            if(*it!=']'){
                st.push(*it);
            }
            else {
                // int n=0;
                // st.pop();
                string a;
                while( !st.empty() && st.top()!='['){
                    
                    a= st.top() + a;
                    st.pop();
                }
                // reverse(a.begin(),a.end());
                st.pop();
                
                // for calculating number
                string number = "";
                while(!st.empty() && isdigit(st.top())){
                    number = st.top() + number;
                    st.pop();
                }
                int n = stoi(number); 
                // int n=st.top(),count=1;
                // st.pop();
                // while( !st.empty() && isdigit(st.top())){
                //     // int n=st.top();
                //     n = n + (st.top()-'0')*10*count;
                //     st.pop();
                //         count++;
                // }
                while(n-->0 ){
                for(auto c:a){
                    st.push(c);
                }
                }
            }
        }
        string final;
        while(!st.empty()){
            final=st.top()+final;
            st.pop();
        }
        // reverse(final.begin(),final.end());
        return final;
    }
};







// class Solution {
//     private: string appendstring(string &s, int k){
//         string a;
//         int z=s.length();
//         int count;
//         if(s[s.length()-1]=='"'){
//             while(k-->0){
//                 a=a+s;
//             }
//             return a;
//         }
//         for (auto i=s.begin()+1,count=0; i!=s.end();i++){
//             if(i=='['){
//                 count++;
//             }
//         }
//         if (count==0){
//             while(k-->0){
//                 a=s+a;
//             }
//             s=s.substr(0,z-k*(s.length()))
//             return a;
//         }
        
//         for(auto it= s.begin();it!=s.end();it++){
//             if (*it== '['){
//                 k=it-1;
//             // }
//             // i
//             appendstring(s.substr(it),k);
//         }
        
//        return a; 
        
//     }
// public:
//     string decodeString(string s) {
        
//         string final;
        
        
//     }
// };