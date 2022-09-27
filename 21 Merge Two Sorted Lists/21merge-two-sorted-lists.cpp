/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        
        if(l1==NULL) return l2;
        if(l2==NULL) return l1;
        if(l1->val>l2->val) swap(l1,l2);
        auto fin= l1;
        // if(->val>p2->val) swap()
        while(l1!=NULL && l2!=NULL){
            ListNode* temp= NULL;
            while(l1!=NULL && l1->val<=l2->val){
                temp=l1;
                l1=l1->next;
            }
                temp->next = l2;
                swap(l1,l2);
        }
        return fin;
        
//         ListNode* temp = l2;
//         ListNode* copy = l1;
        
//         while(l1->next!=NULL){
            
//             if((l1->val)<=(l2->val))l1= l1->next;
//             else{
//                 temp= l1;
//                 l1->next= l2;
//                 l2= temp;
//             }
            
//         }
//         return copy;
    }
};








// /**
//  * Definition for singly-linked list.
//  * struct ListNode {
//  *     int val;
//  *     ListNode *next;
//  *     ListNode() : val(0), next(nullptr) {}
//  *     ListNode(int x) : val(x), next(nullptr) {}
//  *     ListNode(int x, ListNode *next) : val(x), next(next) {}
//  * };
//  */
// class Solution {
// public:
//     ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        
//         ListNode* start1= list1;
//         ListNode* start2=list2;
//         // ListNode* start3 = new ListNode();
//         // ListNode* temp = start3;
//         // if(start1==NULL || start2==NULL){
//         //     return 
//         // }//
//         while(start1!= NULL && start2 != NULL){
//             if(start1->val <= start2->val){
//                 forward1=start1->next;
//                 start1 -> next = start2;
                
//                 // temp= temp->next;
//                 start1= forward;
//             }
//             else{
//                 start1 = start1->next;
//                 // temp= temp->next;
//                 start1 = start1->next;
//             }
//         }

//         if(start1!=NULL) {start1->next= start1;}
//         if(start2!=NULL) {temp->next= start2;}
    
//         return start3->next;
//     }
        
// };


// /**
//  * Definition for singly-linked list.
//  * struct ListNode {
//  *     int val;
//  *     ListNode *next;
//  *     ListNode() : val(0), next(nullptr) {}
//  *     ListNode(int x) : val(x), next(nullptr) {}
//  *     ListNode(int x, ListNode *next) : val(x), next(next) {}
//  * };
//  */
// // class Solution {
// // public:
// //     ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        
// //         ListNode* start1= list1;
// //         ListNode* start2=list2;
// //         ListNode* start3 = new ListNode();
// //         ListNode* temp = start3;
// //         // if(start1==NULL || start2==NULL){
// //         //     return 
// //         // }//
// //         while(start1!= NULL && start2 != NULL){
// //             if(start1->val >= start2->val){
// //                 temp -> next = start2;
// //                 temp= temp->next;
// //                 start2= start2->next;
// //             }
// //             else{
// //                 temp->next = start1;
// //                 temp= temp->next;
// //                 start1 = start1->next;
// //             }
// //         }

// //         if(start1!=NULL){temp->next= start1;temp= temp->next;}
// //         if(start2!=NULL) {temp->next= start2;temp= temp->next;}
    
// //         return start3->next;
// //     }
        
// };