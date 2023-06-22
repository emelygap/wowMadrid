package com.emelyAguilar.wowconsumertodatabaseservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name= "areas")
public class Area implements Serializable{
	
	private static final long serialVersionUID = -4141016174048315110L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="street_address")
	private String streetAddress;
	@Column(name="postal_code")
	private String postalCode;
	
	@OneToMany(mappedBy = "area", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Address> addressList;
	
	public void addAddress(Address address) {
		if (addressList==null) {
			addressList= new ArrayList<>();
		}
		addressList.add(address);
		address.setArea(this);
	}

}
