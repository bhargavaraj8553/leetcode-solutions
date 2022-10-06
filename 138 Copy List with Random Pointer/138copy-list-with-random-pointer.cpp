/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        unordered_map<Node*,Node*> mp;
        
        Node* temp = head;
        while(temp!=NULL){
            Node* copy= new Node(temp->val);
            mp[temp]=copy;
            temp = temp->next;
        }
        
        temp= head;
        Node* final = mp[temp];
        while(temp!=NULL){
            mp[temp]->next = mp[temp->next];
            mp[temp]->random = mp[temp->random];
            temp = temp->next;
        }
       return  final; 
    }
};








// /*
// // Definition for a Node.
// class Node {
// public:
//     int val;
//     Node* next;
//     Node* random;
    
//     Node(int _val) {
//         val = _val;
//         next = NULL;
//         random = NULL;
//     }
// };
// */

// class Solution {
// public:
//     Node* createList(Node* head, Node* temp){
//         // Node* temp = new Node(head->val);
//         Node* rand = new Node(head->random->val);
//         Node* nexxt= new Node(head->next->val);
//         temp->random = rand;
//         temp->next = nexxt;
//         // temp= temp->next;
//         return temp;
//     }
    
//     Node* copyRandomList(Node* head) {
//         // Node* temp = new Node(head->val);
//         // Node* rand = new Node(head->random->val);
//         // Node* nexxt= new Node(head->next->val);
//         // temp->rendom = rand;
//         // temp->next = nexxt;
//         Node* final = new Node(0);
//         while(head!=NULL){
//             Node* temp1= new Node(head->val);
//             temp1= createList(head,temp1);
//             if(temp1->next ==NULL){
//                 final= temp1;
//                 break;
//             }
//             temp1= temp1->next;
//             // cout<<temp1->val<<" ";
//             head= head->next;
//             // if(temp1->next ==NULL){
//             //     final= temp1;
//             // }
//         }
//         return final;
//     }
// };