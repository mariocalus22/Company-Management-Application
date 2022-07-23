package projectApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "business_partners")
public class business_partners {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="business_partners_seq")
	@Column(name = "partner_id")
	private long partnerId;
	
	@Column(name = "name")
	private String name;
	

	
	public business_partners() {
		
	}



	public long getPartnerId() {
		return partnerId;
	}



	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	

}
