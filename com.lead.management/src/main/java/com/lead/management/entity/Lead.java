package com.lead.management.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName, lastName, email, mobileNo;
    private String city, state, pincode, gender, status;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate = LocalDateTime.now();

    // Many Leads → One LeadType
    @ManyToOne
    @JoinColumn(name = "type_id")
    private LeadType leadType;

    // One Lead → Many Comments
    @OneToMany(mappedBy = "lead", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    // One Lead ↔ One Enquiry / ContactUs / Complaint
    @OneToOne(mappedBy = "lead", cascade = CascadeType.ALL)
    private Enquiry enquiry;

    @OneToOne(mappedBy = "lead", cascade = CascadeType.ALL)
    private ContactUs contactUs;

    @OneToOne(mappedBy = "lead", cascade = CascadeType.ALL)
    private Complaint complaint;

    // Many-to-Many with DeveloperSkill
    @ManyToMany
    @JoinTable(
            name = "lead_skills",
            joinColumns = @JoinColumn(name = "lead_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<DeveloperSkill> developerSkills = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public LeadType getLeadType() {
		return leadType;
	}

	public void setLeadType(LeadType leadType) {
		this.leadType = leadType;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Enquiry getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}

	public ContactUs getContactUs() {
		return contactUs;
	}

	public void setContactUs(ContactUs contactUs) {
		this.contactUs = contactUs;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public Set<DeveloperSkill> getDeveloperSkills() {
		return developerSkills;
	}

	public void setDeveloperSkills(Set<DeveloperSkill> developerSkills) {
		this.developerSkills = developerSkills;
	}

	@Override
	public String toString() {
		return "Lead [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", gender=" + gender + ", status=" + status + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", leadType=" + leadType + ", comments=" + comments + ", enquiry=" + enquiry
				+ ", contactUs=" + contactUs + ", complaint=" + complaint + ", developerSkills=" + developerSkills
				+ "]";
	}

	public Lead(Long id, String firstName, String lastName, String email, String mobileNo, String city, String state,
			String pincode, String gender, String status, LocalDateTime createdDate, LocalDateTime modifiedDate,
			LeadType leadType, List<Comment> comments, Enquiry enquiry, ContactUs contactUs, Complaint complaint,
			Set<DeveloperSkill> developerSkills) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.gender = gender;
		this.status = status;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.leadType = leadType;
		this.comments = comments;
		this.enquiry = enquiry;
		this.contactUs = contactUs;
		this.complaint = complaint;
		this.developerSkills = developerSkills;
	}

	public Lead() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters/Setters omitted for brevity
    
}
