package board.aggregate;

import board.iterator.BidIterator;

public class BidAggregate implements Aggregate{

	int[] bidArray = new int[10000];
	
	public BidAggregate() {
		
		for(int i=1; i<10000; i++) {
			bidArray[i] = i+1;
		}
	}
	
	public int[] getBidArray() {
		return this.bidArray;
	}
	@Override
	public Object iterator() {
		return new BidIterator();
	}
}
