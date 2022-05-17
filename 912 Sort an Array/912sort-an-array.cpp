class Solution {
public:
void mergearr(vector<int>& arr,int s,int e){
    int h=s;
        
    int m= (s+e)/2;
    int len1= m-s+1, len2= e-m;
    int i=0,j=0,k=0;
    int *arr1 =new int[len1];
    int *arr2 = new int[len2];
        
    while(i<len1){    
    arr1[i]=arr[s+k];
    i++;
    k++;
    }

    while(j<len2){
    arr2[j]=arr[m+1];
    j++;
    m++;
    }
        
    i=0,j=0;
        
    while(i<len1 && j<len2){
    if(arr1[i]<=arr2[j]){
        arr[s]=arr1[i];
        i++;
        s++;
    }
    else {
        arr[s]=arr2[j];
        s++;
        j++;
    }
    }
    while(j<len2){
        arr[s]=arr2[j];
        s++;
        j++;
    }
    while(i<len1){
        arr[s]=arr1[i];
        s++;
        i++;
    }
    delete []arr1;
    delete []arr2;
}

void mergesort(vector<int>& arr,int s,int e){

    if(s>=e){
        return;
    }
    int m= (s+e)/2;
    
    mergesort(arr,s,m);
    mergesort(arr,m+1,e);        
    mergearr(arr,s,e);
}
    
vector<int> sortArray(vector<int>& nums) {
        // int i=0,n=nums.size()-1;
        // while(i<n){
        //     for(int j=0;j<n-i;j++){
        //         if(nums[j]>nums[j+1]){
        //             swap(nums[j],nums[j+1]);
        //         }
        //     }
        //     i++;
        // }
    
    mergesort(nums,0,nums.size()-1);
//         // sort(nums.begin(),nums.end());
//     int s=
//     if(s>=e){
//         return;
//     }
//     int m= (s+e)/2;
    
//     mergesort(arr,s,m);
//     mergesort(arr,m+1,e);        
//     mergearr(arr,s,e);
        return nums;
    }
};

