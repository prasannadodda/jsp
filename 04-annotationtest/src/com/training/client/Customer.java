package com.training.client;
@table(name="Customer")
@entity()
public class Customer {

	@Id
	int id;

@Column(name="c_name",size=25,notNull=true)
String name;
String city;
double outStandingAmount;

/*@Column(name="c_city",size=25,notNull=true)
String name;
String city;
double outStandingAmount;*/

}
