INSERT INTO account
		(email, name, password, created_by, created_date, last_updated_by, last_updated_date, version_number) 
VALUES 
	 ('admin@admin', 'admin', '97fe81ab9c03083aaa09db415b89597cf22714712d97aca721fec8673cbc7e1f8ed04f4441ce7c6e', 'default_users.sql', sysdate(), 'default_users.sql', sysdate(), 0);

