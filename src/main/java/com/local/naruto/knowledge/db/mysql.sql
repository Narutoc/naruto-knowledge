create table if not exists tbl_menu_info (
	menuid varchar(32) not null,
	parentid varchar(32),
	lang int default 1,
	zhname varchar(50),
	zhdescription varchar(255),
	enname varchar(150),
	endescription varchar(1024),
	status int default 1,
	sortnum int default 1,
	createduser varchar(25) not null,
	createddate Datetime not null,
	lastmodifieduser varchar(25),
	lastmodifieddate Datetime,
	primary key (menuid)
);