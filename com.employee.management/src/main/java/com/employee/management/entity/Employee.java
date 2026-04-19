package com.employee.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee_")
public class Employee {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String username;
	    private String password;

	    @Enumerated(EnumType.STRING)
	    private Role role;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		// ✅ Manual builder
	    public static Builder builder() { return new Builder(); }

	    public static class Builder {
	        private final Employee e = new Employee();
	        public Builder username(String username) { e.username = username; return this; }
	        public Builder password(String password) { e.password = password; return this; }
	        public Builder role(Role role) { e.role = role; return this; }
	        public Employee build() { return e; }
	    }

		@Override
		public String toString() {
			return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
		}
	    
	    

}
