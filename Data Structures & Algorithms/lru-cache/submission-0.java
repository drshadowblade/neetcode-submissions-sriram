class LRUCache {
    class Node
    {
        int key,value;
        Node prev,next;
        Node(int k,int v) {key=k;value=v;}
    }
    private HashMap<Integer,Node> map=new HashMap<>();
    private Node head=new Node(0,0),tail=new Node(0,0);
    private int cap;
    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    private void remove(Node n)
    {
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }

    private void addtoHead(Node n)
    {
        n.next=head.next;
        n.prev=head;
        head.next.prev=n;
        head.next=n;

    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n=map.get(key);
        remove(n);
        addtoHead(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node n=map.get(key);
            n.value=value;
            remove(n);
            addtoHead(n);
        }
        else
        {
            if(map.size()==cap)
            {
                Node lru=tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node n=new Node(key,value);
            map.put(key,n);
            addtoHead(n);
        }
    }
}
