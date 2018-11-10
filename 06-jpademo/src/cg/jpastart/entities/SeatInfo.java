package cg.jpastart.entities;

import javax.persistence.Embeddable;

@Embeddable
public class SeatInfo {

	int totalcount;
	int avlCount;
	int bookedCount;
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getAvlCount() {
		return avlCount;
	}
	public void setAvlCount(int avlCount) {
		this.avlCount = avlCount;
	}
	public int getBookedCount() {
		return bookedCount;
	}
	public void setBookedCount(int bookedCount) {
		this.bookedCount = bookedCount;
	}
	@Override
	public String toString() {
		return "SeatInfo [totalcount=" + totalcount + ", avlCount=" + avlCount
				+ ", bookedCount=" + bookedCount + "]";
	}
	public SeatInfo(int totalcount, int avlCount, int bookedCount) {
		super();
		this.totalcount = totalcount;
		this.avlCount = avlCount;
		this.bookedCount = bookedCount;
	}
	public SeatInfo() {
		super();
	}
	
	
}
