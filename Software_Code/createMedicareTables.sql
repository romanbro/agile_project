CREATE TABLE `medicare` (
	id integer PRIMARY KEY AUTO_INCREMENT,
	drg_definition varchar(255),
	provider_id integer(8),
	provider_name varchar(255),
	provider_street_address varchar(255),
	provider_city varchar(255),
	provider_state varchar(2),
	provider_zip_code integer(5),
	hospital_referral_region_description varchar(255),
	total_discharges integer(8),
	average_covered_charges numeric,
	average_total_payments numeric,
	average_medicare_payments numeric
);
