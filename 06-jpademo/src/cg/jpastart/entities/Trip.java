package cg.jpastart.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Trip {
	int Trip_id;
		String from_city;
		String to_City;
		SeatInfo info;
		public int getTrip_id() {
			return Trip_id;
		}
		public void setTrip_id(int trip_id) {
			Trip_id = trip_id;
		}
		public String getFrom_city() {
			return from_city;
		}
		public void setFrom_city(String from_city) {
			this.from_city = from_city;
		}
		public String getTo_City() {
			return to_City;
		}
		public void setTo_City(String to_City) {
			this.to_City = to_City;
		}
		public SeatInfo getInfo() {
			return info;
		}
		public void setInfo(SeatInfo info) {
			this.info = info;
		}
		@Override
		public String toString() {
			return "Trip [Trip_id=" + Trip_id + ", from_city=" + from_city
					+ ", to_City=" + to_City + ", info=" + info + "]";
		}

		
		
	}



