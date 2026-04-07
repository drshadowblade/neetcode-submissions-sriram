class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<=maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        
        if(maxHeap.size()>minHeap.size()+1)
            minHeap.offer(maxHeap.poll());
        else if(minHeap.size()>maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size())
            return (double)(maxHeap.peek()+minHeap.peek())/2;
        else
            return maxHeap.peek();
    }
}
