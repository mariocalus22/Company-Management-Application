-- INSERT EMPLOYEES			
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Mario', 'Calus', 'mario@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Cristi', 'Pop', 'cristi@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Mihai', 'Matei', 'mihai@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Alex', 'Iaromi', 'alex@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Ion', 'Spinu', 'ion@gmail.com');


-- INSERT PROJECTS			
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Increase sales', 'NOTSTARTED', 'Increase sales with 30%');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'Launch new product',  'COMPLETED', 'The new product is a phone with new colors');
insert into project (project_id, name, stage, description) values (nextval('project_seq'), 'New building', 'INPROGRESS', 'Create new building in Timisoara');

-- INSERT PROJECT_EMPLOYEE_RELATION
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Calus' AND p.name = 'New building');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Matei' AND p.name = 'Increase sales');
insert into project_employee (employee_id, project_id) (select e.employee_id, p.project_id from employee e, project p where e.last_name ='Spinu' AND p.name = 'Launch new product');															