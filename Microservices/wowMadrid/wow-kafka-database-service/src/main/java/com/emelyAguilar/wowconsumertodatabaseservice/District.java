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
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name= "districts")
public class District implements Serializable{
	
	private static final long serialVersionUID = -8155445368120717790L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="district_name")
	private String districtName;
	
	@OneToMany(mappedBy = "district", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Address> addressList;
	
	public void addAddress(Address address) {
		if (addressList==null) {
			addressList= new ArrayList<>();
		}
		addressList.add(address);
		address.setDistrict(this);
	}
}
