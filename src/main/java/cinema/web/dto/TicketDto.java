package cinema.web.dto;

public class TicketDto {
	
	private Long id;
	private String reserved;
	private String user;
	
	private Long seatId;
	private Integer seatNumber;
	private Long projectionId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Long getSeatId() {
		return seatId;
	}
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}
	public Integer getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Long getProjectionId() {
		return projectionId;
	}
	public void setProjectionId(Long projectionId) {
		this.projectionId = projectionId;
	}
	
	
	
	

}
