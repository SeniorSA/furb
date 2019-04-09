/* Database: PostgreSql. Generation date: 2019-04-09 14:02:27:844 */
/* Entity World */
create table world (
	id UUID NOT NULL,
	name VARCHAR(255) NOT NULL
);



/* Join Tables */

/* Primary Key Constraints */
alter table world add constraint pk_world_id primary key(id);

/* Foreign Key Constraints */

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
