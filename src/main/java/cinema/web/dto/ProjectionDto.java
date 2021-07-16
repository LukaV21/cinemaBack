package cinema.web.dto;

public class ProjectionDto {
	
	
	private Long id;
	
	private Long movieId;
	private String movieName;
	
	private Long projectionTypeId;
	private String projectionTypeName;
	
	private Long hallId;
	private String hallName;
	
	private String projectionStart;
	private String projectionEnd;

	private Double ticketPrice;
	private String admin;
	
	public ProjectionDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Long getProjectionTypeId() {
		return projectionTypeId;
	}

	public void setProjectionTypeId(Long projectionTypeId) {
		this.projectionTypeId = projectionTypeId;
	}

	public String getProjectionTypeName() {
		return projectionTypeName;
	}

	public void setProjectionTypeName(String projectionTypeName) {
		this.projectionTypeName = projectionTypeName;
	}

	public Long getHallId() {
		return hallId;
	}

	public void setHallId(Long hallId) {
		this.hallId = hallId;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	

	public String getProjectionStart() {
		return projectionStart;
	}

	public void setProjectionStart(String projectionStart) {
		this.projectionStart = projectionStart;
	}

	public String getProjectionEnd() {
		return projectionEnd;
	}

	public void setProjectionEnd(String projectionEnd) {
		this.projectionEnd = projectionEnd;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	

}
