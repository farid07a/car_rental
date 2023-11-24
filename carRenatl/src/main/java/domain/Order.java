package domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Order {
	private long orderId;
	private long userId;
	private long carId;
	private Date orderDate;
	private Date returnDate;
	private boolean carReurned;
	private BigDecimal rentalcost;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(long orderId, long userId, long carId, Date orderDate, Date returnDate, boolean carReurned,
			BigDecimal rentalcost) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.carId = carId;
		this.orderDate = orderDate;
		this.returnDate = returnDate;
		this.carReurned = carReurned;
		this.rentalcost = rentalcost;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", carId=" + carId + ", orderDate=" + orderDate
				+ ", returnDate=" + returnDate + ", carReurned=" + carReurned + ", rentalcost=" + rentalcost + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(carId, carReurned, orderDate, orderId, rentalcost, returnDate, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return carId == other.carId && carReurned == other.carReurned && Objects.equals(orderDate, other.orderDate)
				&& orderId == other.orderId && Objects.equals(rentalcost, other.rentalcost)
				&& Objects.equals(returnDate, other.returnDate) && userId == other.userId;
	}
	
	
	
}
