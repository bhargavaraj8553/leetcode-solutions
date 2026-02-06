class LRUCache {

    // Doubly Linked List Node
    // Each node stores key-value pair
    // key is required to remove entry from HashMap during eviction
    static class ListNode {

        public int key;
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    // Maximum capacity of LRU Cache
    int capacity;

    // Dummy head and tail nodes
    // head.next -> Most Recently Used (MRU)
    // tail.prev -> Least Recently Used (LRU)
    ListNode head;
    ListNode tail;

    // HashMap to get node reference in O(1)
    Map<Integer, ListNode> keyToNodeMap = new HashMap<>();


    // Constructor: initialize dummy head and tail
    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // GET operation
    public int get(int key) {

        // If key not present, return -1
        if (!keyToNodeMap.containsKey(key)){
            return -1;
        }

        // Fetch the node from HashMap
        ListNode valNode = keyToNodeMap.get(key);

        // Since accessed, move node to front (MRU)
        deleteNode(valNode);
        insertAfterHead(valNode);

        return valNode.val;
    }

    // Inserts a node right after head (marks it as MRU)
    private void insertAfterHead(ListNode valNode) {

        // Node currently after head
        ListNode secondNode = head.next;

        head.next = valNode;
        valNode.prev = head;

        valNode.next = secondNode;
        secondNode.prev = valNode;
    }

    // Deletes a node from doubly linked list in O(1)
    private void deleteNode(ListNode valNode) {

        ListNode prevNode = valNode.prev;
        ListNode nextNode = valNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // PUT operation
    public void put(int key, int value) {

        // Case 1: key already exists
        if (keyToNodeMap.containsKey(key)){

            // Update value
            ListNode oldNode = keyToNodeMap.get(key);
            oldNode.val = value;

            // Move node to front (MRU)
            deleteNode(oldNode);
            insertAfterHead(oldNode);

        }
        // Case 2: key does not exist
        else {

            ListNode newNode = new ListNode(key, value);

            // If cache is full, remove LRU node
            if (keyToNodeMap.size() == capacity){

                // LRU node is before tail
                keyToNodeMap.remove(tail.prev.key);
                deleteNode(tail.prev);
            }

            // Insert new node at front
            insertAfterHead(newNode);
            keyToNodeMap.put(key, newNode);
        }
    }
}
