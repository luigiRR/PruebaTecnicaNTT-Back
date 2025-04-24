create table if not exists roles (
    id serial primary key,
    name varchar(250),
    description varchar(250)
);

insert into roles(name) values('Administrador');
insert into roles(name) values('Cliente');
insert into roles(name) values('Empleado');

create table if not exists statuses (
    id serial primary key,
    name varchar(250),
    description varchar(250)
);

insert into statuses(name) values('Creado');
insert into statuses(name) values('Editado');
insert into statuses(name) values('Eliminado');

create table if not exists users(
	id serial primary key,
	firstname varchar(250),
	lastname varchar(250),
    phone varchar(250),
    identitynumber varchar(250),
    address varchar(250),
    birthdate timestamp,
    email varchar(255),
    password varchar(255),
    role_id int4,
    status_id int4,
    CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles(id),
    CONSTRAINT status_fk FOREIGN KEY (status_id) REFERENCES statuses(id)
);

create table if not exists offices (
    id serial primary key,
    name varchar(250),
    address varchar(250)
);

insert into offices(name,address) values('Oficina 1','direccion 1');
insert into offices(name,address) values('Oficina 2','direccion 2');
insert into offices(name,address) values('Oficina 3','direccion 3');
insert into offices(name,address) values('Oficina 4','direccion 4');
insert into offices(name,address) values('Oficina 5','direccion 5');


CREATE TABLE IF NOT EXISTS employee_offices (
    id serial primary key,
    employee_id int4,
    office_id int4,
    CONSTRAINT employee_fk FOREIGN KEY (employee_id) REFERENCES users(id),
    CONSTRAINT office_fk FOREIGN KEY (office_id) REFERENCES offices(id)
);
