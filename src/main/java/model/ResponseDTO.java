package model;

public class ResponseDTO {
	private String status;
	private Object result = null;
	
	private ResponseDTO(Builder builder) {
		this.status = builder.status;
		this.result = builder.result;
	}	
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Object getResult() {
		return result;
	}
	
	public void setResult(Object result) {
		this.result = result;
	}

	public static class Builder {
		private String status;
		private Object result;
		
		public Builder(String status) {
			this.status = status;
		}
		
		public Builder status(String status) {
			this.status = status;
			return this;
		}
		
		public Builder result(Object result) {
			this.result = result;
			return this;		
		}
		
		public ResponseDTO build() {
			return new ResponseDTO(this);
		}
	}
}
