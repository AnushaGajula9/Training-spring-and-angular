package com.paymentprojectback.exception;


	

	public class EntityNotFoundException extends Exception {
		
		public EntityNotFoundException(String msg) {
			super(msg);
			
		}
		public String toString() {
			return super.getMessage();
		}

	}


