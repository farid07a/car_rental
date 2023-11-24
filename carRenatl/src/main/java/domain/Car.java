package domain;

import java.util.Objects;

/**
 * 
 */
public class Car {

	private long carId;
	private String carModel;
	private String carReleaseYear;
	private String carColor;
	private String carCompany;
	public Car(long carId, String carModel, String carReleaseYear, String carColor, String carCompany) {
		super();
		this.carId = carId;
		this.carModel = carModel;
		this.carReleaseYear = carReleaseYear;
		this.carColor = carColor;
		this.carCompany = carCompany;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarReleaseYear() {
		return carReleaseYear;
	}
	public void setCarReleaseYear(String carReleaseYear) {
		this.carReleaseYear = carReleaseYear;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carModel=" + carModel + ", carReleaseYear=" + carReleaseYear + ", carColor="
				+ carColor + ", carCompany=" + carCompany + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(carColor, carCompany, carId, carModel, carReleaseYear);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(carColor, other.carColor) && Objects.equals(carCompany, other.carCompany)
				&& carId == other.carId && Objects.equals(carModel, other.carModel)
				&& Objects.equals(carReleaseYear, other.carReleaseYear);
	}
	
	
	
}
